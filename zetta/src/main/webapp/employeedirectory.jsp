<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en"> 
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head> 
<body> 
     <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
             <form action="/directory" method="get">
                <div class="row"> 
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                        <div class="sparkline13-list"> 
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                     <div id="toolbar"><h1>Zettaone <span class="table-project-n">Employee</span> Directory</h1> 
                                    </div>  
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="false" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="false" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                <!-- <th data-field="state" data-checkbox="true"></th> -->
                                                <th data-field="id">ID</th>
                                                <th data-field="name" data-editable="false">Name</th>
                                                <th data-field="email" data-editable="false">Department</th>
                                                <th data-field="phone" data-editable="false">Designation</th>
                                                <th data-field="complete">Email</th>
                                                <th data-field="task" data-editable="false">Phone</th>
                                                <!-- <th data-field="date" data-editable="false">Skype</th> -->
                                                <th data-field="price" data-editable="false">Location</th>
                                               <!--  <th data-field="action">Action</th> -->
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${not empty list}">
											<c:forEach var="employee" items="${list}" varStatus="status">
											<tr>
												<!-- <td></td> -->
												<td>${employee.admin_card_no}</td>
												<td>${employee.name}</td> 
												<td>${employee.department}</td>
												<td>${employee.designation}</td>
												<td>${employee.email}</td>
												<td>${employee.mobile}</td> 
												<td>${employee.location}</td> 
											</c:forEach>
										</c:if> 
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div> 
                    </div> 
                </div> 
                 </form> 
            </div>
        </div>  
</body> 
</html>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en"> 
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head> 
<body> 
     <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
             <form action="/employeelisting" method="get">
                <div class="row"> 
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                        <div class="sparkline13-list"> 
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                     <div id="toolbar"><h1>Zettaone <span class="table-project-n">Employee</span> Directory</h1> 
                                    </div>  
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="false" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="false" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                <!-- <th data-field="state" data-checkbox="true"></th> -->
                                                <th data-field="id">ID</th>
                                                <th data-field="name" data-editable="false">Name</th>
                                                <th data-field="email" data-editable="false">Department</th>
                                                <th data-field="phone" data-editable="false">Designation</th>
                                                <th data-field="complete">Email</th>
                                                <th data-field="task" data-editable="false">Phone</th>
                                                <!-- <th data-field="date" data-editable="false">Skype</th> -->
                                                <th data-field="price" data-editable="false">Location</th>
                                               <!--  <th data-field="action">Action</th> -->
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${not empty list}">
											<c:forEach var="employee" items="${list}" varStatus="status">
											<tr>
												<!-- <td></td> -->
												<td>${employee.emp_card_no}</td>
												<td>${employee.name}</td> 
												<td>${employee.department}</td>
												<td>${employee.designation}</td>
												<td>${employee.email}</td>
												<td>${employee.mobile}</td>
												<!-- <td> </td> -->
												<td>${employee.location}</td>
												<!-- <td class="datatable-ct"><i class="fa fa-check"></i>
												</td> -->
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
                 </form> 
            </div>
        </div>  
</body> 
</html> --%>