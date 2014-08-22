package com.marketmobile.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.apache.cordova.example.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.marketmobile.mobile.model.Cidade;
import com.marketmobile.mobile.model.Empresa;
import com.marketmobile.mobile.sync.EmpresaSync;
import com.marketmobile.mobile.sync.SyncFactory;
import com.marketmobile.mobile.utils.LogUtils;

public class LocalizacaoController extends Plugin {

	private SyncFactory syncFactory;
	
	private static final String GET_LOCALIZACAO = "busca_cep";

	/**
	 * Executes the request and returns PluginResult.
	 *
	 * @param action        The action to execute.
	 * @param args          JSONArry of arguments for the plugin.
	 * @param callbackId    The callback id used when calling back into JavaScript.
	 * @return              A PluginResult object with a status and message.
	 */
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		
		syncFactory = new SyncFactory(this.cordova.getContext());
		
		try {
			if (action.equals(GET_LOCALIZACAO)) {
				
				String URL_ESTABELECIMENTO_LOCALIZAR = "estabelecimento/localizar";
				
				String cpfCliente = args.getString(0);
				
				Integer idEmpresa = 1;
				
				EmpresaSync empresaSync = new EmpresaSync();
				Empresa resultPost = empresaSync.postObject(syncFactory.getRealUrl(URL_ESTABELECIMENTO_LOCALIZAR), "Alto dos Passos, Juiz de Fora");
				toastNotification(resultPost.toString());
				
				List<Empresa> estabelecimentos = findEmpresaById(idEmpresa);
				
				SincronizaRecursos processoSync = new SincronizaRecursos(ctx.getContext());
				processoSync.execute(1);
				
				JSONObject obj = new JSONObject();
				JSONArray list = new JSONArray(estabelecimentos);
				obj.put("estabelecimentos", estabelecimentos);

				if (obj != null) { 
					Gson gsonObj =  new Gson();
					return new PluginResult(Status.OK, gsonObj.toJson(obj));
				} else {
					return new PluginResult(Status.ERROR);
				}
			} else {
				return new PluginResult(PluginResult.Status.INVALID_ACTION);
			}
		} catch (JSONException e) {
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
	}

	/**
	 * Find employees  by cep
	 * @param idEmpresa
	 * @return
	 */
	private List<Empresa> findEmpresaById(Integer idEmpresa){

		List<Empresa> empresas = new ArrayList<Empresa>();
		//TODO buscar empresas pelo endere�o
		
		empresas.add(new Empresa((long)1, "Beef de Griff", "images/picker/restau01_mini.jpg", 4));
		empresas.add(new Empresa((long)2, "Empresa 2 tes", "images/picker/restau02_mini.jpg", 3));
		empresas.add(new Empresa((long)3, "Empresa 3 asc", "images/picker/restau03_mini.jpg", 1));
		empresas.add(new Empresa((long)4, "Empresa 4 abc", "images/picker/restau04_mini.jpg", 5));
		empresas.add(new Empresa((long)5, "Empresa 5 tds", "images/picker/restau05_mini.jpg", 3));

		return empresas;
	}

	/**
	 * Find employees by cep
	 * @param cep
	 * @return
	 */
	private List<Cidade> findCidades(String cep){

		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(new Cidade((long)1, "Juiz de Fora", 4));
		cidades.add(new Cidade((long)2, "Juiz de Fora2", 5));
		cidades.add(new Cidade((long)3, "Juiz de Fora3", 7));
		cidades.add(new Cidade((long)4, "Juiz de Fora4", 1));

		return cidades;
	}
	
	/**
	 * Classe que sincroniza os recursos da aplicação, buscando todos recursos não sincronizados (Usuarios / Surveys)
	 * Realiza consulta no servidor atraves de AsyncTask
	 * 
	 * @author augusto
	 * @since  03/07/2012
	 */
	class SincronizaRecursos extends AsyncTask <Integer, String, Integer> {

		private static final String TAG = "EstabelecimentosController.SincronizaRecursos";
		
        private ProgressDialog progress;
        private Context context;
        private SyncFactory syncFactory;

        public SincronizaRecursos(Context context) {
            this.context = context;
            syncFactory = new SyncFactory(context);
    		
        }

        @Override
        protected void onPreExecute() {
            //Cria novo um ProgressDialogo e exibe
            progress = new ProgressDialog(context);
            progress.setMessage("Loading");
            progress.setCancelable(false);
            progress.show();
        }

        @Override
        protected Integer doInBackground(Integer... paramss) {
        	Integer qtde = 0;
        	
        	for (int i = 0; i < paramss.length; i++) {
            	try {
                    //Simula processo...
                    //Thread.sleep(paramss[i]);
            		syncFactory.syncLocalizarEmpresas();
    				
                    //Atualiza a interface através do onProgressUpdate
                    //publishProgress(i + "...");
                } catch (Exception e) {
                	LogUtils.LogError(TAG, "error", e);
                    e.printStackTrace();
                }
            }
            return qtde;
        }

        @Override
        protected void onPostExecute(Integer result) {
            //Preenche lista de usuários
        	//Cancela progressDialogo
            progress.dismiss();
            toastNotification("Usuários, Questionários e Respostas sincronizadas");//result+" resposta(s) sincronizada(s).");
        }
	}
	
	/**
	 * Creating a toast notification
	 * @param text
	 */
	private void toastNotification(String text)
	{
		Context context = ctx.getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
