package com.cursomc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.cursomc.FactoryMessage;
import com.cursomc.services.validations.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final String PREENCHIMENTO_OBRIGATORIO = "Preenchimento Obrigatorio";
	
	private Integer id;
		
	@NotEmpty(message = PREENCHIMENTO_OBRIGATORIO)
	@Length(min = 5, max = 120, message = "O tamanho deve conter entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = PREENCHIMENTO_OBRIGATORIO)
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = PREENCHIMENTO_OBRIGATORIO)
	private String cpfOuCnpj;
	
	private Integer tipo;
	
	private EnderecoDTO endereco;
	
	private CidadeDTO cidade;
	
	private List<@Size (min = 1, message = "Deve ser informado pelo menos um telefone para o cliente") String>telefones = new ArrayList<>();
	
	public ClienteNewDTO() {
	}

	public ClienteNewDTO(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo, EnderecoDTO endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.endereco = endereco;
		
		FactoryMessage.generate("safsdfa", "1");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	
	
	

}
