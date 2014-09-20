package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketmobile.controller.beans.FormUsuario;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;
import com.marketmobile.model.vo.UsuarioLoginVo;
import com.marketmobile.service.UsuarioService;
import com.marketmobile.utils.BasicUtils;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService	usuarioService;
	/*
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AmizadeService amizadeService;

	@Autowired
	private ConviteService conviteService;
	 */
	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	//	@Autowired
	//	private UsuarioService usuarioService;
	//	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@RequestMapping(method = RequestMethod.POST )
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody boolean createMessage( @RequestBody UsuarioLoginVo usuario ) {
		
		Usuario user = new Usuario();
		user.setCellphone(usuario.getCellphone());
		user.setNome(usuario.getUsername());
		usuarioService.save(user);
		
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setEmail(usuario.getEmail());
		usuarioLogin.setSenha(usuario.getPassword());
		usuarioLogin.setIsAtivo(true);
		usuarioLogin.setUsuario(user);
		
		usuarioService.save(usuarioLogin);
		return true;
	}

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String editarUsuario(HttpServletRequest request, Model model) {

		model.addAttribute("teste", new Date());
		model.addAttribute(new FormUsuario());
		//register-account.html
		return "/content/usuario/cadastroUsuario";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String novoUsuario(HttpServletRequest request, Model model) {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		String username = securityContext.getAuthentication().getName();
	    
		Usuario u = usuarioService.findUsuarioByLogin(username);
		
		model.addAttribute(new FormUsuario(u));
		//register-account.html
		return "/content/usuario/cadastroUsuario";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastrarUsuario(HttpServletRequest request, FormUsuario formUsuario, BindingResult result, Model model) {
		
		logger.info("cadastrarUsuario");
		
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setEmail(formUsuario.getEmail());
		usuarioLogin.setIsAtivo(true);
		
		
		Usuario u = usuarioService.findUsuarioByEmail(usuarioLogin);
//		
		if(u!=null){
			FieldError error = new FieldError("formUsuario", "login", "O usuario "+formUsuario.getLogin()+" já foi cadastrado.");
        	result.addError(error);
		}	
		
		usuarioLogin.setFirstAccess(new Date());
		usuarioLogin.setSenha(BasicUtils.passwordMd5Encoder(formUsuario.getSenha()));
		usuarioLogin.setLogin(formUsuario.getLogin());
		
		Usuario usuario = new Usuario();
		usuario.setNome(formUsuario.getFirstName() + " " + formUsuario.getLastName());
		
		usuario.setUsuarioLogin(usuarioLogin);
		usuarioLogin.setUsuario(usuario);
		
		usuarioService.salvarUsuario(usuario);

		return "/content/usuario/cadastroConfirmacao";
	}
}
