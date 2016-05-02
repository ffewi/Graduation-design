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
<script type="text/javascript">
	function showView() {
		$('#myModal').css({
			position : "absolute",
			'top' : 30,
			'left' : 0
		})
		$('#myModal').modal({

			keyboard : true
		})
	}
	//密码修改前端验证
	function changePass() {
		var pass1 = $('input[id=pass1]').val();
		var pass2 = $('input[id=pass2]').val();
		if (pass1.length < 6 || pass2.length < 6) {
			if (pass1 == '' || pass2 == '') {
				alert("输入不能为空！");
				return false;
			} else {
				alert("长度至少为：6位数")
				return false;
			}
		} else if (pass1 != pass2) {
			alert("两次输入不一致！");
			return false;
		}
		return true;
	}
	function getTeaClass(t) {
		//alert(t.innerHTML);
		var se = document.getElementById("selectClass");
		if (se.options[0].value == 0) {
			se.options[0].remove()
		}
		var operator = document.getElementById("selectOperater");
		//alert(operator.options[0].value);
		operator.options[0].selected = true;
		//开始ajax添加课程内容下拉
		var className = t.value;
		var teacherNo = document.getElementById("teaId").innerText;
		//alert(className+"工号："+teacherNo);
		var url = "teacherajaxClassNameChange.action";
		var param = {
			'tauForm.className' : className,
			'tauForm.teacherNo' : teacherNo
		};
		$.post(url, param, callbackGetCourse);
	}
	function callbackGetCourse(result, textStatus) {
		if (textStatus == 'success') {
			if (result != null) {
				var json = eval("(" + result + ")");
				var op = $('#selectCourse');
				//alert(op);
				op.empty();
				for (var v1 = 0; v1 < json.length; v1++) {
					//alert(json[v1].courseNo+":"+json[v1].courseName);
					var courseNo = json[v1].courseNo;
					var courseName = json[v1].courseName;
					//alert(courseNo +": "+courseName);
					op.append("<option value='"+courseNo+"'>" + courseName
							+ "</option>")
				}
			}
		}
	}
	function getStuList() {
		//获取学生信息页面 ，并且判断后面的操作类型
		var operator = document.getElementById("selectOperater");
		//alert(operator.value);
		//值为:1 录入  2：修改  ajax
		var teacherNo = document.getElementById("teaId").innerText;
		var className = document.getElementById("selectClass").value;
		var courseNo = document.getElementById("selectCourse").value;
		var url1 = "teacherajaxStudentluru.action";
		var url2 = "teacherajaxStudentxiugai.action";
		//alert(className + ":" + teacherNo + "courseNo:" + courseNo);
		if (className == -1) {
			alert("请选择课程！")
			return false;
		}
		var param = {
			'tauForm.className' : className,
			'tauForm.teacherNo' : teacherNo,
			'tauForm.courseNo' : courseNo

		};
		if (operator.value == 1) {
			//发送录入请求
			$.post(url1, param, callbackLuru);
		} else if (operator.value == 2) {
			//发送修改请求
			$.post(url2, param, callbackXiugai);
		} else {
			return false;
		}
	}
	function callbackLuru(result, textStatus) {
		if (textStatus == 'success') {
			//alert(result);
			if (result == '' || result == null) {
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML = "<span style='color:red'>学生成绩以及全部录入完毕</span>";
			}
			if (result != null) {
				//alert(result);mytb1
				var json = eval("(" + result + ")");
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML = "";
				for (var v1 = 0; v1 < json.length; v1++) {
					tb.innerHTML += "<tr>"
							+ "<th class='hidden'>" + json[v1].studentNo
							+ "</th>" + "<th class='hidden'>"
							+ json[v1].courseNo + "</th>"
							+ "<th class='col-md-2'>" + json[v1].studentName
							+ "</th>" + "<th class='col-md-2'>"
							+ json[v1].courseName + "</th>"
							+ "<th class='col-md-2'>"
							+ "<input name='pingshi' type='text' maxlength='3' style='width:60px' >"
							+ "</th>" + "<th class='col-md-2'>"
							+ "<input name='exam' type='text' style='width:60px' >" + "</th>"
							+ "<th class='col-md-2'>" + "<input class='btn btn-default' name='exam' type='button' value='确认' style='width:60px' onclick='hiButton(this);' >" + "</th>"
							+ "</tr>";
				}
			}
		}
	}
	function callbackXiugai(result, textStatus) {

	}
	//点击 录入学生一个人的成绩
	function hiButton(b){
		//alert(b.value);
		//.style.visibility="visible";
		//获取表格中input的值
		//平时成绩
		var inputVal1 = b.parentNode.parentNode.cells[4].getElementsByTagName("INPUT")[0].value;
		//考试成绩
		var inputVal2 = b.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value;
		
		//alert(b.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value);
		if (inputVal1>=0&& !isNaN(inputVal1)&&inputVal2>=0&& !isNaN(inputVal2)
				&& inputVal1!='' && inputVal2!='') {
			if (inputVal1>30 || inputVal2>100) {
				alert("请输入正确的成绩范围：平时（0~30），考试（0~100）")
				return false;
			}
			//开始录入成绩
			var courseNo = b.parentNode.parentNode.cells[1].innerText;
			var studentNo = b.parentNode.parentNode.cells[0].innerText;
			var url = "teacherajaxStudentluruCJ.action";
			var param = {
				'tauForm.studentNo' : studentNo,
				'tauForm.courseNo' : courseNo,
				'tauForm.pingshiScore' : inputVal1,
				'tauForm.examScore' : inputVal2
			};
			//alert(studentNo+": "+courseNo+": "+inputVal1+": "+inputVal2);
			$.post(url, param, callbackLuruCJ);
			b.parentNode.parentNode.style.display="none";
		}else {
			alert("请输入成绩的正确格式");
			return false;
		}
		
	}
	function callbackLuruCJ(result, textStatus){
		
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
								
								<th class="hidden">学号</th>
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
