package org.websamples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.websamples.dao.CustomerDAO;
import org.websamples.domain.Customer;


@Controller
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO; 
	
	@RequestMapping("/")
	public ModelAndView getPersons(){
		ModelAndView mv = new ModelAndView();
		List<Customer> persons = this.customerDAO.getCustomers(); 
		mv.addObject("persons",persons);
		mv.setViewName("list");
		return mv;
	}
}
