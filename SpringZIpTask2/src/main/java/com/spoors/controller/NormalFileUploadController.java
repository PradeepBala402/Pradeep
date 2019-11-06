package com.spoors.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spoors.bean.FileUploadBean;

@Controller
public class NormalFileUploadController {
	/*
	 * @RequestMapping(value = "/welcomeFile", method = RequestMethod.POST) public
	 * ModelAndView indexFile() { return new ModelAndView("file_upload"); }
	 */

	@RequestMapping(value = "/zipFile", method = RequestMethod.POST)
	public String uploadFile(Model model, @ModelAttribute("uploadForm") FileUploadBean upload) {
		File dir=new File("/home/spoors/Documents/UnZipProgram/");
		MultipartFile file=upload.getFile();
		String fileName="";
		if(file!=null) {
		fileName=file.getOriginalFilename();
		System.out.println("original file name"+fileName);
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try {
		inputStream=file.getInputStream();
		if(!dir.exists()) {
		dir.mkdir();
		}
		File newFile=new File("/home/spoors/Documents/UnZipProgram/"+fileName);
		outputStream=new FileOutputStream(newFile);
		int read=0;
		byte[] buffer=new byte[1024];
		while((read=inputStream.read(buffer))!=-1) {
		outputStream.write(buffer,0,read);
		}
		outputStream.close();
		inputStream.close();

		}
		catch(IOException ioe) {
		ioe.printStackTrace();
		}
		}
		model.addAttribute("files", fileName);
		return "file_success";

	}
}
