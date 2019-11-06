package com.spoors.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;

@Service
public class FileDownloadService extends AbstractXlsView {
	@Autowired
	PersonDao dao;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"persons.xls\"");
		List<Person> personList = (List<Person>) model.get("personList");
		Sheet sheet = workbook.createSheet("person List");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("id");
		headerRow.createCell(1).setCellValue("name");
		headerRow.createCell(2).setCellValue("gender");
		headerRow.createCell(3).setCellValue("addrs");
		headerRow.createCell(4).setCellValue("imgLoc");
		int row = 1;
		for (Person person : personList) {
			Row dataRow = sheet.createRow(row++);
			dataRow.createCell(0).setCellValue(person.getId());
			dataRow.createCell(1).setCellValue(person.getName());
			dataRow.createCell(2).setCellValue(person.getGender());
			dataRow.createCell(3).setCellValue(person.getAddrs());
			dataRow.createCell(4).setCellValue(person.getImgLoc());
		}
		dao.findAll();
	}

}
