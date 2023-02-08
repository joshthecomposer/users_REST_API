<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

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
		<h1 class="display-4">Create a new user</h1>
		<hr>
		<form:form action="/users" method="POST" modelAttribute="user">
			<div class="form-group">
				<form:label path="first">First Name</form:label>
				<form:errors path="first" class="text-danger" />
				<form:input class="form-control" type="text" path="first" />
			</div>
			<div class="form-group">
				<form:label path="last">Last Name</form:label>
				<form:errors path="last" class="text-danger" />
				<form:input class="form-control" type="text" path="last" />
			</div>
			<div class="form-group">
				<form:label path="first">Email</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input class="form-control" type="text" path="email" />
			</div>
			<button type="submit" class="btn btn-primary btn-block">Submit</button>
		</form:form>
	</div>
</body>
</html>