<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../icon/favicon.ico">

<title>学生欢迎页面</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<%=application.getContextPath()%>/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=application.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<script type="text/javascript" src="../jquery/jquery-1.6.js"></script>
<script type="text/javascript">
	//下一页，上一页
	function nextPage(b) {
		var term = document.getElementById("selectId").value;
		var stuNo = document.getElementById("stuId").innerText;
		var pageNo = document.getElementById("pageNo").innerText;
		var pageCount = document.getElementById("pageCount").innerText;
		pageNo = parseInt(pageNo) + b;
		if (pageNo > pageCount) {
			pageNo = pageCount;
			return false;
		}
		if (pageNo <= 0) {
			pageNo = 1;
			return false;
		}
		document.getElementById("pageNo").innerText = pageNo;
		//alert(term+":"+stuNo+":"+pageNo);
		var url = "studentajaxNextPage.action";
		var param = {
			'ssgForm.term' : term,
			'ssgForm.studentNo' : stuNo,
			'pageMsg.pageNo' : pageNo
		};
		$.post(url, param, callbackNext);

	}
	function callbackNext(result, textStatus) {
		if (textStatus == 'success') {
			//alert("success!");
			if (result != null) {
				//alert(result);
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML = "";
				var json = eval("(" + result + ")");
				//alert(json.toString());
				for (var v1 = 0; v1 < json.length; v1++) {

					var finalScore = json[v1].finalScore;
					if (finalScore < 60) {
						tb.innerHTML += "<tr style='color: red;' > <td class='hidden'>"
								+ json[v1].studentNo
								+ "/></td>"
								+ "<td>"
								+ json[v1].courseNo
								+ "</td>"
								+ "<td>"
								+ json[v1].courseName
								+ "</td>"
								+ "<td class='hidden'>"
								+ json[v1].teacherNo
								+ "</td>"
								+ "<td>"
								+ json[v1].teacherName
								+ "</td>"
								+ "<td>"
								+ json[v1].finalScore
								+ "</td>"
								+ "<td>"
								+ json[v1].gradePoint
								+ "</td>"
								+ "<td>"
								+ json[v1].credit
								+ "</td>"
								+ "</tr> ";
					} else {
						tb.innerHTML += "<tr> <td class='hidden'>"
								+ json[v1].studentNo + "/></td>" + "<td>"
								+ json[v1].courseNo + "</td>" + "<td>"
								+ json[v1].courseName + "</td>"
								+ "<td class='hidden'>" + json[v1].teacherNo
								+ "</td>" + "<td>" + json[v1].teacherName
								+ "</td>" + "<td>" + json[v1].finalScore
								+ "</td>" + "<td>" + json[v1].gradePoint
								+ "</td>" + "<td>" + json[v1].credit + "</td>"
								+ "</tr> ";
					}

				}

			}
		}

	}
	//下拉学期获得信息
	function getStuMsg(msg) {
		var term = msg.value;
		var stuNo = document.getElementById("stuId").innerText;
		//alert(stuNo);
		var url = "studentajaxTermChange.action";
		var param = {
			'ssgForm.term' : term,
			'ssgForm.studentNo' : stuNo
		};
		$.post(url, param, callbackTerm);

	}
	function callbackTerm(result, textStatus) {
		if (textStatus == 'success') {
			//alert("success!");
			if (result != null) {
				//alert(result);
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML = "";
				var json = eval("(" + result + ")");
				//设置分页数据
				if (json != null) {
					var pageCount = json[0].pageNum;
					//var test =  Math.floor(pageCount/8);
					var pages = pageCount / 8 == 0 ? pageCount / 8 : Math
							.ceil(pageCount / 8);
					//alert("现在的总页数为:"+ pages+"::::");
					if (pages == 0) {
						document.getElementById("pageNo").innerText = 0;
					} else {
						document.getElementById("pageNo").innerText = 1;
					}
					document.getElementById("pageCount").innerText = pages;
				}
				//alert(json.toString());
				for (var v1 = 0; v1 < json.length; v1++) {

					var finalScore = json[v1].finalScore;
					if (finalScore < 60) {
						tb.innerHTML += "<tr style='color: red;' > <td class='hidden'>"
								+ json[v1].studentNo
								+ "/></td>"
								+ "<td>"
								+ json[v1].courseNo
								+ "</td>"
								+ "<td>"
								+ json[v1].courseName
								+ "</td>"
								+ "<td class='hidden'>"
								+ json[v1].teacherNo
								+ "</td>"
								+ "<td>"
								+ json[v1].teacherName
								+ "</td>"
								+ "<td>"
								+ json[v1].finalScore
								+ "</td>"
								+ "<td>"
								+ json[v1].gradePoint
								+ "</td>"
								+ "<td>"
								+ json[v1].credit
								+ "</td>"
								+ "</tr> ";
					} else {
						tb.innerHTML += "<tr> <td class='hidden'>"
								+ json[v1].studentNo + "/></td>" + "<td>"
								+ json[v1].courseNo + "</td>" + "<td>"
								+ json[v1].courseName + "</td>"
								+ "<td class='hidden'>" + json[v1].teacherNo
								+ "</td>" + "<td>" + json[v1].teacherName
								+ "</td>" + "<td>" + json[v1].finalScore
								+ "</td>" + "<td>" + json[v1].gradePoint
								+ "</td>" + "<td>" + json[v1].credit + "</td>"
								+ "</tr> ";
					}

				}

			}
		}

	}

	function getSearchMsg() {
		var term = document.getElementById("selectId").value;
		var stuNo = document.getElementById("stuId").innerText;
		var content = document.getElementById("ssgCourseName");
		//alert("内容:" + content.value.trim() + ";学期：" + term + ";学号：" + stuNo);
		if (content.value.trim() == '') {
			alert("请输入内容：")
			return false;
		}
		var courseName = content.value.trim();
		var url = "studentajaxSearchByCourName.action";
		var param = {
			'ssgForm.term' : term,
			'ssgForm.studentNo' : stuNo,
			'ssgForm.courseName' : courseName
		};
		$.post(url, param, callbackSearch);

	}
	function callbackSearch(result, textStatus) {
		if (textStatus == 'success') {
			if (result != null) {
				var tb = document.getElementById("mytb1");
				tb.innerHTML = "";
				var json = eval("(" + result + ")");
				//设置分页数据
				if (json != null) {
					var pageCount = json[0].pageNum;
					//var test =  Math.floor(pageCount/8);
					var pages = pageCount / 8 == 0 ? pageCount / 8 : Math
							.ceil(pageCount / 8);
					//alert("现在的总页数为:"+ pages+"::::");
					if (pages == 0) {
						document.getElementById("pageNo").innerText = 0;
					} else {
						document.getElementById("pageNo").innerText = 1;
					}
					document.getElementById("pageCount").innerText = pages;
				}
				for (var v1 = 0; v1 < json.length; v1++) {
					var finalScore = json[v1].finalScore;
					if (finalScore < 60) {
						tb.innerHTML += "<tr style='color: red;' > <td class='hidden'>"
								+ json[v1].studentNo
								+ "/></td>"
								+ "<td>"
								+ json[v1].courseNo
								+ "</td>"
								+ "<td>"
								+ json[v1].courseName
								+ "</td>"
								+ "<td class='hidden'>"
								+ json[v1].teacherNo
								+ "</td>"
								+ "<td>"
								+ json[v1].teacherName
								+ "</td>"
								+ "<td>"
								+ json[v1].finalScore
								+ "</td>"
								+ "<td>"
								+ json[v1].gradePoint
								+ "</td>"
								+ "<td>"
								+ json[v1].credit
								+ "</td>"
								+ "</tr> ";
					} else {
						tb.innerHTML += "<tr> <td class='hidden'>"
								+ json[v1].studentNo + "/></td>" + "<td>"
								+ json[v1].courseNo + "</td>" + "<td>"
								+ json[v1].courseName + "</td>"
								+ "<td class='hidden'>" + json[v1].teacherNo
								+ "</td>" + "<td>" + json[v1].teacherName
								+ "</td>" + "<td>" + json[v1].finalScore
								+ "</td>" + "<td>" + json[v1].gradePoint
								+ "</td>" + "<td>" + json[v1].credit + "</td>"
								+ "</tr> ";
					}
				}
			}
		}
	}
</script>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="studentwelcomPage?stu.studentNo=${admin.studentNo }">毕业设计:</a> <span
					class="navbar-brand">${admin.studentName }</span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">设置</a></li>
					<li><a href="logoutstudent">注销</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="#"
					onsubmit="return false;">
					<input id="ssgCourseName" name="ssgForm.content" type="text"
						class="form-control" placeholder="请输入课程名称查询"> <input
						type="submit" class="form-control btn btn-info" value="查询"
						onclick="getSearchMsg();">
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9  col-md-10 col-md-offset-1 main">

				<h6 class="sub-header">
					你的身份是：学生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号：<span id="stuId">${admin.studentNo }</span>
				</h6>
				<div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-4 main">
					<select id="selectId" class="pagination col-md-4  "
						onchange="getStuMsg(this);">
						<s:if test="termList==null">
							<option disabled="disabled">你是刚来的吧！等你长大了再来</option>
						</s:if>
						<s:iterator id="li" value="termList" status="tl">
							<option class="center-block" value="<s:property  />">
								<s:if test="#li ==1">第一学期：初入茅庐</s:if>
								<s:if test="#li ==2">第二学期：小有成就</s:if>
								<s:if test="#li ==3">第三学期：霸气外露</s:if>
								<s:if test="#li ==4">第四学期：一日冲天</s:if>
								<s:if test="#li ==5">第五学期：度日如年</s:if>
								<s:if test="#li ==6">第六学期：飞黄腾达</s:if>
								<s:if test="#li ==7">第七学期：无所事事</s:if>
								<s:if test="#li ==8">第八学期：毕业设计</s:if>
							</option>
						</s:iterator>

					</select>
				</div>
				<div class="">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="hidden">学号</th>
								<th class="col-md-2">课程编号</th>
								<th class="col-md-2">课程名称</th>
								<th class="col-md-2">教授老师</th>
								<th class="col-md-2">成绩</th>
								<th class="col-md-2">绩点</th>
								<th class="col-md-2">学分</th>
							</tr>
						</thead>
						<tbody id="mytb1">
							<s:iterator id="list" value="ssgList">
								<s:if test="finalScore <60">
									<tr style="color: red;">
										<td class="hidden"><s:property value="studentName" /></td>
										<td><s:property value="courseNo" /></td>
										<td><s:property value="courseName" /></td>
										<td class="hidden"><s:property value="teacherNo" /></td>
										<td><s:property value="teacherName" /></td>
										<td><s:property value="finalScore" /></td>
										<td><s:property value="gradePoint" /></td>
										<td><s:property value="credit" /></td>
									</tr>
								</s:if>
								<s:else>
									<tr>
										<td class="hidden"><s:property value="studentName" /></td>
										<td><s:property value="courseNo" /></td>
										<td><s:property value="courseName" /></td>
										<td class="hidden"><s:property value="teacherNo" /></td>
										<td><s:property value="teacherName" /></td>
										<td><s:property value="finalScore" /></td>
										<td><s:property value="gradePoint" /></td>
										<td><s:property value="credit" /></td>
									</tr>
								</s:else>
							</s:iterator>

						</tbody>
					</table>
				</div>
				<div style="position: fixed; bottom: 0; padding-top: 50px"
					class=" col-sm-5 col-sm-offset-3 col-md-5 col-md-offset-2 main">
					<ul class="pager">
						<li class="previous "><a href="javascript:void(0)"
							onclick="nextPage(-1);"><span aria-hidden="true">&larr;</span>
								上一页</a></li>
						<li class=" "><span aria-hidden="true"><span
								id="pageNo"><s:property value="pageMsg.pageNo" /></span>/<span
								id="pageCount"><s:property value="pageMsg.pageCount" /></span>页</span></li>
						<li class="next"><a href="javascript:void(0)"
							onclick="nextPage(1);">下一页 <span aria-hidden="true">&rarr;</span></a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="<%=application.getContextPath()%>/bootstrap/bootstrap.min.js"></script>


</body>

</html>
