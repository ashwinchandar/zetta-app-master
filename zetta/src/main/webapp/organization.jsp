<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<html class="no-js" lang="en">
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head>   
<body> 
      
        <!-- <div class="product-sales-area mg-tb-30">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-sales-chart">
                            <center><img src="img/org/org-chart.png" alt=""></center>
                        </div>
                    </div> 
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                        <div class="white-box analytics-info-cs mg-b-10 res-mg-b-30 res-mg-t-30 table-mg-t-pro-n tb-sm-res-d-n dk-res-t-d-n">
                             <img src="img/org/org-side.png" alt="">
                        </div> 
                    </div> 
                </div>
            </div>
        </div> -->
         <div class="pdf-viewer-area mg-b-15"><br />
            <div class="container-fluid">
                <div class="row">  
                     <div class="col-lg-9 col-md-9 col-sm-12 col-xs-8">
                        <div class="pdf-single-pro"> 
                            <center><object class="media" data="pdf/organization-chart.PDF#toolbar=0" type="application/pdf" width=785" height="600"></object><br /><br /></center>
                       	</div> 
                     </div> 
                     <div class="white-box analytics-info-cs mg-b-10 res-mg-b-30 res-mg-t-30 table-mg-t-pro-n tb-sm-res-d-n dk-res-t-d-n">
                             <img src="img/org/org-side.png" alt="">
                     </div> 
                </div> 
            </div>
        </div>
          
</body>

</html>