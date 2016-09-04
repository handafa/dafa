<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/ext/resources/css/ext-all.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/ext/bootstrap.js"/>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/resources/ext/locale/ext-lang-zh_CN.js"/>'>
	
</script>

