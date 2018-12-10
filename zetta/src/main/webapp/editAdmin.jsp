<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
<script type="text/javascript">
	function ValidateForm(frm) {
		if (frm.password1.value != frm.password2.value) {
			alert('Passwords do not match.');
			frm.password1.focus();
			return false;
		}
		if (frm.location.value != "Bangalore"
				&& frm.location.value != "Krishnagiri") {
			alert('Select Location!');
			frm.location.focus();
			return false;
		}
		if (frm.mobile.value.length != 10) {
			alert('Required 10 digits, match requested format!');
			frm.mobile.focus();
			return false;
		}
	}
</script>
</head> 
<body> 
        <!-- Single pro tab review Start-->
        <div class="single-pro-review-area mt-t-30 mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-payment-inner-st">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="">Edit Admin Registration</a></li> 
                            </ul>
                            <form action="/adminlisting" method="post"> 
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
                                                 <form action="/admin/edit" method="post" onsubmit="return ValidateForm(this);">
                                                     <p style="color:green" align="center">${successMessage}</p> 
                                                     <p style="color:red" align="center">${deletesuccessmessage}</p> 
															
                                                        <div class="row">
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            	<div class="form-group">
                                                                     <input name="admin_card_no" type="text" class="form-control" placeholder="Employee Card No." value="${ab.admin_card_no}" required readonly="readonly">
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
																			<option value="Bangalore" ${ab.location eq"Bangalore"?'selected':""}>Bangalore</option>
																			<option value="Krishnagiri" ${ab.location eq"Krishnagiri"?'selected':""}>Krishnagiri</option> 
																	</select>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <select name="role" class="form-control" value="${ab.role}" required>
																			<option value="none" disabled="">Select Role</option>
																			<option value="MASTER" ${ab.role eq"MASTER"?'selected':""}>Master</option>
																			<option value="ADMIN" ${ab.role eq"ADMIN"?'selected':""}>Admin</option> 
																			<option value="AMODERATOR" ${ab.role eq"AMODERATOR"?'selected':""}>Moderator</option> 
																	</select>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <input name="password1" type="password" class="form-control" id="password-field" placeholder="Password" value="${ab.password1}" required>
                                                                   <!--  <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>  -->
                                                                </div>
                                                                
                                                                <div class="form-group">
                                                                    <input name="password2" type="password" class="form-control" placeholder="Confirm Password" required>
                                                                </div> 
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress"> 
                                                                     <button class="btn btn-primary waves-effect waves-light" type="submit" name="submit" value="editsubmit">Update</button>
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