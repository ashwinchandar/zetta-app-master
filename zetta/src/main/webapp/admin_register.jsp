<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                <li class="active"><a href="">Admin Registration</a></li> 
                            </ul>
                            <form action="adminlisting" method="post"> 
								<div class="payment-adress"> 
                                     <button class="btn btn-primary waves-effect waves-light col-md-offset-10 col-md-2" type="submit" name="submit" value="adminListing">Back to Admin List</button>
      							</div>
							</form>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                  <form action="/register" method="post" onsubmit="return ValidateForm(this);">
                                                     <p style="color:green" align="center">${successMessage}</p> 
                                                     <p style="color:red" align="center">${deletesuccessmessage}</p> 
															<script type="text/javascript">
															function ValidateForm(frm) {
																if (frm.password1.value != frm.password2.value) {
																	alert('Passwords do not match');
																	frm.password1.focus();
																	return false;
																	} 
																if (frm.mobile.value.length!=10){
																	alert('Required 10 digits, match requested format!');
																	frm.mobile.focus();
																	return false;
																	}
																if (frm.location.value !="Bangalore" && frm.location.value !="Krishnagiri") {
																	alert('Select Location!');
																	frm.location.focus();
																	return false;
																}
																} 
															</script>
                                                        <div class="row">
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            	<div class="form-group">
                                                                     <input name="admin_card_no" type="text" class="form-control" placeholder="Employee Card No." value="${ab.admin_card_no}" required>
                                                                </div>
                                                                <div class="form-group"> 
                                                                <input name="name" type="text" class="form-control" placeholder="Full Name" value="${ab.name}" required>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <input name="dob" type="date" class="form-control" placeholder="Date of Birth" value="${ab.dob}" required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="department" type="text" class="form-control" placeholder="Department" value="${ab.department}" required>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <input name="designation" type="text" class="form-control" placeholder="Designation" value="${ab.designation}" required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="email" type="text" class="form-control" placeholder="Email" value="${ab.email}" required>
                                                                </div> 
                                                            </div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                                                                <div class="form-group">
                                                                	<input name="mobile" type="number" class="form-control" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" placeholder="Mobile No." value="${ab.mobile}" required>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <select name="location" class="form-control" value="${ab.location}" required>
																			<option value="none" selected="" disabled="">Select Location</option>
																			<option value="Bangalore">Bangalore</option>
																			<option value="Krishnagiri">Krishnagiri</option> 
																	</select>
                                                                </div> 
                                                                <div class="form-group"> 
				                                                   <div class="i-checks pull-left">
                                                                     <label>
																	 <input type="checkbox" name="role" value="Admin" required> <i></i> Admin 
																	 </label>
                                                                   </div>  
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="password1" type="password" class="form-control" placeholder="Password" value="${ab.password1}" required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="password2" type="password" class="form-control" placeholder="Confirm Password" required>
                                                                </div>  
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress"> 
                                                                     <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit" value="register">Submit</button>
                                									<button class="btn btn-primary waves-effect waves-light" type="reset" name="reset" value="reset">Clear</button>
                                									 
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

