package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Funcao;

public class FuncaoBusiness implements InterfaceBusiness<Funcao>{

	InterfaceDao<Funcao> funcaoDao = FactoryDao.createFuncaoDao();
	
	@Override
	public void create(Funcao t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getNomeFuncao().equals(null) || t.getNomeFuncao().equals("")){
			throw new BusinessException("A variável 'nomeFuncao' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		funcaoDao.create(t);
	}

	@Override
	public List<Funcao> list() {
		List<Funcao> funcoes = new ArrayList<>();
		for(Funcao f : funcaoDao.list()){
			if(f.isStatus() == true){
				funcoes.add(f);
			}
		}
		return funcoes;
	}

	@Override
	public void update(Funcao t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}

		if(t.getIdFuncao() == null){
			throw new BusinessException("A variável 'idFuncao' deve ser informada!");
		}else{
			Funcao funcao = funcaoDao.getObjById(t.getIdFuncao());
			if(funcao == null){
				throw new BusinessException("Nenhum resultado para a variável 'funcao' foi encontrado!");
			}
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getNomeFuncao().equals(null) || t.getNomeFuncao().equals("")){
			throw new BusinessException("A variável 'nomeFuncao' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		funcaoDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Funcao funcao = funcaoDao.getObjById(id);
		if(funcao == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Funcao'!");
		}
		funcaoDao.delete(funcao);
	}

	@Override
	public Funcao getObjById(Integer id) throws BusinessException {
		Funcao funcao = funcaoDao.getObjById(id);
		if(funcao == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Funcao'!");
		}
		return funcao;
	}

}
