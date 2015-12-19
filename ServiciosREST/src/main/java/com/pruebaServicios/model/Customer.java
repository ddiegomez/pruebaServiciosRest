package com.pruebaServicios.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LASTNAsME")
	private String lastName;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "EMAIL")
	private String mail;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<Invoice> invoices = new HashSet<Invoice>(0);

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		String desc = "";

		if (this.id > 0) {
			if (this.lastName != null && !this.lastName.isEmpty()) {
				desc = this.lastName;
			}

			if (this.name != null && !this.name.isEmpty()) {
				if (!desc.isEmpty()) {
					desc += ", ";
				}
				desc += this.name;
			}

			if (desc.isEmpty()) {
				desc = String.valueOf(this.id);
			} else {
				desc = String.valueOf(this.id) + " - " + desc;
			}
		}

		return desc;
	}// toString
}// Customer