package com.vsm.devcase.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsm.devcase.FiltroForm;
import com.vsm.devcase.Venda;
import com.vsm.devcase.repository.VendaRepository;

/**
 * @author pauloneves
 *
 */
@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Override
	public Venda update(Venda venda) {
		return vendaRepository.save(venda);
	}

	@Override
	public void delete(Venda venda) {
		 vendaRepository.delete(venda);
	}

	@Override
	public List<Venda> findByDate(LocalDate datainicial, LocalDate datafinal) {
		return vendaRepository.findByDate(datainicial, datafinal);
	}

	@Override
	public List<Venda> findBySexo(String sexo) {
		return vendaRepository.findBySexo(sexo);
	}

	@Override
	public Venda save(Venda venda) {
		
		if(venda.getValorVenda() >= 1 && venda.getValorVenda() <= 50) {
			venda.getCliente().setPontos(venda.getCliente().getPontos() + 5);
		} else if(venda.getValorVenda() > 50 && venda.getValorVenda() <= 100) {
			venda.getCliente().setPontos(venda.getCliente().getPontos() + 10);
		} else if(venda.getValorVenda() > 100) {
			venda.getCliente().setPontos(venda.getCliente().getPontos() + 15);
		}
		
		return vendaRepository.save(venda);
	}

	@Override
	public List<Venda> findAll() {
		return (List<Venda>) vendaRepository.findAll();
	}

}
