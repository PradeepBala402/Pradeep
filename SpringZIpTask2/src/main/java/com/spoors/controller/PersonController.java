package com.spoors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload");
	}
}
