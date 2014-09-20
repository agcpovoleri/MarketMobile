package com.marketmobile.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.marketmobile.common.security.entity.dao.MyUser;
import com.marketmobile.model.Usuario;
import com.marketmobile.model.UsuarioLogin;
import com.marketmobile.service.UsuarioService;

public class ValidarClienteSessionFilter extends OncePerRequestFilter {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ValidarClienteSessionFilter.class);

	@Autowired
	UsuarioService usuarioService;

	private void atribuirInformacaoCliente(HttpServletRequest request, HttpServletResponse response) {

		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth!=null && auth.getPrincipal() instanceof  MyUser) {

			MyUser userDetails = (MyUser) auth.getPrincipal();
			
			if (userDetails.isEnabled()) {
				
				HttpSession session = request.getSession();

				logger.debug("[BASE] Atribuir cliente:"+request.getContextPath());
				
				String username = auth.getName();

				UsuarioLogin user = new UsuarioLogin();
				user.setEmail(username);
				
				Usuario u = usuarioService.findUsuarioByEmail(user);
				
//				Cliente clienteOldSession = null;
//				Cliente clienteCurrentSession = null;
//				if (u.getIdCliente()!=null){
//					clienteOldSession = (Cliente) session.getAttribute("clienteLogado");
//					/* 
//					 * Se Existe ClienteOld na sessao,verifica se o ID eh igual o idCliente.
//					 * Caso TRUE, nao faz nada pois o cliente ja esta na sessão
//					 * Caso contrário, busca cliente e atualiza sessão
//					 *  
//					 */ 
//					if (clienteOldSession!=null && clienteOldSession.getIdCliente().equals(u.getIdCliente())){
//						/*
//						 * Não faz nada pois cliente referente ao usuario logado já esta na sessão
//						 */
//					}else {
//						clienteCurrentSession = clienteService.buscarClientePeloId(u.getIdCliente());
//						if (clienteOldSession == null || !clienteOldSession.equals(clienteCurrentSession)){
//
//							if (clienteCurrentSession!=null){
//								session.setAttribute("clienteLogado", clienteCurrentSession);
//								boolean comissao;
//								if	(clienteCurrentSession.getOcupacao() == null || 
//									 clienteCurrentSession.getOcupacao().equals(-1) || clienteCurrentSession.getOcupacao().equals(0)){
//									comissao = false;
//								}else{
//									comissao = true;
//								}
//								session.setAttribute("clienteFlComissao",comissao);
//							}else{
//								session.removeAttribute("clienteLogado");
//								session.removeAttribute("clienteFlComissao");
//							}
//						}
//					}
//				}else{
//					session.removeAttribute("clienteLogado");
//					session.removeAttribute("clienteFlComissao");
//				}
				
				/*
				 * Se cliente existente na sessao diferente do cliente logado,atualiza o cliente na sessao
				 * Caso contrario, continua sem precisar adicionar nada na sessao
				 * 
				 * Caso o usuario logado nao seja um cliente, estas informações sao removidas da sessao. 
				 */
				
				
				
				
			}
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		long inicio = System.currentTimeMillis();

		atribuirInformacaoCliente(request,response);

		chain.doFilter(request, response);

		long fim = System.currentTimeMillis();

        String nome = "";
        if (request instanceof HttpServletRequest) {
            nome = ((HttpServletRequest)request).getRequestURI();
        }
        logger.info("[perf];"+nome + ";" + (fim - inicio) + ";ms");

	}
}
