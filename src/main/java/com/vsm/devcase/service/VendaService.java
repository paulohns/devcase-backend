package com.vsm.devcase.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.vsm.devcase.Cliente;
import com.vsm.devcase.Venda;

/**
 * @author pauloneves
 *
 */
public interface VendaService {

	public Venda registrarVenda(Venda venda);
	public Venda update(Venda venda);
	public void delete(Venda venda);
	public List<Venda> findBySexo(String sexo);
	public List<Venda> findAll();
	public List<Venda> findByDate(LocalDate datainicial, LocalDate datafinal);
	public List<Cliente> getAllClientes();
	
}
