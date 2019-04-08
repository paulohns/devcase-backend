package com.vsm.devcase;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author pauloneves
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "pontos")
	private Integer pontos;

	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	private List<Venda> vendas;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPontos() {
		return pontos;
	}
	
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public String getSexo() {
		return sexo;
	}

}
