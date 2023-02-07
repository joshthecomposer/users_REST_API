<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="/script/script.js" defer></script>
<title>MVC</title>
</head>

<body>
	<div class="container col-9 bg-light rounded p-5">
		<h1 class="display-4"><c:out value="${u.first}"/> <c:out value="${u.last}"/></h1>
		<hr>
		<p class="lead">Email: <c:out value="${u.email}" /></p>
		<p class="lead">Created: <fmt:formatDate value="${u.created_at}" pattern="MMMM dd, yyyy"/></p>
	</div>
</body>
</html>