package com.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1,"Pentende"),
	QUITADO(2,"Quitado"),
	CANCELADO(3, "Cancelado");
	
	
	private Integer codigo;
	
	private String descricao;
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		
		if(codigo == null)
			return null;
		
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + codigo);
	}

	
	

}
