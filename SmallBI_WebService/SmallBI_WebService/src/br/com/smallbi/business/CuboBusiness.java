package br.com.smallbi.business;

import java.util.List;

import br.com.smallbi.business.exception.BusinessException;
import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Cubo;
import br.com.smallbi.entity.Empresa;

public class CuboBusiness implements InterfaceBusiness<Cubo>{
	
	InterfaceDao<Cubo> cuboDao = FactoryDao.createCuboDao();
	InterfaceDao<Empresa> empresaDao = FactoryDao.createEmpresaDao();

	@Override
	public void create(Cubo t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
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
		
		if(t.getMdx().equals(null) || t.getMdx().equals("")){
			throw new BusinessException("A variável 'mdx' deve ser informada!");
		}
		
		if(t.getNomeCubo().equals(null) || t.getNomeCubo().equals("")){
			throw new BusinessException("A variável 'nomeCubo' deve ser informada!");
		}
		
		if(t.getTabelaFato().equals(null) || t.getTabelaFato().equals("")){
			throw new BusinessException("A variável 'tabelaFato' deve ser informada!");
		}
		
		if(t.getTamanho() == null){
			throw new BusinessException("A variável 'tamanho' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		cuboDao.create(t);
	}

	@Override
	public List<Cubo> list() {
		return cuboDao.list();
	}

	@Override
	public void update(Cubo t) throws BusinessException {
		
		if(t == null){
			throw new BusinessException("O objeto não pode ser null!");
		}
		
		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
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
		
		if(t.getMdx().equals(null) || t.getMdx().equals("")){
			throw new BusinessException("A variável 'mdx' deve ser informada!");
		}
		
		if(t.getNomeCubo().equals(null) || t.getNomeCubo().equals("")){
			throw new BusinessException("A variável 'nomeCubo' deve ser informada!");
		}
		
		if(t.getTabelaFato().equals(null) || t.getTabelaFato().equals("")){
			throw new BusinessException("A variável 'tabelaFato' deve ser informada!");
		}
		
		if(t.getTamanho() == null){
			throw new BusinessException("A variável 'tamanho' deve ser informada!");
		}
		
		if(t.getUsuarioId() == null){
			throw new BusinessException("A variável 'usuarioId' deve ser informada!");
		}
		
		cuboDao.update(t);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		Cubo cubo = cuboDao.getObjById(id);
		if(cubo == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Cubo'!");
		}
		cuboDao.delete(cubo);
	}

	@Override
	public Cubo getObjById(Integer id) throws BusinessException {
		Cubo cubo = cuboDao.getObjById(id);
		if(cubo == null){
			throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Cubo'!");
		}
		return cubo;
	}

}
