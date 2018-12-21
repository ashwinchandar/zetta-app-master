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
                           <center> <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="">New KnowledgeBase</a></li> 
                            </ul></center>
                            <form action="/knowledgelisting" method="post"> 
								<div class="payment-adress"> 
                                     <button class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" type="submit" name="submit" value="knowledgelisting">Back to Knowledge List</button>
      							</div>
							</form>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                     <form action="/addknowledge" method="POST" onsubmit="return ValidateForm(this);">
                                                     <script type="text/javascript">
														function ValidateForm(frm) {
															if (frm.category.value == "none") {
																alert('Please select Category!');
																frm.category.focus();
																return false;
															}  
														}
													 </script>  
                                                        <div class="row tinymce-single responsive-mg-b-30">
                                                        	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
																<select name="category" class="form-control" value="${kb.category}">
																	<option value="none" selected="" disabled="">Select Category</option>
																	<option value="Finance">Finance</option>
																	<option value="Operation">Operation</option>
																	<option value="SCM">SCM</option>
																	<option value="Hardware">Hardware</option>
																	<option value="Software">Software</option>
																	<option value="IT">IT</option>
																	<option value="PCBDesign">PCB Design</option>
																	<option value="PCBLibrary">PCB Library</option> 
																</select>
															</div>
															<div class="form-group">
                                                                <input name="topic" type="text" class="form-control" placeholder="Topic" value="${kb.topic}" required>
                                                            </div> 
                                                                <div class="form-group res-mg-t-15">
                                                                    <textarea name="subject" id="subject" placeholder="Message" value="${kb.subject}" required></textarea>
                                                                </div> 	 
                                                            </div>
                                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div> 
                                                          </div>  
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress"> 
                                                                     <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit">Submit</button>
                                									<button class="btn btn-primary waves-effect waves-light" type="reset" name="reset" value="Reset">Clear</button>
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
                    </div>
                </div>
            </div>
        </div>
       	  
    
 
     
     
    <%-- <div class="all-content-wrapper">   
        <!-- tinymce Start-->
        <div class="tinymce-area mg-b-8"> 
        	<form action="/knowledgelisting" method="post">
				<div class="payment-adress">
					<button
						class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2"
						type="submit" name="submit" value="knowledgelisting">Back
						to Knowledge List</button>
				</div>
			</form>
            <div class="container-fluid"> 
            <form action="/addknowledge" method="POST" onsubmit="return ValidateForm(this);">
               <script type="text/javascript">
					function ValidateForm(frm) {
					if (frm.category.value == "none") {
						alert('Please select Category!');
						frm.category.focus();
						return false;
						}  
					}
			 	</script>
                <div class="row">
                    <div class="col-lg-8 col-md-8 col-sm-6 col-xs-12"><br/><br/>
							<center>
								<ul id="myTabedu1" class="tab-review-design">
									<h3>New KnowledgeBase</h3>
								</ul>
							</center> 
							<br />
							<div class="tinymce-single responsive-mg-b-30"> 
                        	<div class="form-group">
								<select name="category" class="form-control" value="${kb.category}">
									<option value="none" selected="" disabled="">Select Category</option>
									<option value="Finance">Finance</option>
									<option value="Operation">Operation</option>
									<option value="SCM">SCM</option>
									<option value="Hardware">Hardware</option>
									<option value="Software">Software</option>
									<option value="IT">IT</option>
									<option value="PCBDesign">PCB Design</option>
									<option value="PCBLibrary">PCB Library</option> 
								</select>
							</div>
							<div class="form-group">
	                           <input name="topic" type="text" class="form-control" placeholder="Topic" value="${kb.topic}" required>
	                        </div> 
                            <div id="summernote1" >
                            <textarea name="subject" id="subject" placeholder="Message" value="${kb.subject}" required></textarea>
                            </div> 
                        </div>
                    </div> 
                    <div class="row">
                          <div class="col-lg-8">
                              <div class="payment-adress"> 
                                   <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit">Submit</button> 
                              </div>
                          </div>
                    </div> 
               	 </div> 
               </form>
            </div>
        </div>
        <!-- tinymce End--> 
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
    <!-- summernote JS
		============================================ -->
    <script src="js/summernote/summernote.min.js"></script>
    <script src="js/summernote/summernote-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="js/tab.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="js/tawk-chat.js"></script> --%>
 
       	 
</body>

</html>

 