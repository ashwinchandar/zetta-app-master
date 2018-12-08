<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body> 
		<!-- Single pro tab review Start-->
		<%-- <div class="single-pro-review-area mt-t-30 mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-payment-inner-st">
							<ul id="myTabedu1" class="tab-review-design">
								<center><li class="active"><a href="">Employee Directory</a></li></center>
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
										<a href="add_employee.jsp"
											class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-2 col-md-12">
											<span> <i class="fa fa-plus"></i> <span>Create</span>
										</span>
										</a>
									</td> 
									</table>
										<div align="center">
											<p style="color: green" align="center">${deletesuccessmessage}</p>
											<table class="table">
												<thead class="thead-dark">
													<tr>
														<th scope="col">Card No</th>
														<th scope="col">Name</th>
														<th scope="col">DOB</th>
														<th scope="col">Department</th>
														<th scope="col">Designation</th>
														<th scope="col">Email</th>
														<th scope="col">Mobile</th>
														<th scope="col">Location</th> 
														<th scope="col"><center>Actions</center></th>
													</tr>
												</thead>
												<tbody> 
													<c:forEach var="empdetails" items="${list}" varStatus="status">
														<tr>
															<td>${empdetails.emp_card_no}</td>
															<td>${empdetails.name}</td>
															<td>${empdetails.dob}</td>
															<td>${empdetails.department}</td>
															<td>${empdetails.designation}</td>
															<td>${empdetails.email}</td>
															<td>${empdetails.mobile}</td>
															<td>${empdetails.location}</td>  
															<td><a href="<c:url value='/employee/edit?id=${list[status.index].emp_card_no}' />" title="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
        													<td><a onclick="return confirm('Are you sure you want to delete?')" href="<c:url value='/employee/delete/?id=${list[status.index].emp_card_no}' />" title="Trash"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
														
															<td>
																<a href="/employee/edit?id=${empdetails.emp_card_no}">
																	<input type="hidden" id="employeeid" name="employeeid" value=''>
																	<button class="btn btn-primary" type="submit" name="submit" value="edit">Edit</button>
																</a>
															</td>
															<td>
																<a href="/employee/delete?id=${empdetails.emp_card_no}">
																	<input type="hidden" id="employeeid" name="employeeid" value=''>
																	<button class="btn btn-primary" type="submit" name="submit" value="delete">Delete</button>
																</a>
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
		</div> --%>
		
		<div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                            <ul id="myTabedu1" class="tab-review-design">
								<center><li class="active"><a href="">Employee Directory Admin Listing</a></li></center>
							</ul>
                                <div class="main-sparkline13-hd">
								<table class="full-right col-md-offset-9 col-md-1">
									<td><a href="admin.jsp"
										class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-1 col-md-12">
											<span><i class="fa fa-arrow-left"></i> <span>Back
													to Main</span> </span>
									</a></td>
									<td><a href="add_employee.jsp"
										class="btn btn-primary m-btn m-btn--custom m-btn--icon col-md-offset-2 col-md-12">
											<span> <i class="fa fa-plus"></i> <span>Create</span>
										</span>
									</a></td>
								</table> 
							</div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="toolbar">
                                        <select class="form-control dt-tb">
											<option value="">Export Basic</option>
											<option value="all">Export All</option>
											<option value="selected">Export Selected</option>
										</select>
                                    </div>
                                     <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="false" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
                                     <thead>
										<tr>
											<th data-field="state" data-checkbox="false">Card No</th>
											<th data-field="id">Name</th>
											<th data-field="name" data-editable="false">DOB</th>
											<th data-field="email" data-editable="false">Department</th>
											<th data-field="phone" data-editable="false">Designation</th>
											<th data-field="complete">Email</th>
											<th data-field="task" data-editable="false">Mobile</th>
											<th data-field="date" data-editable="false">Location</th>
											<th data-field="price" data-editable="false">Edit</th>
											<th data-field="action">Remove</th>
										</tr>
									</thead>
                                        <tbody>
                                        <c:forEach var="empdetails" items="${list}" varStatus="status">
                                            <tr>
												<td>${empdetails.emp_card_no}</td>
												<td>${empdetails.name}</td>
												<td>${empdetails.dob}</td>
												<td>${empdetails.department}</td>
												<td>${empdetails.designation}</td>
												<td>${empdetails.email}</td>
												<td>${empdetails.mobile}</td>
												<td>${empdetails.location}</td> 
                                                <td><a href="<c:url value='/employee/edit?id=${list[status.index].emp_card_no}' />" title="Edit"> <center><i class="fa fa-pencil-square-o" aria-hidden="true"></i></center></a></td>
        										<td><a onclick="return confirm('Are you sure you want to delete?')" href="<c:url value='/employee/delete/?id=${list[status.index].emp_card_no}' />" title="Trash"> <center><i class="fa fa-trash-o" aria-hidden="true"></i></center></a></td> 		
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
</body> 
</html>