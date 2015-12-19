package com.pruebaServicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaServicios.dao.ProductDao;
import com.pruebaServicios.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductDao dao;
	
	@Override
	public Product findById(long idProduct) {
		return dao.findById(idProduct);
	}

}
