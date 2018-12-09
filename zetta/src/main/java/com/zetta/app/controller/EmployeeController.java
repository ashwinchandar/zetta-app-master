package com.zetta.app.controller;

import java.util.List;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.vo.EmployeeBean;
import com.zetta.app.dao.EmployeeDAO;

@Controller
public class EmployeeController {
 
	@RequestMapping("/employeedirectory")
	public String userEmployeedisplay(HttpServletRequest request, ModelMap model) {
		EmployeeDAO edao = new EmployeeDAO(); 
		List<EmployeeBean> list = edao.getEmployees(); 
		model.addAttribute("list", list);
		return "employeedirectory"; 
	}
	
	@RequestMapping("/employeeregister")
	public String login(HttpServletRequest request,ModelMap model) {
		return "add_employee";
	}

	@RequestMapping(value="/employeeregister",method=RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request,ModelMap model) {
		EmployeeDAO edao = new EmployeeDAO();
		EmployeeBean eb = new EmployeeBean();
		String employeeid = request.getParameter("emp_card_no");
		eb.setEmp_card_no(employeeid);
		eb.setName(request.getParameter("name").trim());
		eb.setDob(request.getParameter("dob"));
		eb.setDepartment(request.getParameter("department"));
		eb.setDesignation(request.getParameter("designation"));
		eb.setEmail(request.getParameter("email"));
		eb.setMobile(request.getParameter("mobile"));
		eb.setLocation(request.getParameter("location"));
		edao.insertEmployee(eb); 
		List<EmployeeBean> list = edao.getEmployees(); 
		model.addAttribute("list", list); 
		model.addAttribute("empsucmsg", "Employee Added Successfully"); 
		return "employeeListing";
	}

	@RequestMapping("/employeelisting")
	public String elisting(HttpServletRequest request,ModelMap model) {
		EmployeeDAO edao = new EmployeeDAO(); 
		List<EmployeeBean> list = edao.getEmployees(); 
		model.addAttribute("list", list); 
		return "employeeListing";
	}

	@RequestMapping(value="/employeelisting",method=RequestMethod.POST)
	public String elistingSubmit(HttpServletRequest request,ModelMap model) {
		EmployeeDAO edao = new EmployeeDAO(); 
		List<EmployeeBean> list = edao.getEmployees(); 
		model.addAttribute("list", list); 
		return "employeeListing";
	}


	@RequestMapping("/employee/edit")
	public String edit(HttpServletRequest request,ModelMap model) { 
		EmployeeDAO edao = new EmployeeDAO(); 
		String employeeid1 = request.getParameter("id");
		EmployeeBean eb = edao.editEmployee(employeeid1);  
		model.addAttribute("eb", eb); 
		return "editEmployee";
	}
	
	@RequestMapping(value="/employee/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,ModelMap model) {
		EmployeeDAO edao = new EmployeeDAO();
		EmployeeBean eb = new EmployeeBean();
		String employeeid = request.getParameter("emp_card_no");
		eb.setEmp_card_no(employeeid); 
		eb.setName(request.getParameter("name").trim());
		eb.setDob(request.getParameter("dob"));
		eb.setDepartment(request.getParameter("department"));
		eb.setDesignation(request.getParameter("designation"));
		eb.setEmail(request.getParameter("email"));
		eb.setMobile(request.getParameter("mobile"));
		eb.setLocation(request.getParameter("location"));
		edao.updateEmployee(eb);
		List<EmployeeBean> list = edao.getEmployees(); 
		model.addAttribute("list", list); 
		model.addAttribute("empsucmsg", "Employee Modified Successfully"); 
		return "employeeListing";
	}	
	
	@RequestMapping("/employee/delete")
	public String delete(HttpServletRequest request,ModelMap model) { 
		EmployeeDAO edao = new EmployeeDAO();
		String employeeid = request.getParameter("id");
		edao.deleteEmployee(employeeid);
		List<EmployeeBean> list = edao.getEmployees();
		model.addAttribute("list", list); 
		return "employeeListing";
	}
	
	@RequestMapping(value="/employee/delete",method=RequestMethod.POST)
	public String deleteSubmit(HttpServletRequest request,ModelMap model) { 
		EmployeeDAO edao = new EmployeeDAO();
		String employeeid = request.getParameter("emp_card_no");
		edao.deleteEmployee(employeeid);
		List<EmployeeBean> list = edao.getEmployees();
		model.addAttribute("list", list); 
		return "employeeListing";
	}
	
} 