package com.marketmobile.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketmobile.model.vo.ServerInformation;


@Controller
@RequestMapping("/**")
public class IndexController {
	
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(IndexController.class);
	
//	@Autowired
//	private UsuarioService usuarioService;
//	
	@InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    
    }
	
//	/**
//	 * Verifica se existe usuário cadastrado com o email do novo cadastro
//	 * Email deve ser único entre os usuários
//	 * @param request
//	 * @param usuarioLogin - objeto com informacao do email
//	 * @return
//	 */
//	@RequestMapping(value="/checkEmail", method=RequestMethod.POST)
//	public @ResponseBody UsuarioLogin checkValidUsuario(HttpServletRequest request, @RequestBody UsuarioLogin usuarioLogin){
//		
//		UsuarioLogin result = null;
//		logger.info("Usuario Login: "+ usuarioLogin.toString());
//		try {	
//			result = usuarioService.findUsuarioLoginByEmail(usuarioLogin.getEmail());
//			//Esconde a senha
//			if (result!=null) result.setSenha("#");
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Erro:",e);
////			result.setCodigo(null);
////			result.setMensagem("Erro ao realizar login:"+e.getLocalizedMessage());
////			result.setResultado(false);
//		}
//		return result;
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public @ResponseBody Usuario login(HttpServletRequest request, @RequestBody UsuarioLogin usuarioLogin){
//		
//		Usuario result = null;
//		logger.info("Usuario Login: "+ usuarioLogin.toString());
//		try {	
//			result = usuarioService.findUsuarioByLogin(usuarioLogin);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Erro:",e);
//		}
//		
//		return result;
//	}
//	
//	
//	@RequestMapping(value="/registrarUsuario", method=RequestMethod.POST)
//	public @ResponseBody Retorno registrarUsuario(HttpServletRequest request, @RequestBody Usuario usuario){
//		
//		Retorno result = new Retorno();
//		logger.info("Novo Usuario: "+ usuario.toString());
//		try {	
//			Long idUsuario = usuarioService.registrarUsuario(usuario);
//			
//			result.setCodigo(idUsuario);
//			result.setMensagem("Registro raealizado com sucesso.");
//			result.setResultado(true);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Erro:",e);
////			result.setCodigo(null);
////			result.setMensagem("Erro ao inserir coordenada:"+e.getLocalizedMessage());
////			result.setResultado(false);
//		}
//		
//		return result;
//	}
	
	/**
	 * Obtem informação do sistema 
	 * @return
	 */
	private ServerInformation findServerInformation() {
		ServerInformation info = new ServerInformation();
		Runtime runtime = Runtime.getRuntime();
		try {
			InetAddress end = InetAddress.getLocalHost();
			
			info.setIp(end.getHostAddress());
			info.setHostname(end.getHostName());
			info.setOsinfo(System.getProperty("os.name")+" "+System.getProperty("os.version")+" , "+System.getProperty("os.arch")+ " (Processors: "+runtime.availableProcessors()+")\n");
			info.setVersion("1.0");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		info.setServertime(new Date());
		return info;
	}
	
	
	@RequestMapping("/isOnline")
	public @ResponseBody ServerInformation isOnline() {
		ServerInformation serverInfo = findServerInformation();
		logger.info("Checking service Online: "+serverInfo.toString());
		return serverInfo;
	}
	
}
