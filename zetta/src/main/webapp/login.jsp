<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login | Zettaone Technology</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
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
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
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
    <!-- forms CSS
		============================================ -->
    <link rel="stylesheet" href="css/form/all-type-forms.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    
    <link rel="stylesheet" href="css/loginstyle.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
	<script src="js/vendor/modernizr-2.8.3.min.js"></script>
	<style>
	body {
		background-image: url("img/org/10.jpg");
		}
	</style>
</head>

<body>
    <!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<div class="error-pagewrap">
		<div class="error-page-int">
			<div class="text-center m-b-md custom-login">
				<a href="/"><img class="main-logo" src="../../img/logo/logo68.png" alt="" /></a><br/><br/>
				<h3 style="color:#ffffff">LOGIN</h3> 
			</div>
			<div class="single_contant_right">
                  <form action="/login" method="post">
                      	<p style="color:red" align="center">${errormsg}</p>  
                      	<p style="color:green" align="center">${adminlogout}</p> 
                     <div class="row">
                         <div class="col-md-12">
                             <div class="form-group">
                                 <input type="text" placeholder="User Name" title="Please enter you username" required="Enter your Card Number" value="" name="admin_card_no" id="admin_card_no" class="form-control">
                             </div>
                         </div>
                     </div>
					<div class="row">
                         <div class="col-md-12">
                             <div class="form-group">
                                 <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="password1" id="password-field" class="form-control">
                             </div>
                         </div>
                     </div> 
                     <div class="row">
                     	 <div class="col-md-3"></div>
                         <div class="col-md-6">
                              <button class="btn btn-success btn-block loginbtn" type="submit" name="submit" value="login">Login</button>
                         </div>
                         <div class="col-md-3"></div>
                     </div>
                 </form> 
             </div>
			<%-- <div class="content-error">
				<div class="hpanel">
                    <div class="panel-body">
                        <form action="/login" method="post">
                        	<p style="color:red" align="center">${errormsg}</p>  
                        	<p style="color:green" align="center">${adminlogout}</p>  
                            <div class="form-group">
                                <label class="control-label" for="username">Card Number</label>
                                <input type="text" placeholder="eg:Z9001" title="Please enter you username" required="Enter your Card Number" value="" name="admin_card_no" id="admin_card_no" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Password</label>
                                <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="password1" id="password-field" class="form-control">
                                <!-- <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span> -->
                                <!-- <span class="help-block small">Yur strong password</span> -->
                            </div>  
                            <button class="btn btn-success btn-block loginbtn" type="submit" name="submit" value="login">Login</button> 
                        </form>
                    </div>
                </div>
			</div> --%>
			<!-- <div class="text-center login-footer">
				<p><a href="/">Back to Home</a></p>
			</div> -->
		</div>   
    </div>
    
    <!-- jquery
		============================================ -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="js/metisMenu/metisMenu.min.js"></script>
    <script src="js/metisMenu/metisMenu-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="js/tab.js"></script>
    <!-- icheck JS
		============================================ -->
    <script src="js/icheck/icheck.min.js"></script>
    <script src="js/icheck/icheck-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="js/main.js"></script>
     <!-- Password Visible
		============================================ -->
    <script src="js/passwordvisible.js"></script>
</body>

</html>