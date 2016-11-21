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
public class Estado {
	
	@Id
	@SequenceGenerator(name="seq_estado", sequenceName="seq_estado_id", allocationSize=1)
	@GeneratedValue(generator="seq_estado", strategy=GenerationType.SEQUENCE)
	private Integer idEstado;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=30, message="Hibernate Validator: O nomeEstado não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O nomeEstado não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O nomeEstado não pode ser null!")
	@Column(name="nomeEstado", nullable=false, length=30)
	private String nomeEstado;
	
	@Length(max=2, message="Hibernate Validator: A siglaEstado não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: A siglaEstado não pode estar em branco!")
	@NotNull(message="Hibernate Validator: A siglaEstado não pode ser null!")
	@Column(name="siglaEstado", nullable=false, length=2)
	private String siglaEstado;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
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

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	
	
	
}