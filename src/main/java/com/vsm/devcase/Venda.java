package com.vsm.devcase;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author pauloneves
 *
 */
@Entity
@Table(name = "vendas")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "data_venda")
	private LocalDate dataVenda;

	@Column(name = "valor_venda")
	private Float valorVenda;

	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JsonBackReference
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public Float getValorVenda() {
		return valorVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
