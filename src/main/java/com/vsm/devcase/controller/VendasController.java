package com.vsm.devcase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vsm.devcase.FiltroForm;
import com.vsm.devcase.Venda;
import com.vsm.devcase.service.VendaService;

/**
 * @author pauloneves
 *
 */
@RestController()
public class VendasController {

	@Autowired
	private VendaService vendaService;

	/**
	 * Registrar uma venda
	 * 
	 * @return
	 */
	@PostMapping("/vendas/registrarVenda")
	public ResponseBody registrarVenda(@RequestBody Venda venda) {
		return (ResponseBody) vendaService.save(venda);
	}

	/**
	 * Lista as vendas filtradas por data
	 * 
	 * @return
	 */
	@RequestMapping("/vendas/filtrodata")
	public List<Venda> listVendasPorData(@RequestBody FiltroForm filtro) {
		return (List<Venda>) this.vendaService.findByDate(filtro.getDatainicial(), filtro.getDatafinal());
	}

	/**
	 * Lista as vendas filtradas por sexo
	 * 
	 * @return
	 */
	@RequestMapping("/vendas/filtrosexo")
	public List<Venda> listVendasPorSexo(@RequestBody FiltroForm filtro) {
		return (List<Venda>) this.vendaService.findBySexo(filtro.getSexo());
	}

}
