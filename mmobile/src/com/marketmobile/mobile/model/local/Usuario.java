package com.marketmobile.mobile.model.local;

public class Usuario {
	
	private Long id;
	
	private String username;
	
	private String email;

	
	
	public Usuario(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email="
				+ email + "]";
	}
	
	
}
