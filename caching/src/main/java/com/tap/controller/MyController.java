package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.entity.Product;
import com.tap.service.MyService;

@RestController
@RequestMapping("/product")
@EnableCaching
public class MyController {
	
	@Autowired
	private MyService service;
	
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return service.save(product);
	}
	
	@GetMapping("/getall")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping("/getproduct/{id}")
//	@Cacheable(key = "#id", value = "Product")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product findProduct(@PathVariable int id) {
		return service.findProduct(id);
	}
	
	@DeleteMapping("/delete/{id}")
	@CacheEvict(key = "#id", value = "Product")
	public String remove(@PathVariable int id) {
		return service.remove(id);
	}

}
