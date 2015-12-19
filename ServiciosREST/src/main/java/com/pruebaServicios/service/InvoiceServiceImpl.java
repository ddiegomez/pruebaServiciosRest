package com.pruebaServicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaServicios.dao.InvoiceDao;
import com.pruebaServicios.model.Invoice;

@Service("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
    private InvoiceDao invoiceDao;

	@Override
	public void saveInvoice(Invoice invoice) {
		invoiceDao.saveInvoice(invoice);

	}

	@Override
	public List<Invoice> findInvoicesByCustomer(long idCustomer) {
		return invoiceDao.findInvoicesByCustomer(idCustomer);
	}

}
