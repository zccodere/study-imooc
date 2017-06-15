<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>登录</h2>
<form action="<%=request.getContextPath()%>/viewall" method="post">

<span>用户名：</span><input type="text" name="name"/>
<span>密&nbsp;&nbsp;码：</span><input type="text" name="pwd"/>
<input type="submit" value="登录"/>
</form>
</body>
</html>