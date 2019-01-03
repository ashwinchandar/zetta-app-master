package com.zetta.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.dao.AdminDAO;
import com.zetta.app.dao.AnnounceDAO;
import com.zetta.app.dao.EmployeeDAO;
import com.zetta.app.dao.KnowledgeDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.AnnounceBean;
import com.zetta.app.vo.EmployeeBean;

@Controller
public class AdminController {

	
	@RequestMapping("/")
	public String login(HttpServletRequest request,ModelMap model) {
		return "login";
	} 
	@RequestMapping("/login")
	public String inlogin(HttpServletRequest request,ModelMap model) {
		return "login";
	} 
	@RequestMapping("/home")
	public String home(HttpServletRequest request,ModelMap model) {
		AnnounceDAO adao = new AnnounceDAO();
		List<AnnounceBean> list = adao.getAnnouncements();
		model.addAttribute("list", list);  
		AdminDAO amdao = new AdminDAO();
		List<AdminBean> birthList = amdao.getEmployeeBirthday();
		model.addAttribute("birthList", birthList); 
		/*EmployeeDAO edao = new EmployeeDAO();
		List<EmployeeBean> birthList = edao.getEmployeeBirthday();
		model.addAttribute("birthList", birthList);*/
		AdminBean ab = (AdminBean) request.getSession().getAttribute("USER");
		model.addAttribute("CURRENT_USER", ab);
		return "home";
	} 
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,ModelMap model) {
		if(request.getSession()!=null) {
			request.getSession().invalidate();
			model.addAttribute("adminlogout", "Successfully logged out");
		}
		return "login";
	} 
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request,ModelMap model) {
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("admin_card_no");
		String password = request.getParameter("password1"); 
		AdminBean ab = adao.getAdmin(adminid, password);  
		if(ab != null && ab.getRole() != null) { 
			model.addAttribute("mastersuccess", "Successfully logged In");
			model.addAttribute("name", ab.getName());
			String role = adao.getRole(ab.getRole());
			List<AdminBean> list = adao.getAdmins(); 
			/*System.out.println("role: " +role); */
			AnnounceDAO adao1 = new AnnounceDAO();
			List<AnnounceBean> list1 = adao1.getAnnouncements();
			model.addAttribute("list", list1); 
			AdminDAO amdao = new AdminDAO();
			List<AdminBean> birthList = amdao.getEmployeeBirthday();
			model.addAttribute("birthList", birthList); 
			/*AdminBean ab = (AdminBean) request.getSession().getAttribute("USER");
			model.addAttribute("CURRENT_USER", ab);*/  
			request.getSession().setAttribute("ROLE", role);
			model.addAttribute("list", list1);
			request.getSession().setAttribute("USER", ab);
			model.addAttribute("CURRENT_USER", ab);
			request.getSession().setAttribute("USER_NAME", ab.getName());
			return "home";   //menu 
		} else {
			model.addAttribute("errormsg","Username or Password is incorrect");
			return "login";
		}   
	}
	
	@RequestMapping("/menu")
	public String menu(HttpServletRequest request,ModelMap model) { 
		KnowledgeDAO kdao = new KnowledgeDAO();
		String count=kdao.getknowledgebasePendingCount();
		model.addAttribute("pendingCount", count);
		return "menu";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,ModelMap model) {
		AdminDAO adao=new AdminDAO(); 
		List<AdminBean> list = adao.getAdmins();  
		model.addAttribute("list", list);
		return "admin_register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request,ModelMap model) {
		AdminBean ab = new AdminBean(); 
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("admin_card_no");
		String password = request.getParameter("password1");
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
		List<AdminBean> list = adao.getAdmins();  
		model.addAttribute("list", list);
		model.addAttribute("successMessage","Admin Registered successfully.");
		return "adminListing";
	}
	
	@RequestMapping("/directory")
	public String alluserdirectory(HttpServletRequest request, ModelMap model) {
		AdminDAO adao=new AdminDAO();
		AdminBean ab = (AdminBean) request.getSession().getAttribute("USER"); 
		List<AdminBean> list = null;
		if("MASTER".equals(ab.getRole())) {
			list = adao.getAdmins();
		}else if("ADMIN".equals(ab.getRole())) {
			list = adao.getAdmins();
		}else if("AMODERATOR".equals(ab.getRole())) {
			list = adao.getAdmins();
		}else {
			list = adao.getAdminz(ab.getRole());
		}  
		model.addAttribute("list", list); 
		return "employeedirectory"; 
	}
	 
	@RequestMapping("/adminlisting")
	public String adminListing(HttpServletRequest request, ModelMap model) {
		AdminDAO adao=new AdminDAO(); 
		List<AdminBean> list = adao.getAdmins();  
		model.addAttribute("list", list); 
		return "adminListing"; 
	}
	
	@RequestMapping(value="/adminlisting",method=RequestMethod.POST)
	public String adminListingSubmit(HttpServletRequest request,ModelMap model) {
	AdminDAO adao=new AdminDAO(); 
	List<AdminBean> list = adao.getAdmins();  
	model.addAttribute("list", list); 
	return "adminListing";
	}

	@RequestMapping("/admin/edit")
	public String edit(HttpServletRequest request,ModelMap model) {   
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("id");
		AdminBean ab = adao.editAdmin(adminid);
		model.addAttribute("ab", ab); 
		return "editAdmin";  
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,ModelMap model) {
		AdminBean ab = new AdminBean(); 
		AdminDAO adao=new AdminDAO();
		String adminid = request.getParameter("admin_card_no");
		ab.setAdmin_card_no(adminid);
		ab.setName(request.getParameter("name"));  
		ab.setDob(request.getParameter("dob"));  
		ab.setDepartment(request.getParameter("department"));
		ab.setDesignation(request.getParameter("designation"));
		ab.setEmail(request.getParameter("email"));
		ab.setMobile(request.getParameter("mobile"));
		ab.setLocation(request.getParameter("location"));
		ab.setRole(request.getParameter("role").trim());  
		String password = request.getParameter("password1");
		ab.setPassword1(password);
		adao.updateAdmin(ab);
		List<AdminBean> list = adao.getAdmins();  
		model.addAttribute("list", list);
		model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		return "adminListing";
	}	
	
	@RequestMapping("/admin/delete")
	public String delete(HttpServletRequest request,ModelMap model) { 
		String adminid1 = request.getParameter("id");
		AdminDAO adao=new AdminDAO();
		adao.deleteAdmin(adminid1);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<AdminBean> list = adao.getAdmins();
		model.addAttribute("list",list); 
		return "adminListing";
	}
	
	@RequestMapping(value="/admin/delete",method=RequestMethod.POST)
	public String deleteSubmit(HttpServletRequest request,ModelMap model) { 
		String adminid1 = request.getParameter("admin_card_no");
		AdminDAO adao=new AdminDAO();
		adao.deleteAdmin(adminid1);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<AdminBean> list = adao.getAdmins();
		model.addAttribute("list",list); 
		return "adminListing";
	} 
} 