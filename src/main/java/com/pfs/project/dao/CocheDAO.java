package com.pfs.project.dao;

import java.util.List;

import com.pfs.project.model.Coche;

public interface CocheDAO {
	
	static final String TABLE_NAME = "Coche";

	public void addCoche(Coche coche);
	public void updateCoche(Coche coche);
	public Coche getCoche(int id);
	public void deleteCoche(int id);
	public List<Coche> getCoches();
}
