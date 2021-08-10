package org.acme.endpoint;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.acme.dao.CategoryDao;
import org.acme.entity.Category;


@Path("category")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CategoryEndPoint {
	@Inject CategoryDao cd;
	
	@GET
	public List<Category> getAll(){
		return cd.findAll();
	}
	
	@POST
	public Response create(Category category) {;
		cd.createCategory(category);
		return Response.status(201).build();
	}
}
