package com.zetta.app.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.zetta.app.vo.UploadBean;
@Controller  
public class FileUploadController {

 
	private static String UPLOADED_FOLDER = "../zetta/src/main/resources/static/uploadedfiles";
	
	@RequestMapping(value="/uploadfile", method = RequestMethod.GET)
	   public String uploadFileHandler(Model model) {
		UploadBean ub = new UploadBean();
		model.addAttribute("ub", ub);
		return "uploadFile";
	}
	 
	@RequestMapping(value="/upload",method=RequestMethod.POST)
		public String singleFileUpload(@RequestParam("files") MultipartFile [] files,ModelMap model) {
		
		for(MultipartFile file:files){
			Path filePath=Paths.get(UPLOADED_FOLDER,file.getOriginalFilename());
			try {
				System.out.println("filePath:: "+filePath);
				Files.write(filePath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("uploadsuccess", "Your file successfully uploaded.");
        return "uploadFile";
    }
	
	 
	
}
