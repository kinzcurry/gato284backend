package org.acme.endpoint;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.acme.dao.ProductsDao;
import org.acme.entity.Products;

@Path("products")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ProductsEndPoint {
	@Inject ProductsDao pd;
	
	@GET
	public List<Products> getAll(){
		return pd.findAll();
	}
	
	@POST
	public Response create(Products product) {
		pd.createProduct(product);
		return Response.status(201).build();
	}
	
	@DELETE
	public Response delete(@QueryParam("id") Long productId) {
		pd.deleteProduct(productId);
		return Response.status(204).build();
	}
	
	@PUT
	public Response update(@QueryParam("id") Long productId, Products product) {
		System.out.println(product.getName());
		String name = product.getName();
		String impName = product.getImpName();
		Long category = product.getCategoryId();
		Long type = product.getTypeId();
		int active = product.getActive();
		int comission = product.getComission();
		Long measure = product.getMeasureId();
		double measureQ = product.getMeasureQtt();
		double price = product.getSellingPrice();
		pd.updateProduct(productId, name, impName, category, type, active,comission, measure, measureQ, price);
		return Response.status(204).build();
	}
}
