package com.pruebaServicios.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pruebaServicios.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

	@Override
	public Customer findCustomerById(final long idCustomer) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", idCustomer));
        return (Customer) criteria.uniqueResult();
	}

}
