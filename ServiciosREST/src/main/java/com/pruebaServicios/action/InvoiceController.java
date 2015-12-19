package com.pruebaServicios.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaServicios.Application;
import com.pruebaServicios.model.Customer;
import com.pruebaServicios.model.Invoice;
import com.pruebaServicios.model.InvoiceProduct;
import com.pruebaServicios.model.Product;
import com.pruebaServicios.model.Preorder;
import com.pruebaServicios.model.PreorderProduct;
import com.pruebaServicios.service.CustomerService;
import com.pruebaServicios.service.InvoiceProductService;
import com.pruebaServicios.service.InvoiceService;
import com.pruebaServicios.service.ProductService;

@RestController
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	InvoiceProductService invoiceProductService;
	@Autowired
	ProductService productService;
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public List<Invoice> getInvoices(@RequestParam(value = "customerId") String customerId) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		if (customerId != null && !customerId.isEmpty()) {
			long id = 0;
			try {
				id = Long.parseLong(customerId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			if (id > 0) {
				invoices = invoiceService.findInvoicesByCustomer(id);
			}
		}
		return invoices;
	}// getInvoices

	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public Invoice createInvoice(@RequestBody Preorder preorder) {
		Invoice invoice = new Invoice();
		if (preorder.getIdCustomer() > 0) {
			if (preorder.getProducts() != null && !preorder.getProducts().isEmpty()) {
				
				
				Customer customer = customerService.findCustomerById(preorder.getIdCustomer());
				invoice = new Invoice();
				invoice.setCustomer(customer);

				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(new Date());

				invoice.setDate(gc.getTime());
				invoice.setYear(gc.get(Calendar.YEAR));
				invoice.setPaid(false);
				
				invoiceService.saveInvoice(invoice);
				
				Set<InvoiceProduct> invoiceProducts = new HashSet<InvoiceProduct>();
				for (PreorderProduct prod : preorder.getProducts()) {
					Product p = productService.findById(prod.getIdProduct());
					if (p != null) {
						InvoiceProduct ip = new InvoiceProduct();
						ip.setProduct(p);
						ip.setQuantity(prod.getQuantity());
						ip.setPrice(p.getPrice());
						ip.setTax(Application.IVA);
						ip.setInvoice(invoice);
						invoiceProductService.saveInvoiceProduct(ip);
						invoiceProducts.add(ip);
					}
				} // for
				invoice.setProducts(invoiceProducts);

			}
		}
		return invoice;
	}// createInvoice
}// InvoiceController