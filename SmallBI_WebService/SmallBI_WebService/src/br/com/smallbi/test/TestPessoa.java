package br.com.smallbi.test;

import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.smallbi.business.EnderecoBusiness;
import br.com.smallbi.business.FuncaoBusiness;
import br.com.smallbi.business.PessoaBusiness;
import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.entity.Endereco;
import br.com.smallbi.entity.Funcao;
import br.com.smallbi.entity.Pessoa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPessoa {

	PessoaBusiness pessoaBusiness = new PessoaBusiness();
	public static int idTestPessoa;
	
	@Test
	public void test1CreatePessoa(){
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("123.123.123-12");
		pessoa.setDataCadastro(Calendar.getInstance());
		
		List<Endereco> enderecos = new EnderecoBusiness().list();
		Endereco endereco = enderecos.get(0);
		pessoa.setEndereco(endereco);
		
		List<Funcao> funcoes = new FuncaoBusiness().list();
		Funcao funcao = funcoes.get(0);
		pessoa.setFuncao(funcao);
		
		pessoa.setNome("Huguinho");
		pessoa.setRg("12.123.123-1");
		pessoa.setStatus(true);
		pessoa.setUsuarioId(1);
		
		try {
			pessoaBusiness.create(pessoa);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		idTestPessoa = pessoa.getIdPessoa();
	}
	
	@Test
	public void test2ListPessoa(){
		List<Pessoa> pessoas = pessoaBusiness.list();
		System.out.println("<<Pessoas>>");
		for(Pessoa p : pessoas){
			System.out.println("----------");
			System.out.println("CPF: " + p.getCpf());
			System.out.println("Nome: " + p.getNome());
			System.out.println("RG: " + p.getRg());
			System.out.println("Id: "+ p.getIdPessoa());
			System.out.println("Usuário: " + p.getUsuarioId());
			System.out.println("Data de cadastro: " + p.getDataCadastro().getTime());
			System.out.println("Endereço: " + p.getEndereco().getEndereco());
			System.out.println("Função: " + p.getFuncao().getNomeFuncao());
			System.out.println("----------");
		}
	}
	
	@Test
	public void test3UpdatePessoa(){
		Pessoa pessoa;
		try {
			pessoa = pessoaBusiness.getObjById(idTestPessoa);
			pessoa.setNome("Zezinho");
			pessoaBusiness.update(pessoa);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE");
		test2ListPessoa();
	}

	@Test
	public void test4DeletePessoa(){
		try {
			pessoaBusiness.delete(idTestPessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DELETE");
		test2ListPessoa();
	}
}