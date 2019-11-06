package com.spoors.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;

@Service
public class PdfFileDownloadService extends AbstractPdfView {
	@Autowired
	PersonDao dao;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"personsList.pdf\"");
		@SuppressWarnings("unchecked")
		List<Person> personList=(List<Person>) model.get("personList");
		Table table=new Table(5);
		table.addCell("id");
		table.addCell("name");
		table.addCell("gender");
		table.addCell("addrs");
		table.addCell("imgLoc");
		for(Person person:personList) {
			table.addCell(String.valueOf(person.getId()));
			table.addCell(person.getName());
			table.addCell(person.getGender());
			table.addCell(person.getAddrs());
			table.addCell(person.getImgLoc());
		}
		document.add(table);
		dao.findAll();
	}

}
