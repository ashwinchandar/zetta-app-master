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
					<div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn"><br />
						<c:forEach var="knowledgedd" items="${list}" varStatus="status">
							<ul id="myTabedu1" class="tab-review-design">
								<center><li class="active"><h1>${knowledgedd.category}</h1></li></center>
							</ul>
						</c:forEach>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<form action="/knowledgelisting" method="get">
									<script type="text/javascript"> 	  
									  function imgValidation(){
									    var fileInput = document.getElementById('kimg');
									    var filePath = fileInput.value; 
									    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
									    if(!allowedExtensions.exec(filePath)){
									        alert('Please upload image having extensions .jpeg/.jpg/.png/.gif only.');
									        fileInput.value = ''; 
									        return false;
									   		 } 
										}   
										function fileValidation(){
										    var fileInput = document.getElementById('files');
										    var filePath = fileInput.value; 
										    var allowedExtensions = /(\.pdf|\.PDF)$/i;
										    if(!allowedExtensions.exec(filePath)){
										        alert('Please upload image/file having extension .pdf only.');
										        fileInput.value = ''; 
										        return false;
										    } 
										}
									</script>  
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<c:forEach var="knowledged" items="${list}"
												varStatus="status">
												<a href="/getAllKnowledgeBase?id=${knowledged.category}"
													class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-9 col-md-3">
													<span><i class="fa fa-arrow-left"></i> <span>Back to topic</span> </span>
												</a>
											</c:forEach>
								</form> <br />
										<c:if test="${not empty list}">
											<c:forEach var="knowledge" items="${list}" varStatus="status">
													<div class="review-content-section">
														<div class="chat-discussion" style="height: auto">
															<div class="message">
																<a class="message-author full-right" href=""> </a><br /> 
																<span class="message-date"><b> ${knowledge.topic} </b></span> <br />
																<span class="message-date"><b><i class="fa fa-user" aria-hidden="true"></i>&nbsp;${knowledge.createdBy}</b></span><br /> 
																<span class="message-date full-right"><i class="fa fa-calendar"></i>&nbsp; ${knowledge.createdDate}</span><br />
																<span class="message-content"> ${knowledge.subject}</span> 
																 <img src="${knowledge.imagePath}" title="${knowledge.imageName}" width="300" height="300" /> 
																 <br/><br/>
																 <a href="${knowledge.filePath}" download> 
																	 ${knowledge.fileName}
																 </a> 
																 <br/> <br/>
																<a href="/reply?id=${knowledge.knowledgeid}&topic=${knowledge.topic}" style="color:blue">Click to Comment</a>
																 
																<c:if test="${not empty isReply}"> 
																		<form action="/replySubmit" method="post" enctype="multipart/form-data" onsubmit="return ValidateForm(this);">
																			<input type="hidden" name="topicid" value="${knowledge.knowledgeid}"><br/>
																			<input type="hidden" name="topic" value="${knowledge.topic}"><br/>
																			<div class="form-group res-mg-t-15"> 	
																			<textarea name="reply" id="reply" placeholder="Your comment" class="res-mg-t-15" required></textarea><br/>
																			</div>
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="form-group">
															<div class="file-upload-inner ts-forms">
																<div class="input prepend-small-btn">
																	<div class="file-button"> File
																	<input type="file" name="files" id="files" multiple="multiple"
																			onchange="document.getElementById('prepend-small-btn').value = this.value; return fileValidation()">
																	</div>
																	<input type="text" id="prepend-small-btn" placeholder="no file selected">
																</div>
															</div>
														</div>
												</div>
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">	
														<div class="form-group">					
															<div class="file-upload-inner ts-forms">
																<div class="input prepend-big-btn">
																	<div class="file-button"> Image
																	<input type="file" name="kimg" id="kimg" multiple="multiple"
																			onchange="document.getElementById('prepend-big-btn').value = this.value; return imgValidation()">
																	</div>
																	<input type="text" id="prepend-big-btn" placeholder="no image selected"/> 
																</div>  	
															</div>
														</div>
												</div> <br/><br/>
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<button class="btn btn-primary waves-effect waves-light"
													type="submit" name="submit" value="${knowledge.topic}">Submit
													</button>
													<button class="btn btn-primary waves-effect waves-light"
													 type="reset">Clear
													</button>
												</div>
																		</form>
																	</c:if><br/><br/>
																	<c:if test="${not empty replylist}">
																		<h6>Comments</h6>
																		<c:forEach var="reply" items="${replylist}" varStatus="status">  
																			<p><span class="glyphicon glyphicon-user"></span> &nbsp;<strong>${reply.createdBy}</strong><br/>
																			<i class="fa fa-calendar"></i>&nbsp; ${reply.createdDate} <br/>
																			${reply.reply} <br/>
																			<img src="${reply.imagePath}" title="${reply.imageName}" width="300" height="300" /><br/><br/>
																			
																			<a href="${reply.filePath}" download> 
																				  ${reply.fileName}
																			</a> 
																			</p>
																		</c:forEach>
																	</c:if> 
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
		 
		 
		<%--  <div class="single-pro-review-area mt-t-30 mg-b-15">
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
											  
											<form action="/knowledgelisting" method="get">
												<c:forEach var="knowledged" items="${list}" varStatus="status">
													<a href="/getAllKnowledgeBase?id=${knowledged.category}"
														class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-3">
														<span><i class="fa fa-arrow-left"></i> <span>Back to topic</span> </span>
													</a>
												</c:forEach> 
											 </form>
											<table id="table" data-toggle="table" data-pagination="true"
												data-search="true" data-show-columns="false"
												data-show-pagination-switch="false" data-show-refresh="false"
												data-key-events="false" data-show-toggle="false"
												data-resizable="false" data-cookie="false"
												data-cookie-id-table="saveId" data-show-export="false"
												data-click-to-select="false" data-toolbar="#toolbar">
												<thead> 
													<tr>
														<th data-field="id"></th>
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty list}">
														<c:forEach var="knowledge" items="${list}" varStatus="status">
															<tr>
																<td> 
																	<h4><b>${knowledge.topic}</b></h4> 
																	<b>${knowledge.createdBy}</b> <br/>
																	${knowledge.createdDate} <br/><br/>
																	${knowledge.subject}<br/><br/>
																	<a href="/reply?id=${knowledge.knowledgeid}&topic=${knowledge.topic}" style="color:blue">Click to Comment</a>
																	<c:if test="${not empty isReply}"> 
																		<form action="/replySubmit" method="post" onsubmit="return ValidateForm(this);">
																			<input type="hidden" name="topicid" value="${knowledge.knowledgeid}"><br/>
																			<input type="hidden" name="topic" value="${knowledge.topic}"><br/>
																			<div class="form-group res-mg-t-15">
																			<textarea name="reply" id="reply" class="res-mg-t-15" required></textarea><br/>
																			</div>
																			<button class="btn btn-primary waves-effect waves-light"
																			type="submit" name="submit" value="${knowledge.topic}">Submit
																			</button>
																		</form>
																	</c:if><br/><br/>
																	<c:if test="${not empty replylist}">
																		<h6>Comments</h6>
																		<c:forEach var="reply" items="${replylist}" varStatus="status">  
																			<p><span class="glyphicon glyphicon-user"></span> &nbsp;<strong>${reply.createdBy}</strong> &nbsp; ${reply.createdDate}  <br/><br/> ${reply.reply}</p><br/>
																		</c:forEach>
																	</c:if>
																</td> 
															</tr>
														</c:forEach>
													</c:if>
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
		</div> --%>
		 
		 
</body> 
</html>