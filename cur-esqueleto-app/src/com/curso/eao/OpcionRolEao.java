package com.curso.eao;

import javax.ejb.Stateless;

import com.curso.eao.interfaz.IOpcionRolEao;
import com.curso.entidades.OpcionRolDto;

@Stateless
public class OpcionRolEao extends BaseEao implements IOpcionRolEao{

	@Override
	public Boolean insertarOpcionRol(OpcionRolDto opcionRol) {
		// TODO Auto-generated method stub
		try {
			em.persist(opcionRol);
			em.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
