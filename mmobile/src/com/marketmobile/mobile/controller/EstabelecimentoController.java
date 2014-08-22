package com.marketmobile.mobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.marketmobile.mobile.model.Empresa;
import com.marketmobile.mobile.model.InfoEmpresa;
import com.marketmobile.mobile.sync.SyncFactory;
import com.marketmobile.mobile.utils.LogUtils;

public class EstabelecimentoController extends Plugin {

	private static final String GET_EMPRESAS = "find_empresa_by_cep";
	private static final String INFO_EMPRESA = "info_empresa";
	private static final String CARDAPIO = "cardapio";

	private List<Empresa> estabelecimentos;
	private Empresa empresaCurrent;
	
	/**
	 * Executes the request and returns PluginResult.
	 *
	 * @param action        The action to execute.
	 * @param args          JSONArry of arguments for the plugin.
	 * @param callbackId    The callback id used when calling back into JavaScript.
	 * @return              A PluginResult object with a status and message.
	 */
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		try {
			
			if (action.equals(GET_EMPRESAS)) {

				Long idEmpresa = args.getLong(0);
				
				List<Empresa> estabelecimentos = findEmpresaById(idEmpresa);

				JSONObject obj = new JSONObject();
				JSONArray list = new JSONArray(estabelecimentos);
				obj.put("estabelecimentos", list);

				if (obj != null) { 
					Gson gsonObj = new Gson();
					return new PluginResult(Status.OK, gsonObj.toJson(obj));
				} else {
					return new PluginResult(Status.ERROR);
				}
				
			}else if (action.equals(INFO_EMPRESA)) {
				//TODO obter informacoes da empresa selecionada
				Long idEmpresa = args.getLong(0);
				
				InfoEmpresa infoempresa = findInfoEmpresa(idEmpresa);
				
				JSONObject obj = new JSONObject();
				obj.put("infoempresa", infoempresa);

				if (obj != null) { 
					return new PluginResult(Status.OK, obj);
				} else {
					return new PluginResult(Status.ERROR);
				}
			} else if (action.equals(CARDAPIO)) {
				/**
				 * Card�pio referente a empresa
				 * Trazer dados categorizados para serem adicionados ao cardapio
				 */
				//TODO obter cardapio da empresa selecionada
				JSONObject obj = new JSONObject();
				//JSONArray list = new JSONArray(cidades);
				//obj.put("estabelecimento", list);

				if (obj != null) { 
					return new PluginResult(Status.OK, obj);
				} else {
					return new PluginResult(Status.ERROR);
				}
			} else{
				return new PluginResult(PluginResult.Status.INVALID_ACTION);
			}
		} catch (JSONException e) {
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
	}

	private Empresa getEmpresaCurrent() {
		if (this.estabelecimentos!=null) {
			
		}
		return null;
	}

	private List<Empresa> findEmpresaById(Long idEmpresa){
		
		estabelecimentos = new ArrayList<Empresa>();
		estabelecimentos.add(new Empresa((long)1, "Beef de Griff", "images/picker/restau02_mini.jpg", 4));
		estabelecimentos.add(new Empresa((long)2, "Beef de Griff", "images/picker/restau03_mini.jpg", 3));
		estabelecimentos.add(new Empresa((long)3, "Beef de Griff", "images/picker/restau05_mini.jpg", 1));
		estabelecimentos.add(new Empresa((long)4, "Beef de Griff", "images/picker/restau04_mini.jpg", 4));
		
		return estabelecimentos;
	}
	
	private Empresa findById(int idEmpresa){
		if (estabelecimentos!=null){
			return estabelecimentos.get(idEmpresa);
		}
		return null;
	}
	
	private InfoEmpresa findInfoEmpresa(Long idEmpresa){
		
		InfoEmpresa info = new InfoEmpresa();
		info.setId((long)1);
		info.setIdEmpresa(idEmpresa);
		info.setNome("Empresa - Biff de Griffe");
		info.setDescricao("ESHUSHASD HSUDAHSUHD IJAISDJ IHAUHSL�K+ OUAS");
		info.setLinkMap("http://www.google.com");
		info.setWebsite("http://www.facebook.com");
		info.setAvaliacao(5);
		return info;
		
		
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
