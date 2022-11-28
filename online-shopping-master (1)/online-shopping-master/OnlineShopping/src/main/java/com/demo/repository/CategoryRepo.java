package com.demo.repository;

import java.util.List;

import com.demo.exception.CategoryNotFoundException;
import com.demo.pojos.Category;

public interface CategoryRepo {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category) throws CategoryNotFoundException;
	boolean update(Category category) throws CategoryNotFoundException;
	boolean delete(Category category) throws CategoryNotFoundException;
	
}