package br.com.smallbi.test;

import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.smallbi.business.FormaPagamentoBusiness;
import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.entity.FormaPagamento;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFormaPagamento {

	FormaPagamentoBusiness formaPagamentoBusiness = new FormaPagamentoBusiness();
	public static int idTestFormaPagamento;
	
	@Test
	public void test1CreateFormaPagamento(){
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setDataCadastro(Calendar.getInstance());
		formaPagamento.setFormaPagamento("Credit");
		formaPagamento.setUsuarioId(1);
		try {
			formaPagamentoBusiness.create(formaPagamento);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		idTestFormaPagamento = formaPagamento.getIdFormaPagamento();
	}
	
	@Test
	public void test2ListFormaPagamento(){
		List<FormaPagamento> formas = formaPagamentoBusiness.list();
		System.out.println("<<Formas de Pagamento>>");
		for(FormaPagamento f : formas){
			System.out.println("----------");
			System.out.println("Forma de pag: " + f.getFormaPagamento());
			System.out.println("Id: " + f.getIdFormaPagamento());
			System.out.println("Usuário: " + f.getUsuarioId());
			System.out.println("Data de cadastro: " + f.getDataCadastro().getTime());
			System.out.println("----------");
		}
	}
	
	@Test
	public void test3UpdateFormaPagamento(){
		try {
			FormaPagamento f = formaPagamentoBusiness.getObjById(idTestFormaPagamento);
			f.setFormaPagamento("Debit");
			formaPagamentoBusiness.update(f);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE");
		test2ListFormaPagamento();
	}
}
