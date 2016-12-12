package br.com.smallbi.test;

import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.smallbi.business.EmpresaBusiness;
import br.com.smallbi.business.PerfilBusiness;
import br.com.smallbi.business.PessoaBusiness;
import br.com.smallbi.business.UsuarioBusiness;
import br.com.smallbi.entity.Empresa;
import br.com.smallbi.entity.Perfil;
import br.com.smallbi.entity.Pessoa;
import br.com.smallbi.entity.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuario {

	UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
	public static int idTestusuario;
	
	@Test
	public void test1CreateUsuario(){
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(Calendar.getInstance());
		
		List<Empresa> empresas = new EmpresaBusiness().list();
		Empresa empresa = empresas.get(0);
		usuario.setEmpresa(empresa);
		
		usuario.setLogin("borbagato");
		
		List<Perfil> perfis = new PerfilBusiness().list();
		Perfil perfil = perfis.get(0);
		usuario.setPerfil(perfil);
		
		List<Pessoa> pessoas = new PessoaBusiness().list();
		Pessoa pessoa = pessoas.get(0);
		usuario.setPessoa(pessoa);
		
		usuario.setSenha("123");
		usuario.setStatus(true);
		usuario.setUsuarioId(1);
		usuario.setUsuarioSaiku("borbasaiku");
		
		usuarioBusiness.create(usuario);
		idTestusuario = usuario.getIdUsuario();
	}
	
	@Test
	public void test2ListUsuario(){
		List<Usuario> usuarios = usuarioBusiness.list();
		System.out.println("<<Usuarios>>");
		for(Usuario u : usuarios){
			System.out.println("----------");
			System.out.println("Login: " + u.getLogin());
			System.out.println("Senha: " + u.getSenha());
			System.out.println("Usuário Saiku: " + u.getUsuarioSaiku());
			System.out.println("Id: " + u.getIdUsuario());
			System.out.println("Id usuário que fez o cadastro: " + u.getUsuarioId());
			System.out.println("Data de cadastro: " + u.getDataCadastro().getTime());
			System.out.println("Empresa: " + u.getEmpresa().getNomeFantasia());
			System.out.println("Perfil: " + u.getPerfil().getNomePerfil());
			System.out.println("Nome: " + u.getPessoa().getNome());
			System.out.println("----------");
		}
	}
	
	@Test
	public void test3UpdateUsuario(){
		Usuario u = usuarioBusiness.getObjById(idTestusuario);
		u.setLogin("borba_1993");
		u.setSenha("1234567890");
		usuarioBusiness.update(u);
		System.out.println("UPDATE");
		test2ListUsuario();
	}
	
	@Test
	public void test4Deleteusuario(){
		usuarioBusiness.delete(idTestusuario);
		System.out.println("DELETE");
		test2ListUsuario();
	}
}
