package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Cidade;
import br.com.smallbi.entity.Endereco;
import br.com.smallbi.entity.Tipo;

public class EnderecoBusiness implements InterfaceBusiness<Endereco>{

	InterfaceDao<Endereco> enderecoDao = FactoryDao.createEnderecoDao();
	InterfaceDao<Cidade> cidadeDao = FactoryDao.createCidadeDao();
	InterfaceDao<Tipo> tipoDao = FactoryDao.createTipoDao();
	
	@Override
	public void create(Endereco t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getBairro().equals(null) || t.getBairro().equals("")){
			throw new BusinessException("A variável 'bairro' deve ser informada!");
		}
		
		if(t.getCidade() != null){
			if(t.getCidade().getIdCidade() != null){
				Cidade cidade = cidadeDao.getObjById(t.getCidade().getIdCidade());
				if(cidade == null){
					throw new BusinessException("Nenhum resultado para a variável 'cidade' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'cidade.idCidade' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'cidade' deve ser informada!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getEndereco().equals(null) || t.getEndereco().equals("")){
			throw new BusinessException("A variável 'endereco' deve ser informada!");
		}
		
		if(t.getNumero() == null){
			throw new BusinessException("A variável 'numero' deve ser informada!");
		}
		
		if(t.getTipo() != null){
			if(t.getTipo().getIdTipo() != null){
				Tipo tipo = tipoDao.getObjById(t.getTipo().getIdTipo());
				if(tipo == null){
					throw new BusinessException("Nenhum resultado para a variável 'tipo' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'tipo.idTipo' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'tipo' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		enderecoDao.create(t);
	}

	@Override
	public List<Endereco> list() {
		List<Endereco> enderecos = new ArrayList<>();
		for(Endereco e : enderecoDao.list()){
			if(e.isStatus() == true){
				enderecos.add(e);
			}
		}
		return enderecos;
	}

	@Override
	public void update(Endereco t) throws BusinessException {

		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getIdEndereco() == null){
			throw new BusinessException("A variável 'idEndereco' deve ser informada!");
		}else{
			Endereco endereco = enderecoDao.getObjById(t.getIdEndereco());
			if(endereco == null){
				throw new BusinessException("Nenhum resultado para a variável 'endereco' foi encontrado!");
			}
		}
		
		if(t.getBairro().equals(null) || t.getBairro().equals("")){
			throw new BusinessException("A variável 'bairro' deve ser informada!");
		}
		
		if(t.getCidade() != null){
			if(t.getCidade().getIdCidade() != null){
				Cidade cidade = cidadeDao.getObjById(t.getCidade().getIdCidade());
				if(cidade == null){
					throw new BusinessException("Nenhum resultado para a variável 'cidade' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'cidade.idCidade' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'cidade' deve ser informada!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getEndereco().equals(null) || t.getEndereco().equals("")){
			throw new BusinessException("A variável 'endereco' deve ser informada!");
		}
		
		if(t.getNumero() == null){
			throw new BusinessException("A variável 'numero' deve ser informada!");
		}
		
		if(t.getTipo() != null){
			if(t.getTipo().getIdTipo() != null){
				Tipo tipo = tipoDao.getObjById(t.getTipo().getIdTipo());
				if(tipo == null){
					throw new BusinessException("Nenhum resultado para a variável 'tipo' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'tipo.idTipo' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'tipo' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		enderecoDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Endereco endereco = enderecoDao.getObjById(id);
		if(endereco == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Endereco'!");
		}
		enderecoDao.delete(endereco);
	}

	@Override
	public Endereco getObjById(Integer id) throws BusinessException {
		Endereco endereco = enderecoDao.getObjById(id);
		if(endereco == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Endereco'!");
		}
		return endereco;
	}

}
