package com.vsm.devcase.service;

import java.time.LocalDate;
import java.util.List;

import com.vsm.devcase.FiltroForm;
import com.vsm.devcase.Venda;

/**
 * @author pauloneves
 *
 */
public interface VendaService {

	public Venda save(Venda venda);
	public Venda update(Venda venda);
	public void delete(Venda venda);
	public List<Venda> findBySexo(String sexo);
	public List<Venda> findAll();
	public List<Venda> findByDate(LocalDate datainicial, LocalDate datafinal);
	
}
