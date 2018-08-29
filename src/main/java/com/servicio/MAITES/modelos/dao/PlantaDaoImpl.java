package com.servicio.MAITES.modelos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.servicio.MAITES.modelos.entidades.planta;

@Repository
public class PlantaDaoImpl implements IPlantaDao{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<planta> findAll() {
		return em.createQuery("from planta").getResultList();
	}

	@Override
	public planta findOne(int id) {
		return em.find(planta.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> finAllId() {
		return em.createNativeQuery("select idplanta, versiondeactualizacion from planta").getResultList();
	}
}
