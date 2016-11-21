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
public class RamoAtividade {

	@Id
	@SequenceGenerator(name="seq_ramoAtividade", sequenceName="seq_ramoAtividade_id", allocationSize=1)
	@GeneratedValue(generator="seq_ramoAtividade", strategy=GenerationType.SEQUENCE)
	private Integer idRamoAtividade;
	
	@NotNull(message="Hibernate Validator: A dataCadastro não pode ser null!")
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;
	
	@NotNull(message="Hibernate Validator: O usuario não pode ser null!")
	@Column(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Length(max=10, message="Hibernate Validator: O ramoAtividade não pode conter mais de {max} caracteres!")
	@NotBlank(message="Hibernate Validator: O ramoAtividade não pode estar em branco!")
	@NotNull(message="Hibernate Validator: O ramoAtividade não pode ser null!")
	@Column(name="ramoAtividade", nullable=false, length=10)
	private String ramoAtividade;

	public Integer getIdRamoAtividade() {
		return idRamoAtividade;
	}

	public void setIdRamoAtividade(Integer idRamoAtividade) {
		this.idRamoAtividade = idRamoAtividade;
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

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	
}