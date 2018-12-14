<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
<body>
	<div class="pdf-viewer-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div
						class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn">
						<br />
						<ul id="myTabedu1" class="tab-review-design">
							<center>
								<li class="active"><a>Knowledge Sharing</a></li>
							</center>
						</ul>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<form action="/knowledgelisting" method="get">
									<div class="row">
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"> 
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=Hardware"><img src="../../img/knowledgebase/hardware.png" alt="" /></a> 
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"> 
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=Software"><img src="../../img/knowledgebase/software.png" alt="" /></a> 
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=PCBDesign"><img src="../../img/knowledgebase/pcb.png" alt="" /></a> 
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=PCBLibrary"><img src="../../img/knowledgebase/pcblibrary.png" alt="" /></a> 
													</div>
												</div>
											</div>
										</div> 
									</div>
									<div class="row"> 
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=IT"><img src="../../img/knowledgebase/itadmin.png" alt="" /></a> 
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=SCM"><img src="../../img/knowledgebase/scm.jpg" alt="" /></a> 
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"> 
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=Finance"><img src="../../img/knowledgebase/finance.png" alt="" /></a>    
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<div class="review-content-section">
												<div class="chat-discussion" style="height: auto">
													<div class="message">
														<a class="message-author full-right"
															href="/getAllKnowledgeBase?id=Operation"><img src="../../img/knowledgebase/h.png" alt="" /></a> 
													</div>
												</div>
											</div>
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