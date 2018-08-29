package com.servicio.MAITES.controladores.planta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.MAITES.modelos.GenericResponse;
import com.servicio.MAITES.modelos.entidades.planta;
import com.servicio.MAITES.modelos.servicios.IPlantaService;

@Controller
@RestController
@RequestMapping("/planta")
public class PlantaController {

	@Autowired
	private IPlantaService plantaservice;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public GenericResponse<List<planta>> obtenerLista() {
		GenericResponse<List<planta>> response = new GenericResponse<>();
		if(plantaservice.findAll()!=null && plantaservice.findAll().size()>0) {
			response.setCode(200);
			response.setMessage("Datos de las plantas en la bd");
			response.setResponse(plantaservice.findAll());
		}else {
			response.setCode(500);
			response.setMessage("No existen datos disponibles");
			response.setResponse(null);
		}
		return response;
	}
	
	@RequestMapping(value="/listarId", method=RequestMethod.GET)
	public GenericResponse<List<String>> obtenerListaId() {
		GenericResponse<List<String>> response = new GenericResponse<>();
		response.setCode(200);
		response.setMessage("Datos de las plantas en la bd");
		response.setResponse(plantaservice.findAllId());
		return response;
	}
	
	@RequestMapping(value="/actualizar", method=RequestMethod.GET)
	public planta datosActualizados(@RequestParam(value="id",required=true) int id) {
		if(id>0) {
			return plantaservice.findOne(id);
		}else {
			System.out.println("El valor del id es cero o nulo");
			return null;
		}
	}
	
}
