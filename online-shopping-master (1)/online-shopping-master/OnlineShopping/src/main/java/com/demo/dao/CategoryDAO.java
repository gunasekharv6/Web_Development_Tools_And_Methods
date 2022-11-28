package com.demo.dao;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.exception.CategoryNotFoundException;
import com.demo.pojos.Category;
import com.demo.repository.CategoryRepo;

@Repository("categoryRepo")

@Component
public class CategoryDAO extends DAO implements CategoryRepo {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
//	public static void main(String[] args) {
//		System.out.println("HELLO");
//		Category cat = new Category();
//		cat.setId(0);
//		cat.setName("mobile");
//		cat.setDescription("mobile descp");
//		CategoryDAO dao = new CategoryDAO();
//		try {
//			dao.add(cat);
//			System.out.println("GET SESSION******************"+dao.getSession());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	

	public CategoryDAO() {
		System.out.println("*** Category DAO");
		//default constructor
	}
	
	
	@Override
	public List<Category> list() {

//		String selectActiveCategory = "FROM Category WHERE active = :active";
		String selectActiveCategory = "FROM Category";
		
//		Query query = DAO.getCurrentSession().createQuery(selectActiveCategory);
		Query<Category> query = getSession().createQuery(selectActiveCategory);	
//		query.setParameter("active", true);
		List<Category> list = query.list();				
		return list;
	}

	@Override
	public Category get(int id) {

		return getSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) throws CategoryNotFoundException {

        try {
            begin();
            getSession().save(category);
            commit();
            return true;
        } catch (Exception e) {
            rollback();
//            e.printStackTrace();
            throw new CategoryNotFoundException("Could not add the category", e);
        }
	}
	
	@Override
	public boolean update(Category category) throws CategoryNotFoundException {		
        try {
            begin();
            getSession().update(category);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryNotFoundException("Could not update the category", e);
        }
	}

	@Override
	public boolean delete(Category category) throws CategoryNotFoundException {
		try {
            begin();
            getSession().delete(category);
            commit();
            category.setActive(false);
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryNotFoundException("Could not delete the category", e);
        }
	}

}
