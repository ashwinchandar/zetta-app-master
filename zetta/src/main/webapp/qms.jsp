<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
<body>  
       <form action="/uploadedlisting" method="get" enctype="multipart/form-data">
          <div class="pdf-viewer-area mg-b-15">
            <div class="container-fluid"> 
                <div class="row">  
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-8">
								<div class="pdf-single-pro">
									<br />
									<br />
									<center>
										<h1>
											<a class="blog-ht">Quality Mangement System</a>
										</h1>
										<object class="media" data="pdf/IT_Policy.pdf#toolbar=0"
											type="application/pdf" width="830" height="1000"></object>
										<br />
										<br />
									</center>
								</div> 
							</div></div><hr>
				<div class="row">
					<c:if test="${not empty list}">
						<c:forEach var="upload" items="${list}" varStatus="status">
							<!-- <div class="col-lg-2 col-md-2 col-sm-12 col-xs-8"></div> -->
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-8">
								<div class="pdf-single-pro">
									<br /> <br />
									<!--  <center><h1><a class="blog-ht">IT Policy</a></h1></center>
                            <object class="media" data="pdf/IT_Policy.pdf#toolbar=0" type="application/pdf" width="690" height="620"></object><br /><br />
                            <hr></br> -->
									<center>
										<h1>
											<a class="blog-ht">${upload.fileName}</a>
										</h1>
										<object class="media" data="${upload.filePath}#toolbar=0"
											type="application/pdf" width="830" height="1000"></object>
									</center>
								</div>
								<!-- <div class="col-lg-2 col-md-2 col-sm-12 col-xs-8"></div>   -->
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
        </div> 
        </form>
</body>

</html>