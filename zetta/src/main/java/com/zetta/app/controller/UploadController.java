package com.zetta.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.zetta.app.vo.UploadBean;

@Controller  
public class UploadController {
	 
	@RequestMapping(value="/uploadfile", method = RequestMethod.GET)
	   public String uploadFileHandler(Model model) {
		UploadBean ub = new UploadBean();
		model.addAttribute("ub", ub);
		return "uploadFile";
	}
	@RequestMapping(value="/uploadfile", method = RequestMethod.POST)
		public String uploadFileHandlers(HttpServletRequest request, Model model, @ModelAttribute("ub") UploadBean ub) {
		return this.doUpload(request,model,ub);
	}
	
	private String doUpload(HttpServletRequest request, Model model, UploadBean ub) {
		String title = ub.getTitle();
		System.out.println("Title: " +title);
		
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("uploadrootpath: "+uploadRootPath);
		
		 File uploadRootDir = new File(uploadRootPath);
		 if(!uploadRootDir.exists()) {
			 uploadRootDir.mkdirs();
		 }
		 MultipartFile[] fileDatas = ub.getFileDatas();
		 List<File> uploadedFiles = new ArrayList<File>();
		 List<String> failedFiles = new ArrayList<String>();
		 
		 for(MultipartFile fileData : fileDatas) {
			 String name = fileData.getOriginalFilename();
			 System.out.println("Original File Name :" +name);
			 
			 if(name != null && name.length()>0) {
				 try {
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
					
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
					
					uploadedFiles.add(serverFile);
				 } catch(Exception e) {
					 System.out.println("Error write file:" +name);
					 failedFiles.add(name);
				 } 
			 }
		 }
		 model.addAttribute("description", title);
		 model.addAttribute("uploadedFiles", uploadedFiles);
		 model.addAttribute("failedFiles", failedFiles);
		 return "uploadedListing";
	}
	
}
