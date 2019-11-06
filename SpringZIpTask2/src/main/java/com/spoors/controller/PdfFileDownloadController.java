package com.spoors.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;
import com.spoors.service.PdfFileDownloadService;

@Controller
public class PdfFileDownloadController {
	@Autowired
	PdfFileDownloadService service;
	@Autowired
	PersonDao dao;
	@RequestMapping(value="/downloadPdf",method=RequestMethod.GET)
	public ModelAndView downloadPdf(HttpServletRequest req,HttpServletResponse res) {
		String reportType = req.getParameter("type");
		List<Person> personList = dao.findAll();
		if(reportType!=null&&reportType.equals("pdf")) {
			return new ModelAndView(service, "personList", personList);
		}
		return new ModelAndView("personReport", "personList", personList);
		
	}

}
