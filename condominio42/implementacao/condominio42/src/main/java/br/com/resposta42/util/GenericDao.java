package br.com.resposta42.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public abstract class GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "condominio42-PU")
	protected EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericEntity findById(Long id, Class entityClass) {
		try {
			GenericEntity genericEntity = (GenericEntity) entityManager.find(entityClass, id);
			return genericEntity;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void create(GenericEntity entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public void update(GenericEntity entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

	public void delete(GenericEntity entity) {
		entityManager.remove(entity);
		entityManager.flush();
	}

	@SuppressWarnings({ "rawtypes" })
	public List findAll(Class entityClass) {
		return entityManager.createQuery(
				" from " + entityClass.getSimpleName()).getResultList();
	}
}
