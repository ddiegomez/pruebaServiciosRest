package com.pruebaServicios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="InvoicesProducts")
public class InvoiceProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVOICE_PRODUCT_ID")
	private long id;
	@ManyToOne
    @JoinColumn(name="PRODUCT_ID")
	private Product product;
	@ManyToOne
    @JoinColumn(name="INVOICE_ID")
	@JsonIgnore
	private Invoice invoice;
	
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "TAX")
	private int tax;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}//InvoiceProduct