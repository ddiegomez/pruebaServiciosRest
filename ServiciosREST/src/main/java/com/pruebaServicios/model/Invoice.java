package com.pruebaServicios.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Invoices")
public class Invoice {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVOICE_ID")
	private long id;
	@Column(name = "YEAR")
	private int year;
	@Column(name = "DATE")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
	@JsonIgnore
	private Customer customer;
	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
	private Set<InvoiceProduct> products = new HashSet<InvoiceProduct>(0);
	@Column(name = "PAID")
	private boolean paid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public Set<InvoiceProduct> getProducts() {
		return products;
	}
	public void setProducts(Set<InvoiceProduct> products) {
		this.products = products;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id) + String.valueOf(this.year);
	}
}