<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 04.12.2015
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit avtor</title>
</head>
<body>
<form action="library" method="post">
    Правка автора
    <table>
        <tr><td>Имя</td><td><input type="text" name="name" value="${avtor.name}"></tr></tr>
        <tr><td>Коммент</td><td><input type="text" name="comment" value="${avtor.comment}"></tr></tr>
        <tr><td colspan="2"><input type="submit" value="Ok"></td></tr>
    </table>
    <input type="hidden" name="editavtor" value="yes">
    <input type="hidden" name="id" value="${avtor.id}">
</form>
</body>
</html>
