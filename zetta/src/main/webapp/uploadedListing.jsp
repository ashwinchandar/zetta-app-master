%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body>
      <!-- <th:block th:include="/_menu"></th:block> -->
       
      Title: <span th:utext="${title}"></span>
      <br/>
      <h3>Uploaded Files:</h3>
       
      <ul th:each="file : ${uploadedFiles}">
         <li th:utext="${file}"></li>  
      </ul>      
       
      <h3>Failed:</h3>
      <ul th:each="file : ${failedFiles}">
         <li style="color:red;" th:utext="${file}"></li>  
      </ul>
       
   </body>
</html>