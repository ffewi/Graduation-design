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
    <link rel="icon" href="../../icon/favicon.ico">

    <title>学生欢迎页面</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS
    <link href="../../BootStrap/bootstrap.min.css" rel="stylesheet">

    Custom styles for this template -->
    <link href="<%=application.getContextPath() %>/page/BYSJPage/student/cover.css" rel="stylesheet">

</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">毕业设计</h3>
                    <ul class="nav masthead-nav">
                        <li class="active"><a href="studentActionindexPage">主页</a></li>
                        <li><a href="#">修改密码</a></li>
                        <li><a href="#">帮助</a></li>
                    </ul>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">修改密码</h1>
               
            </div>

            <div class="inner cover">
				<div class="container " >
				<div class="row col-sm-3 col-sm-offset-2">
				 <s:fielderror></s:fielderror>
				  <form class="form-signin" role="form" action="studentActionupdatePwd" method="get">
				    <h2 class="form-signin-heading text-center">Please write in</h2>
				    <input type="hidden" name="username" value="<%=request.getParameter("username") %>">
				    <input type="password"  name="user.password" class="form-control " placeholder="Password" required>
				    <div class="checkbox">
				    </div>
				    <input type="password"  name="pwd" class="form-control " placeholder="repeat Password" required>
				    <div class="checkbox">
				    </div>
				    <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
				  </form>
				   </div>
				</div>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>李伟的毕业设计 <a href="tomail://ffewi@foxmail.com">@copyright</a>, by <a href="http://www.baidu.com">@李伟</a>.</p>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
<script src="../../BootStrap/bootstrap.min.js"></script>
<script src="../../assets/js/docs.min.js"></script>


</body>

</html>
