package br.com.smallbi.rest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.smallbi.business.EnderecoBusiness;
import br.com.smallbi.entity.Cidade;
import br.com.smallbi.entity.Cliente;
import br.com.smallbi.entity.Endereco;
import br.com.smallbi.entity.Pessoa;
import br.com.smallbi.entity.Tipo;

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
		List<Hashtable<String, Object>> hashEnderecos = new ArrayList<>();
		for(Endereco e : enderecos){
			hashEnderecos.add(getHashFromObject(e));
		}
		return gson.toJson(hashEnderecos);
	}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEndereco(String json) throws JSONException{
		Endereco endereco = getObjectFromHash(json);
		return gson.toJson(enderecoBusiness.create(endereco));
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setEndereco(String json) throws JSONException{
		Endereco endereco = getObjectFromHash(json);
		return gson.toJson(enderecoBusiness.update(endereco));
	}
	
	@DELETE
	@Path("/deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delEndereco(String json) throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(jsonObject.getInt("idEndereco"));
		return gson.toJson(enderecoBusiness.delete(endereco.getIdEndereco()));
	}
	
	@GET
	@Path("/getById/{idEndereco}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("idEndereco") String idEndereco){
		Endereco endereco = enderecoBusiness.getObjById(Integer.parseInt(idEndereco));
		if(endereco != null){
			return gson.toJson(getHashFromObject(endereco));
		}
		return gson.toJson("Nenhum resultado foi encontrado na tabela Endereço com o id {"+idEndereco+"}");
	}
	
	public Endereco getObjectFromHash(String json) throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		Endereco e = new Endereco();

		if(!jsonObject.isNull("idEndereco")){
			e.setIdEndereco(jsonObject.getInt("idEndereco"));
		}
		
		e.setUsuarioId(jsonObject.getInt("usuarioId"));
		e.setEndereco(jsonObject.getString("endereco"));
		e.setNumero(jsonObject.getInt("numero"));
		e.setBairro(jsonObject.getString("bairro"));
		
		Cidade cidade = new Cidade();
		cidade.setIdCidade(jsonObject.getInt("idCidade"));
		e.setCidade(cidade);
		
		if(!jsonObject.isNull("idPessoa")){
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(jsonObject.getInt("idPessoa"));
			e.setPessoa(pessoa);
		}
		
		if(!jsonObject.isNull("idCliente")){
			Cliente cliente = new Cliente();
			cliente.setIdCliente(jsonObject.getInt("idCliente"));
			e.setCliente(cliente);
		}

		Tipo tipo = new Tipo();
		tipo.setIdTipo(jsonObject.getInt("idTipo"));
		e.setTipo(tipo);

		return e;
	}
	
	public Hashtable<String, Object> getHashFromObject(Endereco e){
		Hashtable<String, Object> hashtable = new Hashtable<>();
		hashtable.put("idEndereco", e.getIdEndereco());
		hashtable.put("endereco", e.getEndereco());
		hashtable.put("numero", e.getNumero());
		hashtable.put("bairro", e.getBairro());
		hashtable.put("cidade", e.getCidade().getNomeCidade());
		if(e.getPessoa() != null){
			hashtable.put("pessoa", e.getPessoa().getNome());
			hashtable.put("cliente", e.getPessoa().getCliente().getNomeFantasia());
		}
		if(e.getCliente() != null){
			hashtable.put("cliente", e.getCliente().getNomeFantasia());
		}
		hashtable.put("tipo", e.getTipo().getTipo());		
		return hashtable;
	}
}
