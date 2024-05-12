<%@ page contentType="text/html; charset=UTF-8"
         isELIgnored="false"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="container mt-5">
    <h1 class="mb-4">Book List</h1>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="bookList" scope="request" type="java.util.List"/>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>