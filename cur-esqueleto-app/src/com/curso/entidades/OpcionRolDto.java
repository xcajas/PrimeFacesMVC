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
@Table(name = "SYP_SWS_OROL")
@NamedQueries({ 
	@NamedQuery(name = "opcionRoles.selectAll", query = "select e from OpcionRolDto e "),
	@NamedQuery(name = "opcionRoles.consultaPorRol", query = "select e from OpcionRolDto e  where e.code = :codigo")
})
public class OpcionRolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4820182152551019089L;

	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "genOpcionRol", sequenceName = "SEQ_SYP_SWS_OROL", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genOpcionRol")
	private Integer code;
	
	@Column(name = "NAME")
	private String name;
	
	@JoinColumn(name = "U_SYP_OPCION")
	@ManyToOne(fetch=FetchType.LAZY)
	private OpcionDto opcion;
	
	@JoinColumn(name = "U_SYP_ROL")
	@ManyToOne(fetch=FetchType.LAZY)
	private RolDto rolOpcion;

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

	public OpcionDto getOpcion() {
		return opcion;
	}

	public void setOpcion(OpcionDto opcion) {
		this.opcion = opcion;
	}

	public RolDto getRolOpcion() {
		return rolOpcion;
	}

	public void setRolOpcion(RolDto rolOpcion) {
		this.rolOpcion = rolOpcion;
	}
	
	
}
