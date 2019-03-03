package com.curso.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SYP_SWS_UROL")
@NamedQueries({ 
	@NamedQuery(name = "usuarioRoles.selectAll", query = "select e from UsuarioRolDto e ")	
})
public class UsuarioRolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3027009643824287860L;

	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "genUsuarioRol", sequenceName = "SEQ_SYP_SWS_UROL", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genUsuarioRol")
	private Integer code;
	
	@Column(name = "NAME")
	private String name;
		
	@JoinColumn(name = "U_SYP_ROL")
	@ManyToOne(fetch=FetchType.LAZY)
	private RolDto rolUsuario;
	
	@JoinColumn(name = "U_SYP_USUARIO")
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioDto usuario;

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

	public RolDto getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(RolDto rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
		
}
