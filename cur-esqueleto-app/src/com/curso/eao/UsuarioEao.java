package com.curso.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.curso.eao.interfaz.IUsuarioEao;
import com.curso.entidades.UsuarioDto;

@Stateless
public class UsuarioEao extends BaseEao implements IUsuarioEao {

	@Override
	public Boolean insertarUsuario(UsuarioDto usuario) {
		// TODO Auto-generated method stub
		try {
			em.persist(usuario);
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
	public List<UsuarioDto> consultarUsuarios() {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("usuarios.selectAll");
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public UsuarioDto consultarUsuariosPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("usuarios.selectId");
			qry.setParameter("codigo", id);			
			return (UsuarioDto) qry.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}
/*
	@Override
	public UsuarioDto consultarPorUsuarios(String usuario) {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("usuarios.consultarUsuarios");
			qry.setParameter("usuario", usuario);			
			UsuarioDto usu = (UsuarioDto) qry.getSingleResult();
			
			return usu;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
*/
	@Override
	public UsuarioDto consultarUsuario(String usuario, String clave) {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("usuarios.consultarUsuarios");
			qry.setParameter("usuario", usuario);
			qry.setParameter("clave", clave);
			//UsuarioDto usu = (UsuarioDto) qry.getSingleResult();
			
			return (UsuarioDto) qry.getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}	

}
