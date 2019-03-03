package com.curso.vista.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.curso.eao.interfaz.IUsuarioEao;
import com.curso.entidades.UsuarioDto;
import com.curso.util.JdniNames;
import com.sun.prism.RTTexture;

import lombok.Getter;
import lombok.Setter;

@ManagedBean//(name = "loginMb")
@SessionScoped
//Request datos solo existen en el request
//Session los datos persite en toda la sesion
//View los datos estan disponible cuando la pagina este visible
/**
 * 
 * @author Usuario
 *
 */
public class LoginMb implements Serializable{

	private static final long serialVersionUID = -3120562327492269168L;

	@PostConstruct//Metodo para inicializar la pagina
	private void init() {
		disableClave = true;
	}
	
	@Getter
	@Setter
	private String usuario;
	
	@Getter
	@Setter	
	private String clave;
	
	@Getter
	@Setter		
	private Boolean disableClave;
	
	@Getter
	@Setter	
	private boolean loggedIn;
	
	@EJB(lookup=JdniNames.EJB_USUARIOS)
	private IUsuarioEao usEao;
	
	public String doLogin() {
		
		UsuarioDto us = usEao.consultarUsuario(usuario, clave);
		if (us != null) {
			loggedIn = true;
			return "/paginas/pag_principal.xhtml?faces-redirect=true";
		}
		
		/*if (usuario.equals("lcajas") && clave.equals("lcajas")) {
			loggedIn = true;
			return "/paginas/pag_principal.xhtml?faces-redirect=true";
		}*/
		FacesMessage msg = new FacesMessage("Credenciales incorrectas", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		loggedIn =  false;
		return "/Login.xhtml";
		
	}

	public String doLogout() {
		loggedIn = false;
		
		FacesMessage msg = new FacesMessage("Logout success", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);		
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		usuario = "";
		clave = "";
		
		return "/Login.xhtml";		
	}
}
