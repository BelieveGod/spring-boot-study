<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息页</title>
</head>
<body>
<table>
    <tr>
        <td>学生姓名：</td><td>${student.name}</td>
    </tr>
    <tr>
        <td>学生年龄：</td><td>${student.age}</td>
    </tr>
     <tr>
        <td>学生性别：</td><td>${student.sex}</td>
    </tr>
</table>
</body>
</html>