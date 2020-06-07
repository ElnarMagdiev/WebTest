<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Ваш результат</h3>
<c:if test="${completed == true}">
Тест пройден!
</c:if>
<c:if test="${completed != true}">
    Тест не пройден!
</c:if>
<br>
Пользователь: ${username}
<br>
<br>
Результат: ${count}
<br>
<br>
Вы прошли тестирование лучше чем: ${betterYou}% пользователей
<br>
<br>
Вы прошли тестирование хуже чем: ${worseThanYou} % пользователей
<br>
<br>
<a href="/">Главное меню</a>
</body>

</html>