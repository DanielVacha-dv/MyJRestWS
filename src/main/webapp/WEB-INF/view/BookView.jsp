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
    <script type="application/javascript" src="/js/jquery3_6/jquery-3.6.0.min.js"></script>
</head>
<body>
<div>
    <h3>${message} </h3>
    <table id="bookOverview">
        <thead>
        <tr>
        <th>book name</th>
        <th>pages</th>
        </tr>
        </thead>
        <tbody id="bookOverviewTBody">
        <c:forEach var="book" items="${library}" varStatus="status">
            <tr>
                <input type="hidden" name="bookIdName" id="bookID_${book.id}" value="${book.id}"/>
                 <td>${book.pages}</td>
                <td>${book.name}</td>
                <td><button onclick="deleteRecord(this)">smaz</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <H3>Add book</H3>
    <form method="POST" action="/api/bookService/addBook" id="bookAddFormID">
        book name: <input type="text" name="bookName">
        <br>
        pages: <input type="number" name="pages">
        <input type="submit" >
    </form>
</div>
</body>
<script type="application/javascript" src="/js/bookSupport.js"></script>
</html>
