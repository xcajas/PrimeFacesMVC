package com.curso.vista.bean.usuarios;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.curso.eao.interfaz.IUsuarioEao;
import com.curso.entidades.UsuarioDto;
import com.curso.util.JdniNames;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class UsuarioMb {

	@Getter
	@Setter
	private String nombre;
	
	@Getter
	@Setter	
	private String apellido;
	
	@Getter
	@Setter
	private String usuario;
	
	@Getter
	@Setter
	private String clave;
	
	@Getter
	@Setter	
	private List<UsuarioDto> usuarios;
	
	@EJB(lookup=JdniNames.EJB_USUARIOS)
	private IUsuarioEao usEao;
	
	@PostConstruct
	public void init() {
		usuarios = usEao.consultarUsuarios();
	}
	
	public void insertarUsuario() {
		UsuarioDto us = new UsuarioDto();
		us.setUsuario(usuario);
		us.setClave(clave);
		us.setName(nombre+" "+apellido);
		us.setPrimVez("N");
		us.setReqCanClave("N");
		
		usEao.insertarUsuario(us);
		
		FacesMessage msg = new FacesMessage("Usuario Insertado Exitosamente", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);		
		
		usuarios = usEao.consultarUsuarios();
	}
	
	public void actualizarUsuario() {
		
		System.out.println("Actualizar usuario");		
		
		usuarios = usEao.consultarUsuarios();
	}	
	
	public void seleccionarUsuario(UsuarioDto usuarioDto) {
		usuario = usuarioDto.getUsuario();
		nombre = usuarioDto.getName().substring(0, usuarioDto.getName().indexOf(" "));
		apellido = usuarioDto.getName().substring(usuarioDto.getName().indexOf(" ")+1);
		clave = usuarioDto.getClave();
	}
}
