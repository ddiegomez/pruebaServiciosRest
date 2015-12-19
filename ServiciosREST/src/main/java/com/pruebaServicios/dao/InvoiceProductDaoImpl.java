package com.pruebaServicios.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pruebaServicios.model.InvoiceProduct;

@Repository("invoiceProductDao")
public class InvoiceProductDaoImpl extends AbstractDao implements InvoiceProductDao {

	@Override
	public InvoiceProduct findById(final long idInvoiceProduct) {
        Criteria criteria = getSession().createCriteria(InvoiceProduct.class);
        criteria.add(Restrictions.eq("id", idInvoiceProduct));
        return (InvoiceProduct) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceProduct> findByInvoiceId(final long invoiceId) {
        Criteria criteria = getSession().createCriteria(InvoiceProduct.class);
        criteria.add(Restrictions.eq("invoice", invoiceId));
        return (List<InvoiceProduct>) criteria.list();
	}

	@Override
	public void saveInvoiceProduct(InvoiceProduct invoiceProduct) {
		this.persist(invoiceProduct);
	}

}
