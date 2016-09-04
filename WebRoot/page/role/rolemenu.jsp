<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>角色授权</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<!-- 公共引用 -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/ext/resources/css/ext-all.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/ext/bootstrap.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/locale/ext-lang-zh_CN.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/share.js"/>'></script>
<!-- 公共引用 -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/dafa.css"/>'>
<style type="text/css">
.authorize {
	background-image:
		url('<c:url value="/resources/css/images/authorize.png"/>');
}

.unauthorize {
	background-image:
		url('<c:url value="/resources/css/images/unauthorize.png"/>');
}
</style>
<script type="text/javascript"
	src='<c:url value="/resources/page/role/rolemenu.js"/>' charset="utf-8">
	
</script>

</head>
<body>
	<div id="role" class="left_role"></div>
	<div id="menu" class="right_role"></div>
</body>
</html>
