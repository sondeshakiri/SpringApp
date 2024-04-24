package com.insert.Universityy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insert.Universityy.Entity.Product;
import com.insert.Universityy.Repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/products")
	public List<Product> products(){
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findProducts(@PathVariable Long id){
		return productRepository.findById(id).get();
	}
	
	
}
