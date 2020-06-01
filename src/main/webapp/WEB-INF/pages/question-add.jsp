<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit question</title>
</head>
<body>
<h3>Edit question</h3>
<form action="/question/add" method="post">
    <input type="hidden" name="id" value="${question.id}">
    <input type="text" name="content" id="${question.id}" size="50" value="${question.content}">

    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>