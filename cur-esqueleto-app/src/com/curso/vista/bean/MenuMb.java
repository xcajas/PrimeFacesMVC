package com.curso.vista.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import com.curso.eao.interfaz.IOpcionEao;
import com.curso.entidades.OpcionDto;
import com.curso.util.JdniNames;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
public class MenuMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7225090926599377381L;

	@Getter
	@Setter
	private MenuModel model;
	
	@ManagedProperty(value = "#{loginMb}")
	@Getter
	@Setter	
	private LoginMb loginMb;
	
	@EJB(lookup = JdniNames.EJB_OPCIONES)
	private IOpcionEao opEao;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//LoginMb loginBean = (LoginMb)((HttpServletRequest)request).getSession().getAttribute("loginMb");
		//System.out.println("usuario publico "+loginBean.usStr);
		//System.out.println("loginMb: "+loginBean);
		//System.out.println("usuario: "+loginBean.getUsuario());
		//System.out.println("usuarioObjeto: "+loginBean.getUsuarioObjeto());
		
		parseMenuOpciones(loginMb.getUsuario());
	}
	
	public void parseMenuOpciones(String usuario) {
		
		DefaultMenuItem menItm = new DefaultMenuItem("Principal");
		menItm.setIcon("icon-home-outline");
		menItm.setTitle("Pagina Principal");
		menItm.setOutcome("/paginas/pag_principal.xhtml");		
		menItm.setPartialSubmit(true);
		menItm.setProcess("@this");
		menItm.setContainerStyleClass("layout-menubar-active");
				
		model.addElement(menItm);
		
		List<OpcionDto> opcionesPadre = opEao.consultarOpcionesPadre(usuario);
		
		for (OpcionDto opcion : opcionesPadre) {
			DefaultSubMenu submenu = new DefaultSubMenu(opcion.getOpcion());
			
			submenu.setId("CUR"+opcion.getCode());
			submenu.setIcon(opcion.getIcono());
			
			List<OpcionDto> opcionesHijas = opEao.consultarOpcionesPorIdPadre(opcion.getCode());
			
			for (OpcionDto opcionHija : opcionesHijas) {
				submenu.getElements().add(obtenerMenuHijo(opcionHija, usuario));
			}
			model.addElement(submenu);
		}
				
	}
	
	public MenuElement obtenerMenuHijo (OpcionDto opcionPadre, String usuario) {
		List<OpcionDto> opcionesHija = opEao.consultarOpcionesPorIdPadre(opcionPadre.getCode());
		if(opcionesHija == null || opcionesHija.size() <= 0) {
			DefaultMenuItem menItem = new DefaultMenuItem(opcionPadre.getOpcion());
			menItem.setIcon(opcionPadre.getIcono());
			menItem.setTitle(opcionPadre.getDescripcion());
			menItem.setUrl(opcionPadre.getRuta());
			menItem.setCommand("{id\":" + opcionPadre.getCode()+"}");
			return menItem;
		} else {
			DefaultSubMenu subItem = new DefaultSubMenu(opcionPadre.getOpcion());
			subItem.setIcon(opcionPadre.getIcono());
			
			for (OpcionDto opcion : opcionesHija) {
				subItem.getElements().add(obtenerMenuHijo(opcion, usuario));
			}
			return subItem;
		}
	}
}
