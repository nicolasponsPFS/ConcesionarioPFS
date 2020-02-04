package com.pfs.project.service.interfaces;

import java.util.List;

import com.pfs.project.model.Coche;

public interface CocheServiceInterface {

	public void addCoche(Coche coche);
	public void updateCoche(Coche coche);
	public Coche getCoche(int id);
	public void deleteCoche(int id);
	public List<Coche> getCoches();
}
