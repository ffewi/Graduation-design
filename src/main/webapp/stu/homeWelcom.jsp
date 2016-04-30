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

<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/cover.css"
	rel="stylesheet">
<%-- <link href="<%=application.getContextPath() %>/css/model.css" rel="stylesheet"> --%>
<script type="text/javascript">
	function showView() {
		/* $("#myModal").draggable({
		    handle: ".modal-header"
		}); */
		$('#myModal').css({
			position : "absolute",
			'top' : 30,
			'left' : 0
		})
		$('#myModal').modal({

			keyboard : true
		})
	}

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
</script>
</head>

<body>
	<jsp:include page="../jsp/updateStuPass.jsp"></jsp:include>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">毕业设计</h3>
						<ul class="nav masthead-nav">
							<li><a
								href='<s:url action="studentindexPage">
                    	<s:param name="stu.studentNo" value="stuMsg.studentNo " />
                    	</s:url>'>主页</a></li>
							<li><a href="#myModal" data-toggle="modal"
								onclick="showView();">修改密码</a></li>
							<li><a href="logoutstudent">注销</a></li>
						</ul>
					</div>
				</div>


				<div class="inner cover">
					<h1 class="cover-heading">灰常欢迎你: ${admin.studentName }又回来了</h1>
					<p class="lead">你的成绩概统为一下部分</p>
					<p class="lead">
						<a
							href='<s:url action="studentindexPage">
                    	<s:param name="stu.studentNo" value="stuMsg.studentNo " />
                    </s:url>'
							class="btn btn-lg btn-default">进入主页，带你飞</a>
					</p>
				</div>

				<div class="cover-container">
					<div class="row">
						<p class="lead col-md-2">平均绩点</p>
						<p class="lead col-md-2">总学分</p>
						<p class="lead col-md-2">必修课</p>
						<p class="lead col-md-2">通识教育</p>
						<p class="lead col-md-2">选修课</p>
						<p class="lead col-md-2">社会实践</p>
					</div>
					<div class="row">
						<p class="lead col-md-2">
							<s:property value="sd.avgPoint" />
						</p>
						<p class="lead col-md-2">
							<s:property value="sd.totalXueFen" />
							/170
						</p>
						<p class="lead col-md-2">
							<s:property value="sd.biXiuXueFen" />
							/40
						</p>
						<p class="lead col-md-2">
							<s:property value="sd.tongShiXueFen" />
							/36
						</p>
						<p class="lead col-md-2">
							<s:property value="sd.xuanXiuXueFen" />
							/30
						</p>
						<p class="lead col-md-2">
							<s:property value="sd.sheHuiShiJian" />
							/64
						</p>
					</div>

				</div>

				<div class="mastfoot">
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
	<script src="/bootstrap/bootstrap.min.js"></script>


</body>

</html>
