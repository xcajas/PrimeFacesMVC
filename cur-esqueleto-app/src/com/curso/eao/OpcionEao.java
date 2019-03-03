package com.curso.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.curso.eao.interfaz.IOpcionEao;
import com.curso.entidades.OpcionDto;

@Stateless
public class OpcionEao extends BaseEao implements IOpcionEao{

	@Override
	public Boolean insertarOpcion(OpcionDto opcion) {
		// TODO Auto-generated method stub
		try {
			em.persist(opcion);
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
	public List<OpcionDto> consultarOpciones() {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("opciones.selectAll");
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public OpcionDto consultarRolesPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			Query qry = em.createNamedQuery("opciones.selectId");
			qry.setParameter("codigo", id);			
			return (OpcionDto) qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<OpcionDto> consultarOpcionesPadre(String usuario) {
		// TODO Auto-generated method stub
		try {
			String query = "select O.*   " + 
					"  from SYP_SWS_OPCIONES O,   " + 
					"       SYP_SWS_OROL     ORO,   " + 
					"       SYP_SWS_UROL     URO,   " + 
					"       SYP_SWS_USUARIOS U   " + 
					" WHERE O.CODE = ORO.U_SYP_OPCION   " + 
					"   AND ORO.U_SYP_ROL = URO.U_SYP_ROL   " + 
					"   AND U.CODE = URO.U_SYP_USUARIO   " + 
					"   AND O.U_SYP_CLASE = 'P' " +
				    "   AND U.U_SYP_USUARIO = '" +usuario+ "' ";
			System.out.println("CONSULTA DE OPCIONES PADRE POR USUARIO");
			System.out.println(query);			
			Query qry = em.createNativeQuery(query , OpcionDto.class);
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<OpcionDto> consultarOpcionesPorIdPadre(Integer idPadre) {
		// TODO Auto-generated method stub
		try {
			String query = "select O.*   " + 
					"  from SYP_SWS_OPCIONES O,   " + 
					"       SYP_SWS_OROL     ORO,   " + 
					"       SYP_SWS_UROL     URO,   " + 
					"       SYP_SWS_USUARIOS U   " + 
					" WHERE O.CODE = ORO.U_SYP_OPCION   " + 
					"   AND ORO.U_SYP_ROL = URO.U_SYP_ROL   " + 
					"   AND U.CODE = URO.U_SYP_USUARIO   " + 
				    "   AND O.U_SYP_MENU_PADRE = " +idPadre+ " ";
			System.out.println("CONSULTA DE OPCIONES POR ID PADRE POR USUARIO");
			System.out.println(query);			
			Query qry = em.createNativeQuery(query , OpcionDto.class);
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}	
	

}
