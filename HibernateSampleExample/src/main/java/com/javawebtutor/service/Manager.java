package com.javawebtutor.service;

import org.hibernate.SessionFactory;

import com.javawebtutor.model.HibernateUtil;
import com.javawebtutor.model.Tytul;

public class Manager {
	SessionFactory sessionFactory;
	
	public Manager() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void addTytul(Tytul tytul) {
		tytul.setid_tytul(null);
		sessionFactory.getCurrentSession().persist(tytul);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tytul> getAllTytul() {
		return sessionFactory.getCurrentSession().getNamedQuery("tytul.all").list();
	}
}