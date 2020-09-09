<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="css/style_login.css">
</head>
<body>
<h2>로그인</h2>
    <form action="login.do" method="post" name="frm">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="empNo" value="${empNo}"></td>
            </tr>
            <tr>
                <td>암 &nbsp;&nbsp;호</td>
                <td><input type="password" name="pwd"></td>
            </tr>
        </table>
        <div class='btns'>
            <input type="submit" value="로그인"> 
            <input type="reset" value="취 &nbsp;&nbsp;소">
        </div>
    </form>
    <div class='msg'>${message}</div>
</body>
</html>