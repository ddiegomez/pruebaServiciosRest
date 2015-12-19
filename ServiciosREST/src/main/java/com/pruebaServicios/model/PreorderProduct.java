package com.pruebaServicios.model;

import java.io.Serializable;

public class PreorderProduct implements Serializable {
	private static final long serialVersionUID = 1734951966018091460L;

	private long idProduct;
	private int quantity;

	public PreorderProduct() {

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
}