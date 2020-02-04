package com.pfs.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfs.project.dao.interfaces.VendedorDAOInterface;
import com.pfs.project.model.Vendedor;

@Repository
public class VendedorDAO implements VendedorDAOInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addVendedor(Vendedor vendedor) {
		getCurrentSession().save(vendedor);
	}

	public void updateVendedor(Vendedor vendedor) {
		Vendedor v = getVendedor(vendedor.getId());
		v = vendedor;
		getCurrentSession().update(v);
	}

	public Vendedor getVendedor(int id) {
		return (Vendedor) getCurrentSession().get(Vendedor.class, id);
	}

	public void deleteVendedor(int id) {
		Vendedor v = getVendedor(id);
		getCurrentSession().delete(v);
	}

	public List<Vendedor> getVendedores() {
		return getCurrentSession().createQuery("from "+TABLE_NAME).list();
	}

}
