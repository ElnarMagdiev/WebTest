<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Web Testing</h3>

<form method="post" action="/questions/${question.id}/answers">
    ${question.content}
    <ol type="a">

        <input type="hidden" name="id_question" value="${question.id}">

        <c:forEach var="i" begin="0" end="3">
            <li>

                <input type="hidden" name="id_${i}" value="${!empty question.answers[i].id ? question.answers[i].id
                                                                                                        :''}">
                <input type="text" name="answer_content_${i}" id="answer_content_${i}"
                       value="${!empty question.answers[i].content ? question.answers[i].content : ''}">

               <c:if test="${question.answers[i].correct == true}">
                 <input type="radio" name="answer_isCorrect" value="${i}" checked>
                </c:if>
                <c:if test="${question.answers[i].correct != true}">
                <input type="radio" name="answer_isCorrect" value="${i}">
                 </c:if>

            </li>

            <br>
        </c:forEach>
    </ol>
    <br>
    <input type="submit" value="Submit">
</form>
<a href="/questions">Назад</a>
</body>
</html>