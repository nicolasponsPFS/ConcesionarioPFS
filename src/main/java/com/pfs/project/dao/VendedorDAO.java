package com.pfs.project.dao;

import java.util.List;

import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;

public interface VendedorDAO {

	static final String TABLE_NAME = "Vendedor";

	public void addVendedor(Vendedor vendedor);
	public void updateVendedor(Vendedor vendedor);
	public Vendedor getVendedor(int id);
	public Vendedor getVendedorByUsername(String name);
	public void deleteVendedor(int id);
	public List<Vendedor> getVendedores();
	public List<Coche> getCochesVendedor(Vendedor vendedor);
}
