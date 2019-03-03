package com.curso.eao;

import javax.ejb.Stateless;

import com.curso.eao.interfaz.IUsuarioRolEao;
import com.curso.entidades.UsuarioRolDto;

@Stateless
public class UsuarioRolEao extends BaseEao implements IUsuarioRolEao{

	@Override
	public Boolean insertarUsuarioRol(UsuarioRolDto usuarioRol) {
		// TODO Auto-generated method stub
		try {
			em.persist(usuarioRol);
			em.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
