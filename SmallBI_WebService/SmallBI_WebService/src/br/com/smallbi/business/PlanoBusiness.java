package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Plano;

public class PlanoBusiness implements InterfaceBusiness<Plano>{

	InterfaceDao<Plano> planoDao = FactoryDao.createPlanoDao();
	
	@Override
	public void create(Plano t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getDescricao().equals(null) || t.getDescricao().equals("")){
			throw new BusinessException("A variável 'descricao' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		planoDao.create(t);
	}

	@Override
	public List<Plano> list() {
		List<Plano> planos = new ArrayList<>();
		for(Plano p : planoDao.list()){
			if(p.isStatus() == true){
				planos.add(p);
			}
		}
		return planos;
	}

	@Override
	public void update(Plano t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getIdPlano() == null){
			throw new BusinessException("A variável 'idPlano' deve ser informada!");
		}else{
			Plano plano = planoDao.getObjById(t.getIdPlano());
			if(plano == null){
				throw new BusinessException("Nenhum resultado para a variável 'plano' foi encontrado!");
			}
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getDescricao().equals(null) || t.getDescricao().equals("")){
			throw new BusinessException("A variável 'descricao' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		planoDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Plano plano = planoDao.getObjById(id);
		if(plano == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Plano'!");
		}
		planoDao.delete(plano);
	}

	@Override
	public Plano getObjById(Integer id) throws BusinessException {
		Plano plano = planoDao.getObjById(id);
		if(plano == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Plano'!");
		}
		return plano;
	}

}
