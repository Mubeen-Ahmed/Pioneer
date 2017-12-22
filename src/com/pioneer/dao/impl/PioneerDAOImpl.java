package com.pioneer.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.pioneer.dao.PioneerDAO;
import com.pioneer.model.Pioneer;


@Repository("PioneerDAO")
public class PioneerDAOImpl implements PioneerDAO {
	
	@Autowired 
	private SessionFactory session;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public boolean savePioneer(Pioneer pioneer) {
		int id = (Integer)hibernateTemplate.save(pioneer);
		if(id>0)
			return true;
		return false;
	}
/*	@Override
	public boolean saveExperience(Experience experience) {
		int id = (Integer)hibernateTemplate.save(experience);
		if(id>0)
			return true;
		return false;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public Pioneer getPioneerDetailsByEmailAndPassword(String email, String password) {
		
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Pioneer.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		
		detachedCriteria.add(Restrictions.eq("password", password));
		
		List<Pioneer> findByCriteria = (List<Pioneer>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
	/*
	@Override
	public void add(EtchingIT etchingit) {
		session.getCurrentSession().save(etchingit);
		
	}
	
	@Override
	public void edit(EtchingIT etchingit) {
		session.getCurrentSession().update(etchingit);
		
	}
	@Override
	public void delete(int etchingitid) {
		session.getCurrentSession().delete(getetchingit(etchingitid));
		
	}
	@Override
	public EtchingIT getetchingit(int etchingitid) {
		return (EtchingIT)session.getCurrentSession().get(EtchingIT.class, etchingitid);
	}
	@Override
	public List getAll() {
		return session.getCurrentSession().createQuery("from etching").list();
	}
	
	protected Session currentSession() {
		return session.getCurrentSession();
	}*/
	@Override
	public void addPioneer(Pioneer pioneer) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(pioneer);
	}
	@Override
	public List<Pioneer> getAll() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from pioneer")
              .list();
		
	}
	@Override
	public void deletePioneer(int pioneerid) {
		Pioneer pioneer = (Pioneer) session.getCurrentSession().load(
				Pioneer.class, pioneerid);
        if (null != pioneer) {
            this.session.getCurrentSession().delete(pioneer);
        }
		
	}
	@Override
	public Pioneer updatePioneer(Pioneer pioneer) {
		session.getCurrentSession().update(pioneer);
        return pioneer;
	}
	@Override
	public Pioneer getPioneer(int pioneerid) {
		// TODO Auto-generated method stub
		return (Pioneer) session.getCurrentSession().get(
				Pioneer.class, pioneerid);
	}
	
			
	
}

