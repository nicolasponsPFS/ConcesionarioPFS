package com.pfs.project.service.interfaces;

import java.util.List;

import com.pfs.project.model.Vendedor;

public interface VendedorServiceInterface {

	public void addVendedor(Vendedor vendedor);
	public void updateVendedor(Vendedor vendedor);
	public Vendedor getVendedor(int id);
	public void deleteVendedor(int id);
	public List<Vendedor> getVendedores();
	
}
