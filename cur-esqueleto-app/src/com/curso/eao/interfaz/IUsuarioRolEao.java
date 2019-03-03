package com.curso.eao.interfaz;

import javax.ejb.Local;

import com.curso.entidades.UsuarioRolDto;

@Local
public interface IUsuarioRolEao {

	Boolean insertarUsuarioRol(UsuarioRolDto usuarioRol);
}
