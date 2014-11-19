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

@Component
@Path("/galatic")
public class GalaticResource {

	
	
	@Resource(name="planetGravity")
	private HashMap<String, Double> planetGravity;

	@GET
	@Path("/gravity/{planet}/{weight}")
	@Produces(MediaType.TEXT_XML)
	public Response gravityEffect(@PathParam("planet") String planet, @PathParam("weight") Double weight ) {

		if(!planetGravity.containsKey(planet)) {
			//Response.status(200).entity(result).build();
			//throw new NotFoundException("Planet, " + planet + ", is not found");
			throw new NotFoundException("Planet, " + planet + ", is not found");
			//Response.status(200).entity(result).build()
		}
		
		//String result = "<spring>" + planetGravity.get(planet) + "</spring>";
		
		double totalMass = 0d;
    	
        //System.out.println(planetGravity.size()); 
        /*
        HashMap<String, Double> planetGravity = new HashMap<String, Double>();
        planetGravity.put("earth", 1.0);
        planetGravity.put("outerspace", 0.0);
        planetGravity.put("moon", .17);
        planetGravity.put("venus", .90);
        planetGravity.put("mars", .38);
        planetGravity.put("mercury", .38);
        planetGravity.put("jupiter", 2.36);
        planetGravity.put("saturn", .92);
        planetGravity.put("uranus", .89);
        planetGravity.put("neptune", 1.13);
        planetGravity.put("pluto", .07); 
       */
        totalMass = weight * planetGravity.get(planet.toLowerCase()); 
       
        String result = "<space><planet>" + planet + "</planet>" + "<weight>" + totalMass + "</weight></space>";
		
		return Response.status(200).entity(result).build();

	}

}
