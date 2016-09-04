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

<title>大发系统 后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/ext/resources/css/ext-all.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/ext/bootstrap.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/locale/ext-lang-zh_CN.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/TabCloseMenu.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/page/index.js"/>' charset="utf-8">
	
</script>
</head>

<body>
</body>
</html>
