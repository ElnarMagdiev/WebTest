<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit question</title>
</head>
<body>
<h3>Add question</h3>
<form action="/question/add" method="post">
    <input type="hidden" name="id" value="">
    <input type="text" name="content" id="content" size="50">
    <br>

    <input type="submit" value="Submit">
</form>
</body>
</html>