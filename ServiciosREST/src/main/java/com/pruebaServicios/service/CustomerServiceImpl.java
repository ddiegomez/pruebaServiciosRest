package com.pruebaServicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaServicios.dao.CustomerDao;
import com.pruebaServicios.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerDao dao;

	@Override
	public Customer findCustomerById(long idCustomer) {
		return dao.findCustomerById(idCustomer);
	}


}
