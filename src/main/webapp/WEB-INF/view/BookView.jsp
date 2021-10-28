<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: DZCM4G4
  Date: 28.10.2021
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${library}" varStatus="status">
    <p>${book.pages} ${book.name}</p><br>
</c:forEach>
</body>
</html>
