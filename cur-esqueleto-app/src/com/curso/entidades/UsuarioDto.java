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
@Table(name = "SYP_SWS_USUARIOS")
@NamedQueries({ 
	@NamedQuery(name = "usuarios.selectAll", query = "select e from UsuarioDto e ") ,
	@NamedQuery(name = "usuarios.selectId", query = "select a from UsuarioDto a where a.code = :codigo"),
	@NamedQuery(name = "usuarios.consultarUsuarios", query = "select a from UsuarioDto a where a.usuario = :usuario and a.clave = :clave")
})
public class UsuarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2671376427653737838L;

	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "genUsuario", sequenceName = "SEQ_SYP_SWS_USUARIO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genUsuario")
	private Integer code;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "U_SYP_USUARIO")
	private String usuario;
	
	@Column(name = "U_SYP_PRIM_VEZ")
	private String primVez;
	
	@Column(name = "U_SYP_REQ_CAN_CLA")
	private String reqCanClave;
	
	@Column(name = "U_SYP_CLAVE")
	private String clave;

	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	private List<UsuarioRolDto> listaUsuarios;
	
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPrimVez() {
		return primVez;
	}

	public void setPrimVez(String primVez) {
		this.primVez = primVez;
	}

	public String getReqCanClave() {
		return reqCanClave;
	}

	public void setReqCanClave(String reqCanClave) {
		this.reqCanClave = reqCanClave;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<UsuarioRolDto> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioRolDto> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
		
}
