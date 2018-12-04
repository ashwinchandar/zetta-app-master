<%@ page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
    <!-- forms CSS
		============================================ -->
    <link rel="stylesheet" href="css/form/all-type-forms.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>
 
    <!-- Start Left menu area -->
    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="index.jsp"><img class="main-logo" src="img/logo/logo.png" alt="" /></a>
                <strong><a href="index.jsp"><img src="img/logo/logosn.png" alt="" /></a></strong>
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
                            <a title="Organization chart" href="organization.jsp" aria-expanded="false"><span class="educate-icon educate-charts icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Organization Chart</span></a>
                        </li>
                        <li>
                            <a title="Employee directory" href="employeedirectory.jsp" aria-expanded="false"><span class="educate-icon educate-professor icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Employee Directory</span></a>
                        </li>
                        <li>
                            <a title="QMS" href="qms.jsp" aria-expanded="false"><span class="educate-icon educate-data-table icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">QMS</span></a>
                        </li>
                        <li>
                            <a title="Knowledge Base" href="knowledgebase.jsp" aria-expanded="false"><span class="educate-icon educate-form icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">Knowledge Base</span></a>
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
                        <a href="index.jsp"><img class="main-logo" src="img/logo/logo.png" alt="" /></a>
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
                                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
													<i class="educate-icon educate-nav"></i>
												</button>
                                        </div>
                                    </div>
                                    <div class="col-lg-10 col-md-12 col-sm-6 col-xs-12">
                                    <form action="adminPage" method="post">
                                        <div class="header-top-menu tabl-d-n  ">
                                            <ul class="nav navbar-nav mai-top-nav">
                                                <li class="nav-item"><a href="index.jsp" class="nav-link">Home</a>
                                                </li>
                                                <li class="nav-item"><a href="employeedirectory.jsp" class="nav-link">Employee Directory</a>
                                                </li>
                                                <li class="nav-item"><a href="qms.jsp" class="nav-link">QMS</a>
                                                </li> 
                                                <li class="nav-item"><a href="knowledgebase.jsp" class="nav-link">Knowledge Base</a>
                                                </li>
                                                <li class="nav-item"><a href="calendar.jsp" class="nav-link">Company Calendar</a>
                                                </li> 
                                            </ul> 
                                            <button class="btn btn-primary waves-light " type="submit" name="submit" value="logout">Logout</button>
                                        </div>
                                     </form>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div> 
      </html>

         