package com.curso.entidades.proceso;

import java.io.Serializable;
import java.util.List;

import com.curso.entidades.RolDto;

public class ResponseConsultaRoles extends ResponseGeneral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 430236696476776784L;

	private List<RolDto> listaRoles;
	
	public ResponseConsultaRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseConsultaRoles(String codigo, String mensaje, Boolean resultado) {
		super(codigo, mensaje, resultado);
		// TODO Auto-generated constructor stub
	}
	
	public ResponseConsultaRoles(String codigo, String mensaje, Boolean resultado, List<RolDto> listaRoles) {
		super(codigo, mensaje, resultado);
		this.listaRoles =listaRoles;
		// TODO Auto-generated constructor stub
	}	

	public ResponseConsultaRoles(List<RolDto> listaRoles) {
		super();
		this.listaRoles = listaRoles;
	}

	public List<RolDto> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<RolDto> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
}
