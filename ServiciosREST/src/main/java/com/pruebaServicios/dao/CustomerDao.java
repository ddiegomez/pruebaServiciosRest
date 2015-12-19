package com.pruebaServicios.dao;

import com.pruebaServicios.model.Customer;

public interface CustomerDao {
	Customer findCustomerById(final long idCustomer);
}
