package com.spoors.controller;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spoors.service.FileUploadService;

 

@Controller
public class FileUploadController {
	@Autowired
	 FileUploadService service ;
	
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
			/*
			 * Workbook workbook=null; if (workbook instanceof XSSFWorkbook) {
			 * workbook.write(new FileOutputStream("pathToExcelFile.xlsx")); } else if
			 * (workbook instanceof HSSFWorkbook) { workbook.write(new
			 * FileOutputStream("pathToExcelFile.xls")); } workbook.close();
			 */
		} catch (Exception e) {
			//rdab.addFlashAttribute("message", "Failure occured during upload " + file.getOriginalFilename() + "'");
			e.printStackTrace();
		}
		return new ModelAndView("xl_file_success", "message", "You successfully uploaded '" + file+ "'");
		
	}
	
	

}
