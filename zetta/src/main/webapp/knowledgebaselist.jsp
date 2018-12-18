<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
<body>

	<!-- <div class="breadcome-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcome-list single-page-breadcome">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="breadcome-heading">
									<form role="search" data-search="true" class="sr-input-func">
										<input type="text" placeholder="Search..." data-search="true" class="search-int form-control"> <a href="#">
										<i class="fa fa-search"></i></a>
									</form>
								</div>
							</div> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	
	   
	<div class="pdf-viewer-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn"><br />
						<ul id="myTabedu1" class="tab-review-design">
							<center><li class="active"><a>Knowledge Sharing</a></li></center>
						</ul>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<form action="/knowledgelisting" method="get">
									<div class="row"> 
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<a href="/knowledgebase.jsp"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-9 col-md-3">
											<span><i class="fa fa-arrow-left"></i> <span>Back to Category</span>
										</span>
										</a>
										<br />
											<c:if test="${not empty list}">
												<c:forEach var="knowledge" items="${list}" varStatus="status">
													<div class="review-content-section">
														<div class="chat-discussion" style="height: auto">
															<div class="message">
																<%-- <a class="message-author full-right" href=""> ${knowledge.category} </a><br />  --%>
																  <a href="/getAlltopickb?id=${knowledge.topic}"><span class="message-date"><b> ${knowledge.topic} </b></span></a> <br/>
																  <span class="message-date"><b> ${knowledge.createdBy} </b></span> <br/>
																<span class="message-date full-right"> ${knowledge.createdDate} </span> <br/>
																<span class="message-content"> ${knowledge.subject} </span>  
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body> 
</html>