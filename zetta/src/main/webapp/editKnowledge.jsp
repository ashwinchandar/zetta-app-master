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
                                <li class="active"><a href="">Modify KnowledgeBase</a></li> 
                            </ul></center>
                            <a href="/knowledgelisting"> 
								<div class="payment-adress"> 
                                     <button class="btn btn-primary waves-effect waves-light col-md-offset-8 col-md-3" type="submit" name="submit" value="knowledgelisting">Back to knowledge List</button>
      							</div>
							</a>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                     <form action="/knowledge/edit" method="post" >  
                                                        <div class="row">
                                                        	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                               <input type="hidden" id="knowledgeid" name="knowledgeid" value='${kb.knowledgeid}' readonly="readonly">
                                                            </div>
															<div class="form-group"> 
																<select name="category" class="form-control" value="${kb.category}" readonly="readonly" required>
																	<option value="none" disabled="">Select Category</option>
																	<option value="Finance" ${kb.category eq"Finance"?'selected':""}>Finance</option>
																	<option value="Operation" ${kb.category eq"Operation"?'selected':""}>Operation</option>
																	<option value="SCM" ${kb.category eq"SCM"?'selected':""}>SCM</option>
																	<option value="Hardware" ${kb.category eq"Hardware"?'selected':""}>Hardware</option>
																	<option value="Software" ${kb.category eq"Software"?'selected':""}>Software</option>
																	<option value="IT" ${kb.category eq"IT"?'selected':""}>IT</option>
																	<option value="PCBDesign" ${kb.category eq"PCBDesign"?'selected':""}>PCB Design</option>
																	<option value="PCBLibrary" ${kb.category eq"PCBLibrary"?'selected':""}>PCB Library</option> 
																</select>
															</div>
															<div class="form-group">
                                                              <input name="topic" type="text" class="form-control" placeholder="Topic" value="${kb.topic}" required>
                                                            </div> 
                                                            <div class="form-group res-mg-t-15">
                                                              <textarea name="subject" id="subject" placeholder="Message" value="" required>${kb.subject}</textarea>
                                                            </div> 
                                                            </div>
                                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"></div> 
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress"> 
                                                                     <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit" value="knowledge">Submit</button>
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

 