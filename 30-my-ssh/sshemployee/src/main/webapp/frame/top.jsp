<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:90%; font-size:14px; color:white}
</style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
欢迎您：<s:property value="#session.existEmployee.ename"/>
</div>
</body>
</html>