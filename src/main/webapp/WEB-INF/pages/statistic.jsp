<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>
<body>
<h3>Статистика</h3>

<br>
Всего пользователей: ${allUsersCount}
<br>
<br>
Количество пользователей прошедших тестирование: ${resultsCount}
<br>
<br>
Количество пользователей ответивших на все вопросы: ${completeTest}
<br>
<br>
<a href="/">Главное меню</a>
</body>

</html>