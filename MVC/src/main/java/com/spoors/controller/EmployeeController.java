package com.spoors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spoors.bean.Employee;
import com.spoors.dao.EmployeeDao;

@Controller
public class EmployeeController {
	 @Autowired    
	    EmployeeDao dao;//will inject dao from XML file    
	        
	    /*It displays a form to input data, here "command" is a reserved request attribute  
	     *which is used to display object data into form  
	     */    
	    @RequestMapping("/empform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Employee());  
	        return "empform";   
	    }    
	  
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("emp") Employee emp){    
	        dao.save(emp);    
	        return "redirect:/viewemp";//will redirect to viewemp request mapping    
	    }    
	     
	    @RequestMapping("/viewemp")    
	    public String viewemp(Model m){    
	        List<Employee> list=dao.getEmployees();    
	        m.addAttribute("list",list);  
	        return "viewemp";    
	    }    
	    
	    @RequestMapping(value="/editemp/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Employee emp=dao.getEmpById(id);    
	        m.addAttribute("command",emp);  
	        return "empeditform";    
	    }    
	  
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("emp") Employee emp){    
	        dao.update(emp);    
	        return "redirect:/viewemp";    
	    }    
	       
	    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewemp";    
	    }     
}
