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
										<a href="/menu"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-12">
											<span><i class="fa fa-arrow-left"></i> <span>Back to Main</span>
										</span>
										</a>
									</td>
									<td>
										<a href="/new_announcement.jsp"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-2 col-md-12">
											<span> <i class="fa fa-plus"></i> <span>Create</span>
										</span>
										</a>
									</td> 
									</table>
									<div class="sparkline13-graph">
										<div class="datatable-dashv1-list custom-datatable-overright">
											<div id="toolbar">
												<select class="form-control dt-tb">
													<option value="">Export Basic</option>
													<option value="all">Export All</option>
													<option value="selected">Export Selected</option>
												</select>
											</div>
											<table id="table" data-toggle="table" data-pagination="true"
												data-search="true" data-show-columns="true"
												data-show-pagination-switch="true" data-show-refresh="false"
												data-key-events="true" data-show-toggle="true"
												data-resizable="true" data-cookie="true"
												data-cookie-id-table="saveId" data-show-export="true"
												data-click-to-select="true" data-toolbar="#toolbar">
												<thead>
													<tr>
														<th data-field="state" data-checkbox="false">Title</th>
														<th data-field="id">Date</th>
														<th data-field="name" data-editable="false">Announcement</th> 
														<th data-field="price" data-editable="false">Edit</th>
														<th data-field="action">Remove</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="announce" items="${list}"
														varStatus="status">
														<tr>
															<td>${announce.title}</td>
															<td>${announce.date}</td>
															<td>${announce.announcement}</td>  
															<td><a href="<c:url value='/announce/edit/?id=${list[status.index].announceid}' />" title="Edit"> <center><i class="fa fa-pencil-square-o" aria-hidden="true"></i></center></a></td>
															 <td><a onclick="return confirm('Are you sure you want to delete?')" href="<c:url value='/announce/delete/?id=${list[status.index].announceid}' />" title="Trash"> <center><i class="fa fa-trash-o" aria-hidden="true"></i></center></a></td>
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