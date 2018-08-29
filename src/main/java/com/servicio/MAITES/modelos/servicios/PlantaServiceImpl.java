package com.servicio.MAITES.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicio.MAITES.modelos.dao.IPlantaDao;
import com.servicio.MAITES.modelos.entidades.planta;

@Service
public class PlantaServiceImpl implements IPlantaService{

	@Autowired
	private IPlantaDao plantadao;
	
	@Override
	@Transactional(readOnly = true)
	public List<planta> findAll() {
		return plantadao.findAll();
	}

	@Override
	public planta findOne(Long id) {
		return plantadao.findOne(id);
	}

}
