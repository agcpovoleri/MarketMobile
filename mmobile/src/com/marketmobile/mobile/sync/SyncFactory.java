package com.marketmobile.mobile.sync;


import java.util.ArrayList;
import java.util.List;

import org.apache.cordova.example.R;
import org.springframework.web.client.HttpClientErrorException;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.marketmobile.mobile.dao.UsuarioDao;
import com.marketmobile.mobile.model.Empresa;
import com.marketmobile.mobile.model.local.Usuario;
import com.marketmobile.mobile.utils.LogUtils;
import com.marketmobile.mobile.utils.dao.DataManager;

/**
 * Classe responsavel pelo acesso a informacao no servidor remoto
 * 
 * @author Augusto
 * @since 13/12/2012
 */
public class SyncFactory {

	private final String TAG = SyncFactory.class.getSimpleName();

	private String URL_ESTABELECIMENTO_LOCALIZAR =         "estabelecimento/localizar";
	private String URL_USER      =         "usuario/index";

	private String URL_SURVEY_SYNC =       "?entity=Surveys&action=syncAll&output=json";
	private String URL_SURVEY      =       "?entity=Surveys&action=getSurvey&output=json&params=";

	private String URL_QUESTION    =       "?entity=Questions&action=getSurvey&output=quexml&params=";

	private String URL_RESULTSURVEY =      "?entity=ResultSurveys&action=postResultSurvey&output=json";

	private EmpresaSync empresaSync;

	private UsuarioDao usuarioDao;

	private DataManager dataManager;

	private Context myContext;

	public SyncFactory(Context context){
		this.myContext = context;
	}
	
	/**
	 * Obtem a url completa para acessar o servidor remoto
	 * 
	 * @param urlSuffix - sufixo do endereco
	 * @return
	 */
	public String getRealUrl(String urlSuffix){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(myContext);
		String preffix = prefs.getString("webservice_host_url", myContext.getResources().getString(R.string.sync_server));
		return preffix + urlSuffix;
	}

	/**
	 * Sincroniza todos os recursos disponíveis para sincronização
	 * Sincronização realizada para Usuarios e Questionários disponíveis
	 */
	public void syncAll(){

		syncLocalizarEmpresas();
	}

	/**
	 * Sincroniza dados de usu�rio localizando dados anteriores se possuir.
	 */
	public void syncLocalizarEmpresas(){

		empresaSync = new EmpresaSync();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		try {
			try {
				Empresa resultPost = empresaSync.postObject(getRealUrl(URL_ESTABELECIMENTO_LOCALIZAR), "Alto dos Passos, Juiz de Fora");
				toastNotification(resultPost.toString());
				LogUtils.LogInfo(TAG, resultPost.toString());
			
			}catch (HttpClientErrorException e) {
				toastNotification("Host inacessível. Verifique as configurações.");
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Creating a toast notification
	 * @param text
	 */
	private void toastNotification(String text)
	{
		Context context = myContext;
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
