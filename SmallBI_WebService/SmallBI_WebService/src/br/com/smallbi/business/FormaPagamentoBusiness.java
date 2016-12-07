package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.FormaPagamento;

public class FormaPagamentoBusiness implements InterfaceBusiness<FormaPagamento>{

	InterfaceDao<FormaPagamento> formaPagamentoDao = FactoryDao.createFormaPagamentoDao();
	
	@Override
	public void create(FormaPagamento t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getFormaPagamento().equals(null) || t.getFormaPagamento().equals("")){
			throw new BusinessException("A variável 'formaPagamento' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		formaPagamentoDao.create(t);
	}

	@Override
	public List<FormaPagamento> list() {
		List<FormaPagamento> formas = new ArrayList<>();
		for(FormaPagamento f : formaPagamentoDao.list()){
			if(f.isStatus() == true){
				formas.add(f);
			}
		}
		return formas;
	}

	@Override
	public void update(FormaPagamento t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getFormaPagamento().equals(null) || t.getFormaPagamento().equals("")){
			throw new BusinessException("A variável 'formaPagamento' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		formaPagamentoDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		FormaPagamento formaPagamento = formaPagamentoDao.getObjById(id);
		if(formaPagamento == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'FormaPagamento'!");
		}
		formaPagamentoDao.delete(formaPagamento);
	}

	@Override
	public FormaPagamento getObjById(Integer id) throws BusinessException {
		FormaPagamento formaPagamento = formaPagamentoDao.getObjById(id);
		if(formaPagamento == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'FormaPagamento'!");
		}
		return formaPagamento;
	}

}