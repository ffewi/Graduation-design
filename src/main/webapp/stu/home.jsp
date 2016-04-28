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
	<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="<%=application.getContextPath() %>/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=application.getContextPath() %>/css/dashboard.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed btn btn-default" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar">11111111111111</span>
                <span class="icon-bar">22222222222</span>
                <span class="icon-bar">3333333333</span>
            </button>
            
            <a class="navbar-brand" href="#">毕业设计:</a>
            <span class="navbar-brand" >${student.studentName }</span>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <li><a href="#">设置</a></li>
                <li><a href="logout">注销</a></li>
                <li><a href="#">帮助</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="#">
					<input id="deptID" name="deptForm.content" type="text" class="form-control" placeholder="Search...">
					<input type="submit" class="form-control btn btn-info" value="查询">
				</form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <!-- <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">详情(点我没有用！)</a></li>
                <li><a href="#">课程(点我没有用！)</a></li>
                <li><a href="#">活动(点我没有用！)</a></li>
                <li><a href="#">消息(点我没有用！)</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="#">新概念(点我没有用！)</a></li>
                <li><a href="#">新东方(点我没有用！)</a></li>
                <li><a href="#">新文化(点我没有用！)</a></li>
                <li><a href="#">新世界(点我没有用！)</a></li>
                <li><a href="#">新新世界(点我没有用！)</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="#">退出(点我没有用！)</a></li>
                <li><a href="#">已经超神(点我没有用！)</a></li>
                <li><a href="#">我能打八个(点我没有用！)</a></li>
            </ul>col-sm-offset-3col-md-offset-2
        </div> -->
        <div class="col-sm-9  col-md-10 col-md-offset-1 main">
           
            <h6 class="sub-header">你的身份是：学生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号：${student.studentNo }</h6>
            <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-4 main">
            <ul class="pagination ">
                <li><a href="#">&laquo;</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><span>...</span></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
            </ul>
            
            </div>
            <div class="">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="hidden">ID</th>
                        <th>课程名称</th>
                        <th>课程类型</th>
                        <th>教授老师</th>
                        <th>成绩</th>
                        <th>绩点</th>
                    </tr>
                    </thead>
                    <tbody>
                    
                   	<s:iterator id="list" value="list">
                   		<tr>
                   		<td class="hidden">1,004</td>
                   		<td>:<s:property value="cou_name"/></td>
                   		<td>:<s:property value="category_name"/></td>
                        <td>:<s:property value="tea_name"/></td>
                        <td>:<s:property value="score"/></td>
                        <td>:<s:property value="grade"/></td>
                   		</tr>
                   	</s:iterator>
                   	
					
                    </tbody>
                </table>
              </div> 
                <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-4 main">
                    <ul class="pagination ">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><span>...</span></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
                
            </div>
		</div>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
<script src="<%=application.getContextPath() %>/bootstrap/bootstrap.min.js"></script>


</body>

</html>
