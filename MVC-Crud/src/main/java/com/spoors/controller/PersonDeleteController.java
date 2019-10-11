package com.spoors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spoors.bean.Person;
import com.spoors.service.PersonService;

@Controller
@SessionAttributes("person")
public class PersonDeleteController {
	@Autowired(required = true)
	PersonService service;
	@RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.GET)
    public String selectForDelete(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.findById(id));
        return "personDelete";
    }
     
    @RequestMapping(value = "/deletePersonFailed", method = RequestMethod.GET)
    public String deletePersonFailed() {
        return "personDelete";
    }
 
    @RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
    public String delete(@ModelAttribute Person person, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
        String message = null;
        String viewName = null;
        try {
            service.delete(person.getId());
            message = "Person deleted. Person id :" + person.getId();
            viewName = "redirect:/mvc/listPersons";
            sessionStatus.setComplete();
        } catch (Exception ex) {
            message = "Person delete failed.";
            viewName = "redirect:/mvc/deletePersonFailed";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return viewName;
    }

}
