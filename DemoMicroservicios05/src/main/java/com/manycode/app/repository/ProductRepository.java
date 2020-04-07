package com.manycode.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manycode.app.entity.Category;
import com.manycode.app.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByCategory(Category category);
}