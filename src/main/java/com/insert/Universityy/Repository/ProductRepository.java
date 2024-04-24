package com.insert.Universityy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insert.Universityy.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	List<Product> findByNameContains(String mc);
	
	@Query("select p from Product p where p.name like :x")
	List<Product> search(@Param("x")String mc);
	
	List<Product> findByPriceGreaterThan(double price);

	@Query("select p from Product p where p.price >=:x")
	List<Product> searchByPrice(@Param("x")double price);
	

}
