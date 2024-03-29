package br.com.smallbi.dal.factory;

import br.com.smallbi.dal.CidadeDao;
import br.com.smallbi.dal.CuboDao;
import br.com.smallbi.dal.ClienteDao;
import br.com.smallbi.dal.EnderecoDao;
import br.com.smallbi.dal.EstadoDao;
import br.com.smallbi.dal.FormaPagamentoDao;
import br.com.smallbi.dal.FuncaoDao;
import br.com.smallbi.dal.PerfilDao;
import br.com.smallbi.dal.PessoaDao;
import br.com.smallbi.dal.PlanoDao;
import br.com.smallbi.dal.RamoAtividadeDao;
import br.com.smallbi.dal.TelefoneDao;
import br.com.smallbi.dal.TipoDao;
import br.com.smallbi.dal.UsuarioDao;
import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.entity.Cidade;
import br.com.smallbi.entity.Cubo;
import br.com.smallbi.entity.Cliente;
import br.com.smallbi.entity.Endereco;
import br.com.smallbi.entity.Estado;
import br.com.smallbi.entity.FormaPagamento;
import br.com.smallbi.entity.Funcao;
import br.com.smallbi.entity.Perfil;
import br.com.smallbi.entity.Pessoa;
import br.com.smallbi.entity.Plano;
import br.com.smallbi.entity.RamoAtividade;
import br.com.smallbi.entity.Telefone;
import br.com.smallbi.entity.Tipo;
import br.com.smallbi.entity.Usuario;

public class FactoryDao {

	public static InterfaceDao<Cidade> createCidadeDao(){
		return new CidadeDao();
	}
	
	public static InterfaceDao<Cubo> createCuboDao(){
		return new CuboDao();
	}
	
	public static InterfaceDao<Cliente> createClienteDao(){
		return new ClienteDao();
	}
	
	public static InterfaceDao<Endereco> createEnderecoDao(){
		return new EnderecoDao();
	}
	
	public static InterfaceDao<Estado> createEstadoDao(){
		return new EstadoDao();
	}
	
	public static InterfaceDao<FormaPagamento> createFormaPagamentoDao(){
		return new FormaPagamentoDao();
	}
	
	public static InterfaceDao<Funcao> createFuncaoDao(){
		return new FuncaoDao();
	}
	
	public static InterfaceDao<Perfil> createPerfilDao(){
		return new PerfilDao();
	}
	
	public static InterfaceDao<Pessoa> createPessoaDao(){
		return new PessoaDao();
	}
	
	public static InterfaceDao<Plano> createPlanoDao(){
		return new PlanoDao();
	}
	
	public static InterfaceDao<RamoAtividade> createRamoAtividadeDao(){
		return new RamoAtividadeDao();
	}
	
	public static InterfaceDao<Telefone> createTelefoneDao(){
		return new TelefoneDao();
	}
	
	public static InterfaceDao<Tipo> createTipoDao(){
		return new TipoDao();
	}
	
	public static InterfaceDao<Usuario> createUsuarioDao(){
		return new UsuarioDao();
	}
}
