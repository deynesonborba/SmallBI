package br.com.smallbi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@SequenceGenerator(name="seq_usuario", sequenceName="seq_usuario_id", allocationSize=1)
	@GeneratedValue(generator="seq_usuario", strategy=GenerationType.SEQUENCE)
	private Integer idUsuario;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O login não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O login não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O login não pode ser null!")
	@Column(name="login", nullable=false, length=30)
	private String login;
	
	@Length(max=20, message="Hibernate Validator: A senha não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: A senha não pode estar em branco!")
	@NotNull(message="Hibernate Validator: A senha não pode ser null!")
	@Column(name="senha", nullable=false, length=20)
	private String senha;
	
	@NotNull(message="Hibernate Validator: O perfil não pode ser null!")
	@Column(name="perfil", nullable=false)
	private Perfil perfil;
	
	@NotNull(message="Hibernate Validator: A pessoa não pode ser null!")
	@Column(name="pessoa", nullable=false)
	private Pessoa pessoa;
	
	@NotNull(message="Hibernate Validator: O cliente não pode ser null!")
	@Column(name="cliente", nullable=false)
	private Empresa empresa;
	
	@Length(max=30, message="Hibernate Validator: O usuarioSaiku não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O usuarioSaiku não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O usuarioSaiku não pode ser null!")
	@Column(name="usuarioSaiku", nullable=false, length=30)
	private String usuarioSaiku;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getUsuarioSaiku() {
		return usuarioSaiku;
	}

	public void setUsuarioSaiku(String usuarioSaiku) {
		this.usuarioSaiku = usuarioSaiku;
	}
	
	
}