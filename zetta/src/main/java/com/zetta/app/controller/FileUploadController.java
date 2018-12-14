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
import com.zetta.app.dao.FileUploadDAO;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.FileVo;

@Controller  
public class FileUploadController {

 
	private static String UPLOADED_FOLDER = "../zetta/uploadedfiles";
	
	@RequestMapping(value="/uploadfile", method = RequestMethod.GET)
	   public String uploadFileHandler(Model model) {
		FileUploadDAO fdao = new FileUploadDAO();
		List<FileVo> list = fdao.getFileuploadlist();
		System.out.println("List: " +list.size());
		model.addAttribute("list", list);
		return "uploadFileListing";
	}
	
	@RequestMapping(value="/qms", method = RequestMethod.GET)
	   public String qms(Model model) {
		FileUploadDAO fdao = new FileUploadDAO();
		List<FileVo> list = fdao.getFileuploadlist();
		System.out.println("List: " +list.size());
		model.addAttribute("list", list);
		return "qms";
	}
	 
	@RequestMapping(value="/upload",method=RequestMethod.POST)
		public String singleFileUpload(HttpServletRequest request, @RequestParam("files") MultipartFile [] files,ModelMap model) {
		
		for(MultipartFile file:files){
			Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename());
			try {
				FileVo fv = new FileVo();
				fv.setFileName(file.getOriginalFilename());
				String sFilepath = "/uploadedfiles/" +file.getOriginalFilename();
				fv.setFilePath(sFilepath);
				HttpSession session = request.getSession(); 
				AdminBean ab = (AdminBean)session.getAttribute("USER"); 
				fv.setCreatedBy(ab.getName());
				fv.setUpdatedBy(ab.getName());
				System.out.println("filePath:: "+filePath);
				FileUploadDAO fdao = new FileUploadDAO();
				fdao.insertUploadfile(fv);
				Files.write(filePath, file.getBytes());
				List<FileVo> list = fdao.getFileuploadlist(); 
				model.addAttribute("list", list); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("uploadsuccess", "Your file successfully uploaded.");
        return "uploadFileListing";
    }
	
	@RequestMapping("/uploadedlisting")
	public String knowledgelisting(HttpServletRequest request,ModelMap model) {   
		FileUploadDAO fdao = new FileUploadDAO();
		List<FileVo> list = fdao.getFileuploadlist(); 
		model.addAttribute("list", list); 
		return "uploadFileListing";
	}
	
	@RequestMapping(value="/uploadedlisting",method=RequestMethod.POST)
	public String klistingSubmit(HttpServletRequest request,ModelMap model) { 
		FileUploadDAO fdao = new FileUploadDAO();
		List<FileVo> list = fdao.getFileuploadlist(); 
		model.addAttribute("list", list); 
		return "uploadFileListing";
	}
	
	@RequestMapping("/upload/delete")
	public String knowledgeDelete(HttpServletRequest request,ModelMap model) {
		String fileupload = request.getParameter("id");
		Integer fileid = 0;
		if(fileupload != null) {
			fileid = Integer.parseInt(fileupload);
		}
		FileUploadDAO fdao = new FileUploadDAO();
		fdao.deleteFileupload(fileid);
		List<FileVo> list = fdao.getFileupload();
		model.addAttribute("list", list);  
		return "uploadFileListing";
	}  
}
