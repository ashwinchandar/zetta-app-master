<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<title>Zettaone Admin</title>
<link rel="stylesheet"
	href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/lightbox.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/preloader.css">
<link rel="stylesheet" href="css/image.css">
<link rel="stylesheet" href="css/icon.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
</head>
<body>
	<center>
		<br>
		<h2>Hi ${username}. Welcome to Zettaone Portal!</h2>

		<!-- <h2>
            <a href="/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Books</a>
             
        </h2> -->
	</center>
	<br>
	<h2>Zettaone Directory</h2>
	<div align="center">
		  <p style="color: green" align="center">${editsuccessMessage}</p>  
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Gender</th>
					<th scope="col">DOB</th>
					<th scope="col">Department</th>
					<th scope="col">Designation</th>
					<th scope="col">Extention</th>
					<th scope="col">Mobile</th>
					<th scope="col">Email</th>
					<th scope="col">Skype</th>
					<th scope="col">Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="details" items="${list}">
					<tr> 
						<td>${details.empCardNo}</td>
						<td>${details.name}</td>
						<td>${details.gender}</td>
						<td>${details.dob}</td>
						<td>${details.department}</td>
						<td>${details.designation}</td>
						<td>${details.extention}</td>
						<td>${details.mobile}</td>
						<td>${details.email}</td>
						<td>${details.skype}</td>
						<td>${details.location}</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>