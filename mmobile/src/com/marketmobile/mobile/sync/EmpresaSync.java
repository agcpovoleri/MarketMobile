package com.marketmobile.mobile.sync;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.util.Log;

import com.marketmobile.mobile.model.Empresa;
import com.marketmobile.mobile.model.local.Usuario;
import com.marketmobile.mobile.utils.LogUtils;

public class EmpresaSync{

	private RestTemplate restTemplate;
	
	private final String TAG = "UsuarioSync";
	
	
	public Empresa[] getObjects(String url) {
		
		try{
			
			restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			return restTemplate.getForObject(url, Empresa[].class);
			
		}catch (Exception e) {
			Log.i(TAG,e.getMessage());
			return null;
		}
		
	}

	/**
	 * Envia localizacao para receber como retorno a lista de estabelecimentos disponiveis no endereço citado
	 */
	public Empresa postObject(String url, String location) {
		try{
			restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			
			Empresa retornoSync = restTemplate.postForObject(url, location, Empresa.class);
			
			LogUtils.LogInfo(TAG, retornoSync.toString());
			
			return retornoSync;
		}catch (Exception e) {
			e.printStackTrace();
			LogUtils.LogError(TAG, "Erro buscando estabelecimentos");
			
			return null;
		}
	}
	
	public Empresa getObject(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void postObjectsSync(String url, List<Usuario> listaUsuarios) {
		
//		HashMap<Long, String> infoUsersExistentes = new HashMap<Long, String>();
//		for (int i = 0; i < listaUsuarios.size(); i++) {
//			Usuario u = listaUsuarios.get(i);
//			infoUsersExistentes.put(u.getUid(), u.getHash());
//		}	
//		
////		long[] listaIdUsuariosExistentes = new long[listaUsuarios.size()];
////		for (int i = 0; i < listaUsuarios.size(); i++) {
////			listaIdUsuariosExistentes[i] = listaUsuarios.get(i).getUid();
////		}
//		
//		try{
//			restTemplate = new RestTemplate();
//			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//			RetornoUsuarioSync retornoSync = restTemplate.postForObject(url, infoUsersExistentes, RetornoUsuarioSync.class);
//			
//			LogUtils.LogInfo(TAG, retornoSync.toString());
//			
//			return retornoSync;
//		}catch (Exception e) {
//			e.printStackTrace();
//			LogUtils.LogError(TAG, "Erro sincronizando resultado de Usuario");
//			
//			return null;
//		}
	}


}
