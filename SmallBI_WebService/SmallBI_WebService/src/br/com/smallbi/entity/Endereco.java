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
public class Endereco {

	@Id
	@SequenceGenerator(name="seq_endereco", sequenceName="seq_endereco_id", allocationSize=1)
	@GeneratedValue(generator="seq_endereco", strategy=GenerationType.SEQUENCE)
	private Integer idEndereco;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O endereco não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O endereco não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O endereco não pode ser null!")
	@Column(name="endereco", nullable=false, length=30)
	private String endereco;
	
	@Length(max=10, message="Hibernate Validator: O numero não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O numero não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O numero não pode ser null!")
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Length(max=30, message="Hibernate Validator: O bairro não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O bairro não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O bairro não pode ser null!")
	@Column(name="bairro", nullable=false, length=30)
	private String bairro;
	
	@NotNull(message="Hibernate Validator: A cidade não pode ser null!")
	@Column(name="cidade", nullable=false)
	private Cidade cidade;
	
	@NotNull(message="Hibernate Validator: A pessoa não pode ser null!")
	@Column(name="pessoa", nullable=false)
	private Pessoa pessoa;
	
	@NotNull(message="Hibernate Validator: O tipo não pode ser null!")
	@Column(name="tipo", nullable=false)
	private Tipo tipo;
	
	@NotNull(message="Hibernate Validator: O cliente não pode ser null!")
	@Column(name="cliente", nullable=false)
	private Empresa empresa;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}