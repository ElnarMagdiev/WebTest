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

    <ol type="1">
        Add answers

        <li>
            <input type="hidden" name="answer_id_1" id="answer_id_1">
            <input type="text" name="answer_content_1" id="answer_content_1" value="">
            <input type="radio" name="answer_isCorrect_1" id="answer_isCorrect_1" value="">
        </li>
        <li>
            <input type="hidden" name="answer_id_2" id="answer_id_2">
            <input type="text" name="answer_content_2" id="answer_content_2" value="">
            <input type="radio" name="answer_isCorrect_2" id="answer_isCorrect_2" value="">
        </li>
        <li>
            <input type="hidden" name="answer_id_3" id="answer_id_3">
            <input type="text" name="answer_content_3" id="answer_content_3" value="">
            <input type="radio" name="answer_isCorrect_3" id="answer_isCorrect_3" value="">
        </li>
        <li>
            <input type="hidden" name="answer_id_4" id="answer_id_4">
            <input type="text" name="answer_content_4" id="answer_content_4" value="">
            <input type="radio" name="answer_isCorrect_4" id="answer_isCorrect_4" value="">
        </li>
    </ol>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>