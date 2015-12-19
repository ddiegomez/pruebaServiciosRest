package com.pruebaServicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaServicios.dao.InvoiceProductDao;
import com.pruebaServicios.model.InvoiceProduct;

@Service("invoiceProductService")
@Transactional
public class InvoiceProductServiceImpl implements InvoiceProductService {

	@Autowired
    private InvoiceProductDao dao;
	
	@Override
	public InvoiceProduct findById(long idInvoiceProduct) {
		return dao.findById(idInvoiceProduct);
	}

	@Override
	public List<InvoiceProduct> findByInvoiceId(long invoiceId) {
		return dao.findByInvoiceId(invoiceId);
	}

	@Override
	public void saveInvoiceProduct(InvoiceProduct invoiceProduct) {
		dao.saveInvoiceProduct(invoiceProduct);
	}

}
