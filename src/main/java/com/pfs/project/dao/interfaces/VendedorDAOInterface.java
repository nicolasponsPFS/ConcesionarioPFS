package com.pfs.project.dao.interfaces;

import java.util.List;

import com.pfs.project.model.Vendedor;

public interface VendedorDAOInterface {

	static final String TABLE_NAME = "Vendedor";

	public void addVendedor(Vendedor vendedor);
	public void updateVendedor(Vendedor vendedor);
	public Vendedor getVendedor(int id);
	public void deleteVendedor(int id);
	public List<Vendedor> getVendedores();
}
