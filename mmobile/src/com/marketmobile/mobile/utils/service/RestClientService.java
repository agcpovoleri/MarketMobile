package com.marketmobile.mobile.utils.service;


/**
 * Interface para comunicacao com o servico WEB
 * Define os m�todos que devem existir em cada Class que implementa esta interface]
 * 
 * @author Augusto Geara
 * @since 12/12/2012
 * 
 */
public interface RestClientService<T> {
	
	/**
	 * Retorna o objeto do serviço
	 * @param url caminho do serviço
	 * @param clazz classe de retorno 
	 * @return Objeto de retorno
	 */
	T getObject(String url);
	
	T[] getObjects(String url);
	
	/**
	 * Posta um objeto no serviço WEB
	 * @param url caminho do serviço
	 * @param object objeto a ser postado
	 * @param clazz classe de retorno
	 * @return Objeto de retorno
	 */
	T postObject(String url, T t);
	
	//Retorno postObjects(String url, List<T> t);
	//RetornoSync postObjectsSync(String url, List<T> lista);
	
}
