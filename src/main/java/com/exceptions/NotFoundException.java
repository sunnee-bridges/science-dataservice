package com.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

public class NotFoundException extends WebApplicationException{

	 public NotFoundException() {
	       super(Responses.notFound().build());
	 }
	 
	 public NotFoundException(String response) {
		   super(Response.status(Responses.NOT_FOUND).
	                entity(response).type("text/plain").build());
     }
}
