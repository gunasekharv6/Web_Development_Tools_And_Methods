package com.demo.repository;

import java.util.List;
import com.demo.exception.ProductNotFoundException;
import com.demo.pojos.Product;


public interface ProductRepo {

	Product get(int productId);
	List<Product> list();	
	boolean add(Product product) throws ProductNotFoundException;
	boolean update(Product product) throws ProductNotFoundException;
	boolean delete(Product product) throws ProductNotFoundException;
	
	
	// business methods
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
