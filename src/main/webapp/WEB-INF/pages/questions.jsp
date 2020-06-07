<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Web Testing</h3>
<a href="/questions/add">add new question</a>
<form method="post" action="/questions/edit">
    <ol type="1">
        <c:forEach var="question" items="${listQuestion}">
            <li>
                    ${question.content}
                <a href="/questions/${question.id}/answers">Добавить ответы</a>
                <input type="hidden" name="questionId" value="${question.id}">
                <ol type="a">
                    <c:forEach var="answer" items="${question.answers}">
                        <li>
                                ${answer.content}
                        </li>
                    </c:forEach>
                </ol>
            </li>
        </c:forEach>
    </ol>
    <br>
</form>

</body>
</html>