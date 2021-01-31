package com.namegenerator.au2021rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/old")
public class StringOperationsOld {
	
	@GET
	@Path("/gen/{string1}/{string2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String generate(@PathParam("string1") String string1,@PathParam("string2") String string2) {
		return string1+" "+string2;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String split(String string1, String string2) {
		return string1.split(string2)[0];
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCharacterByIndex (String text, int index) {
		return "Character at "+index+" is : "+text.charAt(index);
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String toLower(String string) {
		return string+" in lowercase is : "+string.toLowerCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String toUpper(String string) {
		return string+" in uppercase is : "+string.toUpperCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Integer getIndex(String string, String char1) {
		return string.indexOf(char1);
	}
	

}