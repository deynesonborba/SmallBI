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
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Pessoa {

	@Id
	@SequenceGenerator(name="seq_pessoa", sequenceName="seq_pessoa_id", allocationSize=1)
	@GeneratedValue(generator="seq_pessoa", strategy=GenerationType.SEQUENCE)
	private Integer idPessoa;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O nome não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O nome não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nome não pode ser null!")
	@Column(name="nome", nullable=false, length=30)
	private String nome;
	
	@CPF
	@NotNull(message="Hibernate Validator: O cpf não pode ser null!")
	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Length(max=12, message="Hibernate Validator: O rg não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O rg não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O rg não pode ser null!")
	@Column(name="rg", nullable=false, length=12)
	private String rg;
	
	@NotNull(message="Hibernate Validator: O cliente não pode ser null!")
	@Column(name="cliente", nullable=false)
	private Empresa empresa;
	
	@NotNull(message="Hibernate Validator: A funcao não pode ser null!")
	@Column(name="funcao", nullable=false)
	private Funcao funcao;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
}
