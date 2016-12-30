package br.com.smallbi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Endereco {

	@Id
	private Integer idEndereco;
	
	private Calendar dataCadastro;

	private Integer usuarioId;
	
	@Column (length=120)
	private String endereco;
	
	@Column(name = "numero", columnDefinition = "int4")
	private String numero;
	
	@Column (length=60)
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name="cidadeId", referencedColumnName="idCidade")
	@ForeignKey(name="fk_cidade")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name="pessoaId", referencedColumnName="idPessoa")
	@ForeignKey(name="fk_pessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name="tipoId", referencedColumnName="idTipo")
	@ForeignKey(name="fk_tipo")
	private Tipo tipo;
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
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
	

	

	
	
}
