package com.spoors.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spoors.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	 FileUploadService service ;
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload");
	}
	@RequestMapping(value="/fileUpload",method=RequestMethod.GET)
	public ModelAndView SavePerson(@RequestParam("file") String file,RedirectAttributes rdab) {
		if (file.isEmpty()) {
			rdab.addFlashAttribute("message", "please select file");
			return new ModelAndView("upload", "message", "please select file");
		}
		try {
//			byte[] bytes = file.getBytes();
//			Path paths = Paths.get("/home/spoors/Desktop/Task" + file.getOriginalFilename());
//			Files.write(paths, bytes);
			service.importFile(file);
			//rdab.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (Exception e) {
			//rdab.addFlashAttribute("message", "Failure occured during upload " + file.getOriginalFilename() + "'");
			e.printStackTrace();
		}
		return new ModelAndView("upload", "message", "You successfully uploaded '" + file+ "'");
		
	}
	
	

}
