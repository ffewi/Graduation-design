<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.cs.liwei.pojo.Admin"%>
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

<title>Admin主页</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<%=application.getContextPath()%>/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=application.getContextPath()%>/bootstrap/dashboard.css"
	rel="stylesheet">
<script type="text/javascript" src="<%=application.getContextPath()%>/jquery/jquery-1.6.js"></script>
<script type="text/javascript">
	//秘密重置表单事件效果
	function contralDiv1(){
		//alert("sb");
		//var div1 = $('#contralofdiv1');
		var div1 = document.getElementById("contralofdiv1");
		var btn1 = document.getElementById("btn1");
		if (div1.style.display=="none") {
			div1.style.display = "";
			btn1.innerText="修改密码";
		}else {
			div1.style.display = "none";
			btn1.innerText="这里有个秘密";
			$("#pass").attr("disabled", true);
		}
	}
	//
	function subPass(){
		var account = $("#account").val();
		var pass = $("#pass").val();
		//alert(account+":"+pass);
		if (pass.length<6) {
			alert("密码不为空并且长度大于等于6");
			return;
		}
		var url = "adminajaxChangeUserPass.action";
		var accountNameType = account.charAt(0);
		var accountName = "";
		if (accountNameType=='9') {
			accountName ="admin";
		}
		if (accountNameType=='4') {
			accountName ="student";
		}
		if (accountNameType=='3') {
			accountName ="teacher";
		}
		if (accountName=="") {
			alert("账号类型错误！");
			return;
		}
		var param ={
				"ad.account": account,
				"ad.password": pass,
				"ad.accountName":accountName
		};
		
		$.post(url,param,chenggongxiugai);
	}
	function chenggongxiugai(result,textStatus){
		if (textStatus=="success") {
			if (result!=null) {
				var json = eval("(" + result + ")");
				if (json==true) {
					alert("修改成功！");
				}
			}
		}
	}
	function showPass(zh){
		//undefined || disabled
		if (zh.value.length==0) {
			alert("请输入账号");
			return ;
		}
		var url = "adminajaxChangeUserPassJudge.action";
		var account =zh.value;
		var accountNameType = zh.value.charAt(0);
		var accountName = "";
		if (accountNameType=='9') {
			accountName ="admin";
		}
		if (accountNameType=='4') {
			accountName ="student";
		}
		if (accountNameType=='3') {
			accountName ="teacher";
		}
		if (!(accountNameType=='3' || accountNameType=='4' || accountNameType=='9')) {
			$("#pass").attr("disabled",true);
			return ;
		}
		//alert(accountName+":"+account);
		//accountName:admin/teacher/student  
		var param ={
				"ad.account": account,
				
				"ad.accountName":accountName
		};
		$("#pass").attr("disabled", false);
		$.post(url,param,hasAccount);
	}
	function hasAccount(result,textStatus){
		if (textStatus=="success") {
			if (result!=null) {
				var json = eval("(" + result + ")");
				//alert(json);
				if (json==false) {
					alert("账户不存在");
					$("#pass").attr("disabled", true);
					return ;
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
            <!-- (Admin) .getAccount()-->
				<a class="navbar-brand" href="#">欢迎您：</a><span class="navbar-brand"><%=((Admin)ActionContext.getContext().getSession().get("admin")).getAccount() %></span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">设置</a></li>
					<li><a href="logoutadmin">注销</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="#" onsubmit="return false;">
					<input id="deptID" name="deptForm.content" type="text" class="form-control" placeholder="Search...">
					<input type="submit" class="form-control btn btn-info" value="查询">
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
					<li><a href="admingetAllDeptList?pageMsg.pageNo=1">学院管理</a></li>
					<li><a href="admingetAllProList?pageMsg.pageNo=1">专业管理</a></li>
					<li><a href="admingetAllCourseList?pageMsg.pageNo=1">课程管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetAllTeacherList?pageMsg.pageNo=1">教师管理</a></li>
					<li><a href="membergetClassIndex?pageMsg.pageNo=1">班级管理</a></li>
					<li><a href="membergetStudentIndex">学生管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetTeachingPlanIndex?tpForm.className=20160001">教学方案制定（班级选课）</a></li>
					<li><a href="membergetScoreIndex?scoreForm.studentNo=0">成绩管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header">
					欢迎：<%=((Admin)ActionContext.getContext().getSession().get("admin")).getAccount()%></h2>
				<div class="well well-lg text-center">
						<h3>欢迎登录到首页，请选择左边 选项进行操作
						</h3>
						<button id="btn1" class="btn btn-danger"  onclick="contralDiv1();"> 这里有个秘密</button>
				</div>
				<div id="contralofdiv1" style="display: none" class="well well-lg text-center center-block">
					
					<form action="#" role="form" onsubmit="return false;" >
						<input type="text" id="account" class="form-control col-sm-offset-4 " onblur="showPass(this);"
						 style="width:300px" placeholder="这里可以重置任何人账号密码">
						<input type="password" id ="pass" style="width:300px;margin-top: 20px" disabled="disabled"
						class="form-control col-sm-offset-4 " placeholder="请输入重置密码">
						<button type="submit" style="margin-top: 20px;width: 100px" 
						class="btn btn-primary form-group " onclick="subPass();">提交</button>
					</form>
					
				</div>
			</div>
		</div>
	</div>
	<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="<%=application.getContextPath()%>/bootstrap/bootstrap.min.js"></script>
</body>
</html>