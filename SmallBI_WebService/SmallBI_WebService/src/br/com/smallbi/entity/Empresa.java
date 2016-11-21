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
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Empresa {

	@Id
	@SequenceGenerator(name="seq_empresa", sequenceName="seq_empresa_id", allocationSize=1)
	@GeneratedValue(generator="seq_empresa", strategy=GenerationType.SEQUENCE)
	private Integer idEmpresa;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: A razaoSocial não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: A razaoSocial não pode estar em branco!")
	@NotNull(message="Hibernate Validator: A razaoSocial não pode ser null!")
	@Column(name="razaoSocial", nullable=false, length=30)
	private String razaoSocial;
	
	@Length(max=30, message="Hibernate Validator: O nomeFantasia não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O nomeFantasia não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nomeFantasia não pode ser null!")
	@Column(name="nomeFantasia", nullable=false, length=30)
	private String nomeFantasia;
	
	@CNPJ
	@NotNull(message="Hibernate Validator: O cnpj não pode ser null!")
	@Column(name="cnpj", nullable=false)
	private String cnpj;
	
	@Length(max=30, message="Hibernate Validator: O ie não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O ie não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O ie não pode ser null!")
	@Column(name="ie", nullable=false, length=30)
	private String ie;
	
	@NotNull(message="Hibernate Validator: O endereco não pode ser null!")
	@Column(name="endereco", nullable=false)
	private Endereco endereco;
	
	@NotNull(message="Hibernate Validator: O ramoAtividade não pode ser null!")
	@Column(name="ramoAtividade", nullable=false)
	private RamoAtividade ramoAtividade;
	
	@NotNull(message="Hibernate Validator: O tamanhoTotal não pode ser null!")
	@Column(name="tamanhoTotal", nullable=false)
	private int tamanhoTotal;
	
	@NotNull(message="Hibernate Validator: A formaPagamento não pode ser null!")
	@Column(name="formaPagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@NotNull(message="Hibernate Validator: O plano não pode ser null!")
	@Column(name="plano", nullable=false)
	private Plano plano;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public int getTamanhoTotal() {
		return tamanhoTotal;
	}

	public void setTamanhoTotal(int tamanhoTotal) {
		this.tamanhoTotal = tamanhoTotal;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
}