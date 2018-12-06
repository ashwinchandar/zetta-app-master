package com.zetta.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.zetta.app.dao.KnowledgeDAO; 
import com.zetta.app.vo.KnowledgeBean;

@Controller 
public class KnowledgeController{
	
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
		kb.setDate(request.getParameter("date"));
		kdao.insertKnowledgebase(kb); 
		model.addAttribute("knowledge", "Knowledgebase Published."); 
		return "knowledgebaseListing";
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
	public String announceEdit(HttpServletRequest request,ModelMap model) {
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
	
	
	
	
	
}
