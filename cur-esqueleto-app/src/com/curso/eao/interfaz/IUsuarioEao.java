package com.curso.eao.interfaz;

import java.util.List;

import javax.ejb.Local;

import com.curso.entidades.UsuarioDto;

@Local
public interface IUsuarioEao {

	Boolean insertarUsuario(UsuarioDto usuario);
	
	List<UsuarioDto> consultarUsuarios();
	
	UsuarioDto consultarUsuariosPorId(Integer id);
	
	//UsuarioDto consultarPorUsuarios(String usuario);
	
	UsuarioDto consultarUsuario(String usuario, String clave);
}
