package com.G01.onlineFishAuction.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.G01.onlineFishAuction.entities.Customer;

@Repository
public class HibernateCodeRepository implements ICodeRepository{
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCodeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public String generateAndRecord() {
		Session session  = entityManager.unwrap(Session.class);
		
		return null;
	}

	@Override
	public void delete(String code) {
		Session session  = entityManager.unwrap(Session.class);
		
	}

}
