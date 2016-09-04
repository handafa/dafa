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

<title>组织管理</title>

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
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/dafa.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/ext/TreeGroupComboBox.js"/>'></script>
<!-- 公共引用 -->
<style type="text/css">
.add {
	background-image:
		url('<c:url value="/resources/css/images/user_add.gif"/>');
}

.modify {
	background-image:
		url('<c:url value="/resources/css/images/user_edit.png"/>');
}

.remove {
	background-image:
		url('<c:url value="/resources/css/images/user_delete.gif"/>');
}
</style>
<script type="text/javascript"
	src='<c:url value="/resources/page/group/group.js"/>' charset="utf-8">
	
</script>

<style type="text/css">
.add {
	background-image:
		url('<c:url value="/resources/css/images/user_add.gif"/>');
}

.modify {
	background-image:
		url('<c:url value="/resources/css/images/user_edit.png"/>');
}

.remove {
	background-image:
		url('<c:url value="/resources/css/images/user_delete.gif"/>');
}

.open {
	background-image: url('<c:url value="/resources/css/images/open.png"/>');
}

.close {
	background-image:
		url('<c:url value="/resources/css/images/close.png"/>');
}

.refresh {
	background-image:
		url('<c:url value="/resources/css/images/refresh.png"/>');
}
</style>

</head>
<body>
	<div id="tree" class="left"></div>
	<div id="content" class="right"></div>
</body>
</html>
