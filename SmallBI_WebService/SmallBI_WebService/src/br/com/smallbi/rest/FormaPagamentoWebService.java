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

import br.com.smallbi.business.FormaPagamentoBusiness;
import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.entity.FormaPagamento;

@Path("/formaPagamento")
public class FormaPagamentoWebService {

	FormaPagamentoBusiness formaPagamentoBusiness = new FormaPagamentoBusiness();
	Gson gson = new Gson();
	Type type = new TypeToken<FormaPagamento>() {}.getType();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFormasPag(){
		List<FormaPagamento> formas = formaPagamentoBusiness.list();
		return gson.toJson(formas);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addFormaPag(String json){
		FormaPagamento forma = gson.fromJson(json, type);
		try {
			formaPagamentoBusiness.create(forma);
			return gson.toJson(true);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setFormaPag(String json){
		FormaPagamento forma = gson.fromJson(json, type);
		try {
			formaPagamentoBusiness.update(forma);
			return gson.toJson(true);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@POST
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delFormaPag(String json){
		FormaPagamento forma = gson.fromJson(json, type);
		try {
			formaPagamentoBusiness.delete(forma.getIdFormaPagamento());
			return gson.toJson(true);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return gson.toJson(false);
	}
	
	@GET
	@Path("/getById/{idFormaPagamento}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idFormaPagamento") String idFormaPagamento){
		try {
			FormaPagamento forma = formaPagamentoBusiness.getObjById(Integer.parseInt(idFormaPagamento));
			return gson.toJson(forma);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "";
	}
}
