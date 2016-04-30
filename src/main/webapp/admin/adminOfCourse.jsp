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
<script type="text/javascript">
	function btnClick(u){
		//alert(u.innerText);
		/* var val =a.parentNode.childNodes; */
		//获取该行
		var tr = u.parentNode.parentNode;
		//获取第一列的内容
		var td1 = tr.cells[0].innerText;
		var td2 = tr.cells[1].innerText;
		var td3 = tr.cells[2].innerText;
		var td4 = tr.cells[3].innerText;
		var td5 = tr.cells[4].innerText;
		var td6 = tr.cells[5].innerText;
		var td7 = tr.cells[6].innerText;
		//alert(td1+":  "+td2);
		location.href="adminupdate?courseForm.courseNo="+td1+"&& msg.method=3 && courseForm.courseName= "+td2
				+"&& courseForm.courseType= "+td3+"&& courseForm.credit= "+td4+"&& courseForm.term= "+td5
				+"&& courseForm.professionName= "+td6+"&& courseForm.professionNo= "+td7;
		
	}
	function btnClickDel(d){
		//获取该行
		var tr = d.parentNode.parentNode;
		//获取第一列的内容
		var td1 = tr.cells[0].innerText;
		//发送删除dept消息
		location.href="admindelCourseById?courseForm.courseNo="+td1+"&&pageMsg.pageNo=1";
	}
</script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="adminhome">欢迎您：</a><span class="navbar-brand"><%=((Admin)ActionContext.getContext().getSession().get("admin")).getAccount() %></span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">设置</a></li>
					<li><a href="logoutadmin">注销</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="adminsearchCourseByNameForLike" method="get">
					<input  name="courseForm.content" type="text" class="form-control" placeholder="Search...">
					<input type="submit" class="form-control btn btn-info" value="查询">
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="adminhome">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
					<li><a href="admingetAllDeptList?pageMsg.pageNo=1">学院管理</a></li>
					<li><a href="admingetAllProList?pageMsg.pageNo=1">专业管理</a></li>
					<li class="active"><a href="#">课程管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetAllTeacherList?pageMsg.pageNo=1">教师管理</a></li>
					<li><a href="membergetClassIndex?pageMsg.pageNo=1">班级管理</a></li>
					<li><a href="membergetStudentIndex">学生管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetTeachingPlanIndex?tpForm.className=2016001">教学方案制定（班级选课）</a></li>
					<li><a href="membergetScoreIndex?scoreForm.studentNo=0">成绩管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header">
					欢迎：<%=((Admin)ActionContext.getContext().getSession().get("admin")).getAccount()%></h2>
				<button type="button" class="btn btn-success " onclick="javascript:location.href='adminadd?msg.method=3'">添加</button>
				
				<table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="col-sm-2">ID</th>
                        <th class="col-sm-2">课程名称</th>
                        <th class="col-sm-1">课程类型</th>
                        <th class="col-sm-1">学分</th>
                        <th class="col-sm-2">开课学期</th>
                        <th class="col-sm-2">专业名称</th>
                        <th class="hidden">专业编号</th>
                        <th class="col-sm-2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                   	<s:iterator id="list" value="courseList">
                   		<tr>
                   		<td><s:property value="courseNo"/></td>
                   		<td><s:property value="courseName"/></td>
                   		<td><s:property value="courseType"/></td>
                   		<td><s:property value="credit"/></td>
                   		<td><s:property value="term"/></td>
                   		<td><s:property value="professionName"/></td>
                   		<td class="hidden"><s:property value="professionNo"/></td>
                   		<td><button type="button" class="btn btn-default btn-sm" onclick="btnClick(this);">修改</button>
                   		<button type="button" class="btn btn-default btn-sm" onclick="btnClickDel(this);">删除</button>
                   		</td>
                   		</tr>
                   	</s:iterator>
                    </tbody>
                </table>
                <!-- 设置分页  -->
                <div>
					<ul class="pager">
						<s:if test="pageMsg.pageNo>1">
							<li class="previous"><a
								href="javascript:location.href='admingetAllCourseList?
							pageMsg.pageNo=<s:property value="pageMsg.pageNo-1" />
							&&pageMsg.pageCount=<s:property value="pageMsg.pageCount" />'">&larr;
									上一页</a></li>
						</s:if>
						<s:else>
							<li class="previous disabled"><a>&larr;上一页</a></li>
						</s:else>
						<li class=""><span>总计：<s:property
									value="pageMsg.pageNo" />/<s:property
									value="pageMsg.pageCount" /> 页
						</span></li>
						<s:if test="pageMsg.pageNo+1<=pageMsg.pageCount">
							<li class="next"><a
								href="javascript:location.href='admingetAllCourseList?
							pageMsg.pageNo=<s:property value="pageMsg.pageNo+1" />
							&& pageMsg.pageCount=<s:property value="pageMsg.pageCount" />'">下一页
									&rarr;</a></li>
						</s:if>
						<s:else>
							<li class="next disabled"><a>&larr;上一页</a></li>
						</s:else>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="<%=application.getContextPath()%>/bootstrap/bootstrap.min.js"></script>
</body>
</html>