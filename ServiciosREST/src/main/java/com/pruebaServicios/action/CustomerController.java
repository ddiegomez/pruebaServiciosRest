package com.pruebaServicios.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaServicios.model.Customer;
import com.pruebaServicios.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
    CustomerService service;
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public Customer getCustomer(@RequestParam(value="customerId") String customerId) {
		Customer customer = null;
		if (customerId != null && !customerId.isEmpty()) {
			long id = 0;
			try {
				id = Long.parseLong(customerId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			if (id > 0) {
				 customer = service.findCustomerById(id);
			}
		}
		
		return customer;
	}
	
}//CustomerController
