package com.pfs.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfs.project.dao.CocheDAO;
import com.pfs.project.model.Coche;

@Service
@Transactional
public class CocheServiceImpl implements CocheService{

	@Autowired
	private CocheDAO cocheDAO;
	
	public void addCoche(Coche coche) {
		cocheDAO.addCoche(coche);
	}

	public void updateCoche(Coche coche) {
		cocheDAO.updateCoche(coche);
	}

	public Coche getCoche(int id) {
		return cocheDAO.getCoche(id);
	}

	public void deleteCoche(int id) {
		cocheDAO.deleteCoche(id);
	}

	public List<Coche> getCoches() {
		return cocheDAO.getCoches();
	}

}
