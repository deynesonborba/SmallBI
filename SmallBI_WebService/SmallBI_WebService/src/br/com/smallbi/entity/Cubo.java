package br.com.smallbi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Cubo {

	@Id
	private Integer idCubo;
	
	private Calendar dataCadastro;
	
	private Integer usuarioId;
	
	@Column (length=40)
	private String nomeCubo;
	
	@ManyToOne
	@JoinColumn(name="clienteId", referencedColumnName="idCliente")
	@ForeignKey(name="fk_cliente")
	private Cliente cliente;
	
	@Column(name = "mdx", columnDefinition = "xml")
	private String mdx;
	
	@Column (length=25)
	private String tabelaFato;
	
	private Integer tamanho;

	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeCubo() {
		return nomeCubo;
	}

	public void setNomeCubo(String nomeCubo) {
		this.nomeCubo = nomeCubo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMdx() {
		return mdx;
	}

	public void setMdx(String mdx) {
		this.mdx = mdx;
	}

	public String getTabelaFato() {
		return tabelaFato;
	}

	public void setTabelaFato(String tabelaFato) {
		this.tabelaFato = tabelaFato;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	
	
	
}
