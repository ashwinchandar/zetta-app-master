<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
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
                                <li class="active"><a href="">Modify Announcement</a></li> 
                            </ul></center>
                            <a href="/announcelisting"> 
								<div class="payment-adress"> 
                                     <button class="btn btn-primary waves-effect waves-light col-md-offset-8 col-md-3" type="submit" name="submit" value="announcementListing">Back to Announcement List</button>
      							</div>
							</a>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                     <form action="/announce/edit" method="post" >
                                                      <p style="color:green" align="center">${editannounce}</p>  
                                                        <div class="row">
                                                        	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                                                           		 <div class="form-group">
                                                                     <input type="hidden" id="announceid" name="announceid" value='${ab.announceid}' readonly="readonly">
                                                                </div>
                                                            	<div class="form-group">
                                                                     <input name="title" id="title" type="text" class="form-control" placeholder="Title" value="${ab.title}" required>
                                                                </div>
                                                                <%--  <div class="form-group">
                                                                    <input name="date" type="date" class="form-control" placeholder="Date" value="${ab.date}" required>
                                                                </div> --%>
                                                                <div class="form-group res-mg-t-15">
                                                                    <textarea name="announcement" id="announcement" placeholder="Announcement message" required>${ab.announcement}</textarea>
                                                                </div> 
                                                            </div>
                                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div> 
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress"> 
                                                                     <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit" value="editannounce">Submit</button>
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
</body>

</html>

 