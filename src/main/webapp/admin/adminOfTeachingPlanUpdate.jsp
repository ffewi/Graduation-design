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
<script type="text/javascript" src="../jquery/jquery-1.6.js" ></script>
<script type="text/javascript">
	function getCourse(s){
		//alert(s.value);
		var term = s.value;
		var cno = $('#classNo').val();
		
		alert(cno);
		var url = "membergetTerm.action";
		var param ={
				'tpForm.term':term,
				'tpForm.className':cno
		};
		$.post(url,param,callback);
	}
	function callback(result,textStatus){
		if (textStatus  == 'success') {
			if (result!=null) {
				//alert(result);
				var selectCourse =  $('#list1');
				selectCourse.empty();
				//var s = result.split(",");
				var json =  eval("(" + result + ")");
				//alert(json.length);
				for (var v1 = 0; v1 < json.length; v1++) {
					var courseNo = json[v1].courseNo;
					var courseName = json[v1].courseName;
					selectCourse.append("<option value='"+courseNo+"'>"+courseNo+courseName+"</option>");
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
            </button>-->
				<a class="navbar-brand" href="#">欢迎您：</a><span class="navbar-brand"><%=((Admin) ActionContext.getContext().getSession().get("admin")).getAccount()%></span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="javascript:void(0)" onclick="showcaoz();">设置</a></li>
					<li><a href="#">注销</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right "  action="adminsearchDeptByNameForLike" method="get">
					<input id="deptID" name="deptForm.content" disabled="disabled" type="text" class="form-control " placeholder="Search...">
					<input type="submit" disabled="disabled" class="form-control btn btn-info " value="查询">
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
					<li><a href="admingetAllProList?pageMsg.pageNo=1">专业管理</a></li>
					<li><a href="admingetAllCourseList?pageMsg.pageNo=1">课程管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">教师管理</a></li>
					<li><a href="#">辅导员管理</a></li>
					<li><a href="#">教学秘书管理</a></li>
					<li><a href="#">学生管理</a></li>
					<li><a href="#"></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">教学方案制定（班级选课）</a></li>
					<li><a href="#">成绩管理</a></li>
					<li><a href="#"></a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header">
					欢迎：<%=((Admin) ActionContext.getContext().getSession().get("admin")).getAccount()%></h2>
				<s:form action="memberexeUpdateTeaching" method="post" >
				
					<div class="row input-group col-sm-4" style="margin-top: 60px;margin-left: 80px">
						<span class="input-group-addon" style="width:100px">班级号</span> <input type="text"  readonly="readonly"
							id="classNo" name="tpForm.className" class="form-control"  value='<s:property value="tpForm.className"/>'>
					</div>
					
					<div class="row input-group col-sm-4" style="margin-top: 20px;margin-left: 80px">
						<span class="input-group-addon" style="width:100px">学期</span>
							<!-- 使用select -->
						<select disabled="disabled" name="tpForm.term" class="form-control" onchange="getCourse(this);">
							<s:hidden><option selected="selected" value='<s:property value="tpForm.term"/>'>
							<s:if test="tpForm.term==1">1 大一上</s:if>
							<s:if test="tpForm.term==2">2 大一下</s:if>
							<s:if test="tpForm.term==3">3 大二上</s:if>
							<s:if test="tpForm.term==4">4 大二下</s:if>
							<s:if test="tpForm.term==5">5 大三上</s:if>
							<s:if test="tpForm.term==6">6 大三下</s:if>
							<s:if test="tpForm.term==7">7 大四上</s:if>
							<s:if test="tpForm.term==8">8 大四下</s:if>
							</option></s:hidden>
						</select>
					</div>
					<div class="row input-group col-sm-4" style="margin-top: 20px;margin-left: 80px">
						<span class="input-group-addon" style="width:100px">授课老师</span>
							<!-- 使用select -->
						<select name="tpForm.teacherNo" class="form-control">
							<s:iterator id="list2" value="teacherList">
								<option value="<s:property value="teacherNo"/>"><s:property value="teacherNo"/><s:property value="teacherName"/></option>
							</s:iterator>
							<s:hidden><option selected="selected" value='<s:property value="tpForm.teacherNo"/>'>
							<s:property value="tpForm.teacherNo"/><s:property value="tpForm.teacherName"/></option></s:hidden>
						</select>
					</div>
					<div class="row input-group col-sm-4" style="margin-top: 20px;margin-left: 80px">
						<span class="input-group-addon" style="width:100px">课程</span>
							<!-- 使用select -->
						<select  id="list1" name="tpForm.courseNo" class="form-control">
							<option selected="selected" value='<s:property value="tpForm.courseNo"/>'>
							<s:property value="tpForm.courseNo"/><s:property value="tpForm.courseName"/></option>>
						</select>
						
					</div>
					<div align="center" class="row input-group col-sm-4" style="margin-top: 20px;margin-left: 80px;">
						<button type="submit" style="width:120px" class="btn btn-default">确定</button>
						<button type="button" style="margin-left: 40px;width:120px" class="btn btn-default"
							onclick="javascript:history.go(-1);">返回</button>	
					</div>
						
				</s:form>
			</div>
		</div>
	</div>
	<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="<%=application.getContextPath()%>/bootstrap/bootstrap.min.js"></script>
</body>
</html>