package com.spoors.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spoors.service.HardCodeFileUploadService;

@Controller
public class ZipToUnzipController {
	@Autowired
	HardCodeFileUploadService service;

	@RequestMapping(value = "/toZipToUnZip", method = RequestMethod.POST)
	public ModelAndView extractZip(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();

		// System.out.println(path+" "+filename);

		byte barr[] = file.getBytes();

		String INPUT_ZIP_FILE = (path + "/" + filename);
		String OUTPUT_FOLDER = "/home/spoors/Documents/UnZipProgram";

		byte[] buffer = new byte[1024];

		try {
			// create output directory is not exists
			File folder = new File(OUTPUT_FOLDER);
			if (!folder.exists()) {
				folder.mkdir();
			}

			// get the zip file content
			ZipInputStream zis = new ZipInputStream(new FileInputStream(INPUT_ZIP_FILE));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();// Returns the next entry from
			// this ZipInputStream or null if no more entries are present.

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);

				// System.out.println("file unzip : "+ newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();

				zis.closeEntry();
				zis.close();
				service.importFile(OUTPUT_FOLDER);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("personReport", "filename", path + "/" + filename);
	}
}