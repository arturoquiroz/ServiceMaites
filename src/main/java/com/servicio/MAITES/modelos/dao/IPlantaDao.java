package com.servicio.MAITES.modelos.dao;

import java.util.List;

import com.servicio.MAITES.modelos.entidades.planta;

public interface IPlantaDao {
	
	public List<planta> findAll();

	public planta findOne(Long id);

}
