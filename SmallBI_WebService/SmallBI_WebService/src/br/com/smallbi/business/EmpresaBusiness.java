package br.com.smallbi.business;

import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Empresa;
import br.com.smallbi.entity.Endereco;
import br.com.smallbi.entity.FormaPagamento;
import br.com.smallbi.entity.Plano;
import br.com.smallbi.entity.RamoAtividade;

public class EmpresaBusiness implements InterfaceBusiness<Empresa>{

	InterfaceDao<Empresa> empresaDao = FactoryDao.createEmpresaDao();
	InterfaceDao<Endereco> enderecoDao = FactoryDao.createEnderecoDao();
	InterfaceDao<FormaPagamento> formaPagamentoDao = FactoryDao.createFormaPagamentoDao();
	InterfaceDao<Plano> planoDao = FactoryDao.createPlanoDao();
	InterfaceDao<RamoAtividade> ramoAtividadeDao = FactoryDao.createRamoAtividadeDao();
	
	@Override
	public void create(Empresa t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getCnpj().equals(null) || t.getCnpj().equals("")){
			throw new BusinessException("A variável 'cnpj' deve ser informada!");
		}else{
			//validar cnpj
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getEndereco() != null){
			if(t.getEndereco().getIdEndereco() != null){
				Endereco endereco = enderecoDao.getObjById(t.getEndereco().getIdEndereco());
				if(endereco == null){
					throw new BusinessException("Nenhum resultado para a variável 'endereco' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'endereco.idEndereco' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'endereco' deve ser informada!");
		}
		
		if(t.getFormaPagamento() != null){
			if(t.getFormaPagamento().getIdFormaPagamento() != null){
				FormaPagamento formaPagamento = formaPagamentoDao.getObjById(t.getFormaPagamento().getIdFormaPagamento());
				if(formaPagamento == null){
					throw new BusinessException("Nenhum resultado para a variável 'FormaPagamento' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'formaPagamento.idFormaPagamento' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'formaPagamento' deve ser informada!");
		}
		
		if(t.getIe().equals(null) || t.getIe().equals("")){
			throw new BusinessException("A variável 'ie' deve ser informada!");
		}
		
		if(t.getNomeFantasia().equals(null) || t.getNomeFantasia().equals("")){
			throw new BusinessException("A variável 'nomeFantasia' deve ser informada!");
		}
		
		if(t.getPlano() != null){
			if(t.getPlano().getIdPlano() != null){
				Plano plano = planoDao.getObjById(t.getPlano().getIdPlano());
				if(plano == null){
					throw new BusinessException("Nenhum resultado para a variável 'Plano' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'plano.idPlano' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'plano' deve ser informada!");
		}
		
		if(t.getRamoAtividade() != null){
			if(t.getRamoAtividade().getIdRamoAtividade() != null){
				RamoAtividade ramoAtividade = ramoAtividadeDao.getObjById(t.getRamoAtividade().getIdRamoAtividade());
				if(ramoAtividade == null){
					throw new BusinessException("Nenhum resultado para a variável 'RamoAtividade' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'ramoAtividade.idRamoAtividade' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'ramoAtividade' deve ser informada!");
		}
		
		if(t.getRazaoSocial().equals(null) || t.getRazaoSocial().equals("")){
			throw new BusinessException("A variável 'razaoSocial' deve ser informada!");
		}
		
		if(t.getTamanhoTotal() == null){
			throw new BusinessException("A variável 'tamahoTotal' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		empresaDao.create(t);
	}

	@Override
	public List<Empresa> list() {
		return empresaDao.list();
	}

	@Override
	public void update(Empresa t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getCnpj().equals(null) || t.getCnpj().equals("")){
			throw new BusinessException("A variável 'cnpj' deve ser informada!");
		}else{
			//validar cnpj
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}
		
		if(t.getEndereco() != null){
			if(t.getEndereco().getIdEndereco() != null){
				Endereco endereco = enderecoDao.getObjById(t.getEndereco().getIdEndereco());
				if(endereco == null){
					throw new BusinessException("Nenhum resultado para a variável 'endereco' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'endereco.idEndereco' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'endereco' deve ser informada!");
		}
		
		if(t.getFormaPagamento() != null){
			if(t.getFormaPagamento().getIdFormaPagamento() != null){
				FormaPagamento formaPagamento = formaPagamentoDao.getObjById(t.getFormaPagamento().getIdFormaPagamento());
				if(formaPagamento == null){
					throw new BusinessException("Nenhum resultado para a variável 'FormaPagamento' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'formaPagamento.idFormaPagamento' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'formaPagamento' deve ser informada!");
		}
		
		if(t.getIe().equals(null) || t.getIe().equals("")){
			throw new BusinessException("A variável 'ie' deve ser informada!");
		}
		
		if(t.getNomeFantasia().equals(null) || t.getNomeFantasia().equals("")){
			throw new BusinessException("A variável 'nomeFantasia' deve ser informada!");
		}
		
		if(t.getPlano() != null){
			if(t.getPlano().getIdPlano() != null){
				Plano plano = planoDao.getObjById(t.getPlano().getIdPlano());
				if(plano == null){
					throw new BusinessException("Nenhum resultado para a variável 'Plano' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'plano.idPlano' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'plano' deve ser informada!");
		}
		
		if(t.getRamoAtividade() != null){
			if(t.getRamoAtividade().getIdRamoAtividade() != null){
				RamoAtividade ramoAtividade = ramoAtividadeDao.getObjById(t.getRamoAtividade().getIdRamoAtividade());
				if(ramoAtividade == null){
					throw new BusinessException("Nenhum resultado para a variável 'RamoAtividade' foi encontrado!");
				}
			}else{
				throw new BusinessException("A variável 'ramoAtividade.idRamoAtividade' deve ser informada!");
			}
		}else{
			throw new BusinessException("A variável 'ramoAtividade' deve ser informada!");
		}
		
		if(t.getRazaoSocial().equals(null) || t.getRazaoSocial().equals("")){
			throw new BusinessException("A variável 'razaoSocial' deve ser informada!");
		}
		
		if(t.getTamanhoTotal() == null){
			throw new BusinessException("A variável 'tamahoTotal' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		empresaDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Empresa empresa = empresaDao.getObjById(id);
		if(empresa == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Empresa'!");
		}
		empresaDao.delete(empresa);
	}

	@Override
	public Empresa getObjById(Integer id) throws BusinessException {
		Empresa empresa = empresaDao.getObjById(id);
		if(empresa == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Empresa'!");
		}
		return empresa;
	}

}
