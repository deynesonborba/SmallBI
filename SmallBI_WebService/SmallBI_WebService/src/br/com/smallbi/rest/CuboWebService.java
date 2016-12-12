package br.com.smallbi.rest;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.smallbi.business.CuboBusiness;
import br.com.smallbi.entity.Cubo;

@Path("/cubo")
public class CuboWebService {

	CuboBusiness cuboBusiness = new CuboBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Cubo>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCubos(){
		List<Cubo> cubos = cuboBusiness.list();
		return gson.toJson(cubos);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCubo(String json){
		Cubo cubo = gson.fromJson(json, type);
		String response = cuboBusiness.create(cubo);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setCubo(String json){
		Cubo cubo = gson.fromJson(json, type);
		String response = cuboBusiness.update(cubo);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delCubo(String json){
		Cubo cubo = gson.fromJson(json, type);
		String response = cuboBusiness.delete(cubo.getIdCubo());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idCubo}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idCubo") String idCubo){
		Cubo cubo = cuboBusiness.getObjById(Integer.parseInt(idCubo));
		return gson.toJson(cubo);
	}
}