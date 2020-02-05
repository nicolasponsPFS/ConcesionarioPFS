package com.pfs.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfs.project.dao.interfaces.VendedorDAOInterface;
import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.interfaces.VendedorServiceInterface;

@Service
@Transactional
public class VendedorService implements VendedorServiceInterface {

	@Autowired
	private VendedorDAOInterface vendedorDAO;
	
	public void addVendedor(Vendedor vendedor) {
		vendedorDAO.addVendedor(vendedor);
	}

	public void updateVendedor(Vendedor vendedor) {
		vendedorDAO.updateVendedor(vendedor);
	}

	public Vendedor getVendedor(int id) {
		return vendedorDAO.getVendedor(id);
	}

	public void deleteVendedor(int id) {
		vendedorDAO.deleteVendedor(id);
	}

	public List<Vendedor> getVendedores() {
		return vendedorDAO.getVendedores();
	}

	public Vendedor getVendedorByUsername(String name) {
		return vendedorDAO.getVendedorByUsername(name);
	}

	public List<Coche> getCochesVendedor(Vendedor vendedor) {
		return vendedorDAO.getCochesVendedor(vendedor);
	}

}
