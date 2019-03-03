package com.curso.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseEao {

	@PersistenceContext(unitName="cur-esqueleto-app")
	public EntityManager em;
}
