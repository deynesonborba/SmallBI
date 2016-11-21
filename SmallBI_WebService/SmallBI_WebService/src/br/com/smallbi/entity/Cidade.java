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
public class Cidade {
	
	@Id
	@SequenceGenerator(name="seq_cidade", sequenceName="seq_cidade_id", allocationSize=1)
	@GeneratedValue(generator="seq_cidade", strategy=GenerationType.SEQUENCE)
	private Integer idCidade;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O nomeCidade não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O nomeCidade não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nomeCidade não pode ser null!")
	@Column(name="nomeCidade", nullable=false, length=30)
	private String nomeCidade;
	
	@Length(max=4, message="Hibernate Validator: A siglaCidade não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: A siglaCidade não pode estar em branco!")
	@NotNull(message="Hibernate Validator: A siglaCidade não pode ser null!")
	@Column(name="siglaCidade", nullable=false, length=4)
	private String siglaCidade;
	
	@NotNull(message="Hibernate Validator: O estado não pode ser null")
	@Column(name="estado", nullable=false)
	private Estado estado;

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
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

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getSiglaCidade() {
		return siglaCidade;
	}

	public void setSiglaCidade(String siglaCidade) {
		this.siglaCidade = siglaCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
