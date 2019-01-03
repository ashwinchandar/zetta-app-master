package com.zetta.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zetta.app.dao.OrgUploadDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.OrganizationVO;

 
@Controller
public class OrganizationController {
	 
	private static String UPLOADED_FOLDER = "C:/Workspace/repo/zetta-app-master/orgchart";
	
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
	public String knowledgeDelete(HttpServletRequest request,ModelMap model) {
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
	} 
	
	/*@RequestMapping(value="/uploadorg", method = RequestMethod.GET)
	   public String uploadFileHandler(Model model) {
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists(); 
		System.out.println("OrgList: " +list.size());
		model.addAttribute("list", list);
		return "orgListing";
	}
	
	@RequestMapping(value="/organization", method = RequestMethod.GET)
	   public String org(Model model) {
		FileUploadDAO fdao = new FileUploadDAO();
		List<FileVo> list = fdao.getFileuploadlist();
		System.out.println("List: " +list.size());
		model.addAttribute("list", list);
		return "organization";
	}*/
	
	/*@RequestMapping(value="/uploadorgfile",method=RequestMethod.POST)
	public String singleFileUpload(HttpServletRequest request, @RequestParam("files") MultipartFile [] files,ModelMap model) {
		
		for(MultipartFile file:files){
			Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename());
			try {
				OrganizationVO ov = new OrganizationVO();
				ov.setOrgFileName(file.getOriginalFilename());
				String oFilepath = "/orgchart/" +file.getOriginalFilename();
				ov.setOrgFilePath(oFilepath);
				HttpSession session = request.getSession(); 
				AdminBean ab = (AdminBean)session.getAttribute("USER"); 
				ov.setCreatedBy(ab.getName());
				ov.setUpdatedBy(ab.getName());
				System.out.println("Org FilePath:: "+filePath);
				OrgUploadDAO odao = new OrgUploadDAO(); 
				odao.insertOrgfile(ov);
				Files.write(filePath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("uploadsuccess", "Your file successfully uploaded.");
        return "orgListing";
	}*/
	
	/*@RequestMapping("/orguploadedlisting")
	public String organizationlisting(HttpServletRequest request,ModelMap model) {   
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists();
		model.addAttribute("list", list); 
		return "orgListing";
	}
	
	@RequestMapping(value="/orguploadedlisting",method=RequestMethod.POST)
	public String olistingSubmit(HttpServletRequest request,ModelMap model) { 
		OrgUploadDAO odao = new OrgUploadDAO(); 
		List<OrganizationVO> list = odao.getOrgLists();
		model.addAttribute("list", list);
		return "orgListing";
	}*/
	
	/*@RequestMapping("/orgupload/delete")
	public String orgDelete(HttpServletRequest request,ModelMap model) {
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
