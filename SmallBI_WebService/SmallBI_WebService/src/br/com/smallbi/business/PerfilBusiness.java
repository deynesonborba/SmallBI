package br.com.smallbi.business;

import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Perfil;

public class PerfilBusiness implements InterfaceBusiness<Perfil>{

	InterfaceDao<Perfil> perfilDao = FactoryDao.createPerfilDao();
	
	@Override
	public void create(Perfil t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getNomePerfil().equals(null) || t.getNomePerfil().equals("")){
			throw new BusinessException("A variável 'nomePerfil' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		perfilDao.create(t);
	}

	@Override
	public List<Perfil> list() {
		return perfilDao.list();
	}

	@Override
	public void update(Perfil t) throws BusinessException {

		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getNomePerfil().equals(null) || t.getNomePerfil().equals("")){
			throw new BusinessException("A variável 'nomePerfil' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		perfilDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Perfil perfil = perfilDao.getObjById(id);
		if(perfil == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Perfil'!");
		}
		perfilDao.delete(perfil);
	}

	@Override
	public Perfil getObjById(Integer id) throws BusinessException {
		Perfil perfil = perfilDao.getObjById(id);
		if(perfil == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Perfil'!");
		}
		return perfil;
	}

}
