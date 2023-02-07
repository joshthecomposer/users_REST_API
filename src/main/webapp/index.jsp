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
	<div class="container col-9 bg-light rounded">
		<c:forEach var="u" items="${users}">
			<h1 class="display-5">${u.first} ${u.last}</h1>
			<p>Email: ${u.email}</p>
			<p>Created: <fmt:formatDate value="${u.created_at}" pattern="MMMM d, yyyy"/></p>
			<div class="d-flex gap-3 my-3">
				<a class="btn btn-outline-primary btn-sm" href="/users/${u.id}">View</a>
				<a class="btn btn-outline-danger btn-sm" href="/users/delete/${u.id}">Delete</a>
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
</html>