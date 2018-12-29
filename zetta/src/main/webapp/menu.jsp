<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %> 
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>  
	<body> 
        <div class="widgets-programs-area">
            <div class="container-fluid"><br />
                <div class="row">
				<c:if test="${fn:contains(sessionScope.ROLE, 'MA')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="hpanel widget-int-shape responsive-mg-b-30">
							<!-- <form action="/adminlisting" method="post"> -->
							<a href="/adminlisting">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Manage Admin</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-apps"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> The Admin has access to all administrative
											tasks &amp; can: Create, Edit, Update &amp; Delete admin
											users. </small>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:if> 
				<c:if test="${fn:contains(sessionScope.ROLE, 'KB')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="hpanel widget-int-shape responsive-mg-b-30">
							<a href="/knowledgelisting">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Manage KnowledgeBase</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-form"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> You can Add New Knowledge Base documents as
											well as Drop KB document from the record. </small><br/>
											<c:if test="${not empty pendingCount }">
											<strong>You have <span class="label label-info">${pendingCount}</span> records to approve.</strong>
											</c:if>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:if>
				<c:if test="${fn:contains(sessionScope.ROLE, 'ANC')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="hpanel widget-int-shape responsive-mg-b-30">
							<a href="/announcelisting">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Manage Announcement</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-department"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> You can add organization important
											announcement as well as drop the announcement. </small>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:if>
				<c:if test="${fn:contains(sessionScope.ROLE, 'QMS')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="hpanel widget-int-shape responsive-mg-b-30">
							<a href="/uploadfile">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Manage QMS</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-data-table"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> You can add Quality Management Documents as
											well as drop QMS document. </small>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:if>
			</div><br/>
            <div class="row">
				<c:if test="${fn:contains(sessionScope.ROLE, 'CC')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="hpanel widget-int-shape responsive-mg-b-30">
							<a href="/orgupload">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Company Chart</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-library"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> You can add organization chart as well as drop
											organization chart as of every update may applied. </small>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:if>
				<c:if test="${fn:contains(sessionScope.ROLE, 'RLY')}">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<a href="/knowledgereplylisting">
							<div class="hpanel widget-int-shape responsive-mg-b-30">
								<div class="panel-body">
									<div class="stats-title pull-left">
										<h4>Manage Knowledge Comments</h4>
									</div>
									<div class="stats-icon pull-right">
										<i class="educate-icon educate-form"></i>
									</div>
									<div class="m-t-xl widget-cl-1">
										<small> Here you can view all comments and perform
											delete too. </small>
									</div>
								</div>
							</div>
						</a>
					</div>
				</c:if>
				<%-- <c:if test = "${fn:contains(sessionScope.ROLE, 'ME')}">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                        <div class="hpanel widget-int-shape responsive-mg-b-30"> 
	                        <a href="/employeelisting">
	                            <div class="panel-body">
	                                <div class="stats-title pull-left">
	                                    <h4>Manage Employee</h4>
	                                </div>
	                                <div class="stats-icon pull-right">
	                                    <i class="educate-icon educate-professor"></i>
	                                </div>
	                                <div class="m-t-xl widget-cl-1"> 
	                                    <small>
											You can Add New Employee details as well as Edit employee details &amp; Drop employee from the record.	 
										</small>
	                                </div>
	                            </div> 
                           </a>
                        </div>
                    </div> 
                    </c:if> --%>
			</div>    
                </div><br /><br /><br /><br /><br /><br /><br /> 
            </div>
        </div>
          
</body>

</html>
 