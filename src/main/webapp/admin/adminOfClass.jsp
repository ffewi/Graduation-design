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
<!-- 添加弹框需要的风格与样式，远程引入 -->
<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.gbtags.com/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script
	src="http://cdn.gbtags.com/twitter-bootstrap/3.2.0/js/bootstrap.js"></script>
<!-- 添加弹框需要的风格与样式，远程引入 -->
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
	function btnClick(u) {
		//alert(u.innerText);
		/* var val =a.parentNode.childNodes; */
		//获取该行
		var tr = u.parentNode.parentNode;
		//获取第一列的内容
		var td1 = tr.cells[0].innerText;
		var td2 = tr.cells[1].innerText;
		var td3 = tr.cells[2].innerText;
		//alert(td1+":  "+td2);
		location.href = "adminupdate?proForm.professionNo=" + td1
				+ "&& proForm.professionName= " + td2
				+ "&& msg.method=2 && proForm.deptName=" + td3;

	}

	function btnClickDel(d) {
		//获取该行
		var tr = d.parentNode.parentNode;
		//获取第一列的内容
		var td1 = tr.cells[0].innerText;
		//发送删除dept消息
		location.href = "admindelProById?proForm.professionNo=" + td1+"&&pageMsg.pageNo=1";
	}
</script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<!--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>-->
				<a class="navbar-brand" href="#">欢迎您：</a><span class="navbar-brand"><%=((Admin) ActionContext.getContext().getSession().get("admin")).getAccount()%></span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="javascript:void(0)" onclick="showcaoz();">设置</a></li>
					<li><a href="#">注销</a></li>
					<li><a href="#">帮助</a></li>
				</ul>

				<form class="navbar-form navbar-right"
					action="adminsearchProByNameForLike" method="get">
					<input name="proForm.content" type="text" class="form-control"
						placeholder="Search..."> <input type="submit"
						class="form-control btn btn-info" value="查询">
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="#">详情(点我没有用！)</a></li>
					<li><a href="admingetAllDeptList?pageMsg.pageNo=1">学院管理</a></li>
					<li><a href="#">专业管理</a></li>
					<li><a href="admingetAllCourseList?pageMsg.pageNo=1">课程管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetAllTeacherList?pageMsg.pageNo=1">教师管理</a></li>
					<li><a href="#">辅导员管理</a></li>
					<li class="active"><a href="#">班级管理</a></li>
					<li><a href="#">学生管理</a></li>
					<li><a href="#"></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="membergetTeachingPlanIndex?tpForm.className=2016001">教学方案制定（班级选课）</a></li>
					<li><a href="#">成绩管理</a></li>
					<li><a href="#"></a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header">
					欢迎：<%=((Admin) ActionContext.getContext().getSession().get("admin")).getAccount()%></h2>
				<button type="button" class="btn btn-success " onclick="javascript:location.href='adminadd?msg.method=1'">添加</button>

				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-sm-2">ID</th>
							<th class="col-sm-4">专业名称</th>
							<th class="col-sm-4">人数</th>
							<th class="hidden">专业ID</th>
							<th class="col-sm-2">操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="list" value="cfList">
							<tr>
								<td><s:property value="className" /></td>
								<td><s:property value="professionName" /></td>
								<td><s:property value="stuTotal" /></td>
								<td class="hidden"><s:property value="professionNo" /></td>
								<td><button type="button" class="btn btn-default btn-sm"
										onclick="btnClick(this);">修改</button>
									<button type="button" class="btn btn-default btn-sm"
										onclick="btnClickDel(this);">删除</button></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div>
					<ul class="pager">
						<s:if test="pageMsg.pageNo>1">
							<li class="previous"><a
								href="javascript:location.href='admingetAllProList?
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
								href="javascript:location.href='admingetAllProList?
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