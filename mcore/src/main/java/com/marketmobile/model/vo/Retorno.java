package com.marketmobile.model.vo;

import java.io.Serializable;

/**
 * Objeto de retorno armazenando informação de resultado,mensagem e código do retorno
 * @author augusto
 *
 */
public class Retorno implements Serializable {
	
	private Boolean resultado;
	private String mensagem;
	private Long codigo;
	
	public Boolean getResultado() {
		return resultado;
	}
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retorno [resultado=");
		builder.append(resultado);
		builder.append(", mensagem=");
		builder.append(mensagem);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append("]");
		return builder.toString();
	}
	

	
	

}
