package br.com.smallbi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Usuario {

	@Id
	private Integer idUsuario;
	
	private Calendar dataCadastro;
	
	private Integer usuarioId;
	
	@Column (length=25)
	private String login;
	
	@Column (length=25)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="perfilId", referencedColumnName="idPerfil")
	@ForeignKey(name="fk_perfil")
	private Perfil perfil;
	
	@OneToOne
	@JoinColumn(name="pessoaId", referencedColumnName="idPessoa")
	@ForeignKey(name="fk_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="clienteId", referencedColumnName="idCliente")
	@ForeignKey(name="fk_cliente")
	private Cliente cliente;
	
	private String usuarioSaiku;
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getUsuarioSaiku() {
		return usuarioSaiku;
	}

	public void setUsuarioSaiku(String usuarioSaiku) {
		this.usuarioSaiku = usuarioSaiku;
	}

	
	
	
}
