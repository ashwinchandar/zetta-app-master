<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                                <li class="active"><a href="">Add Calendar</a></li> 
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                     <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                    <form action="/upload" class="needsclick add-professors" id="demo1-upload">
                                                        <div class="row"> 
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">  
                                                                <div class="form-group-inner">
			                                                        <div class="row">
			                                                            <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
			                                                                <label class="login2 pull-right pull-right-pro"></label>
			                                                            </div>
			                                                            <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
			                                                                <div class="file-upload-inner file-upload-inner-right ts-forms">
			                                                                    <div class="input append-big-btn"> 
			                                                                        <div class="file-button">
			                                                                            Browse
			                                                                            <input type="file" onchange="document.getElementById('append-big-btn').value = this.value;">
			                                                                        </div>
			                                                                        <input type="text" id="append-big-btn" placeholder="no file selected">
			                                                                    </div>
			                                                                </div>
			                                                                <div class="payment-adress">
                                                                    			<button type="submit" class="btn btn-primary waves-effect waves-light">Upload</button>
                                                                			</div>
			                                                            </div>
			                                                        </div>
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
</body>

</html>

