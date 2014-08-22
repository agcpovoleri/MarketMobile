package com.marketmobile.mobile.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import android.util.Log;

import com.marketmobile.mobile.exceptions.RestException;

public class AndroidResponseErrorHandler implements ResponseErrorHandler {
	private String lastError;
	
	public String convertStreamToString(InputStream is)  throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		    
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		      sb.append(line + "\n");
		    }
		}   finally {
		   	is.close();
		}

	    return sb.toString();
	}

	public void handleError(ClientHttpResponse clienthttpresponse) throws IOException, RestException {
		if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
			String msgErro = "";
			if (clienthttpresponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				msgErro = "Erro:" + clienthttpresponse.getStatusCode() +" - "+ "Erro de autenticação!";
			} else if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
				msgErro = "Erro:" + clienthttpresponse.getStatusCode() +" - "+ "Acesso Negado!";
			} else if (clienthttpresponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				msgErro = "Erro:" + clienthttpresponse.getStatusCode() +" - "+ "Erro genérico no servidor!";
			} else {
				msgErro = "Erro:" + clienthttpresponse.getStatusCode() +" - "+ "Erro não previsto!";
			}
			
			throw new RestException(msgErro);
		}

	}

	public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {
		if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
			BufferedInputStream br = new BufferedInputStream(clienthttpresponse.getBody());
			lastError = convertStreamToString(br);
			String msgErro = "Status code: " + clienthttpresponse.getStatusCode() +
			 				 "Response" + clienthttpresponse.getStatusText() +
			 				lastError;
			
			Log.e("REST",msgErro);

			
			return true;
		}
		return false;
	}

}
