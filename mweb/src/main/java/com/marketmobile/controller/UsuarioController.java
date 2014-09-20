package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
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
		usuarioLogin.setIdUsuario(user.getId());
		
		usuarioService.save(usuarioLogin);
		return true;
	}

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String novoUsuario(HttpServletRequest request, Model model) {

		model.addAttribute("teste", new Date());
		model.addAttribute(new FormUsuario());
		
		return "/content/usuario/cadastroUsuario";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastrarUsuario(HttpServletRequest request, FormUsuario formUsuario, BindingResult result, Model model) {
		
		logger.info("cadastrarUsuario");
		
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setEmail(formUsuario.getEmail());

		Usuario u = usuarioService.findUsuarioByEmail(usuarioLogin);
//		
		if(u!=null){
			FieldError error = new FieldError("formUsuario", "login", "O usuario "+formUsuario.getLogin()+" j� foi cadastrado.");
        	result.addError(error);
		}	
		
		Usuario usuario = new Usuario();
//			
//		if(result.hasErrors()){
//			model.addAttribute(formUsuario);
//			return "/cliente/cadastro/usuario";
//		}
//		Cliente cliente = clienteService.buscarClientePeloId(formUsuario.getIdCliente());
//		cliente.setEmail(formUsuario.getEmail().toUpperCase());
//		Usuario usuario = new Usuario();
//		usuario.setFlAtivo(false);
//		usuario.setIdCliente(formUsuario.getIdCliente());
//		usuario.setLogin(formUsuario.getLogin());
//		usuario.setSenha(formUsuario.getSenha());
//		
//		RecuperacaoSenha recuperacaoSenha = new RecuperacaoSenha();
//		recuperacaoSenha.setIdPergunta(formUsuario.getIdPergunta());
//		recuperacaoSenha.setLogin(usuario.getLogin());
//		recuperacaoSenha.setResposta(formUsuario.getResposta());
//		
//		UsuarioConfirmacao usuarioConfirmacao = new UsuarioConfirmacao();
//		usuarioConfirmacao.setDtCadastro(new Date());
//		usuarioConfirmacao.setLogin(usuario.getLogin());
//		usuarioConfirmacao.setCdConfirmacao(UUIDGenerator.getUUID());
//		
//		FormCadastroCliente formCadastroCliente = converterClienteEmFormCadastroCliente(cliente);
//		formCadastroCliente.setLogin(usuario.getLogin());
//		formCadastroCliente.setIdPergunta(formUsuario.getIdPergunta());
//		formCadastroCliente.setResposta(formUsuario.getResposta());
//		String emailConfirmacao = gerarEmailConfirmacao(usuarioConfirmacao, formCadastroCliente, request);
//		usuarioConfirmacao.setDsCorpoEmail(emailConfirmacao);
//				
//		usuarioConfirmacao.setDsEmail(cliente.getEmail());
//		
//		clienteService.alterarClienteCriarUsuario(cliente, usuario, recuperacaoSenha, usuarioConfirmacao);
//		
//		try {
//			mailService.sendMail(applicationProperties.getProperty("mail.from"), formCadastroCliente.getEmail() ,applicationProperties.getProperty("mail.replyTo"), applicationProperties.getProperty("mail.title"), usuarioConfirmacao.getDsCorpoEmail(),null);
//			usuarioConfirmacao.setDtEnvio(new Date());
//			usuarioConfirmacaoService.alterarUsuarioConfirmacao(usuarioConfirmacao);
//		} catch (Exception e) {
//			logger.error("Erro ao tentar enviar email de confirmacao",e);
//		}
//		
		return "/content/usuario/cadastroConfirmacao";
	}

	//	/**
	//	 * Verifica se existe usu�rio cadastrado com o email do novo cadastro
	//	 * Email deve ser �nico entre os usu�rios
	//	 * @param request
	//	 * @param usuarioLogin - objeto com informacao do email
	//	 * @return
	//	 */
	//	@RequestMapping(value="/salvarLocalizacao", method=RequestMethod.POST)
	//	public @ResponseBody Retorno checkValidUsuario(HttpServletRequest request, @RequestBody Localizacao localizacao){
	//
	//		logger.info("Salvando localizacao para usu�rio "+localizacao.getIdUsuario());
	//
	//		Retorno retorno = new Retorno();
	//		localizacaoService.save(localizacao);
	//		return retorno;
	//	}
	//
	//	/**
	//	 *  Obtem historico de localizacao do usuario passado como parametro
	//	 * @param request
	//	 * @param idUsuario
	//	 * @return
	//	 */
	//	@RequestMapping(value="/obterHistoricoLocalizacao", method=RequestMethod.POST)
	//	public @ResponseBody HistoricoLocalizacao historicoLocalizacao(HttpServletRequest request, @RequestBody Long idUsuario){
	//
	//		List<Localizacao> localizacoes = localizacaoService.obterHistoricoLocalizacao(idUsuario);
	//		HistoricoLocalizacao historico = new HistoricoLocalizacao();
	//
	//		historico.setIdUsuario(idUsuario);
	//		historico.setLocalizacoes(localizacoes);
	//
	//		return historico;
	//	}
	//
	//
	//	/**
	//	 * Obtem informa�oes do usu�rio e perfil
	//	 * @param request
	//	 * @param idUsuario
	//	 * @return
	//	 */
	//	@RequestMapping(value="/find", method=RequestMethod.POST)
	//	public @ResponseBody Usuario findUsuarioById(HttpServletRequest request, @RequestBody Long idUsuario){
	//
	//		Usuario usuario = usuarioService.load(Usuario.class, idUsuario);
	//		usuario.setPerfil(usuarioService.load(Perfil.class, usuario.getIdPerfil()));
	//
	//		List<Localizacao> localizacoes = localizacaoService.obterHistoricoLocalizacao(idUsuario);
	//
	//		HistoricoLocalizacao historico = new HistoricoLocalizacao();
	//		historico.setIdUsuario(idUsuario);
	//		historico.setLocalizacoes(localizacoes);
	//		usuario.setHistoricoLocalizacao(historico);
	//
	//		return usuario;
	//	}
	//
	//	/**
	//	 * Obtem informa�oes do usu�rio e perfil
	//	 * @param request
	//	 * @param idUsuario
	//	 * @return
	//	 */
	//	@RequestMapping(value="/getAmizades", method=RequestMethod.POST)
	//	public @ResponseBody AmizadesUsuario getAmizades(HttpServletRequest request, 
	//			@RequestBody Long idUsuario){
	//
	//		List<InfoAmigoUsuario> amigosUsuario = amizadeService.findAmizadesByUsuario(idUsuario);
	//		AmizadesUsuario amizadesUsuario =  new AmizadesUsuario();
	//		amizadesUsuario.setInfoAmigos(amigosUsuario);
	//
	//		return amizadesUsuario;
	//	}
	//
	//	/**
	//	 * Verificar amigos cadastrados com informa��es de contatos do usu�rio
	//	 * Recebe lista de Contatos do usu�rio e verifica quais usu�rios possuem 
	//	 * @param request
	//	 * @param contatosAgenda lista de 
	//	 * @return
	//	 */
	//	@RequestMapping(value="/adicionarAmizade", method=RequestMethod.POST)
	//	public @ResponseBody Retorno findAmigosDaAgenda(HttpServletRequest request, @RequestBody ContatoAgenda contatoAgendaUsuario){
	//
	//		Retorno retornoAddAmizade = new Retorno();
	//		String cellphone = contatoAgendaUsuario.getCellphone();
	//		/*
	//		 * Verifica existencia de usuario com o email correspondente
	//		 */
	//		Usuario usuarioWithCellphone = usuarioService.findUsuarioByCellphone(cellphone);
	//		
	//		
	//		if (usuarioWithCellphone!=null){
	//			
	//			logger.info("Adicionando amizade entre usu�rio "+contatoAgendaUsuario.getIdUsuario()+" e usu�rio "+usuarioWithCellphone.getId());
	//
	//			if (contatoAgendaUsuario.getIdUsuario().equals(usuarioWithCellphone.getId())){
	//				//Solicitacao para pr�prio usu�rio
	//				retornoAddAmizade.setResultado(false);
	//				retornoAddAmizade.setMensagem("N�o � poss�vel adicionar uma amizade o pr�prio usu�rio.");
	//				retornoAddAmizade.setCodigo(CodigosRetorno.ERROR);
	//				return retornoAddAmizade;
	//			}
	//
	//			/*
	//			 * Verifica rela��o entre usu�rios
	//			 * Caso NAO exista relacao de amizade entre usu�rios, realiza solicita��o de amizade
	//			 */
	//			Amizade amizadeEncontrada = amizadeService.findAmizadeEntreUsuarios(contatoAgendaUsuario.getIdUsuario(), usuarioWithCellphone.getId()); 
	//			if (amizadeEncontrada == null){
	//				/*
	//				 *  N�o existe relacao de amizade identificada entre usu�rio
	//				 *  Nova amizade � solicitada com a dataAtual e fica pendente enquanto dataAprovacao == null
	//				 */
	//				Amizade amizade = new Amizade();
	//				amizade.setIdUsuario1(contatoAgendaUsuario.getIdUsuario());
	//				amizade.setIdUsuario2(usuarioWithCellphone.getId());
	//				amizade.setDataSolicitacao(new Date());
	//				amizadeService.save(amizade);
	//
	//				retornoAddAmizade.setResultado(true);
	//				retornoAddAmizade.setMensagem("Solicita��o de Amizade enviada com sucesso.");
	//				retornoAddAmizade.setCodigo(CodigosRetorno.SUCESS);
	//
	//			}else{
	//				/*
	//				 * J� existe identifica��o de amizade entre usu�rios
	//				 * Amizade j� concretizada ou Solicita��o pendente aguardando aprova��o 
	//				 */
	//				if (amizadeEncontrada.getDataAprovacao()!=null){
	//					retornoAddAmizade.setResultado(false);
	//					retornoAddAmizade.setMensagem("J� existe amizade entre os usu�rios selecionados");
	//					retornoAddAmizade.setCodigo(CodigosRetorno.AMIZADE_EXISTENTE);
	//
	//				}else{
	//					retornoAddAmizade.setResultado(false);
	//					retornoAddAmizade.setMensagem("Aguardando aprova��o da solicita��o de amizade entre usu�rios.");
	//					retornoAddAmizade.setCodigo(CodigosRetorno.AMIZADE_AGUARDANDO_APROVACAO);
	//				}
	//			}
	//		}else{
	//			/*
	//			 * N�o existe usu�rio registrado com o Celular correspondente
	//			 */
	//			retornoAddAmizade.setResultado(false);
	//			retornoAddAmizade.setMensagem("Nenhum usu�rio encontrado com o telefone: "+cellphone);
	//			retornoAddAmizade.setCodigo(CodigosRetorno.USER_NOT_FOUND);
	//		}
	//
	//		return retornoAddAmizade;
	//	}
	//
	//	@RequestMapping(value="/desfazerAmizades", method=RequestMethod.POST)
	//	public @ResponseBody Retorno desfazerAmizades(HttpServletRequest request, @RequestBody DesfazerAmizadesUsuario desfazerAmizadesUsuario){
	//
	//		Retorno retornoDesfazerAmizades = new Retorno();
	//
	//		Long idUsuario = desfazerAmizadesUsuario.getIdUsuario();
	//		List<Long> listaIdUsuarios = desfazerAmizadesUsuario.getListaIdUsuarios();
	//
	//		logger.info("Desfazendo amizade do usu�rio "+idUsuario+" e usu�rio "+listaIdUsuarios.toArray().toString());
	//		try{
	//			
	//			List<Amizade> amizades = amizadeService.findAmizadesByUsuario(idUsuario, listaIdUsuarios);
	//			for (Amizade amizade : amizades) {
	//				amizadeService.delete(amizade);
	//			}
	//			
	//			retornoDesfazerAmizades.setResultado(true);
	//			retornoDesfazerAmizades.setCodigo(CodigosRetorno.SUCESS);
	//			retornoDesfazerAmizades.setMensagem("Amizades desfeitas com sucesso");
	//			
	//		}catch (Exception e) {
	//			e.printStackTrace();
	//			
	//			retornoDesfazerAmizades.setResultado(false);
	//			retornoDesfazerAmizades.setCodigo(CodigosRetorno.ERROR);
	//			retornoDesfazerAmizades.setMensagem(e.getMessage());
	//		}
	//		
	//		return retornoDesfazerAmizades;
	//	}
	//
	//	@RequestMapping(value="/registrarConvite", method=RequestMethod.POST)
	//	public @ResponseBody Retorno registrarSolicitacao(HttpServletRequest request, @RequestBody ContatoAgenda contatoAgendaUsuario){
	//
	//		Retorno retornoConvite = new Retorno();
	//
	//		Long idUsuario = contatoAgendaUsuario.getIdUsuario();
	//		String phone = contatoAgendaUsuario.getCellphone();
	//
	//		Convite convite = conviteService.findConviteByUsuarioAndPhone(idUsuario, phone);
	//		if (convite == null){
	//			Convite novoConvite = new Convite();
	//			novoConvite.setIdUsuario(idUsuario);
	//			novoConvite.setPhone(phone);
	//			novoConvite.setDataSolicitacao(new Date());
	//
	//			conviteService.save(novoConvite);
	//
	//			retornoConvite.setResultado(true);
	//			retornoConvite.setMensagem("Convite realizado com sucesso.");
	//			retornoConvite.setCodigo(CodigosRetorno.SUCESS);
	//		}else{
	//
	//			retornoConvite.setResultado(false);
	//			retornoConvite.setMensagem("Convite j� existente para telefone: "+phone);
	//			retornoConvite.setCodigo(CodigosRetorno.CONVITE_EXISTENTE);
	//		}
	//
	//		return retornoConvite;
	//	}


}
