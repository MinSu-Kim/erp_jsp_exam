<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서/직책 목록</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<h2>부서목록</h2>
<table border=1>
<thead>
        <td>부서번호</td>
        <td>부서명</td>
        <td>위치</td>
</thead>
<c:forEach var="dept" items="${deptList}">
    <tr>
        <td>${dept.no}</td>
        <td>${dept.name}</td>
        <td>${dept.floor}</td>
    </tr>
</c:forEach>
</table>
<div class="split"></div>
<h2>직책목록</h2>
<table border=1>
<thead>
        <td>직책번호</td>
        <td>직책명</td>
</thead>
<c:forEach var="title" items="${titleList}">
    <tr>
        <td>${title.no}</td>
        <td>${title.name}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>