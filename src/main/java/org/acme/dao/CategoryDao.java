package org.acme.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.entity.Category;

import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class CategoryDao {
	@Inject
	@PersistenceUnit("category")
	EntityManager em;
	
	public List<Category> findAll(){
		return em.createNamedQuery("category.findAll", Category.class).getResultList();
	}
	
	@Transactional
	public void createCategory(Category category) {
		em.persist(category);
	}
}
