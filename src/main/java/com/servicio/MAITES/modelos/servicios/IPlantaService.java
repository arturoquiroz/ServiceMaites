package com.servicio.MAITES.modelos.servicios;

import java.util.List;

import com.servicio.MAITES.modelos.entidades.planta;

public interface IPlantaService {

	public List<planta> findAll();

	public planta findOne(Long id);
}
