package com.javawebtutor.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.javawebtutor.model.HibernateUtil;
import com.javawebtutor.model.KlientPubliczny;
import com.javawebtutor.model.KlientSamodzielny;
import com.javawebtutor.model.Pracownik;
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
	
	public void addPracownik(Pracownik pracownik) {
		pracownik.setid_pracownik(null);
		sessionFactory.getCurrentSession().persist(pracownik);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pracownik> getAllPracownik() {
		return sessionFactory.getCurrentSession().getNamedQuery("pracownik.all").list();
	}
	
	public void addKlientPubliczny(KlientPubliczny klientPubliczny) {
		klientPubliczny.setid_klientPubliczny(null);
		sessionFactory.getCurrentSession().persist(klientPubliczny);
	}
	
	@SuppressWarnings("unchecked")
	public List<KlientPubliczny> getAllKlientPuliczny() {
		return sessionFactory.getCurrentSession().getNamedQuery("klientPubliczny.all").list();
	}
	
	public void addKlientSamodzielny(KlientSamodzielny klientSamodzielny) {
		klientSamodzielny.setid_klientSamodzielny(null);
		sessionFactory.getCurrentSession().persist(klientSamodzielny);
	}
	
	@SuppressWarnings("unchecked")
	public List<KlientSamodzielny> getAllKlientSamodzielny() {
		return sessionFactory.getCurrentSession().getNamedQuery("klientSamodzielny.all").list();
	}
	
		
}