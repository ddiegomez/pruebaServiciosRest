package com.pruebaServicios.dao;

import java.util.List;

import com.pruebaServicios.model.Invoice;

public interface InvoiceDao {
	void saveInvoice(Invoice invoice);
	List<Invoice> findInvoicesByCustomer(final long idCustomer);
}
