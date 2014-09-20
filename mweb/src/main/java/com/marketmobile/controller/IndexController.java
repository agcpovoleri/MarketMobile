package com.marketmobile.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketmobile.model.vo.ServerInformation;


@Controller
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
	
	@Secured(value="ROLE_USER")
	@RequestMapping("/isOnline")
	public @ResponseBody ServerInformation isOnline() {
		ServerInformation serverInfo = findServerInformation();
		logger.info("Checking service Online: "+serverInfo.toString());
		
		return serverInfo;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        
		logger.info("About page !");
         
        return "content/about";
    }

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
}

