package com.marketmobile.dao;

import com.marketmobile.model.Autorizacao;

public interface AutorizacaoDao{
	
	Autorizacao findByRole(String role);
	
}
