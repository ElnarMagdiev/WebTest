<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Web Testing</h3>

<form method="post" action="${pageContext.request.contextPath}/submit">
    ${question.content}
    <ol type="a">
        <c:forEach var="answer" items="${question.answers}">
            <li>
                <input type="hidden" name="answerId" value="${answer.id}">
                <input type="radio" name="answer_content" value=${answer.content}>
            </li>
        </c:forEach>
    </ol>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>