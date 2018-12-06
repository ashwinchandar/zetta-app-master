<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>
<body><br>
  		<div class="blog-details-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="blog-details-inner">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="latest-blog-single blog-single-full-view">
                                        <div class="blog-image">
                                            <img src="img/org/raw.png" alt="" />  
                                        </div> 
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
      <div class="single-pro-review-area mt-t-30 mg-b-15">
            <div class="container-fluid">
                <div class="row"> 
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                        <div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="#description">Announcement</a></li> 
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
								<form action="/announcelisting" method="get">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<c:if test="${not empty list}">
												<c:forEach var="announce" items="${list}" varStatus="status">
													<div class="review-content-section">
														<div class="chat-discussion" style="height: auto">
															<div class="message">
																<a class="message-author full-right" href="#"> ${announce.title} </a><br /> 
																<span class="message-date"> ${announce.date} </span> 
																<span class="message-content"> ${announce.announcement} </span>
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</form>
							</div>  
                            </div>
                        </div>
                    </div>

				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="profile-info-inner">
						<div class="profile-img">
							<img src="img/profile/1.jpg" alt="" />
						</div>
						<div class="profile-details-hr">
							<div class="row">
								<div class="col-lg-12"> 
									<c:choose>
										<c:when test="${ not empty birthList }">
											<c:forEach var="birth" items="${birthList}" varStatus="status">
												<div class="address-hr">
													<h2>Happy birthday!</h2>
													<h1>${birth.name}</h1>
													<p>We hope all your birthday wishes and dreams come true.</p>
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<h2>No Zetta Babies born today!</h2>
										</c:otherwise>
									</c:choose>
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