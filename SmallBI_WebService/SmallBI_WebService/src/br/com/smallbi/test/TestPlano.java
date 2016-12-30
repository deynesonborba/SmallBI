package br.com.smallbi.test;

import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.smallbi.business.PlanoBusiness;
import br.com.smallbi.entity.Plano;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPlano {

	PlanoBusiness planoBusiness = new PlanoBusiness();
	public static int idTestPlano;
	
	@Test
	public void test1CreatePlano(){
		Plano plano = new Plano();
		plano.setDataCadastro(Calendar.getInstance());
		plano.setNomePlano("Cheap plan");
		plano.setStatus(true);
		plano.setUsuarioId(1);
		
		planoBusiness.create(plano);
		idTestPlano = plano.getIdPlano();
	}
	
	@Test
	public void test2ListPlano(){
		List<Plano> planos = planoBusiness.list();
		System.out.println("<<Planos>>");
		for(Plano p : planos){
			System.out.println("----------");
			System.out.println("Descrição: " + p.getNomePlano());
			System.out.println("Id: " + p.getIdPlano());
			System.out.println("Usuário: " + p.getUsuarioId());
			System.out.println("Data de cadastro: " + p.getDataCadastro().getTime());
			System.out.println("----------");
		}
	}
	
	@Test
	public void test3UpdatePlano(){
		Plano p = planoBusiness.getObjById(idTestPlano);
		p.setNomePlano("Expensive plan");
		planoBusiness.update(p);
		System.out.println("UPDATE");
		test2ListPlano();
	}

	@Test
	public void test4DeletePlano(){
		planoBusiness.delete(idTestPlano);
		System.out.println("DELETE");
		test2ListPlano();
	}
}
