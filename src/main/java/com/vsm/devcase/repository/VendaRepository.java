package com.vsm.devcase.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vsm.devcase.Venda;

/**
 * @author pauloneves
 *
 */
public interface VendaRepository extends CrudRepository<Venda, Long> {

	public static final String SELECT_VENDA_DATE = "SELECT venda FROM Venda venda WHERE venda.dataVenda BETWEEN :datainicial AND :datafinal ORDER BY venda.dataVenda asc";
	public static final String SELECT_VENDA_SEXO = "SELECT venda FROM Venda venda WHERE venda.cliente.sexo = :sexo ORDER BY venda.dataVenda asc";

	public List<Venda> findById(Integer id);
	
    /**
     * Busca as vendas filtrando por sexo
     * @param filtro
     * @return
     */
    @Query(SELECT_VENDA_SEXO)
    public List<Venda> findBySexo(@Param("sexo") String sexo);

    /**
     * Busca as vendas filtrando por data
     * @param filtro
     * @return
     */
    @Query(SELECT_VENDA_DATE)
	public List<Venda> findByDate(@Param("datainicial") LocalDate datainicial,@Param("datafinal") LocalDate datafinal);
    
}