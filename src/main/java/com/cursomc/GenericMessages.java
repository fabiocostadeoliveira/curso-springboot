package com.cursomc;

public enum GenericMessages {
	
	CAMPO_PREENCHIMENTO_OBRIGATORIO("O campo {0} é obrigatorio!"),
	PREENCHIMENTO_OBRIGATORIO("Preenchimento obrigatorio");
	
	private String mensagem;
	
	private GenericMessages(String msg) {
		this.mensagem = msg;
	}

	public String getGenericMessages() {
		return mensagem;
	}
	
	public void setGenericMessages(String mensagem) {
		this.mensagem = mensagem;
	}

}
