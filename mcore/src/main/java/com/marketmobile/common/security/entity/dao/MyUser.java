package com.marketmobile.common.security.entity.dao;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {

	private static final long serialVersionUID = 1L;
	
	private String password;
	private UserInfo userInfo;


	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

       super(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
       this.password=password;
    }


	public MyUser(String username, String password, boolean enabled, Integer idUsuario, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

       super(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
       UserInfo userInfo = new UserInfo();
       userInfo.setId(idUsuario);
       this.setUserInfo(userInfo);
       this.password=password;
    }
	
	public MyUser changeAuthorities(Collection<? extends GrantedAuthority> authorities) {
		return new MyUser(this.getUsername(),this.getPassword(),this.isEnabled(),this.isAccountNonExpired(),this.isCredentialsNonExpired(),
				this.isAccountNonLocked(),authorities);
	}

    public String getPassword() {
		return password;
	}

    public String getUsernameInfo() {
		return getUsername().replaceFirst("\\[.*\\]", "");
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}



	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(";");
        sb.append("UserInfo: "+this.userInfo).append(";");
        return sb.toString();
    }
}
