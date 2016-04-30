<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html>
<html>
<head>
    <!-- <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content=""> -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="icon/favicon.ico">

    <title>学生欢迎页面</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=application.getContextPath() %>/css/cover.css" rel="stylesheet">

<style>  
.col-center-block {  
    float: none;  
    display: block;  
    margin-left: auto;  
    margin-right: auto;  
}  
</style> 
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">
		<h2 class="form-signin-heading text-center"  style="margin-bottom: 50px">学生成绩学分制管理系统</h2>
            <div class="inner cover">
				<div class="container " >
				
				<div class="row col-sm-3 col-center-block">
				
				  <form class="form-signin" role="form" action="login" method="get">
				    <h2 class="form-signin-heading text-center">    </h2>
				    <input type="text"  name="user.username" class="form-control " placeholder="username" required autofocus>
				    <span style="color:red" ><s:fielderror fieldName="user.username"></s:fielderror></span>
				    <input style="margin-top: 20px "  type="password"  name="user.password" class="form-control" placeholder="Password" required>
				    <span style="color:red" ><s:fielderror fieldName="user.password"></s:fielderror></span>
				    
				    <select name="user.type" class="form-control" style="margin-top:20px  ">
					<option value="0">管理员</option>
					<option value="1">老师</option>
					<option value="2">学生</option>
					</select>
				    <button class="btn btn-lg btn-primary btn-block"  style="margin-top: 20px" type="submit">登录</button>
				  </form>
				   </div>
				</div>
            </div>

            <div class="cover-container">
            <div class="mastfoot row col-center-block">
                <div class="inner">
                    <p>李伟的毕业设计</p>
                </div>
            </div>

        </div>

    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
<script src="../bootStrap/bootstrap.min.js"></script>


</body>

</html>
