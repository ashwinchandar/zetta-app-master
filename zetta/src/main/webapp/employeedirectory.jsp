<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en"> 
<head>
<%@ include file = "header.jsp" %> 
<meta charset="ISO-8859-1"> 
</head> 
<body> 
     <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <!-- <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                    <h1>Zettaone <span class="table-project-n">Employee</span> Directory</h1>
                                </div>
                            </div> -->
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                     <div id="toolbar"><h1>Zettaone <span class="table-project-n">Employee</span> Directory</h1>
                                       <!-- <select class="form-control dt-tb">
											<option value="">Export Basic</option>
											<option value="all">Export All</option>
											<option value="selected">Export Selected</option>
										</select> --> 
                                    </div>  
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="false" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="false" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                <th data-field="state" data-checkbox="true"></th>
                                                <th data-field="id">ID</th>
                                                <th data-field="name" data-editable="false">Name</th>
                                                <th data-field="email" data-editable="false">Designation</th>
                                                <th data-field="phone" data-editable="false">Department</th>
                                                <th data-field="complete">Email</th>
                                                <th data-field="task" data-editable="true">Phone</th>
                                                <th data-field="date" data-editable="false">Skype</th>
                                                <th data-field="price" data-editable="false">Location</th>
                                                <th data-field="action">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td>Z0011</td>
                                                <td>KARTHIKEYAN S</td>
                                                <td>Tech Lead- PCB Design</td>
                                                <td>PCB</td>
                                                <td>karthik@zettaone.com</td>
                                                <td>9035162344</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0016</td>
                                                <td>PRAVEEN N</td>
                                                <td>Lead - PCB Design</td>
                                                <td>PCB</td>
                                                <td>praveen@zettaone.com</td>
                                                <td>9742884750</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0024</td>
                                                <td>NAVEEN KUMAR N</td>
                                                <td>Lead - PCB Design</td>
                                                <td>PCB</td>
                                                <td>naveen@zettaone.com</td>
                                                <td>7829867477</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0025</td>
                                                <td>SURENDIRA KUMAR D</td>
                                                <td>Manager - PCB Design</td>
                                                <td>PCB</td>
                                                <td>surendira@zettaone.com</td>
                                                <td>9036407204</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0026</td>
                                                <td>RAJASEKARAN R</td>
                                                <td>Manager - PCB Design</td>
                                                <td>PCB</td>
                                                <td>rajsekar@zettaone.com</td>
                                                <td>9986059530</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0027</td>
                                                <td>PARAMASIVAN T</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>tparamasivan@zettaone.com</td>
                                                <td>9786121694</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0028</td>
                                                <td>PARAMESHVARAN A</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>parameshvaran@zettaone.com</td>
                                                <td>9444151513</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0029</td>
                                                <td>JAGADISH K</td>
                                                <td>Senior PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>jagadish@zettaone.com</td>
                                                <td>9566331434</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0030</td>
                                                <td>ARUN V</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>varun@zettaone.com</td>
                                                <td>9943779688</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0031</td>
                                                <td>PARAMASIVAM S</td>
                                                <td>Lead - PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>sparamasivam@zettaone.com</td>
                                                <td>9843058617</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0036</td>
                                                <td>SUNIL K</td>
                                                <td>Technical Support</td>
                                                <td>SCM</td>
                                                <td>sunil@zettaone.com</td>
                                                <td>7090017499</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0039</td>
                                                <td>PRASANTH R</td>
                                                <td>Library Engineer</td>
                                                <td>PCB Library</td>
                                                <td>prasanth@zettaone.com</td>
                                                <td>7708885453</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0040</td>
                                                <td>PRAVEEN V</td>
                                                <td>Library Engineer</td>
                                                <td>PCB Library</td>
                                                <td>vpraveen@zettaone.com</td>
                                                <td>8695760406</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0042</td>
                                                <td>JAYASURIYA G</td>
                                                <td>Library Engineer</td>
                                                <td>PCB Library</td>
                                                <td>jayasuriya@zettaone.com</td>
                                                <td>9629055040</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0043</td>
                                                <td>NARESH G</td>
                                                <td>Library Engineer</td>
                                                <td>PCB Library</td>
                                                <td>nareshg@zettaone.com</td>
                                                <td>9865373095</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0047</td>
                                                <td>USHA S</td>
                                                <td>Head- Operations</td>
                                                <td>Accounts</td>
                                                <td>usha@zettaone.com</td>
                                                <td>9538683799</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0049</td>
                                                <td>BHAVYA SHREE M V</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>bhavyashree@zettaone.com</td>
                                                <td>8892993060</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0050</td>
                                                <td>KUSUMA M L</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>kusuma@zettaone.com</td>
                                                <td>8904038248</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0055</td>
                                                <td>YAKSHITHA P</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>yakshitha@zettaone.com</td>
                                                <td>9620455630</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0056</td>
                                                <td>VINODH KUMAR M</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>vinodh@zettaone.com</td>
                                                <td>9535069984</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0059</td>
                                                <td>LEELA KUMARI B</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>leela@zettaone.com</td>
                                                <td>9902368156</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0060</td>
                                                <td>SATHEESH KUMAR S</td>
                                                <td>Lead - Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>satheesh@zettaone.com</td>
                                                <td>9738151517</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0061</td>
                                                <td>MANIVANNAN M</td>
                                                <td>Embedded Engineer</td>
                                                <td>Hardware</td>
                                                <td>mani@zettaone.com</td>
                                                <td>9742213107</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0062</td>
                                                <td>JAGADISH K</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>kjagadish@zettaone.com</td>
                                                <td>9980099079</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0063</td>
                                                <td>NAGARAJ P</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>nagarajp@zettaone.com</td>
                                                <td>8792273462</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0064</td>
                                                <td>THENNARASU M</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>thennarasu@zettaone.com</td>
                                                <td>7353075590</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0065</td>
                                                <td>MUTHUVEL P</td>
                                                <td>Junior Library Engineer</td>
                                                <td>PCB Library</td>
                                                <td>muthuvel@zettaone.com</td>
                                                <td>8124456799</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0067</td>
                                                <td>CHAITHANYA K K</td>
                                                <td>PCB Trainee Engineer</td>
                                                <td>PCB</td>
                                                <td>chaithanya@zettaone.com</td>
                                                <td>7019211831</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0068</td>
                                                <td>PRABU D</td>
                                                <td>Junior PCB Trainee Engineer</td>
                                                <td>PCB</td>
                                                <td>d.prabu@zettaone.com</td>
                                                <td>9597799147</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0070</td>
                                                <td>SASANAMU YUVARAJU</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>yuvaraju@zettaone.com</td>
                                                <td>9550294775</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0073</td>
                                                <td>BALAJI N</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>n.balaji@zettaone.com</td>
                                                <td>9035828348</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0075</td>
                                                <td>NANDAKISHORE P</td>
                                                <td>Manager – PCB Library</td>
                                                <td>PCB Library</td>
                                                <td>kishore@zettaone.com</td>
                                                <td>9880785484</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0076</td>
                                                <td>MOHAN SANJEEVI</td>
                                                <td>Technical Support</td>
                                                <td>Technical</td>
                                                <td>msanjeevi@zettaone.com</td>
                                                <td>9597952302</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0077</td>
                                                <td>PRAVEEN V PATIL</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>praveenpatil@zettaone.com</td>
                                                <td>8867492702</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0078</td>
                                                <td>GAYATHRI G</td>
                                                <td>Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>gayathri@zettaone.com</td>
                                                <td>9489559331</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0081</td>
                                                <td>SADANAND SINGH</td>
                                                <td>Manager - Hardware Engineer</td>
                                                <td>Hardware</td>
                                                <td>sadanand@zettaone.com</td>
                                                <td>9886033133</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0083</td>
                                                <td>MANJUNATH L</td>
                                                <td>Sr.Executive - Accounts</td>
                                                <td>Accounts</td>
                                                <td>manjunath@zettaone.com</td>
                                                <td>9731108777</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0084</td>
                                                <td>ILLAYARAJA</td>
                                                <td>Junior PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>illaiyaraja@zettaone.com</td>
                                                <td>8973948993</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0086</td>
                                                <td>BALAJI G</td>
                                                <td>Trainee - Component Engineering</td>
                                                <td>PCB Library</td>
                                                <td>balajig@zettaone.com</td>
                                                <td>8883752271</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0089</td>
                                                <td>STANLIN RAJ. D</td>
                                                <td>IT Manager</td>
                                                <td>IT</td>
                                                <td>stanlin@zettaone.com</td>
                                                <td>9902875393</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0090</td>
                                                <td>JOTHINATHAN S</td>
                                                <td>Embedded Software Engineer</td>
                                                <td>Hardware</td>
                                                <td>jothinathan@zettaone.com</td>
                                                <td>9443277164</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0092</td>
                                                <td>NARASIMMAN N</td>
                                                <td>PCB Library Trainee</td>
                                                <td>PCB Library</td>
                                                <td>narasimhan@zettaone.com</td>
                                                <td>9943343061</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0093</td>
                                                <td>YAMUNA G</td>
                                                <td>Supply Chain Executive</td>
                                                <td>SCM</td>
                                                <td>yamuna@zettaone.com</td>
                                                <td>9480356841</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0094</td>
                                                <td>SHANKAR M</td>
                                                <td>PCB Library Trainee</td>
                                                <td>PCB Library</td>
                                                <td>mshankar@zettaone.com</td>
                                                <td>8608936923</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0095</td>
                                                <td>DHANARAJ K</td>
                                                <td>Embedded Engineer Trainee</td>
                                                <td>Hardware</td>
                                                <td>dhanaraj@zettaone.com</td>
                                                <td>8301820023</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0096</td>
                                                <td>SWATHI A</td>
                                                <td>Component Engineer</td>
                                                <td>Hardware</td>
                                                <td>swathi@zettaone.com</td>
                                                <td>9738232876</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0098</td>
                                                <td>BEENA MS</td>
                                                <td>PCB Library Manager</td>
                                                <td>PCB Library</td>
                                                <td>beena@zettaone.com</td>
                                                <td>9900211851</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0099</td>
                                                <td>VIDYA R</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>vidya@zettaone.com</td>
                                                <td>9738463842</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0100</td>
                                                <td>NAGARATHNA M</td>
                                                <td>Embedded Engineer Trainee</td>
                                                <td>Hardware</td>
                                                <td>nagarathna@zettaone.com</td>
                                                <td>9739899770</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0104</td>
                                                <td>SEKAR UDAYAKUMAR</td>
                                                <td>PCB Library Trainee</td>
                                                <td>PCB Library</td>
                                                <td>sekar.udayakumar@zettaone.com</td>
                                                <td>7094023940</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0105</td>
                                                <td>SIDDIQ K</td>
                                                <td>PCB Library Trainee</td>
                                                <td>PCB Library</td>
                                                <td>siddiq.k@zettaone.com</td>
                                                <td>9092626726</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0106</td>
                                                <td>JOTHISHANKARAN RAMANATHAN</td>
                                                <td>PCB Library Trainee</td>
                                                <td>PCB Library</td>
                                                <td>jothishankaran.ramanathan@zettaone.com</td>
                                                <td>9944123086</td>
                                                <td>-</td>
                                                <td>Krishnagiri</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0107</td>
                                                <td>AYYAPPAN T B</td>
                                                <td>Senior Manager - PCB Design</td>
                                                <td>PCB</td>
                                                <td>ayyappan.balaraman@zettaone.com</td>
                                                <td>9840523785</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0108</td>
                                                <td>MAGENDRAN M</td>
                                                <td>PCB Design Engineer</td>
                                                <td>PCB</td>
                                                <td>magendran.m@zettaone.com</td>
                                                <td>9943567723</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td></td>
                                                <td>Z0109</td>
                                                <td>KANNAN SHA</td>
                                                <td>Manager - PCB Design</td>
                                                <td>PCB</td>
                                                <td>kannan.sha@zettaone.com</td>
                                                <td>9004044665</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0110</td>
                                                <td>RAVIKUMAR R</td>
                                                <td>-</td>
                                                <td>PCB</td>
                                                <td>ravikumar.r@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0111</td>
                                                <td>AKSHAY UPADHYE</td>
                                                <td>-</td>
                                                <td>PCB</td>
                                                <td>akshay.upaadhye@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0113</td>
                                                <td>SHRUTI GUPTA</td>
                                                <td>-</td>
                                                <td>PCB Library</td>
                                                <td>shruti.gupta@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0114</td>
                                                <td>SURESH M</td>
                                                <td>-</td>
                                                <td>PCB</td>
                                                <td>suresh.m@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0115</td>
                                                <td>PALANICHAMY</td>
                                                <td>-</td>
                                                <td>PCB</td>
                                                <td>palanichamy@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>Z0116</td>
                                                <td>SUKANYA M</td>
                                                <td>-</td>
                                                <td>Accounts</td>
                                                <td>sukanya.m@zettaone.com</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr>
                                            <!--  
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>-</td>
                                                <td>Bangalore</td>
                                                <td class="datatable-ct"><i class="fa fa-check"></i>
                                                </td>
                                            </tr> -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Static Table End -->
          
</body>

</html>