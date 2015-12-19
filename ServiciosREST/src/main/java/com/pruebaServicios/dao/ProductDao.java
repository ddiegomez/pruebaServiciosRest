package com.pruebaServicios.dao;

import com.pruebaServicios.model.Product;

public interface ProductDao {
    Product findById(final long idProduct);
}
