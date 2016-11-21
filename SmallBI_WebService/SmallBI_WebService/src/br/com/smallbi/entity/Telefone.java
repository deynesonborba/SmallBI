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
public class Telefone {
	
	@Id
	@SequenceGenerator(name="seq_telefone", sequenceName="seq_telefone_id", allocationSize=1)
	@GeneratedValue(generator="seq_telefone", strategy=GenerationType.SEQUENCE)
	private Integer idTelefone;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@NotNull(message="Hibernate Validator: O tipo não pode ser null!")
	@Column(name="tipo", nullable=false)
	private Tipo tipo;
	
	@Length(max=2, message="Hibernate Validator: O ddd não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O ddd não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O ddd não pode ser null!")
	@Column(name="ddd", nullable=false, length=2)
	private String ddd;
	
	@Length(max=10, message="Hibernate Validator: O telefone não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O telefone não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O telefone não pode ser null!")
	@Column(name="ddd", nullable=false, length=10)
	private String telefone;
	
	@NotNull(message="Hibernate Validator: A pessoa não pode ser null!")
	@Column(name="pessoa", nullable=false)
	private Pessoa pessoa;
	
	@NotNull(message="Hibernate Validator: O cliente não pode ser null!")
	@Column(name="cliente", nullable=false)
	private Empresa empresa;

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	
	
}