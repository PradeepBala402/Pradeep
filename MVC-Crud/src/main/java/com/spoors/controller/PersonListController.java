package com.spoors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spoors.service.PersonService;
@Controller   
public class PersonListController {
	@Autowired(required = true)
	PersonService service;
	@RequestMapping(value="/listPersons",method=RequestMethod.GET)
	public String findAllPersons(Model model) {
		model.addAttribute("persons",service.findAll());
		return "personList";
	}
}
