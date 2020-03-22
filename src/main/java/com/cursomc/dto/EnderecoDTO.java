package com.cursomc.dto;

import javax.validation.constraints.NotEmpty;

public class EnderecoDTO {
	
	private static final String PREENCHIMENTO_OBRIGATORIO = "Preenchimento Obrigatorio";
	
	private Integer id;
	
	@NotEmpty(message = PREENCHIMENTO_OBRIGATORIO)
	private String logradouro;
	
	@NotEmpty(message = PREENCHIMENTO_OBRIGATORIO)
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	public EnderecoDTO() {
	}
	
	public EnderecoDTO(Integer id, String logradouro, String numero, String complemento, String bairro, String cep) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
