package br.com.smallbi.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.smallbi.business.interfaceBusiness.InterfaceBusiness;
import br.com.smallbi.dal.factory.FactoryDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Cidade;
import br.com.smallbi.entity.Estado;
import br.com.smallbi.entity.Usuario;

public class CidadeBusiness implements InterfaceBusiness<Cidade>{

	InterfaceDao<Cidade> cidadeDao = FactoryDao.createCidadeDao();
	InterfaceDao<Usuario> usuarioDao = FactoryDao.createUsuarioDao();
	InterfaceDao<Estado> estadoDao = FactoryDao.createEstadoDao();
	
	@Override
	public String create(Cidade t){
		
		if(t == null){
			//throw new BusinessException("O objeto não pode ser null!");
			return "O objeto não pode ser null!";
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getIdCidade() != null){
			return "A variavel ID não pode ser informada na criação de um novo objeto!";
		}
		
		if(t.getEstado() != null){
			if(t.getEstado().getIdEstado() != null){
				Estado estado = estadoDao.getObjById(t.getEstado().getIdEstado());
				if(estado == null){
					//throw new BusinessException("Nenhum resultado para a variável 'estado' foi encontrado!");
					return "Nenhum resultado para a variável 'estado' foi encontrado!";
				}
			}else{
				//throw new BusinessException("A variável 'estado.idEstado' deve ser informada!");
				return "A variável 'estado.idEstado' deve ser informada!";
			}
		}else{
			//throw new BusinessException("A variável 'estado' deve ser informada!");
			return "A variável 'estado' deve ser informada!";
		}
		
		if(t.getNomeCidade().equals(null) || t.getNomeCidade().equals("")){
			//throw new BusinessException("A variável 'nomeCidade' deve ser informada!");
			return "A variável 'nomeCidade' deve ser informada!";
		}
		
		if(t.getSiglaCidade().equals(null) || t.getSiglaCidade().equals("")){
			//throw new BusinessException("A variável 'siglaCidade' deve ser informada!");
			return "A variável 'siglaCidade' deve ser informada!";
		}
		
		if(t.getUsuarioId() == null){
			//throw new BusinessException("A variável 'usuarioId' deve ser informada!");
			return "A variável 'usuarioId' deve ser informada!";
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		cidadeDao.create(t);
		return "Cidade cadastrada com sucesso!";
	}
	
	@Override
	public List<Cidade> list() {
		List<Cidade> cidades = new ArrayList<>();
		for(Cidade c : cidadeDao.list()){
			if(c.isStatus() == true){
				cidades.add(c);
			}
		}
		return cidades;
	}
	
	@Override
	public String update(Cidade t){

		if(t == null){
			//throw new BusinessException("O objeto não pode ser null!");
			return "O objeto não pode ser null!";
		}
		
		if(t.getIdCidade() == null){
			//throw new BusinessException("A variável 'idCidade' deve ser informada!");
			return "A variável 'idCidade' deve ser informada!";
		}else{
			Cidade cidade = cidadeDao.getObjById(t.getIdCidade());
			if(cidade == null){
				//throw new BusinessException("Nenhum resultado para a variável 'cidade' foi encontrado!");
				return "Nenhum resultado para a variável 'cidade' foi encontrado!";
			}
		}
		
/*		if(t.getDataCadastro() == null){
			throw new BusinessException("A variável 'dataCadastro' deve ser informada!");
		}*/
		
		if(t.getEstado() != null){
			if(t.getEstado().getIdEstado() != null){
				Estado estado = estadoDao.getObjById(t.getEstado().getIdEstado());
				if(estado == null){
					//throw new BusinessException("Nenhum resultado para a variável 'estado' foi encontrado!");
					return "Nenhum resultado para a variável 'estado' foi encontrado!";
				}
			}else{
				//throw new BusinessException("A variável 'estado.idEstado' deve ser informada!");
				return "A variável 'estado.idEstado' deve ser informada!";
			}
		}else{
			//throw new BusinessException("A variável 'estado' deve ser informada!");
			return "A variável 'estado' deve ser informada!";
		}
		
		if(t.getNomeCidade().equals(null) || t.getNomeCidade().equals("")){
			//throw new BusinessException("A variável 'nomeCidade' deve ser informada!");
			return "A variável 'nomeCidade' deve ser informada!";
		}
		
		if(t.getSiglaCidade().equals(null) || t.getSiglaCidade().equals("")){
			//throw new BusinessException("A variável 'siglaCidade' deve ser informada!");
			return "A variável 'siglaCidade' deve ser informada!";
		}
		
		if(t.getUsuarioId() == null){
			//throw new BusinessException("A variável 'usuarioId' deve ser informada!");
			return "A variável 'usuarioId' deve ser informada!";
		}
		
		t.setDataCadastro(Calendar.getInstance());
		t.setStatus(true);
		
		cidadeDao.update(t);
		return "Cidade alterada com sucesso!";
	}
	
	@Override
	public String delete(Integer id){
		Cidade cidade = cidadeDao.getObjById(id);
		if(cidade == null){
			//throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Cidade'!");
			return "Nenhum resultado foi encontrado para o objeto do tipo 'Cidade'!";
		}
		cidadeDao.delete(cidade);
		return "Cidade deletada com sucesso!";
	}
	@Override
	public Cidade getObjById(Integer id){
		Cidade cidade = cidadeDao.getObjById(id);
		if(cidade == null){
			//throw new BusinessException("Nenhum resultado foi encontrado para o objeto do tipo 'Cidade'!");
		}
		return cidade;
	}
}
