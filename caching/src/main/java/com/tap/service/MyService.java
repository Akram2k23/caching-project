package com.tap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.entity.Product;
import com.tap.repository.ProductDao;

@Component
public class MyService {
	
	@Autowired
	private ProductDao dao;
	
	
	
	public Product save(Product product) {
		return dao.save(product);
	}
	
	public List<Product> getAllProduct(){
		return dao.findAll();
	}
	
	public Product findProduct(int id) {
		return dao.findProductById(id);
	}
	
	public String remove(int id) {
		return dao.deleteProduct(id);
	}

}
