package com.science.rest;


import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.exceptions.NotFoundException;
import java.util.HashMap;


//TODO add logger to capture more info
@Component
@Path("/galatic")
public class GalaticResource {

	
	
	@Resource(name="planetGravity")
	private HashMap<String, Double> planetGravity;

	@GET
	@Path("/gravity/{planet}/{weight}")
	@Produces(MediaType.TEXT_XML)
	public Response gravityEffect(@PathParam("planet") String planet, @PathParam("weight") Double weight ) {

		double totalMass = 0d;
		
		if(!planetGravity.containsKey(planet)) {
			
			//throw new NotFoundException();
			throw new NotFoundException("Planet, " + planet + ", is not found");

		}
		
		

        totalMass = weight * planetGravity.get(planet.toLowerCase()); 
       
        String result = "<space><planet>" + planet + "</planet>" + "<weight>" + totalMass + "</weight></space>";
		
		return Response.status(200).entity(result).build();

	}

}
