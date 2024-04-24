package com.insert.Universityy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insert.Universityy.Entity.Product;
import com.insert.Universityy.Repository.ProductRepository;

@SpringBootApplication
public class UniversityyApplication  implements CommandLineRunner{
	@Autowired
	private ProductRepository productRespository;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversityyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product prod= new Product();
		prod.setName("computer");
		prod.setPrice(4300);
		prod.setQuantity(3);
		productRespository.save(prod);
		
		Product prod2= new Product();
		prod2.setName("Printer");
		prod2.setPrice(1200);
		prod2.setQuantity(4);
		productRespository.save(prod2);
		
		Product prod3= new Product();
		prod3.setName("Smaet Phone");
		prod3.setPrice(3200);
		prod3.setQuantity(32);
		productRespository.save(prod3);
		
		List <Product> products=productRespository.findAll();
		
		products.forEach(p->{
			System.out.println(p.toString());
		});
		
		Product product=productRespository.findById(Long.valueOf(1)).get();
		System.out.println("**********1*******");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());

		System.out.println(product.getQuantity());
		System.out.println("*****************");

		List <Product> products2=productRespository.findByNameContains("C");
		products2.forEach(p->{
			System.out.println(p);
		});
		System.out.println("***---------2-----------****");

		List <Product> productsList=productRespository.search("%C%");
		productsList.forEach(p->{
			System.out.println(p);
		});
		
		System.out.println("***-----------3---------****");
		List <Product> productsprice=productRespository.findByPriceGreaterThan(3000);
		productsprice.forEach(p->{
			System.out.println(p);
		});
		
		System.out.println("***--------4------------****");
		List <Product> productsprice2=productRespository.searchByPrice(3000);
		productsprice2.forEach(p->{
			System.out.println(p);
		});
		
		
	}
	
	
	


}
