package com.zetta.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.dao.AdminDAO;
import com.zetta.app.vo.AdminBean;

@Controller
public class UserController {

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
		AdminBean ab = adao.getAdmin(adminid, password); 
		if(ab != null) {
			if(ab.getRole() != null && ab.getRole().equals("admin")) { 
				request.setAttribute("adminsuccessmsg", "Successfully logged In");
				request.setAttribute("name", ab.getName());
				List<AdminBean> list = adao.getAdmins();
				model.addAttribute("list", list);
				return "admin_register";
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
		AdminDAO adao=new AdminDAO();
		adao.insertAdmin(ab);
		model.addAttribute("successMessage","Admin Registered successfully.");
		return "admin_register";
	}


	@RequestMapping("/user/edit")
	public String edit(HttpServletRequest request,ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value="/user/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,ModelMap model) {
		return "home";
	}	


}
