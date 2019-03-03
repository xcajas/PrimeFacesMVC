package com.curso.eao.interfaz;

import javax.ejb.Local;

import com.curso.entidades.OpcionRolDto;

@Local
public interface IOpcionRolEao {

	Boolean insertarOpcionRol(OpcionRolDto opcionRol);
}
