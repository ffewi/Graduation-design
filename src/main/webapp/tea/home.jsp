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
<link rel="icon"
	href="<%=application.getContextPath()%>/icon/favicon.ico">

<title>教师主页</title>
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
<script type="text/javascript"
	src="<%=application.getContextPath()%>/js/teacher.js"></script>
<script type="text/javascript">
	//模糊检索
	function getSearchMsg() {
		//alert("开始检索");
		var teacherNo = document.getElementById("teaId").innerText;
		var className = document.getElementById("selectClass").value;
		var courseNo = document.getElementById("selectCourse").value;
		var studentName = document.getElementById("studentNameContent").value;
		var url = "teacherajaxSearchStudentToUpdate.action";
		if (courseNo == -1) {
			alert("请选择课程！")
			return false;
		}
		if (studentName.trim() == '') {
			alert("请输入内容");
			return false;
		}
		var param = {
			'tauForm.className' : className,
			'tauForm.teacherNo' : teacherNo,
			'tauForm.courseNo' : courseNo,
			'tauForm.studentName' : studentName

		};
		//alert(teacherNo+": "+className +": "+courseNo +": "+studentName);
		$.post(url, param, callbackShowSearchMsg);
	}
	function callbackShowSearchMsg(result, textStatus) {
		//显示检索内容
		if (textStatus == 'success') {
			//alert(result == null);
			if (result != null) {
				var tb = document.getElementById("mytb1");
				if (result == "") {
					//清除录入的页面效果
					tb.innerHTML = "<tr><th colspan ='6'> <span style='color:red'>不存在该学生或者没有录入学生成绩！</span></th></tr>";
					return;
				}
				var json = eval("(" + result + ")");
				//清除录入的页面效果
				tb.innerHTML = "";
				for (var v1 = 0; v1 < json.length; v1++) {
					tb.innerHTML += "<tr>"
							+ "<th class='col-md-2'>"
							+ json[v1].studentNo
							+ "</th>"
							+ "<th class='hidden'>"
							+ json[v1].courseNo
							+ "</th>"
							+ "<th class='col-md-2'>"
							+ json[v1].studentName
							+ "</th>"
							+ "<th class='col-md-2'>"
							+ json[v1].courseName
							+ "</th>"
							+ "<th class='col-md-2'>"
							+ "<input name='pingshi' type='text' maxlength='3' style='width:60px' value='"+json[v1].pingshiScore+"' >"
							+ "</th>"
							+ "<th class='col-md-2'>"
							+ "<input name='exam' type='text' style='width:60px' value='"+json[v1].examScore+"' >"
							+ "</th>"
							+ "<th class='col-md-2'>"
							+ "<input class='btn btn-default' name='exam' type='button' value='修改' style='width:60px' onclick='xiugaiCJ(this);' >"
							+ "</th>" + "</tr>";

				}
			}
		}
	}
</script>
</head>

<body>
	<jsp:include page="../jsp/updateTeaPass.jsp"></jsp:include>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">毕业设计:</a> <span
					class="navbar-brand">${admin.teacherName }</span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#myModal" data-toggle="modal"
						onclick="showView();">密码修改</a></li>
					<li><a href="logoutteacherout">注销</a></li>
					<!-- <li><a href="#">帮助</a></li> -->
				</ul>
				<form class="navbar-form navbar-right" action="#"
					onsubmit="return false;">
					<input id="studentNameContent" type="text" class="form-control"
						placeholder="请输入课程名称查询"> <input type="submit"
						class="form-control btn btn-info" value="查询"
						onclick="getSearchMsg();">
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9  col-md-10 col-md-offset-1 main">

				<h6 class="sub-header">
					你的身份是：老师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工号：<span id="teaId">${admin.teacherNo }</span>
				</h6>
				<div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-3 main">
					<select id="selectClass" class="pagination col-md-2  "
						onchange="getTeaClass(this);">
						<option value="0" selected="selected">班级选择</option>
						<s:iterator id="list" value="classMenuName">
							<option value="<s:property/>"><s:property />级
							</option>
						</s:iterator>
						<s:if test="classMenuName==null">
							<option value="-1" disabled="disabled">你没有课程</option>
						</s:if>
					</select> <select id="selectCourse" class="pagination col-md-2  "
						onchange="getStuList();">
						<option value="-1" disabled="disabled">请先选择班级</option>
					</select> <select id="selectOperater" class="pagination col-md-2  "
						onchange="getStuList();">
						<option value="0" disabled="disabled" selected="selected">请选择操作类型</option>
						<option value="1">录入</option>
						<option value="2">修改</option>
					</select>

				</div>
				<div class="">
					<table class="table table-striped">
						<thead>
							<tr>

								<th class="col-md-2">学号</th>
								<th class="hidden">课程编号</th>
								<th class="col-md-2">学生姓名</th>
								<th class="col-md-2">课程名称</th>
								<th class="col-md-2">平时成绩</th>
								<th class="col-md-2">考试成绩</th>
								<th class="col-md-2">操作</th>

							</tr>
						</thead>
						<tbody id="mytb1">

						</tbody>
					</table>
				</div>
				<!--  分页 -->
				<%-- <div style="position: fixed; bottom: 0; padding-top: 50px"
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
				</div> --%>
				<div id="pageNext"
					style="position: fixed; bottom: 0; padding-top: 50px"
					class=" col-sm-5 col-sm-offset-3 col-md-5 col-md-offset-2 main">

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
