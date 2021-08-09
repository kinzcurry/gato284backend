package org.acme.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.acme.entity.Products;

import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class ProductsDao {
	@Inject
	@PersistenceUnit("products")
	EntityManager em;
	
	public List<Products> findAll(){
		return em.createNamedQuery("products.findAll", Products.class).getResultList();
	}
	
	@Transactional
	public void deleteProduct(Long productId) {
		Products p = findProductById(productId);
		em.remove(p);
	}
	
	public Products findProductById (Long id) {
		Products product = em.find(Products.class, id);
		if(product == null) {
			System.out.println("Produto Não encontrado");
		}
		return product;
	}
	
	@Transactional
	public void createProduct(Products product) {
		em.persist(product);
	}
	
	@Transactional
	public void updateProduct (Long id, String name, String impName, Long category, Long type, int active, int comission, Long measure, double measureQ, double price) {
		Products productUpdate = findProductById(id);
		productUpdate.setName(name);
		productUpdate.setImpName(impName);
		productUpdate.setCategoryId(category);
		productUpdate.setTypeId(type);
		productUpdate.setActive(active);
		productUpdate.setComission(comission);
		productUpdate.setMeasureId(measure);
		productUpdate.setMeasureQtt(measureQ);
		productUpdate.setSellingPrice(price);
		
	}
}
