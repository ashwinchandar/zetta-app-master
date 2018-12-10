<%@ page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html class="no-js" lang="en"> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zettaone Technology</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
	<!-- <link href="../../webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/owl.carousel.css">
    <link rel="stylesheet" href="../../css/owl.theme.css">
    <link rel="stylesheet" href="../../css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/main.css">
    <!-- forms CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/form/all-type-forms.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="../../css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="../../css/calendar/fullcalendar.print.min.css">
     <!-- x-editor CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/editor/select2.css">
    <link rel="stylesheet" href="../../css/editor/datetimepicker.css">
    <link rel="stylesheet" href="../../css/editor/bootstrap-editable.css">
    <link rel="stylesheet" href="../../css/editor/x-editor-style.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="../../css/data-table/bootstrap-editable.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="../../style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="../../css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="../../js/vendor/modernizr-2.8.3.min.js"></script>
    
    <!-- jquery
		============================================ -->
	<script src="../../js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="../../js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="../../js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="../../js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="../../js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="../../js/owl.carousel.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script src="../../js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="../../js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="../../js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="../../js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script src="../../js/metisMenu/metisMenu.min.js"></script>
	<script src="../../js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="../../js/sparkline/jquery.sparkline.min.js"></script>
	<script src="../../js/sparkline/jquery.charts-sparkline.js"></script>
	<!-- calendar JS
		============================================ -->
	<script src="../../js/calendar/moment.min.js"></script>
	<script src="../../js/calendar/fullcalendar.min.js"></script>
	<script src="../../js/calendar/fullcalendar-active.js"></script>
	<!-- maskedinput JS
		============================================ -->
	<script src="../../js/jquery.maskedinput.min.js"></script>
	<script src="../../js/masking-active.js"></script>
	<!-- datepicker JS
		============================================ -->
	<script src="../../js/datepicker/jquery-ui.min.js"></script>
	<script src="../../js/datepicker/datepicker-active.js"></script>
	<!-- form validate JS
		============================================ -->
	<!-- <script src="../../js/form-validation/jquery.form.min.js"></script>
    <script src="../../js/form-validation/jquery.validate.min.js"></script>
    <script src="../../js/form-validation/form-active.js"></script> -->
	<!-- dropzone JS
		============================================ -->
	<script src="../../js/dropzone/dropzone.js"></script>
	<!-- tab JS
		============================================ -->
	 <!-- data table JS
		============================================ -->
    <script src="../../js/data-table/bootstrap-table.js"></script>
    <script src="../../js/data-table/tableExport.js"></script>
    <script src="../../js/data-table/data-table-active.js"></script>
    <script src="../../js/data-table/bootstrap-table-editable.js"></script>
    <script src="../../js/data-table/bootstrap-editable.js"></script>
    <script src="../../js/data-table/bootstrap-table-resizable.js"></script>
    <script src="../../js/data-table/colResizable-1.5.source.js"></script>
    <script src="../../js/data-table/bootstrap-table-export.js"></script>
    <!--  editable JS
		============================================ -->
    <script src="../../js/editable/jquery.mockjax.js"></script>
    <script src="../../js/editable/mock-active.js"></script>
    <script src="../../js/editable/select2.js"></script>
    <script src="../../js/editable/moment.min.js"></script>
    <script src="../../js/editable/bootstrap-datetimepicker.js"></script>
    <script src="../../js/editable/bootstrap-editable.js"></script>
    <script src="../../js/editable/xediable-active.js"></script>
    <!-- Chart JS
		============================================ -->
    <script src="../../js/chart/jquery.peity.min.js"></script>
    <script src="../../js/peity/peity-active.js"></script>	
		
	<script src="../../js/tab.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="../../js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="../../js/main.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };
    });
	</script>
</head>
 
    <!-- Start Left menu area -->
    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="/"><img class="main-logo" src="../../img/logo/logo.png" alt="" /></a>
                <strong><a href="/"><img src="../../img/logo/logosn.png" alt="" /></a></strong>
            </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                    	<li>
                            <center><a aria-expanded="false"><br />Quick Lookup</a></center>
                        </li>
                        <li>
                            <a title="Zettaone website" href="http://www.zettaone.com/" target="_blank" aria-expanded="false"><span class="educate-icon educate-library icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Company Website</span></a>
                        </li>
                        <li class="active">
                            <a title="Organization chart" href="/fileupload" aria-expanded="false"><span class="educate-icon educate-charts icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Organization Chart</span></a>
                        </li>
                        <li>
                            <a title="Employee directory" href="/employeedirectory" aria-expanded="false"><span class="educate-icon educate-professor icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Employee Directory</span></a>
                        </li>
                        <li>
                            <a title="QMS" href="qms.jsp" aria-expanded="false"><span class="educate-icon educate-data-table icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">QMS</span></a>
                        </li>
                        <li>
                            <a title="Knowledge Base" href="/knowledgebase" aria-expanded="false"><span class="educate-icon educate-form icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Knowledge Base</span></a>
                        </li>
                        <li>
                            <a title="Calendar" href="calendar.jsp" aria-expanded="false"><span class="educate-icon educate-event icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Company Calendar</span></a>
                        </li>
                        <li>
                            <a title="IT Help Desk" href="https://zettaone.on.spiceworks.com/portal/tickets" target="_blank" aria-expanded="false"><span class="educate-icon educate-apps icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">IT Help Desk</span></a>
                        </li>  
                    </ul>
                </nav>
            </div>
        </nav>
    </div>
    <!-- End Left menu area -->
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo-pro">
                        <a href="/"><img class="main-logo" src="../../img/logo/logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-advance-area">
            <div class="header-top-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="header-top-wraper">
                                <div class="row">
                                    <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                        <div class="menu-switcher-pro">
                                            <!-- <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
													<i class="educate-icon educate-nav"></i>
												</button> -->
                                        </div>
                                    </div>
                                    <div class="col-lg-10 col-md-12 col-sm-6 col-xs-12">
                                        <div class="header-top-menu tabl-d-n">
                                            <ul class="nav navbar-nav mai-top-nav">
                                                <li class="nav-item"><a href="/" class="nav-link">Home</a>
                                                </li>
                                                <!-- <li class="nav-item"><a href="/employeedirectory" class="nav-link">Employee Directory</a>
                                                </li>
                                                <li class="nav-item"><a href="qms.jsp" class="nav-link">QMS</a>
                                                </li> 
                                                <li class="nav-item"><a href="/knowledgebase" class="nav-link">Knowledge Base</a>
                                                </li>
                                                <li class="nav-item"><a href="calendar.jsp" class="nav-link">Company Calendar</a>
                                                </li> -->   
                                                <c:choose>
                                                <c:when test="${ not empty sessionScope.USER}"> 
                                                 <li class="nav-item"><a href="/logout" class="nav-link">Logout</a>
                                                </li> 
                                                </c:when>
                                                <c:otherwise>
                                                 <li class="nav-item"><a href="/login" class="nav-link">Login</a>
                                                </li> 
                                                </c:otherwise>  
                                                </c:choose>                                            
                                            </ul>
                                        </div>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div> 
          
      </html>

         