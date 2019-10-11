package com.spoors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spoors.bean.Person;
import com.spoors.service.PersonService;
@Controller
@SessionAttributes("person")
public class PersonCreateController {
@Autowired(required = true)
PersonService service;
 
@RequestMapping(value = "/createPerson", method = RequestMethod.GET)
public String startCreatingNewPerson(Model model) {
    model.addAttribute("person", new Person());
    return "personCreate";      
}
	/*
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * submitForm(@ModelAttribute("persons") Person person, BindingResult result,
	 * SessionStatus status) { //Validation code start boolean error = false;
	 * 
	 * System.out.println(person); //Verifying if information is same as input by
	 * user
	 * 
	 * if(person.getId()<=0){ result.rejectValue("id", "error.id"); error = true; }
	 * 
	 * if(person.getFirstName().isEmpty()){ result.rejectValue("firstName",
	 * "error.firstName"); error = true; }
	 * 
	 * if(person.getLastName().isEmpty()){ result.rejectValue("lastName",
	 * "error.lastName"); error = true; }
	 * 
	 * if(error) { return "personCreate"; } return "redirect:/mvc/listPersons"; }
	 */
 
	/*
	 * @RequestMapping(value = "/createPersonFailed", method = RequestMethod.GET)
	 * public String createPersonFailed() { return "personCreate"; }
	 */

	/*
	 * @RequestMapping(value = "/createPerson", method = RequestMethod.POST) public
	 * String performCreate(@ModelAttribute Person person, RedirectAttributes
	 * redirectAttributes, SessionStatus sessionStatus) { String message = null;
	 * String viewName = null; try { service.create(person); message =
	 * "Person created. Person id :" + person.getId(); viewName =
	 * "redirect:/mvc/listPersons"; sessionStatus.setComplete(); } catch (Exception
	 * ex) { ex.printStackTrace(); message = "Person create failed"; viewName =
	 * "redirect:/mvc/createPersonFailed"; }
	 * redirectAttributes.addFlashAttribute("message", message); return viewName; }
	 * return "redirect:/mvc/listPersons";    
	 */

    
@RequestMapping(value="/createPerson",method = RequestMethod.POST)    
public String save(@ModelAttribute("person") Person person ,BindingResult result){    
    service.create(person);    
    if (result.hasErrors()) {
        return "personCreate";
    }
    
   return "redirect:/mvc/listPersons";    
}    
}
