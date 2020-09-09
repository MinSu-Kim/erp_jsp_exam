<%@page import="erp_jsp_exam.ds.LocalJNDIHikari"%>
<%@page import="erp_jsp_exam.ds.LocalJNDIDBCP"%>
<%@page import="erp_jsp_exam.ds.LocalJNDISingle"%>
<%@page import="erp_jsp_exam.ds.JdbcUtilJNDI"%>
<%@page import="erp_jsp_exam.ds.HikariCPJAVA"%>
<%@page import="erp_jsp_exam.ds.JdbcUtil"%>
<%@page import="erp_jsp_exam.ds.HikariCPJNDI"%>
<%@page import="java.sql.Connection"%>
<%@page import="erp_jsp_exam.listener.HikariCPListener"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

    Connection con1 = HikariCPJAVA.getConnection();
    out.print("HikariCPJAVA con1 : " + con1 + "<br>");
    
    Connection con2 = HikariCPListener.getConnection();
    out.print("HikariCPListener con2 : " + con2 + "<br>");
    
    Connection con4 = JdbcUtil.getConnection();
    out.print("JdbcUtil con4 : " + con4 + "<br>"); 
        
   
    Connection con3 = HikariCPJNDI.getConnection();
    out.print("HikariCPJNDI con3 : " + con3 + "<br>");

    Connection con5 = JdbcUtilJNDI.getConnection();
    out.print("JdbcUtilJNDI con5 : " + con5 + "<br>");

    Connection con6 = LocalJNDISingle.getConnection();
    out.print("JdbcUtilJNDI con6 : " + con6 + "<br>");
    
    Connection con7 = LocalJNDIDBCP.getConnection();
    out.print("JdbcUtilJNDI con7 : " + con7 + "<br>");
    
    Connection con8 = LocalJNDIHikari.getConnection();
    out.print("JdbcUtilJNDI con8 : " + con8 + "<br>");
%>

<a href="EmployeeController">employee</a>
<a href="DeptAndTitleController">department&title</a>
</body>
</html>