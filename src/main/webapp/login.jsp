<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
</head>
<body>
	<div align="center" style="width: 100%;height: 100%">
	<div id="div"
		style="width: 40%; height: 100%; border: 1px solid #000; margin-top: 20%" align="center">
			<div>
			<s:form action="login" method="get">
				<%-- <s:fielderror></s:fielderror> --%>
				<s:textfield name="user.username" label="用户名"></s:textfield>
				<s:password name="user.password" label="密码"></s:password>
				<s:actionmessage theme="simple" />
				<s:select
					list="#{'0':'admin','1':'teacher','2':'student','3':'assistant','4':'mishu'}"
					listKey="key" listValue="value" name="user.type" label="类型："
					value="2"></s:select>
				<s:submit value="login in" align="right"></s:submit>
			</s:form>
			</div>
	</div>
	</div>
</body>
</html>