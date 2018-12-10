package com.zetta.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		public String singleFileUpload(HttpServletRequest request,ModelMap model) {
		
       /* System.out.println("file upload befor");
        * if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "uploadFile";
        }

        try { 
            // Get the file and save it somewhere
        	System.out.println("file upload inside try");
            byte[] bytes = file.getBytes();
            Path path = (Path) Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println("file upload inside try path");
            Files.write(bytes, path);
            Files.write((java.nio.file.Path) path, bytes, null);
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		model.addAttribute("uploadsuccess", "Your file successfully uploaded.");
        return "uploadFile";
    }
	
	 
	
}
