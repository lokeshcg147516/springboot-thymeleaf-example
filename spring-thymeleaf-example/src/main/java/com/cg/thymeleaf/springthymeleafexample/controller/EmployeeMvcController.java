package com.cg.thymeleaf.springthymeleafexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.thymeleaf.springthymeleafexample.dto.EmployeeDTO;
import com.cg.thymeleaf.springthymeleafexample.sevice.EmployeeService;

@Controller
@RequestMapping
public class EmployeeMvcController {

	@Autowired
	EmployeeService service;
	  @RequestMapping
	    public String getAllEmployees(Model model) 
	    {
	        List<EmployeeDTO> list = service.getAllEmployees();
	 
	        model.addAttribute("employees", list);
	        return "list-employees";
	    }
	 
	    @RequestMapping(path = {"/edit", "/edit/{id}"})
	    public String editEmployeeById(Model model, @PathVariable(name="id", required=false) Integer id) 
	                            throws RuntimeException 
	    {
	        if(id!=null) {
	            EmployeeDTO entity = service.getEmployee(id);
	            model.addAttribute("employee", entity);
	        } else {
	            model.addAttribute("employee", new EmployeeDTO());
	        }
	        return "add-edit-employee";
	    }
	     
	    @RequestMapping(path = "/delete/{id}")
	    public String deleteEmployeeById(Model model, @PathVariable("id") int id) 
	                            throws RuntimeException 
	    {
	        service.deleteEmployeeById(id);;
	        return "redirect:/";
	    }
	 
	    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	    public String createOrUpdateEmployee(EmployeeDTO employee) 
	    {
	        service.createOrUpdateEmployee(employee);
	        return "redirect:/";
	    }

}
