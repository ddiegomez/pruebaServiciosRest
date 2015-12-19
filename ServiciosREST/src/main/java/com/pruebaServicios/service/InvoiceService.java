package com.pruebaServicios.service;

import java.util.List;

import com.pruebaServicios.model.Invoice;

public interface InvoiceService {
	void saveInvoice(Invoice invoice);
	List<Invoice> findInvoicesByCustomer(final long idCustomer);
}
