package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Empresa;
import br.com.smallbi.entity.Pessoa;
import br.com.smallbi.entity.Telefone;
import br.com.smallbi.entity.Tipo;

public class TelefoneBusiness implements InterfaceBusiness<Telefone>{

	InterfaceDao<Telefone> telefoneDao = FactoryDao.createTelefoneDao();
	InterfaceDao<Empresa> empresaDao = FactoryDao.createEmpresaDao();
	InterfaceDao<Pessoa> pessoaDao = FactoryDao.createPessoaDao();
	InterfaceDao<Tipo> tipoDao = FactoryDao.createTipoDao();
	
	@Override
	public void create(Telefone t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getDdd().equals(null) || t.getDdd().equals("")){
			throw new BusinessException("A variável 'ddd' deve ser informada!");
		}
		
		if(t.getEmpresa() != null){
			if(t.getEmpresa().getIdEmpresa() != null){
				Empresa empresa = empresaDao.getObjById(t.getEmpresa().getIdEmpresa());
				if(empresa == null){
					throw new BusinessException("Nenhum resultado para a variável 'empresa' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'empresa.idEmpresa' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'empresa' deve ser informada!");
		}
		
		if(t.getPessoa() != null){
			if(t.getPessoa().getIdPessoa() != null){
				Pessoa pessoa = pessoaDao.getObjById(t.getPessoa().getIdPessoa());
				if(pessoa == null){
					throw new BusinessException("Nenhum resultado para a variável 'pessoa' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'pessoa.idPessoa' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'pessoa' deve ser informada!");
		}
		
		if(t.getTelefone().equals(null) || t.getTelefone().equals("")){
			throw new BusinessException("A variável 'telefone' deve ser informada!");
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
		
		telefoneDao.create(t);
	}

	@Override
	public List<Telefone> list() {
		List<Telefone> telefones = new ArrayList<>();
		for(Telefone t : telefoneDao.list()){
			if(t.isStatus() == true){
				telefones.add(t);
			}
		}
		return telefones;
	}

	@Override
	public void update(Telefone t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getDdd().equals(null) || t.getDdd().equals("")){
			throw new BusinessException("A variável 'ddd' deve ser informada!");
		}
		
		if(t.getEmpresa() != null){
			if(t.getEmpresa().getIdEmpresa() != null){
				Empresa empresa = empresaDao.getObjById(t.getEmpresa().getIdEmpresa());
				if(empresa == null){
					throw new BusinessException("Nenhum resultado para a variável 'empresa' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'empresa.idEmpresa' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'empresa' deve ser informada!");
		}
		
		if(t.getPessoa() != null){
			if(t.getPessoa().getIdPessoa() != null){
				Pessoa pessoa = pessoaDao.getObjById(t.getPessoa().getIdPessoa());
				if(pessoa == null){
					throw new BusinessException("Nenhum resultado para a variável 'pessoa' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'pessoa.idPessoa' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'pessoa' deve ser informada!");
		}
		
		if(t.getTelefone().equals(null) || t.getTelefone().equals("")){
			throw new BusinessException("A variável 'telefone' deve ser informada!");
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
		
		telefoneDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Telefone telefone = telefoneDao.getObjById(id);
		if(telefone == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Telefone'!");
		}
		telefoneDao.delete(telefone);
	}

	@Override
	public Telefone getObjById(Integer id) throws BusinessException {
		Telefone telefone = telefoneDao.getObjById(id);
		if(telefone == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Telefone'!");
		}
		return telefone;
	}

}