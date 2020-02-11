package com.pfs.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfs.project.model.Coche;

@Repository
public class CocheDAOImpl implements CocheDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCoche(Coche coche) {
		getCurrentSession().save(coche);
	}

	public void updateCoche(Coche coche) {
		Coche c = getCoche(coche.getId());
		c = coche;
		getCurrentSession().save(c);
	}

	public Coche getCoche(int id) {
		return (Coche) getCurrentSession().get(Coche.class, id);
	}

	public void deleteCoche(int id) {
		Coche c = getCoche(id);
		getCurrentSession().delete(c);
	}

	public List<Coche> getCoches() {
		return getCurrentSession().createQuery("from " + TABLE_NAME).list();
	}

}
