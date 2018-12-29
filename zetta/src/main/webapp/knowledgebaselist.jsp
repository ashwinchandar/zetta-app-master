<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
<body>

	  
	<%-- <div class="pdf-viewer-area mg-b-15">
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
																<a class="message-author full-right" href=""> ${knowledge.category} </a><br /> 
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
	</div> --%>
	
	<div class="single-pro-review-area mt-t-30 mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-payment-inner-st"> 
							<div id="myTabContent" class="tab-content custom-product-edit">
								<div class="product-tab-list tab-pane fade active in"
									id="description">
									<div class="row"> 
									<div class="sparkline13-graph">
										<div class="datatable-dashv1-list custom-datatable-overright"> 
											 <div id="toolbar">
												<h2>Knowledge Sharing</h2>
											</div> <br/>
											 <form action="/addknowledge" method="get"> 
												<div class="payment-adress"> 
				                                     <button class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" type="submit" name="submit" value="">Create</button>
				      							</div>
											</form> 
											<table id="table" data-toggle="table" data-pagination="true"
												data-search="true" data-show-columns="false"
												data-show-pagination-switch="false" data-show-refresh="false"
												data-key-events="false" data-show-toggle="false"
												data-resizable="false" data-cookie="false"
												data-cookie-id-table="saveId" data-show-export="false"
												data-click-to-select="false" data-toolbar="#toolbar">
												<thead>
												 <%-- <c:forEach var="knowledge" items="${list}" varStatus="status">
													<tr> 
														<th data-field="id">${knowledge.category}</th> 
													</tr>
												 </c:forEach> --%>
													<tr>
														<th data-field="id"><center>Discussion</center></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="knowledge" items="${list}" varStatus="status">
														<tr>
															<td> 
																<a href="/getAlltopickb?id=${knowledge.knowledgeid}&topic=${knowledge.topic}" style="color:#4B70C5" title="click here to view this topic"><h4>${knowledge.topic}</h4></a> 
																<span class="glyphicon glyphicon-user"></span>&nbsp;${knowledge.createdBy} &nbsp;&nbsp;&nbsp;
																<i class="fa fa-calendar"></i> ${knowledge.createdDate} <br/>
																<%-- ${knowledge.subject} --%>
															</td> 
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
</body> 
</html>