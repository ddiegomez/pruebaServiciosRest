package com.pruebaServicios.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pruebaServicios.model.Invoice;

@Repository("invoiceDao")
public class InvoiceDaoImpl  extends AbstractDao implements InvoiceDao {

	@Override
	public void saveInvoice(Invoice invoice) {
		this.persist(invoice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> findInvoicesByCustomer(final long idCustomer) {
        Criteria criteria = getSession().createCriteria(Invoice.class);
        criteria.add(Restrictions.eq("customer.id", idCustomer));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.asc("date"));
        return (List<Invoice>) criteria.list();
	}

}//InvoiceDaoImpl