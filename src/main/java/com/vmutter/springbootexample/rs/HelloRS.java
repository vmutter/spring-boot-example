package com.vmutter.springbootexample.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloRS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello() {
		return Response.ok().build();
	}

}
