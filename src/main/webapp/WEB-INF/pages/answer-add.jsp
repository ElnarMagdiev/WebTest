<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Web Testing</h3>

<form method="post" action="/question/${question.id}/answers">
    ${question.content}
    <ol type="a">

        <c:forEach var="i" begin="0" end="3">
            <li>
                <c:if test="${!empty question.answers[i].id}">
                    <input type="hidden" name="id_${i}" value="${question.answers[i].id}">
                    <input type="text" name="answer_content_${i}" id="answer_content_${i}"
                                                                        value="${question.answers[i].content}">

                    <input type="radio" name="answer_isCorrect_${i}" id="answer_isCorrect_${i}" checked>
                </c:if>
                <c:if test="${empty question.answers[i].id}">
                    <input type="text" name="answer_content_${i}" id="answer_content_${i}">
                    <input type="radio" name="answer_isCorrect_${i}" id="answer_isCorrect_${i}">
                </c:if>
            </li>

            <br>
        </c:forEach>
    </ol>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>