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

<title>用户管理</title>

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
<script type="text/javascript"
	src='<c:url value="/resources/ext/SearchField.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/TreeGroupComboBox.js"/>'></script>
<!-- 公共引用 -->
<style type="text/css">
.user_add {
	background-image:
		url('<c:url value="/resources/css/images/user_add.gif"/>');
}

.user_modify {
	background-image:
		url('<c:url value="/resources/css/images/user_edit.png"/>');
}

.user_remove {
	background-image:
		url('<c:url value="/resources/css/images/user_delete.gif"/>');
}

.user_reset {
	background-image:
		url('<c:url value="/resources/css/images/user_suit.png"/>');
}

.search {
	background-image:
		url('<c:url value="/resources/css/images/search.png"/>');
}
</style>
<script type="text/javascript"
	src='<c:url value="/resources/page/user/user.js"/>' charset="utf-8">
	
</script>

</head>
<body>
	<!-- 
	<div id="tree" class="left"></div>
	<div id="content" class="right"></div>
 -->
</body>
</html>
