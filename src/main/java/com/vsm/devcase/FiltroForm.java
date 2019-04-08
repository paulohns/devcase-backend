package com.vsm.devcase;

import java.time.LocalDate;

public class FiltroForm {
	private LocalDate datainicial;
	private LocalDate datafinal;
	private String sexo;

	public LocalDate getDatainicial() {
		return datainicial;
	}

	public void setDatainicial(LocalDate datainicial) {
		this.datainicial = datainicial;
	}

	public LocalDate getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(LocalDate datafinal) {
		this.datafinal = datafinal;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}