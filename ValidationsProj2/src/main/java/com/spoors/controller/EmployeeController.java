package com.spoors.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoors.bean.Employee;
import com.spoors.validator.EmployeeValidator;
@Controller
public class EmployeeController {
	 @Autowired(required = true)
	 EmployeeValidator validator;
	 
	 @RequestMapping("/hello")  
	    public String display(Model m)  
	    {  
	        m.addAttribute("emp", new Employee());  
	        return "viewpage";  
	    }  
	    @RequestMapping("/helloagain")  
	    public String submitForm( @Valid @ModelAttribute("emp") Employee e, BindingResult br)  
	    {  
	     validator.validate(e, br);
	        if(br.hasErrors())  
	        {  
	            return "viewpage";  
	        }  
	        else  
	        {  
	        return "final";  
	        }  
	    }  
}
