package com.curso.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.curso.eao.interfaz.IRolEao;
import com.curso.eao.interfaz.IUsuarioEao;
import com.curso.eao.interfaz.IUsuarioRolEao;
import com.curso.entidades.RolDto;
import com.curso.entidades.UsuarioDto;
import com.curso.entidades.UsuarioRolDto;
import com.curso.entidades.proceso.ResponseConsultaRoles;
import com.curso.entidades.proceso.ResponseGeneral;
import com.curso.util.JdniNames;

@WebService
public class Integrador {

	@EJB(lookup = JdniNames.EJB_ROLES)
	private IRolEao rolEao;
	@EJB(lookup = JdniNames.EJB_USUARIOS)
	private IUsuarioEao usuarioEao;
	@EJB(lookup = JdniNames.EJB_USUARIO_ROLES)
	private IUsuarioRolEao usuarioRolEao;
	
	@WebMethod
	public ResponseGeneral insertarRol (@WebParam(name = "name") String name,
										@WebParam(name = "rol") String rol,
										@WebParam(name = "descripcion") String descripcion) {
		
		try {
			RolDto r = new RolDto();
			r.setName(name);
			r.setRol(rol);
			r.setDescripcion(descripcion);
			
			if (rolEao.insertarRol(r)) {
				return new ResponseGeneral("0", "Proceso exitoso", true);
			} else {
				return new ResponseGeneral("-10", "Error insertar rol", false);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseGeneral("-20", "Error general insertar rol", false);
		}	
		
	}
	
	@WebMethod
	public ResponseGeneral insertarUsuario (@WebParam(name = "name") String name,
											@WebParam(name = "usuario") String usuario,
											@WebParam(name = "prim_vez") String primVez,
											@WebParam(name = "req_can_cla") String reqCanClave,
											@WebParam(name = "clave") String clave) {
		
		try {
			RolDto r = new RolDto();
			UsuarioDto u = new UsuarioDto();
			UsuarioRolDto ur = new UsuarioRolDto();
			u.setName(name);
			u.setUsuario(usuario);
			u.setPrimVez(primVez);
			u.setReqCanClave(reqCanClave);
			u.setClave(clave);
			

			
			if (usuarioEao.insertarUsuario(u)) {
				r.setCode(1);
				u.setCode(1);
				ur.setRolUsuario(r);
				ur.setUsuario(u);
				if (usuarioRolEao.insertarUsuarioRol(ur)) {
					return new ResponseGeneral("0", "Proceso exitoso", true);
				} else {
					return new ResponseGeneral("-10", "Error insertar usuario rol", false);
				}	
				
			} else {
				return new ResponseGeneral("-10", "Error insertar usuario", false);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseGeneral("-20", "Error general insertar usuario", false);
		}	
		
	}	
	
	@WebMethod
	public ResponseConsultaRoles consultarRoles() {
		try {
			List<RolDto> listaRoles = rolEao.consultarRoles();
			return new ResponseConsultaRoles("0", "Proceso exitoso", true, listaRoles);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseConsultaRoles("-10", e.getMessage(), false, new ArrayList<>());
		}
	}
}
