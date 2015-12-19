package com.pruebaServicios.dao;

import java.util.List;

import com.pruebaServicios.model.InvoiceProduct;

public interface InvoiceProductDao {
	InvoiceProduct findById(final long invoiceProductId);
	List<InvoiceProduct> findByInvoiceId(final long invoiceId);
	void saveInvoiceProduct(InvoiceProduct invoiceProduct);
}
