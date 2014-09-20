<<<<<<< Updated upstream
package com.marketmobile.controller.beans;

public class FormUsuario {

	private String login;
	private String senhaAtual;
	private String senha;
	private String confirmarSenha;
	private String nome;
	private Integer idCliente;
	private Integer idPergunta;
	private String resposta;
	private String email;
	private Boolean ativo;
	
	
	public FormUsuario(){}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Integer idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
=======
package com.marketmobile.controller.beans;

import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;

public class FormUsuario {

	private Long id;
	
	private String login;
	private String email;
	
	private String senhaAtual;
	private String senha;
		
	private String firstName;
	private String lastName;
	
	private Boolean receiveNewsletter;
	
	private Boolean ativo;

	public FormUsuario(Usuario usuario) {
		
		UsuarioLogin usuarioLogin = usuario.getUsuarioLogin();
		
		this.id = usuario.getId();
		
		this.login = usuarioLogin.getLogin();
		this.email = usuarioLogin.getEmail();
		
		String nome =  usuario.getNome();
		String[] splittedName = nome.split(" ");
		this.firstName = splittedName[0];
		this.lastName = splittedName[1];
		
		this.ativo = usuarioLogin.getIsAtivo();
	}
	
	public FormUsuario() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(Boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
>>>>>>> Stashed changes
