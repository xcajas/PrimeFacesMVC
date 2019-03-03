package com.curso.vista.bean.usuarios;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.curso.eao.interfaz.IRolEao;
import com.curso.entidades.RolDto;
import com.curso.entidades.UsuarioDto;
import com.curso.util.JdniNames;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class RolMb {

	@Getter
	@Setter
	private String descripcion;

	@Getter
	@Setter	
	private String nombre;
	
	@Getter
	@Setter	
	private String rol;
	
	@EJB(lookup=JdniNames.EJB_ROLES)
	private IRolEao rolEao;	
	
	
	public void insertarRol() {
		RolDto r = new RolDto();
		r.setDescripcion(descripcion);
		r.setName(nombre);
		r.setRol(rol);;

		
		rolEao.insertarRol(r);
		
		FacesMessage msg = new FacesMessage("Rol Insertado Exitosamente", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);		
		
		//usuarios = usEao.consultarUsuarios();
	}	
}
