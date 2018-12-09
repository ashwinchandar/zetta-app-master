package com.zetta.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.dao.KnowledgeDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.KnowledgeBean;

@Controller 
public class KnowledgeController{
	
	@RequestMapping("/knowledgebase")
	public String userEmployeedisplay(HttpServletRequest request, ModelMap model) {
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list); 
		return "knowledgebase"; 
	}
	
	@RequestMapping("/addknowledge")
	public String knowledgeregister(HttpServletRequest request,ModelMap model) { 
		return "add_knowledgebase";
	}

	@RequestMapping(value="/addknowledge",method=RequestMethod.POST)
	public String knowledgeSubmit(HttpServletRequest request,ModelMap model) { 		
		KnowledgeBean kb = new KnowledgeBean(); 
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		kb.setCategory(request.getParameter("category"));
		kb.setTopic(request.getParameter("topic"));
		kb.setSubject(request.getParameter("subject"));
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		kb.setCreatedBy(ab.getName());
		kb.setUpdatedBy(ab.getName());
		kdao.insertKnowledgebase(kb);  
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list);
		model.addAttribute("knowledge", "Knowledgebase Published."); 
		return "knowledgebaseListing";
	}
	
	
	@RequestMapping("/getAllKnowledgeBase")
	public String getAllKnowledgeBase(HttpServletRequest request,ModelMap model) { 
		String category = request.getParameter("id");
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeBean> list = kdao.getKBbyCategory(category);
		model.addAttribute("list", list); 
		return "knowledgebaselist";
	}
 
	
	
	@RequestMapping("/knowledgelisting")
	public String knowledgelisting(HttpServletRequest request,ModelMap model) {  
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list); 
		return "knowledgebaseListing";
	}
	
	@RequestMapping(value="/knowledgelisting",method=RequestMethod.POST)
	public String klistingSubmit(HttpServletRequest request,ModelMap model) { 
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list); 
		return "knowledgebaseListing";
	}
	
	@RequestMapping("/knowledge/edit")
	public String knowledgeEdit(HttpServletRequest request,ModelMap model) {
		String knowledge = request.getParameter("id");
		Integer knowledgeid = 0;
		if(knowledge!=null) {
			knowledgeid = Integer.parseInt(knowledge);
		}
		KnowledgeDAO kdao = new KnowledgeDAO();
		KnowledgeBean kb = kdao.editKnowledgebase(knowledgeid);
		
		model.addAttribute("kb", kb);
		return "editKnowledge";  
	}
	
	@RequestMapping(value="/knowledge/edit",method=RequestMethod.POST)
	public String eknowledgeSubmit(HttpServletRequest request,ModelMap model) { 
		String knowledge = request.getParameter("knowledgeid");
		Integer knowledgeid = 0;
		if(knowledge != null) {
			knowledgeid = Integer.parseInt(knowledge);
		} 
		KnowledgeBean kb = new KnowledgeBean();
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		kb.setKnowledgeid(knowledgeid); 
		kb.setCategory(request.getParameter("category"));
		kb.setTopic(request.getParameter("topic"));
		kb.setSubject(request.getParameter("subject"));
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER");  
		kb.setUpdatedBy(ab.getName());
		kdao.updateKnowldegebase(kb);
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		/*System.out.println("category");*/
		
		model.addAttribute("list", list); 
		model.addAttribute("kb", kb);
		return "knowledgebaseListing";
	}
	
	@RequestMapping("/knowledge/delete")
	public String knowledgeDelete(HttpServletRequest request,ModelMap model) {
		String knowledge = request.getParameter("id");
		Integer knowledgeid = 0;
		if(knowledge != null) {
			knowledgeid = Integer.parseInt(knowledge);
		}
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteKnowledgebase(knowledgeid);
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list);  
		return "knowledgebaseListing";
	}
	
	@RequestMapping(value="/knowledge/delete",method=RequestMethod.POST)
	public String dknowledgeSubmit(HttpServletRequest request,ModelMap model) { 
		String knowledge = request.getParameter("knowledgeid");
		Integer knowledgeid = 0;
		if(knowledge != null) {
			knowledgeid = Integer.parseInt(knowledge);
		}
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteKnowledgebase(knowledgeid);
		List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list);  
		return "knowledgebaseListing";
	}
}
