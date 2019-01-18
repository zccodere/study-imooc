<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我不是真正的慕课网</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
</head>
<body>
<div align="center">
<h1>上传多个附件</h1>
<form method="post" action="/courses/doUpload2" enctype="multipart/form-data">
<input type="file" name="file1"/>
<br/>
<input type="file" name="file2"/>
<input type="submit"/>
</form>

</div>
</body>
</html>