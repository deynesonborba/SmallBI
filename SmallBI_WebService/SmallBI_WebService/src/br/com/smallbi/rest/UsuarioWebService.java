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

import br.com.smallbi.business.UsuarioBusiness;
import br.com.smallbi.entity.Usuario;

@Path("/usuario")
public class UsuarioWebService {

	UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Usuario>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsuarios(){
		List<Usuario> usuarios = usuarioBusiness.list();
		return gson.toJson(usuarios);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addUsuario(String json){
		Usuario usuario = gson.fromJson(json, type);
		String response = usuarioBusiness.create(usuario);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setUsuario(String json){
		Usuario usuario = gson.fromJson(json, type);
		String response = usuarioBusiness.update(usuario);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delUsuario(String json){
		Usuario usuario = gson.fromJson(json, type);
		String response = usuarioBusiness.delete(usuario.getIdUsuario());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idUsuario") String idUsuario){
		Usuario usuario = usuarioBusiness.getObjById(Integer.parseInt(idUsuario));
		return gson.toJson(usuario);
	}
}