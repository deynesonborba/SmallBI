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

import br.com.smallbi.business.FuncaoBusiness;
import br.com.smallbi.entity.Funcao;

@Path("/funcao")
public class FuncaoWebService {

	FuncaoBusiness funcaoBusiness = new FuncaoBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Funcao>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFuncoes(){
		List<Funcao> funcoes = funcaoBusiness.list();
		return gson.toJson(funcoes);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addFuncao(String json){
		Funcao funcao = gson.fromJson(json, type);
		String response = funcaoBusiness.create(funcao);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setFuncao(String json){
		Funcao funcao = gson.fromJson(json, type);
		String response = funcaoBusiness.update(funcao);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delFuncao(String json){
		Funcao funcao = gson.fromJson(json, type);
		String response = funcaoBusiness.delete(funcao.getIdFuncao());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idFuncao}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idFuncao") String idFuncao){
		Funcao funcao = funcaoBusiness.getObjById(Integer.parseInt(idFuncao));
		return gson.toJson(funcao);
	}
}