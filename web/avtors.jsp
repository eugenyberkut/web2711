<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 27.11.2015
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторы</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>id</th><th>Имя</th><th>Комментарий</th><th>Книги</th><th></th><th></th>
        </thead>
        <tbody>
        <c:forEach var="avtor" items="${avtors}">
            <tr>
                <td>${avtor.id}</td><td>${avtor.name}</td><td>${avtor.comment}</td>
                <td><a href="library?avtor_id=${avtor.id}">Показать</a></td>
                <td><a href="library?delete_avtor_id=${avtor.id}">Удалить</a></td>
                <td><a href="library?edit_avtor_id=${avtor.id}">Правка</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="library" method="post">
        Новый автор
        <table>
            <tr><td>Имя</td><td><input type="text" name="name"></tr></tr>
            <tr><td>Коммент</td><td><input type="text" name="comment"></tr></tr>
            <tr><td colspan="2"><input type="submit" value="Ok"></td></tr>
        </table>
        <input type="hidden" name="addavtor" value="yes">
    </form>
</body>
</html>
