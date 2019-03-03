package com.curso.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SYP_SWS_OPCIONES")
@NamedQueries({ 
	@NamedQuery(name = "opciones.selectAll", query = "select e from OpcionDto e ") ,
	@NamedQuery(name = "opciones.selectId", query = "select a from OpcionDto a where a.code = :codigo"),
	@NamedQuery(name = "opciones.obtenerMenuPadre", query = "select a from OpcionDto a where a.clase = :clase")
})
public class OpcionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8272372787306900830L;

	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "genOpcion", sequenceName = "SEQ_SYP_SWS_OPCION", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genOpcion")
	private Integer code;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "U_SYP_OPCION")
	private String opcion;
	
	@Column(name = "U_SYP_RUTA")
	private String ruta;
	
	@Column(name = "U_SYP_DESCRIPCION")
	private String descripcion;
	
	@Column(name = "U_SYP_CLASE")
	private String clase;
	
	@Column(name = "U_SYP_ICONO")
	private String icono;	
	
	@Column(name = "U_SYP_MENU_PADRE")
	private Integer menuPadre;
	
	@Column(name = "U_SYP_ORDEN")
	private Integer orden;
	
	@OneToMany(mappedBy="opcion", fetch = FetchType.EAGER)
	private List<OpcionRolDto> listaOpciones;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Integer getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(Integer menuPadre) {
		this.menuPadre = menuPadre;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public List<OpcionRolDto> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(List<OpcionRolDto> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	
}
