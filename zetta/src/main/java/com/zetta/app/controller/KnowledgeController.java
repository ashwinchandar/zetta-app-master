package com.zetta.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.zetta.app.dao.KnowledgeDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.KnowledgeBean;
import com.zetta.app.vo.KnowledgeReplyVO;

@Controller 
public class KnowledgeController{ 			 	 
	 
	private static String UPLOADED_FOLDER = "C:/Workspace/zetta-app-master/knowledgefiles/"; 
	
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
	public String knowledgeSubmit(HttpServletRequest request, @RequestParam("files") MultipartFile [] files,@RequestParam("kimg") MultipartFile [] images,ModelMap model) { 
		KnowledgeBean kb = new KnowledgeBean();
		KnowledgeDAO kdao = new KnowledgeDAO();
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		kb.setCategory(request.getParameter("category"));
		kb.setTopic(request.getParameter("topic")); 
		for(MultipartFile file:files) {
			Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename()); 
			try {
			kb.setFileName(file.getOriginalFilename());
			String sFilePath = UPLOADED_FOLDER +file.getOriginalFilename().trim();
			kb.setFilePath(sFilePath); 
			Files.write(filePath, file.getBytes());
			Path temp = Files.move(Paths.get("C:/Workspace/zetta-app-master/knowledgefiles/"+file.getOriginalFilename()), Paths.get("C:/Program Files (x86)/Apache Software Foundation/Apache2.2/htdocs/zetta/knowledgefiles/"+file.getOriginalFilename()));
			if(temp != null) 
	        { 
	            System.out.println("File renamed and moved successfully"); 
	        } 
	        else
	        {
	            System.out.println("Failed to move the file");
	        }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(MultipartFile file:images) {
			Path imagePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename()); 
			try {
			kb.setImageName(file.getOriginalFilename());
			String simagePath = UPLOADED_FOLDER +file.getOriginalFilename().trim();
			kb.setImagePath(simagePath); 
			Files.write(imagePath, file.getBytes());
			Path temp = Files.move(Paths.get("C:/Workspace/zetta-app-master/knowledgefiles/"+file.getOriginalFilename()), Paths.get("C:/Program Files (x86)/Apache Software Foundation/Apache2.2/htdocs/zetta/knowledgefiles/"+file.getOriginalFilename()));
			if(temp != null) 
	        { 
	            System.out.println("File renamed and moved successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to move the file"); 
	        }
			} catch (IOException e) { 
				e.printStackTrace();
			} 
		}
		kb.setSubject(request.getParameter("subject")); 
		kb.setCreatedBy(ab.getName());
		kb.setUpdatedBy(ab.getName());
		List<KnowledgeBean> list = null;
		if(ab.getRole().equals("COMMONUSER")) {
			kb.setStatus("PENDING");
			model.addAttribute("kbpost", "Your knowledge shared Successfully, Please wait for approval to publish.");  
		} else {
			kb.setStatus("ACTIVE");
			model.addAttribute("kball", "Dear Admin, Your knowledge Published.");   
		}
		kdao.insertKnowledgebase(kb);
		if(ab.getRole().equals("COMMONUSER")) { 
			 list = kdao.getknowledgebaselist(ab.getName());
		} else { 
			 list = kdao.getknowledgebaselist();
		}
		model.addAttribute("role", ab.getRole());  
		model.addAttribute("list", list);
		model.addAttribute("knowledge", "Knowledgebase Published."); 
		/*return "add_knowledgebase";*/
		return "knowledgebaseListing"; 
	}
	 
	@RequestMapping(value="/publish",method=RequestMethod.GET)
	public String knowledgepublishPost(HttpServletRequest request,ModelMap model) {
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		KnowledgeBean kb = new KnowledgeBean();
		kb.setKnowledgeid(Integer.parseInt(request.getParameter("id")));
		kdao.publishkb(kb);
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		List<KnowledgeBean> list = null;
		if(ab.getRole().equals("COMMONUSER")) { 
			 list = kdao.getknowledgebaselist(ab.getName());
		} else {  
			 list = kdao.getknowledgebaselist();
		}
		model.addAttribute("list", list);
		model.addAttribute("role", ab.getRole());
		return "knowledgebaseListing"; 
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,ModelMap model) {  
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		Integer replyid = Integer.parseInt(request.getParameter("id"));
		String topic = request.getParameter("topic");
		List<KnowledgeReplyVO> replylist = kdao.getKnowledgereply(replyid);
		List<KnowledgeBean> list = kdao.getKBbyTopic(topic);
		model.addAttribute("list", list);
		model.addAttribute("replylist", replylist);
		model.addAttribute("isReply", "YES"); 
		return "knowledgebasetopic";
	}

	@RequestMapping(value="/replySubmit",method=RequestMethod.POST )
	public String replySubmit(HttpServletRequest request, @RequestParam("files") MultipartFile [] rfiles,@RequestParam("kimg") MultipartFile [] rimages,ModelMap model) {  
		KnowledgeReplyVO rvo = new KnowledgeReplyVO();
		KnowledgeDAO kdao = new KnowledgeDAO(); 
/*		Integer replyid = Integer.parseInt(request.getParameter("reply_id"));*/
		Integer topicid = Integer.parseInt(request.getParameter("topicid"));
		String topic = request.getParameter("topic");
		rvo.setTopicid(topicid);
		rvo.setTopic(topic);
		rvo.setReply(request.getParameter("reply"));
		for(MultipartFile file:rfiles) {
			Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename()); 
			try {
			rvo.setFileName(file.getOriginalFilename());
			String sFilePath = UPLOADED_FOLDER +file.getOriginalFilename().trim();
			rvo.setFilePath(sFilePath); 
			Files.write(filePath, file.getBytes());
			Path temp = Files.move(Paths.get("C:/Workspace/zetta-app-master/knowledgefiles/"+file.getOriginalFilename()), Paths.get("C:/Program Files (x86)/Apache Software Foundation/Apache2.2/htdocs/zetta/knowledgefiles/"+file.getOriginalFilename()));
			if(temp != null) 
	        { 
	            System.out.println("File renamed and moved successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to move the file"); 
	        }
			} catch (IOException e) { 
				e.printStackTrace();
			} 
		}
		for(MultipartFile file:rimages) {
			Path imagePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename()); 
			try {
			rvo.setImageName(file.getOriginalFilename());
			String simagePath = UPLOADED_FOLDER +file.getOriginalFilename().trim();
			rvo.setImagePath(simagePath); 
			Files.write(imagePath, file.getBytes());
			Path temp = Files.move(Paths.get("C:/Workspace/zetta-app-master/knowledgefiles/"+file.getOriginalFilename()), Paths.get("C:/Program Files (x86)/Apache Software Foundation/Apache2.2/htdocs/zetta/knowledgefiles/"+file.getOriginalFilename()));
			if(temp != null) 
	        { 
	            System.out.println("File renamed and moved successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to move the file"); 
	        }
			} catch (IOException e) { 
				e.printStackTrace();
			} 
		}
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
		Integer replyid = Integer.parseInt(request.getParameter("id"));
		String topic = request.getParameter("topic");
		List<KnowledgeReplyVO> replylist = kdao.getKnowledgereply(replyid);
		List<KnowledgeBean> list = kdao.getKBbyTopic(topic);
		model.addAttribute("list", list);
		model.addAttribute("replylist", replylist);  
		return "knowledgebasetopic";
	}
	
	@RequestMapping("/knowledgelisting")
	public String knowledgelisting(HttpServletRequest request,ModelMap model) {  
		KnowledgeDAO kdao = new KnowledgeDAO(); 
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		List<KnowledgeBean> list = null;
		if(ab.getRole().equals("COMMONUSER")) { 
			 list = kdao.getknowledgebaselist(ab.getName());
		} else {  
			 list = kdao.getknowledgebaselist();
		}
		model.addAttribute("role", ab.getRole());  
		model.addAttribute("list", list); 
		return "knowledgebaseListing";
		/*list.forEach(li->{System.out.println("dddd" +li.getImageName());});*/
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
		/*List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list);  
		return "knowledgebaseListing";*/
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		List<KnowledgeBean> list = null;
		if(ab.getRole().equals("COMMONUSER")) { 
			 list = kdao.getknowledgebaselist(ab.getName());
		} else {  
			 list = kdao.getknowledgebaselist();
		}
		model.addAttribute("role", ab.getRole());  
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
		/*List<KnowledgeBean> list = kdao.getknowledgebaselist();
		model.addAttribute("list", list);  
		return "knowledgebaseListing";*/ 
		HttpSession session = request.getSession(); 
		AdminBean ab = (AdminBean)session.getAttribute("USER"); 
		List<KnowledgeBean> list = null;
		if(ab.getRole().equals("COMMONUSER")) { 
			 list = kdao.getknowledgebaselist(ab.getName());
		} else {  
			 list = kdao.getknowledgebaselist();
		}
		model.addAttribute("role", ab.getRole());  
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
		Integer replyid = Integer.parseInt(request.getParameter("id"));  
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteReply(replyid);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<KnowledgeReplyVO> list = kdao.getListKnowledgereply(); 
		model.addAttribute("list",list); 
		return "knowledgeReplyListing";
	}
	
	@RequestMapping(value="/reply/delete",method=RequestMethod.POST)
	public String dreplySubmit(HttpServletRequest request,ModelMap model) { 
		Integer replyid = Integer.parseInt(request.getParameter("replyid")); 
		KnowledgeDAO kdao = new KnowledgeDAO();
		kdao.deleteReply(replyid);
		model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
		List<KnowledgeReplyVO> list = kdao.getListKnowledgereply(); 
		model.addAttribute("list",list); 
		return "knowledgeReplyListing";
	} 
	
	/*File upload*/
	
	/*private static String UPLOADED_FOLDER = "../zetta/src/main/resources/static/knowledgefiles";
	
	@RequestMapping(value="/orgupload", method = RequestMethod.GET)
	   public String organizationHandler(Model model) {
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists(); 
		System.out.println("List: " +list.size());
		model.addAttribute("list", list);
		return "orgListing";
	}
	
	@RequestMapping(value="/organization", method = RequestMethod.GET)
	   public String orgchart(Model model) {
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists(); 
		System.out.println("List: " +list.size());
		model.addAttribute("list", list);
		return "organization";
	}
	 
	@RequestMapping(value="/chartinsert",method=RequestMethod.POST)
	public String orgChartUpload(HttpServletRequest request, @RequestParam("files") MultipartFile [] files,ModelMap model) {
	
	for(MultipartFile file:files){
		Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename());
		try {
			OrganizationVO ov = new OrganizationVO(); 
			ov.setFileName(file.getOriginalFilename());
			String sFilepath = "/orgchart/" +file.getOriginalFilename().trim();
			ov.setFilePath(sFilepath);
			HttpSession session = request.getSession(); 
			AdminBean ab = (AdminBean)session.getAttribute("USER"); 
			ov.setCreatedBy(ab.getName());
			ov.setUpdatedBy(ab.getName());
			System.out.println("filePath:: "+filePath);
			OrgUploadDAO odao = new OrgUploadDAO(); 
			odao.insertOrgfile(ov);
			Files.write(filePath, file.getBytes()); 
			List<OrganizationVO> list = odao.getOrgLists();
			model.addAttribute("list", list); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	model.addAttribute("uploadsuccess", "Your file successfully uploaded.");
    return "orgListing";
}
	
	@RequestMapping("/firmchartlisting")
	public String orglisting(HttpServletRequest request,ModelMap model) {   
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists();
		model.addAttribute("list", list); 
		return "orgListing";
	}
	
	@RequestMapping(value="/firmchartlisting",method=RequestMethod.POST)
	public String orglistingSubmit(HttpServletRequest request,ModelMap model) { 
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists();
		model.addAttribute("list", list); 
		return "orgListing";
	}
	
	@RequestMapping("/organizationchart/delete")
	public String knowledgedDelete(HttpServletRequest request,ModelMap model) {
		String fileupload = request.getParameter("id");
		Integer orgId = 0;
		if(fileupload != null) {
			orgId = Integer.parseInt(fileupload);
		}
		OrgUploadDAO odao = new OrgUploadDAO();
		odao.deleteOrgFile(orgId);
		List<OrganizationVO> list = odao.getOrgList(); 
		model.addAttribute("list", list);  
		return "orgListing";
	} */
	
}
