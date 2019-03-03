package com.curso.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.curso.eao.interfaz.IRolEao;
import com.curso.entidades.RolDto;

@Stateless
public class RolEao extends BaseEao implements IRolEao{

	@Override
	public Boolean insertarRol(RolDto rol) {
		// TODO Auto-generated method stub
		try {
			em.persist(rol);
			em.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolDto> consultarRoles() {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("roles.selectAll");
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}

	@Override
	public RolDto consultarRolesPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("roles.selectId");
			qry.setParameter("codigo", id);
			return (RolDto) qry.getResultList();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}

}
