package org.acme.security.keycloak;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;

@Path("/api/admin/")
@Authenticated
public class AdminDao {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String admin() {
        return "granted";
    }

}
