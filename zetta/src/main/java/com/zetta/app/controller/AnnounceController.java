package com.zetta.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetta.app.dao.AnnounceDAO;
import com.zetta.app.vo.AnnounceBean;
 
@Controller
public class AnnounceController   {
	  
	@RequestMapping("/newannounce")
	public String announceregister(HttpServletRequest request,ModelMap model) { 
		return "new_announcement";
	}

	@RequestMapping(value="/newannounce",method=RequestMethod.POST)
	public String announceSubmit(HttpServletRequest request,ModelMap model) { 		
		AnnounceBean ab = new AnnounceBean(); 
		AnnounceDAO adao = new AnnounceDAO();
		ab.setTitle(request.getParameter("title"));
		ab.setDate(request.getParameter("date"));
		ab.setAnnouncement(request.getParameter("announcement"));
		adao.insertAnnouncement(ab);
		model.addAttribute("announce", "Announcement Published."); 
		return "announcementListing";
	}
	
	@RequestMapping("/announcelisting")
	public String announcelisting(HttpServletRequest request,ModelMap model) { 
		AnnounceDAO adao = new AnnounceDAO();
		List<AnnounceBean> list = adao.getAnnouncementslist();
		model.addAttribute("list", list); 
		return "announcementListing";
	}

	@RequestMapping(value="/announcelisting",method=RequestMethod.POST)
	public String alistingSubmit(HttpServletRequest request,ModelMap model) {
		AnnounceDAO adao = new AnnounceDAO();
		List<AnnounceBean> list = adao.getAnnouncementslist();
		model.addAttribute("list", list); 
		return "announcementListing"; 
	}
	
	@RequestMapping("/announce/edit")
	public String announceEdit(HttpServletRequest request,ModelMap model) {
		String announce = request.getParameter("id");
		Integer announceid=0;
		if(announce != null) {
			  announceid = Integer.parseInt(announce);
		} 
		AnnounceDAO adao = new AnnounceDAO();
		AnnounceBean ab = adao.editAnnouncement(announceid);
		model.addAttribute("ab", ab); 
		return "editAnnouncement";	}
	
	@RequestMapping(value="/announce/edit",method=RequestMethod.POST)
	public String announceEditSubmit(HttpServletRequest request,ModelMap model) {
		String announce = request.getParameter("announceid");
		Integer announceid=0;
		if(announce != null) {
			  announceid = Integer.parseInt(announce);
		} 
		AnnounceDAO adao = new AnnounceDAO();
		AnnounceBean ab=new AnnounceBean();
		ab.setAnnounceid(announceid); 
		ab.setTitle(request.getParameter("title"));
		ab.setDate(request.getParameter("date"));
		ab.setAnnouncement(request.getParameter("announcement"));
		adao.updateAnnouncement(ab);
		List<AnnounceBean> list = adao.getAnnouncementslist();
		model.addAttribute("list", list); 		
		model.addAttribute("editannounce", "Successfully Modified."); 
		return "announcementListing";
	}
	
	@RequestMapping("/announce/delete")
	public String announceDelete(HttpServletRequest request,ModelMap model) {
		String announce = request.getParameter("id");
		Integer announceid=0;
		if(announce != null) {
			  announceid = Integer.parseInt(announce);
		} 
		AnnounceDAO adao = new AnnounceDAO();
		adao.deleteAnnouncement(announceid);
		List<AnnounceBean> list = adao.getAnnouncements();
		model.addAttribute("list", list); 
		return "announcementListing";
	}
	
	@RequestMapping(value="/announce/delete",method=RequestMethod.POST)
	public String announceDeleteSubmit(HttpServletRequest request,ModelMap model) {
		String announce = request.getParameter("announceid");
		Integer announceid=0;
		if(announce != null) {
			  announceid = Integer.parseInt(announce);
		} 
		AnnounceDAO adao = new AnnounceDAO();
		adao.deleteAnnouncement(announceid);
		List<AnnounceBean> list = adao.getAnnouncements();
		model.addAttribute("list", list); 
		return "announcementListing";
	}
	
}
