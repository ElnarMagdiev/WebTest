<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
<table>
    <tr>
        <th>Пройти тестирование</th>
        <th>Редактировать тест</th>
        <th>Статистика</th>
    </tr>
    <tr>
        <td>
            <a href="/test">Пройти тестирование</a>
        </td>
        <td>
            <a href="/question">Редактировать тест</a>
        </td>
        <td>
            <a href="/statistic">Статистика</a>
        </td>
    </tr>
</table>
</body>
</html>