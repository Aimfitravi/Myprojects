package com.shopx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopx.entities.CategoryType;
import com.shopx.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(CategoryType category);
	List<Product> findByProductName(String name);
}
