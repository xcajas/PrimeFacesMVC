package com.curso.entidades.proceso;

import java.io.Serializable;

public class ResponseGeneral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5862471887620187380L;
	
	private String codigo;
	private String mensaje;
	private Boolean resultado;
	
	public ResponseGeneral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseGeneral(String codigo, String mensaje, Boolean resultado) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.resultado = resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	
}
