
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Книги</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>id</th><th>Название</th><th>стр</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td><td>${book.nazvanie}</td><td>${book.pages}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
