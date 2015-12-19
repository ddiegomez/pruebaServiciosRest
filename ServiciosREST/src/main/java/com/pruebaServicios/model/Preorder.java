package com.pruebaServicios.model;

import java.io.Serializable;
import java.util.List;

public class Preorder implements Serializable {
	private static final long serialVersionUID = -6884119003689961049L;

	private long idCustomer;
	private List<PreorderProduct> products;

	public Preorder() {

	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<PreorderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<PreorderProduct> products) {
		this.products = products;
	}
}