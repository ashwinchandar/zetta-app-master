<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body>
	<form th:object="${ub}" method="POST" action="/uploadfile" enctype="multipart/form-data">
	
		Title: <br> <input th:field="*{title}" style="width: 300px;" /> <br /> <br /> 
		File to upload: <input th:field="*{fileDatas}" type="file" /> <br />
		<input type="submit" value="Upload"> 
		
	</form>
</body>
</html>