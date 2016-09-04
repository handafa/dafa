<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>大发系统 登陆界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/ext/resources/css/ext-all.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/ext/bootstrap.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/locale/ext-lang-zh_CN.js"/>'>
	
</script>

<script type="text/javascript"
	src='<c:url value="/resources/ext/ExtMD5.js"/>'>
	
</script>

<script type="text/javascript"
	src='<c:url value="/resources/login.js"/>'></script>
<style type="text/css">
.login {
	margin-left: 0;
	margin-top: 150;
	width: 400;
}
</style>
</head>

<body background="<c:url value="/resources/css/images/login_bg.png"/>">

	<table width="100%" height="100%" border="1" align="center">
		<tr width="100%" height="100%" valign="top">
			<td width="100%" height="100%" align="center">
				<div id="login" align="left" class="login"></div>
			</td>
		</tr>
	</table>
</body>
</html>
