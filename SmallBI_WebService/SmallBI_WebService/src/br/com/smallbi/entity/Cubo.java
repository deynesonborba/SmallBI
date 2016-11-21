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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

@Entity
public class Cubo {

	@Id
	@SequenceGenerator(name="seq_cubo", sequenceName="seq_cubo_id", allocationSize=1)
	@GeneratedValue(generator="seq_cubo", strategy=GenerationType.SEQUENCE)
	private Integer idCubo;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O nomeCubo não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O nomeCubo não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nomeCubo não pode ser null!")
	@Column(name="nomeCubo", nullable=false, length=30)
	private String nomeCubo;
	
	@NotNull(message="Hibernate Validator: O cliente não pode ser null!")
	@Column(name="cliente", nullable=false)
	private Empresa empresa;
	
	@NotNull(message="Hibernate Validator: O mdx não pode ser null!")
	@Column(name="mdx", nullable=false)
	private Text mdx;
	
	@NotBlank(message="Hibernate Validator: O nomeCubo não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nomeCubo não pode ser null!")
	@Column(name="nomeCubo", nullable=false)
	private String tabelaFato;
	
	@NotNull(message="Hibernate Validator: O tamanho não pode ser null!")
	@Column(name="tamanho", nullable=false)
	private int tamanho;

	public Integer getIdCubo() {
		return idCubo;
	}

	public void setIdCubo(Integer idCubo) {
		this.idCubo = idCubo;
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

	public String getNomeCubo() {
		return nomeCubo;
	}

	public void setNomeCubo(String nomeCubo) {
		this.nomeCubo = nomeCubo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Text getMdx() {
		return mdx;
	}

	public void setMdx(Text mdx) {
		this.mdx = mdx;
	}

	public String getTabelaFato() {
		return tabelaFato;
	}

	public void setTabelaFato(String tabelaFato) {
		this.tabelaFato = tabelaFato;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
