package com.vsm.devcase;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * ...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DevcaseApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void listAll() throws Exception {
		mockMvc.perform(get("/vendas/filtrodata?dataInicial=2019-04-01&dataFinal=2019-04-30")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(5))).andExpect(jsonPath("$[0].dataVenda", is("2019-04-07")))
				.andExpect(jsonPath("$[1].id", is(4))).andExpect(jsonPath("$[1].dataVenda", is("2019-04-24")));
	}

	@Test
	public void listCategoryByName() throws Exception {
		mockMvc.perform(get("/vendas/filtrosexo?sexo=Masculino")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(2))).andExpect(jsonPath("$[0].valorVenda", is(250.9)));
	}

}

