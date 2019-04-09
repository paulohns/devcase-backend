package com.vsm.devcase.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseBody registrarVenda(@RequestBody Venda venda) {
		return (ResponseBody) vendaService.registrarVenda(venda);
	}

	/**
	 * Registrar uma venda
	 * 
	 * @return
	 */
	@PostMapping("/clientes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseBody getAllClientes() {
		return (ResponseBody) vendaService.getAllClientes();
	}

	/**
	 * Lista as vendas filtradas por data
	 * 
	 * @return
	 */
	@RequestMapping("/vendas/filtrodata")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Venda> listVendasPorData(
			@RequestParam(name = "dataInicial") @DateTimeFormat(iso = ISO.DATE) LocalDate dataInicial,
			@RequestParam(name = "dataFinal") @DateTimeFormat(iso = ISO.DATE) LocalDate dataFinal) {
		return (List<Venda>) this.vendaService.findByDate(dataInicial, dataFinal);
	}

	/**
	 * Lista as vendas filtradas por sexo
	 * 
	 * @return
	 */
	@RequestMapping(path = "/vendas/filtrosexo", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Venda> listVendasPorSexo(@RequestParam String sexo) {
		return (List<Venda>) this.vendaService.findBySexo(sexo);
	}
	
	
	@GetMapping("/vendas")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Venda> getVendas() {
	    return vendaService.findAll().stream()
	            .collect(Collectors.toList());
	}

}
