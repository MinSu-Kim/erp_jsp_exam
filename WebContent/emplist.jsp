<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<h2>사원목록</h2>
<table border=1>
<thead>
        <td>사원번호</td><td>사원명</td><td>직책</td><td>직속상사</td><td>급여</td><td>부서</td><td>입사일</td>
</thead>
<c:forEach var="employee" items="${emplist}">
    <tr>
        <td>${employee.no}</td>
        <td>${employee.name}</td>
        <td>${employee.title.name}</td>
        <c:if test="${employee.manager.no ne 0}">
            <td>${employee.manager.name}(${employee.manager.no})</td>
        </c:if> 
        <c:if test="${employee.manager.no eq 0}">
            <td></td>
        </c:if> 
        <td><fmt:formatNumber value="${employee.salary}"></fmt:formatNumber></td>
        <td>${employee.dept.name}</td>
        <td><fmt:formatDate value="${employee.hireDate}" pattern="yyyy년 MM월 dd일"/>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>