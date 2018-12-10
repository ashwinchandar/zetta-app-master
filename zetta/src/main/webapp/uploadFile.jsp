<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body><br/><br />
	<form method="POST" action="/upload" enctype="multipart/form-data">
	<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"></div>
		<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
			<div class="file-upload-inner file-upload-inner-right ts-forms">
				<div class="input append-small-btn">
					    <input type="file"  name="files" multiple="multiple"/><br/><br/>
				</div>
			</div>
		</div>
	<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
	<div class="form-control">
						 <input type="submit" value="Submit" id="btnSubmit"/>
					</div>
	</div>
	</form>
</body>
</html>