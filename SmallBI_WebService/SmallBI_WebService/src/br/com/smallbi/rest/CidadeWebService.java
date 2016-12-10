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

import br.com.smallbi.business.CidadeBusiness;
import br.com.smallbi.entity.Cidade;

@Path("/cidade")
public class CidadeWebService {
	
	CidadeBusiness cidadeBusiness = new CidadeBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Cidade>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCidade(){
		List<Cidade> cidades = cidadeBusiness.list();
		return gson.toJson(cidades);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCidade(String json){
		Cidade cidade = gson.fromJson(json, type);
		String response = cidadeBusiness.create(cidade);
		return gson.toJson(response);
	}
	
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setCidade(String json){
		Cidade cidade = gson.fromJson(json, type);
		String response = cidadeBusiness.update(cidade);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delCidade(String json){
		Cidade cidade = gson.fromJson(json, type);
		String response = cidadeBusiness.delete(cidade.getIdCidade());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idCidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idCidade") String idCidade){
		Cidade cidade = cidadeBusiness.getObjById(Integer.parseInt(idCidade));
		return gson.toJson(cidade);
	}
}
