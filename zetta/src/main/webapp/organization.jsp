<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
<body>  
       <form action="/firmchartlisting" method="get" enctype="multipart/form-data">
          <div class="pdf-viewer-area mg-b-15">
            <div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-8">
						<div class="pdf-single-pro">
							<br /> <br />
							<center>
								<h1>
									<a class="blog-ht">Organization Chart</a>
								</h1> 
							</center>
						</div>
					</div>
				</div>
				<div class="row">
					<c:if test="${not empty list}">
						<c:forEach var="orgvar" items="${list}" varStatus="status">
							<!-- <div class="col-lg-2 col-md-2 col-sm-12 col-xs-8"></div> -->
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-8">
								<div class="pdf-single-pro"> 
									<center>
										<%-- <h1>
											<a class="blog-ht">${orgvar.fileName}</a>
										</h1> --%>
										<object class="media" data="${orgvar.filePath}#toolbar=0"
											type="application/pdf" width="830" height="630"></object>
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