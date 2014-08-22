package com.marketmobile.model.vo;

public class UsuarioLoginVo {
	
	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String cellphone;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UsuarioLoginVo [id=" + id + ", username=" + username
				+ ", email=" + email + ", password=" + password
				+ ", cellphone=" + cellphone + "]";
	}

	
	
}
