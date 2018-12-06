<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body> 
		<!-- Single pro tab review Start-->
		<div class="single-pro-review-area mt-t-30 mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-payment-inner-st">
							<ul id="myTabedu1" class="tab-review-design">
								<center><li class="active"><a href="">Announcement Listing</a></li></center>
							</ul>

							<div id="myTabContent" class="tab-content custom-product-edit">
								<div class="product-tab-list tab-pane fade active in"
									id="description">
									<div class="row">
									<table class="full-right">
									<td>
										<a href="admin.jsp"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-12">
											<span><i class="fa fa-arrow-left"></i> <span>Back to Main</span>
										</span>
										</a>
									</td>
									<td>
										<a href="new_announcement.jsp"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-2 col-md-12">
											<span> <i class="fa fa-plus"></i> <span>Create</span>
										</span>
										</a>
									</td> 
									</table>
										<div align="center">
											<p style="color: green" align="center">${announce}</p> 
											<table class="table">
												<thead class="thead-dark">
													<tr>
														<th scope="col">Title</th>
														<th scope="col">Date</th>
														<th scope="col">Announcement</th> 
														<th scope="col">Actions</th>
													</tr>
												</thead>
												<tbody> 
													<c:forEach var="announce" items="${list}" varStatus="status">
														<tr>
															<td>${announce.title}</td>
															<td>${announce.date}</td>
															<td>${announce.announcement}</td> 
															
															<td><a class="btn btn-info" href="<c:url value='/announce/edit/?id=${list[status.index].announceid}' />" >Edit</a></td>
															 <td><a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')" href="<c:url value='/announce/delete/?id=${list[status.index].announceid}' />" >Delete</a></td>
															<%-- <td>
																<a href="/announce/edit?id=${announce.announceid}">
																	<input type="hidden" id="announceid" name="announceid" value=''>
																	<button class="btn btn-primary" type="submit" name="submit" value="edit">Edit</button>
																</a>
															</td>
															<td>
																<a href="/announce/delete?id=${announce.announceid}">
																	<input type="hidden" id="announceid" name="announceid" value=''>
																	<button class="btn btn-primary" type="submit" name="submit" value="delete">Delete</button>
																</a>
															</td> --%>
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
	 
</body>

</html>