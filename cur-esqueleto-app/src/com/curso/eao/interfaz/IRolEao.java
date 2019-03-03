package com.curso.eao.interfaz;

import java.util.List;

import javax.ejb.Local;

import com.curso.entidades.RolDto;

@Local
public interface IRolEao {

	Boolean insertarRol(RolDto rol);
	
	List<RolDto> consultarRoles();
	
	RolDto consultarRolesPorId(Integer id);
}
