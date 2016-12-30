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

import br.com.smallbi.business.ClienteBusiness;
import br.com.smallbi.entity.Cliente;

@Path("/cliente")
public class ClienteWebService {

	ClienteBusiness clienteBusiness = new ClienteBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<Cliente>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmpresas(){
		List<Cliente> clientes = clienteBusiness.list();
		return gson.toJson(clientes);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmpresa(String json){
		Cliente cliente = gson.fromJson(json, type);
		String response = clienteBusiness.create(cliente);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setEmpresa(String json){
		Cliente cliente = gson.fromJson(json, type);
		String response = clienteBusiness.update(cliente);
		return gson.toJson(response);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delEmpresa(String json){
		Cliente cliente = gson.fromJson(json, type);
		String response = clienteBusiness.delete(cliente.getIdCliente());
		return gson.toJson(response);
	}
	
	@GET
	@Path("/getById/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idEmpresa") String idEmpresa){
		Cliente cliente = clienteBusiness.getObjById(Integer.parseInt(idEmpresa));
		return gson.toJson(cliente);
	}
}
