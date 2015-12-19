package com.pruebaServicios.service;

import java.util.List;

import com.pruebaServicios.model.InvoiceProduct;

public interface InvoiceProductService {
	InvoiceProduct findById(final long idInvoiceProduct);
	List<InvoiceProduct> findByInvoiceId(final long invoiceId);
	void saveInvoiceProduct(InvoiceProduct invoiceProduct);
}
