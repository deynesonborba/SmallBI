package br.com.smallbi.business;

import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Tipo;

public class TipoBusiness implements InterfaceBusiness<Tipo>{

	InterfaceDao<Tipo> tipoDao = FactoryDao.createTipoDao();
	
	@Override
	public void create(Tipo t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getTipo().equals(null) || t.getTipo().equals("")){
			throw new BusinessException("A variável 'tipo' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		tipoDao.create(t);
	}

	@Override
	public List<Tipo> list() {
		return tipoDao.list();
	}

	@Override
	public void update(Tipo t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getTipo().equals(null) || t.getTipo().equals("")){
			throw new BusinessException("A variável 'tipo' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		tipoDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Tipo tipo = tipoDao.getObjById(id);
		if(tipo == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Tipo'!");
		}
		tipoDao.delete(tipo);
	}

	@Override
	public Tipo getObjById(Integer id) throws BusinessException {
		Tipo tipo = tipoDao.getObjById(id);
		if(tipo == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Tipo'!");
		}
		return tipo;
	}

}
