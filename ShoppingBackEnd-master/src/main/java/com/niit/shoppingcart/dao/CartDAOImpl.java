package com.niit.shoppingcart.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")

public class CartDAOImpl implements CartDAO {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(CartDAOImpl.class);
	
	

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		
		System.out.println("hiii");
		
		logger.debug("calling list");
		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	@Transactional
	public String delete(int id) {

		
		Cart cart = new Cart();
		cart.setId(id);
		
		sessionFactory.getCurrentSession().delete(cart);
		 return null;

	}

	@Transactional
	public Cart get(int id) {
		logger.debug("calling get");
		
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public int getTotalAmount(String id) {
		String hql = "select sum(price) from Cart where userID = " + "'" + id + "'";
		/*Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();*/
		//return query.getFirstResult();   // Need to check
		
		return 0;

	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	/*@Transactional
	public int getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	

}
