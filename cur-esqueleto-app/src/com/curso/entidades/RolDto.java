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
@Table(name = "SYP_SWS_ROLES")
@NamedQueries({ 
	@NamedQuery(name = "roles.selectAll", query = "select e from RolDto e ") ,
	@NamedQuery(name = "roles.selectId", query = "select a from RolDto a where a.code = :codigo")
})
public class RolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1182347675828424462L;
	
	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "genRol", sequenceName = "SEQ_SYP_SWS_ROL", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genRol")
	private Integer code;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "U_SYP_ROL")
	private String rol;
	
	@Column(name = "U_SYP_DESCRIPCION")
	private String descripcion;
	
	@OneToMany(mappedBy="rolUsuario")//, fetch=FetchType.EAGER)
	private List<UsuarioRolDto> listaRolesUsuarios;
	
	@OneToMany(mappedBy="rolOpcion")//, fetch=FetchType.EAGER)
	private List<OpcionRolDto> listaRolesOpciones;

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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuarioRolDto> getListaRolesUsuarios() {
		return listaRolesUsuarios;
	}

	public void setListaRolesUsuarios(List<UsuarioRolDto> listaRolesUsuarios) {
		this.listaRolesUsuarios = listaRolesUsuarios;
	}

	public List<OpcionRolDto> getListaRolesOpciones() {
		return listaRolesOpciones;
	}

	public void setListaRolesOpciones(List<OpcionRolDto> listaRolesOpciones) {
		this.listaRolesOpciones = listaRolesOpciones;
	}
	
}
