package com.zetta.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zetta.app.dao.AdminDAO;
import com.zetta.app.dao.KnowledgeDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.KnowledgeBean;
import com.zetta.app.vo.KnowledgeReplyVO;

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
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,ModelMap model) {  
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		Integer topic_id = Integer.parseInt(request.getParameter("id"));
		String topic = request.getParameter("topic");
		List<KnowledgeReplyVO> replylist = kdao.getKnowledgereply(topic_id);
		List<KnowledgeBean> list = kdao.getKBbyTopic(topic);
		model.addAttribute("list", list);
		model.addAttribute("replylist", replylist);
		model.addAttribute("isReply", "YES"); 
		return "knowledgebasetopic";
	}

	@RequestMapping(value="/replySubmit",method=RequestMethod.POST)
	public String replaySubmit(HttpServletRequest request,ModelMap model) {  
		KnowledgeReplyVO rvo = new KnowledgeReplyVO();
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		Integer topicid = Integer.parseInt(request.getParameter("topicid"));
		String topic = request.getParameter("topic");
		rvo.setTopicid(topicid);
		rvo.setTopic(topic);
		rvo.setReply(request.getParameter("reply")); 
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		rvo.setCreatedBy(ab.getName());
		rvo.setUpdatedBy(ab.getName());
		kdao.insertKnowledgeReply(rvo);
		List<KnowledgeReplyVO> replylist = kdao.getKnowledgereply(topicid);
		List<KnowledgeBean> list = kdao.getKBbyTopic(topic);
		model.addAttribute("list", list);
		model.addAttribute("replylist", replylist); 
		return "knowledgebasetopic";
	}
	
	
	@RequestMapping("/getAllKnowledgeBase")
	public String getAllKnowledgeBase(HttpServletRequest request,ModelMap model) { 
		String category = request.getParameter("id");
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeBean> list = kdao.getKBbyCategory(category);
		model.addAttribute("list", list); 
		return "knowledgebaselist";
	}   
 
	@RequestMapping("/getAlltopickb")
	public String getAlltopicKnowledgeBase(HttpServletRequest request,ModelMap model) {  
		KnowledgeDAO kdao = new KnowledgeDAO();
		Integer topicid = Integer.parseInt(request.getParameter("id"));
		String topic = request.getParameter("topic");
		List<KnowledgeReplyVO> replylist = kdao.getKnowledgereply(topicid);
		List<KnowledgeBean> list = kdao.getKBbyTopic(topic);
		model.addAttribute("list", list);
		model.addAttribute("replylist", replylist);  
		return "knowledgebasetopic";
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
	
	@RequestMapping("/knowledgereplylisting")
	public String replylisting(HttpServletRequest request,ModelMap model) {   
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeReplyVO> list = kdao.getListKnowledgereply(); 
		model.addAttribute("list", list); 
		return "knowledgeReplyListing";
	}
	
	@RequestMapping(value="/knowledgereplylisting",method=RequestMethod.POST)
	public String kreplylistSubmit(HttpServletRequest request,ModelMap model) { 
		KnowledgeDAO kdao = new KnowledgeDAO();
		List<KnowledgeReplyVO> list = kdao.getListKnowledgereply(); 
		model.addAttribute("list", list);
		return "knowledgeReplyListing";
	}
	
	@RequestMapping("/reply/delete")
	public String deleteReply(HttpServletRequest request,ModelMap model) { 
		Integer topicid = Integer.parseInt(request.getParameter("id")); 
		String topic = request.getParameter("topic");
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteReply(topicid,topic);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<KnowledgeReplyVO> list = kdao.getKnowledgereply(topicid);
		model.addAttribute("list",list); 
		return "knowledgeReplyListing";
	}
	
	@RequestMapping(value="/reply/delete",method=RequestMethod.POST)
	public String dreplySubmit(HttpServletRequest request,ModelMap model) { 
		Integer topicid = Integer.parseInt(request.getParameter("topicid"));
		String topic = request.getParameter("topic");
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteReply(topicid,topic);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<KnowledgeReplyVO> list = kdao.getKnowledgereply(topicid);
		model.addAttribute("list",list); 
		return "knowledgeReplyListing";
	} 
}
