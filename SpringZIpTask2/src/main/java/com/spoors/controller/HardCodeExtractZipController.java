package com.spoors.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spoors.service.FileUploadService;
import com.spoors.service.HardCodeFileUploadService;

@Controller
public class HardCodeExtractZipController {
	@Autowired
	HardCodeFileUploadService service;

	@RequestMapping(value = "/unzip", method = RequestMethod.GET)
	public String SavePerson() {
		/*
		 * if (file.isEmpty()) { rdab.addFlashAttribute("message",
		 * "please select file"); return new ModelAndView("upload", "message",
		 * "please select file"); }
		 */

	//	ExtractZipController unZip = new ExtractZipController();
		String INPUT_ZIP_FILE = "/home/spoors/Documents/ExcelZip.zip";
		String OUTPUT_FOLDER = "/home/spoors/Documents/UnZipProgram";

		byte[] buffer = new byte[1024];

		try {

			File folder = new File(OUTPUT_FOLDER);
			if (!folder.exists()) {
				folder.mkdir();
			}

			ZipInputStream zis = new ZipInputStream(new FileInputStream(INPUT_ZIP_FILE));

			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);

				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}	//System.out.println("Done");

			zis.closeEntry();
			zis.close();

			service.importFile(OUTPUT_FOLDER);

		} catch (IOException ex) {
			ex.printStackTrace();

			service.importFile(OUTPUT_FOLDER);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return "personReport";
	}

}