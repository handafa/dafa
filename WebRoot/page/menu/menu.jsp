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

<title>菜单管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
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
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/dafa.css"/>'>

</script>
<script type="text/javascript"
	src='<c:url value="/resources/page/menu/menu.js"/>' charset="utf-8">
	
</script>

<style type="text/css">
.add {
	background-image: url('<c:url value="/resources/css/images/add.gif"/>');
}

.modify {
	background-image:
		url('<c:url value="/resources/css/images/cog_edit.png"/>');
}

.remove {
	background-image:
		url('<c:url value="/resources/css/images/delete.gif"/>');
}
</style>
</head>

<body>
	<div id="tree" class="left"></div>
	<div id="content" class="right"></div>
</body>
</html>
