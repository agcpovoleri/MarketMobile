package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;
import com.marketmobile.service.CardapioService;
import com.marketmobile.service.EstabelecimentoService;


@Controller
@RequestMapping("/shop")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private CardapioService cardapioService;
	/*
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AmizadeService amizadeService;

	@Autowired
	private ConviteService conviteService;
*/
	private Logger logger = LoggerFactory.getLogger(EstabelecimentoController.class);

	//	@Autowired
	//	private UsuarioService usuarioService;
	//	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CategoriaVo> getAll(@RequestParam( value = "type", required = false ) String type) {   
        List<CategoriaVo> estabelecimentos = estabelecimentoService.findAllVo();   
        logger.info(estabelecimentos.toString());
        return estabelecimentos; 
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody InfoEstabelecimentoVo getById(@PathVariable Long id ) {      
    	InfoEstabelecimentoVo infoEstabelecimentoVo = estabelecimentoService.findById(id);
    	infoEstabelecimentoVo.setCategoriasMenu(estabelecimentoService.findCategoriasMenuById(id));
    	return infoEstabelecimentoVo;     
    }
    
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( value = HttpStatus.NO_CONTENT )
    public void deleteMessage(@PathVariable Integer id ) throws NotFoundException {     
    	estabelecimentoService.delete(id);      
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<CategoriaVo> searchByAll(@RequestParam String strSearch) {   
       
    	List<CategoriaVo> estabelecimentos = estabelecimentoService.findBy(strSearch);   
        logger.info(estabelecimentos.toString());
        return estabelecimentos; 
    }
    
    
//	@RequestMapping(value="/create", method=RequestMethod.POST)
//	public @ResponseBody String create(HttpServletRequest request, @RequestParam Long id){
//
//		logger.info("Controller success! Param: [idEstabelecimento]:"+id);
//
//		InfoEstabelecimentoVo ie = estabelecimentoService.findById(id);
//		return ie.toString();
//		
//	}
//	
//	/**
//	 * Retorna informacao do estabelecimento se o atributo id for valido
//	 * @param request
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value="/read", method=RequestMethod.GET)
//	public @ResponseBody InfoEstabelecimentoVo read(HttpServletRequest request, Long id){
//
//		logger.info("Controller success! Param: [idEstabelecimento]:"+id);
//		InfoEstabelecimentoVo ie = null; 
//		if (id!=null) {
//			ie = estabelecimentoService.findById(id);
//		}
//		return ie;
//	}
//	
//	@RequestMapping(value="/update", method=RequestMethod.PUT)
//	public @ResponseBody InfoEstabelecimentoVo update(HttpServletRequest request, @RequestParam InfoEstabelecimentoVo place){
//
//		logger.info("Controller success! Param: [idEstabelecimento]:"+place.getId());
//
////		InfoEstab
////		InfoEstabelecimentoVo ie = estabelecimentoService.update(place);
//		return place;
//		
//	}
//	
//	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
//	public @ResponseBody String delete(HttpServletRequest request, @RequestParam Long id){
//
//		logger.info("Controller success! Param: [idEstabelecimento]:"+id);
//
//		InfoEstabelecimentoVo ie = estabelecimentoService.findById(id);
//		return ie.toString();
//		
//	}
//	
//	
	@RequestMapping(value="/findByCidade", method=RequestMethod.POST)
	public @ResponseBody List<CategoriaVo> findByCidade(HttpServletRequest request, @RequestParam Long idCidade){

		logger.info("Controller success! Param: [City]:"+idCidade);

//		Retorno retorno = new Retorno();
//		localizacaoService.save(localizacao);
//		return retorno;
		
		List<CategoriaVo> estabelecimentos = estabelecimentoService.findByCity(idCidade);
		
		return estabelecimentos;
	}
	
	@RequestMapping(value="/filtrarByPostcode", method=RequestMethod.GET)
	public @ResponseBody List<CategoriaVo> index(HttpServletRequest request, @RequestParam Long idCidade, @RequestParam Integer postcode){

		logger.info("Controller success! Param: [Postcode]:"+postcode);

//		Retorno retorno = new Retorno();
//		localizacaoService.save(localizacao);
//		return retorno;
		
		List<CategoriaVo> estabelecimentos = estabelecimentoService.filtrarByPostcode(idCidade, postcode);
		
		return estabelecimentos;
		
	}

	@RequestMapping(value="/find", method=RequestMethod.GET)
	public @ResponseBody InfoEstabelecimentoVo findById(HttpServletRequest request, @RequestParam Long idEstabelecimento){

		logger.info("Controller success! Param: [idEstabelecimento]:"+idEstabelecimento);

		InfoEstabelecimentoVo ie = estabelecimentoService.findById(idEstabelecimento);
		return ie;
		
	}
	
//	/**
//	 * Verifica se existe usuário cadastrado com o email do novo cadastro
//	 * Email deve ser único entre os usuários
//	 * @param request
//	 * @param usuarioLogin - objeto com informacao do email
//	 * @return
//	 */
//	@RequestMapping(value="/salvarLocalizacao", method=RequestMethod.POST)
//	public @ResponseBody Retorno checkValidUsuario(HttpServletRequest request, @RequestBody Localizacao localizacao){
//
//		logger.info("Salvando localizacao para usuário "+localizacao.getIdUsuario());
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
//	 * Obtem informaçoes do usuário e perfil
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
//	 * Obtem informaçoes do usuário e perfil
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
//	 * Verificar amigos cadastrados com informações de contatos do usuário
//	 * Recebe lista de Contatos do usuário e verifica quais usuários possuem 
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
//			logger.info("Adicionando amizade entre usuário "+contatoAgendaUsuario.getIdUsuario()+" e usuário "+usuarioWithCellphone.getId());
//
//			if (contatoAgendaUsuario.getIdUsuario().equals(usuarioWithCellphone.getId())){
//				//Solicitacao para próprio usuário
//				retornoAddAmizade.setResultado(false);
//				retornoAddAmizade.setMensagem("Não é possível adicionar uma amizade o próprio usuário.");
//				retornoAddAmizade.setCodigo(CodigosRetorno.ERROR);
//				return retornoAddAmizade;
//			}
//
//			/*
//			 * Verifica relação entre usuários
//			 * Caso NAO exista relacao de amizade entre usuários, realiza solicitação de amizade
//			 */
//			Amizade amizadeEncontrada = amizadeService.findAmizadeEntreUsuarios(contatoAgendaUsuario.getIdUsuario(), usuarioWithCellphone.getId()); 
//			if (amizadeEncontrada == null){
//				/*
//				 *  Não existe relacao de amizade identificada entre usuário
//				 *  Nova amizade é solicitada com a dataAtual e fica pendente enquanto dataAprovacao == null
//				 */
//				Amizade amizade = new Amizade();
//				amizade.setIdUsuario1(contatoAgendaUsuario.getIdUsuario());
//				amizade.setIdUsuario2(usuarioWithCellphone.getId());
//				amizade.setDataSolicitacao(new Date());
//				amizadeService.save(amizade);
//
//				retornoAddAmizade.setResultado(true);
//				retornoAddAmizade.setMensagem("Solicitação de Amizade enviada com sucesso.");
//				retornoAddAmizade.setCodigo(CodigosRetorno.SUCESS);
//
//			}else{
//				/*
//				 * Já existe identificação de amizade entre usuários
//				 * Amizade já concretizada ou Solicitação pendente aguardando aprovação 
//				 */
//				if (amizadeEncontrada.getDataAprovacao()!=null){
//					retornoAddAmizade.setResultado(false);
//					retornoAddAmizade.setMensagem("Já existe amizade entre os usuários selecionados");
//					retornoAddAmizade.setCodigo(CodigosRetorno.AMIZADE_EXISTENTE);
//
//				}else{
//					retornoAddAmizade.setResultado(false);
//					retornoAddAmizade.setMensagem("Aguardando aprovação da solicitação de amizade entre usuários.");
//					retornoAddAmizade.setCodigo(CodigosRetorno.AMIZADE_AGUARDANDO_APROVACAO);
//				}
//			}
//		}else{
//			/*
//			 * Não existe usuário registrado com o Celular correspondente
//			 */
//			retornoAddAmizade.setResultado(false);
//			retornoAddAmizade.setMensagem("Nenhum usuário encontrado com o telefone: "+cellphone);
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
//		logger.info("Desfazendo amizade do usuário "+idUsuario+" e usuário "+listaIdUsuarios.toArray().toString());
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
//			retornoConvite.setMensagem("Convite já existente para telefone: "+phone);
//			retornoConvite.setCodigo(CodigosRetorno.CONVITE_EXISTENTE);
//		}
//
//		return retornoConvite;
//	}


}
