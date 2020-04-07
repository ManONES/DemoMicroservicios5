package com.manycode.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manycode.app.entity.Category;
import com.manycode.app.entity.Product;
import com.manycode.app.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product productDB = getProduct(product.getId());
		if (null == productDB) {
			return null;
		}
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Product productDB = getProduct(id);
		if (null == productDB) {
			return null;
		}		
		productDB.setStatus("DELETE");
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		// TODO Auto-generated method stub
		Product productDB = getProduct(id);
		if (null == productDB) {
			return null;
		}		
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productRepository.save(productDB);
	}

	
	
}