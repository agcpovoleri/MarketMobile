package com.marketmobile.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

@SuppressWarnings("deprecation")
public class IPTokenBasedRememberMeServices extends TokenBasedRememberMeServices {

	Logger logger = Logger.getLogger(IPTokenBasedRememberMeServices.class);
	
	private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	
	public HttpServletRequest getContext(){
		return requestHolder.get();
	}
	
	public void setContext(HttpServletRequest context){
		requestHolder.set(context);
	}
	
	protected String getUserIPAddress(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	@Override
	public void onLoginSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication successfulAuthentication) {

		try{
			setContext(request);
			super.onLoginSuccess(request, response, successfulAuthentication);
		}finally{
			setContext(null);
		}
	}
	
	@Override
	protected void setCookie(String[] tokens, int maxAge,
			HttpServletRequest request, HttpServletResponse response) {
		
		String[] tokenWithIPAddress = Arrays.copyOf(tokens, tokens.length - 1);
		tokenWithIPAddress[tokenWithIPAddress.length - 1] = getUserIPAddress(request);
		
		super.setCookie(tokens, maxAge, request, response);
	}
	
	@Override
	protected UserDetails processAutoLoginCookie(String[] cookieTokens,
			HttpServletRequest request, HttpServletResponse response) {

		try{
			setContext(request);
			//take off the last token
			String ipAddressToken = cookieTokens[cookieTokens.length - 1];
			if (!getUserIPAddress(request).equals(ipAddressToken)){
				throw new InvalidCookieException("Cookie IP Address não contém o IP de referência: '"+ipAddressToken +"'");
			}
			return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length-1), request, response);
		}finally{
			setContext(null);
		}
	}
	
	@Override
	protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
		
		//return super.makeTokenSignature(tokenExpiryTime, username, password);
		String tokenSignature = DigestUtils.md5DigestAsHex((username + ":" + tokenExpiryTime + ":" + password + ":" + getKey() + ":" + getUserIPAddress(getContext())).getBytes());
		logger.info(tokenSignature);
		return tokenSignature;
	}
}
