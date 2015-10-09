package com.vmutter.springbootexample.rs;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("/hello")
public class HelloRS {

	@Autowired
	private ObjectMapper om;

	@Context
	private SecurityContext sc;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("USER")
	public Response hello() throws JsonProcessingException {
		return Response.ok(om.writeValueAsString("Hello, " + sc.getUserPrincipal().getName())).build();
	}

}
