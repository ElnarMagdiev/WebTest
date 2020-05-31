<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit question</title>
</head>
<body>
<h3>Edit question</h3>
<form action="/question/edit" method="POST">
    <input type="hidden" name="id" value="${question.id}">
    <label for="content">Question</label>
    <input type="text" name="content" id="${question.id}" size="50" value="${question.content}">

    <ol type="a">
        <c:forEach var="answer" items="${question.answers}">
            <li>
                    ${answer.content}
            </li>
        </c:forEach>
    </ol>

    <br>

    <input type="submit" value="Submit">
</form>
</body>
</html>