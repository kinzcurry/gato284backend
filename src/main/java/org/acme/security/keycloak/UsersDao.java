package org.acme.security.keycloak;

import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.User;
import org.jboss.resteasy.annotations.cache.NoCache;

import io.quarkus.security.identity.SecurityIdentity;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersDao {
	@Inject
	SecurityIdentity identity;
	
	@GET
	@Path("/me")
	@NoCache
	@RolesAllowed("user")
	public Map<String, String> me() {
		return Map.of("username", identity.getPrincipal().getName());
	}

}
