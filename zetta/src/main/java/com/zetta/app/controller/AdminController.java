package com.zetta.app.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.dao.AdminDAO;
import com.zetta.app.vo.AdminBean;

@Controller
public class AdminController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		return "home";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request,ModelMap model) {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request,ModelMap model) {
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("admin_card_no");
		String password = request.getParameter("password");
		System.out.println("user" + adminid);
		
		AdminBean ab = adao.getAdmin(adminid, password); 
		if(ab != null) {
			if(ab.getRole() != null && ab.getRole().equals("admin")) { 
				request.setAttribute("adminsuccessmsg", "Successfully logged In");
				request.setAttribute("name", ab.getName());
				List<AdminBean> list = adao.getAdmins();
				model.addAttribute("list", list);
				return "admin";
			}else {
				model.addAttribute("errormsg","Username or Password is incorrect");
				return "login";
			}
		}
		return "login";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request,ModelMap model) {
		return "admin_register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request,ModelMap model) {
		AdminBean ab = new AdminBean(); 
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("admin_card_no");
		String password = request.getParameter("password");
		ab.setAdmin_card_no(adminid);
		ab.setName(request.getParameter("name"));  
		ab.setDob(request.getParameter("dob")); 
		//System.out.println("DOB: "+request.getParameter("dob")); 
		ab.setDepartment(request.getParameter("department"));
		ab.setDesignation(request.getParameter("designation"));
		ab.setEmail(request.getParameter("email"));
		ab.setMobile(request.getParameter("mobile"));
		ab.setLocation(request.getParameter("location"));
		ab.setRole(request.getParameter("role").trim());  
		ab.setPassword1(password); 
		adao.insertAdmin(ab);
		model.addAttribute("successMessage","Admin Registered successfully.");
		return "admin_register";
	}


	@RequestMapping("/user/edit")
	public String edit(HttpServletRequest request,ModelMap model) { 
		String adminid1 = request.getParameter("id");
		AdminDAO adao=new AdminDAO();
		AdminBean ab = adao.editAdmin(adminid1);
		model.addAttribute("ab", ab);  
		return "editAdmin";
	}
	
	@RequestMapping(value="/user/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,ModelMap model) {
		AdminBean ab = new AdminBean(); 
		AdminDAO adao=new AdminDAO();
		String adminid1 = request.getParameter("id");
		ab.setAdmin_card_no(adminid1);
		ab.setName(request.getParameter("name"));  
		ab.setDob(request.getParameter("dob")); 
		//System.out.println("DOB: "+request.getParameter("dob")); 
		ab.setDepartment(request.getParameter("department"));
		ab.setDesignation(request.getParameter("designation"));
		ab.setEmail(request.getParameter("email"));
		ab.setMobile(request.getParameter("mobile"));
		ab.setLocation(request.getParameter("location"));
		ab.setRole(request.getParameter("role").trim());  
		String password = request.getParameter("password");
		ab.setPassword1(password);
		adao.updateAdmin(ab);
		model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		return "editAdmin";
	}	
	
	@RequestMapping("/user/delete")
	public String delete(HttpServletRequest request,ModelMap model) { 
		return "admin_register";
	}
	
	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public String deleteSubmit(HttpServletRequest request,ModelMap model) { 
		String adminid1 = request.getParameter("adminid");
		AdminDAO adao=new AdminDAO();
		adao.deleteAdmin(adminid1);
		model.addAttribute("deletesuccessmessage","Deleted Successfully");
		List<AdminBean> list = adao.getAdmins();
		model.addAttribute("list",list); 
		return "admin_register";
	}
	
}
