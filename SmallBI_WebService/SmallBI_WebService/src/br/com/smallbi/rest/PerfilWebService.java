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

import br.com.smallbi.business.PerfilBusiness;
import br.com.smallbi.entity.Perfil;

@Path("/perfil")
public class PerfilWebService {

	PerfilBusiness perfilBusiness = new PerfilBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Perfil>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPerfis(){
		List<Perfil> perfis = perfilBusiness.list();
		return gson.toJson(perfis);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addPerfil(String json){
		Perfil perfil = gson.fromJson(json, type);
		String response = perfilBusiness.create(perfil);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setPerfil(String json){
		Perfil perfil = gson.fromJson(json, type);
		String response = perfilBusiness.update(perfil);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delPerfil(String json){
		Perfil perfil = gson.fromJson(json, type);
		String response = perfilBusiness.delete(perfil.getIdPerfil());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idPerfil}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idPerfil") String idPerfil){
		Perfil perfil = perfilBusiness.getObjById(Integer.parseInt(idPerfil));
		return gson.toJson(perfil);
	}
}