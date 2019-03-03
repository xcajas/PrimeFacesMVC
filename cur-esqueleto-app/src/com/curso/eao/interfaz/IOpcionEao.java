package com.curso.eao.interfaz;

import java.util.List;

import javax.ejb.Local;

import com.curso.entidades.OpcionDto;

@Local
public interface IOpcionEao {

	Boolean insertarOpcion(OpcionDto opcion);
	
	List<OpcionDto> consultarOpciones();
	
	OpcionDto consultarRolesPorId(Integer id);
	
	List<OpcionDto> consultarOpcionesPadre(String usuario);
	
	List<OpcionDto> consultarOpcionesPorIdPadre(Integer idPadre);
}
