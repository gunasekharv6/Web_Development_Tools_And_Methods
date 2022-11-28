package com.demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.exception.ProductNotFoundException;
import com.demo.pojos.Product;
import com.demo.repository.ProductRepo;

@Repository("productRepo")
public class ProductDAO extends DAO implements ProductRepo{

//	@Autowired
//	private SessionFactory sessionFactory;
	
	
	public ProductDAO() {
		System.out.println("*** Product DAO");
		//default constructor
	}
	
	
	@Override
	public Product get(int productId) {
		try {
			return getSession().get(Product.class,Integer.valueOf(productId));
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}
	
	@Override
	public List<Product> list() {
		
		Query<Product> query = getSession().createQuery("FROM Product" , Product.class);
//		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean add(Product product) throws ProductNotFoundException {
		try {
            begin();
            getSession().persist(product);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new ProductNotFoundException("Could not delete the product", e);
        }
	}

	@Override
	public boolean update(Product product) throws ProductNotFoundException{
        try {
            begin();
            getSession().update(product);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new ProductNotFoundException("Could not delete the product", e);
        }
	}

	
	@Override
	public boolean delete(Product product) throws ProductNotFoundException {
		try {
            begin();
            getSession().delete(product);
            commit();
            product.setActive(false);
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new ProductNotFoundException("Could not delete the product", e);
        }
	}
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return getSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return getSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return getSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}	

}
