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

import br.com.smallbi.business.EnderecoBusiness;
import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.entity.Endereco;

@Path("/endereco")
public class EnderecoWebService {

	EnderecoBusiness enderecoBusiness = new EnderecoBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Endereco>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEnderecos(){
		List<Endereco> enderecos = enderecoBusiness.list();
		return gson.toJson(enderecos);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEndereco(String json){
		Endereco endereco = gson.fromJson(json, type);
		try {
			enderecoBusiness.create(endereco);
			return gson.toJson(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setEndereco(String json){
		Endereco endereco = gson.fromJson(json, type);
		try {
			enderecoBusiness.update(endereco);
			return gson.toJson(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delEndereco(String json){
		Endereco endereco = gson.fromJson(json, type);
		try {
			enderecoBusiness.delete(endereco.getIdEndereco());
			return gson.toJson(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@GET
	@Path("/getById/{idEndereco}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idEndereco") String idEndereco){
		try {
			Endereco endereco = enderecoBusiness.getObjById(Integer.parseInt(idEndereco));
			return gson.toJson(endereco);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		//return gson.toJson("Nenhum resultado encontrado");
		return gson.toJson(false);
	}
}
