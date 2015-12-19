package com.pruebaServicios.service;

import com.pruebaServicios.model.Customer;

public interface CustomerService {
	Customer findCustomerById(final long idCustomer);
}
