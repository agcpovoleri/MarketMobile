<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>
<div id="home-sis-web-mid-menu">
<c:url value="/index" var="url_inicio"></c:url>
<h1><a href="${url_inicio}">Avisos Importantes</a></h1>
<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO')">
	<c:url value="/cliente/dadosCadastrais" var="url_dados_cadastrais"></c:url>
	<h1><a href="${url_dados_cadastrais}">Dados Pessoais</a></h1>
	<c:url value="/cliente/financeiro" var="url_financeiro"></c:url>
	<h1><a href="${url_financeiro}">Meus Boletos</a></h1>
	<c:url value="/cliente/fundo" var="url_fundo"></c:url>
	<h1><a href="${url_fundo}">Documentos do Fundo de Formatura</a></h1>
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	<c:url value="/config/configuracaoFundo" var="url_config_fundo"></c:url>
	<h1><a href="${url_config_fundo}">Configurações dos Fundos</a></h1>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO')">
	<c:url value="/config/desligamentoFundo" var="url_desligamento_fundo"></c:url>
	<h1><a href="${url_desligamento_fundo}">Desligamento</a></h1>
</sec:authorize>

<c:if test="${clienteFlComissao == true}">
	<!-- ADICIONAR CONTROLE PARA VISUALIZACAO - SOMENTE PARA RESPONSAVEL PELO FUNDO -->
		<c:url value="/cliente/relatorioInadimplentes" var="url_inadimplencia"></c:url>
		<h1><a href="${url_inadimplencia}">Relatório de Inadimplência</a></h1>
	<!-- ADICIONAR CONTROLE PARA VISUALIZACAO - SOMENTE PARA RESPONSAVEL PELO FUNDO -->	
</c:if>

<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO','ROLE_ADMIN')">
	<c:url value="/cliente/alteracaoSenha" var="url_alterar_senha"></c:url>
	<h1><a href="${url_alterar_senha}">Alterar senha </a></h1>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	<c:url value="/arquivos/arquivoFundo" var="url_upload_arquivo"></c:url>
	<h1><a href="${url_upload_arquivo}">Upload arquivos</a></h1>
	<c:url value="/aviso/cadastro" var="url_avisos"></c:url>
	<h1><a href="${url_avisos}">Avisos</a></h1>
	<c:url value="/cliente/adminAlterarUsuario" var="autenticacao_usuario"></c:url>
	<h1><a href="${autenticacao_usuario}">Acesso Usuário</a></h1>
</sec:authorize>
<h1><a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">Sair </a></h1>
</div>

<%-- 
			<div class="box" style="width: 150px;height: 100%; " align="left">
				<div class="menu" align="center" style="padding-top: 10px;">
				<table style="font-weight: bold;" cellpadding="2">
				<tr>
					<td align="center">
						<b style="color:#E78F08;text-decoration: underline;">MENU </b><br><br>
					</td>
				</tr>
				<tr>
					<td align="left">
					<c:url value="/index" var="url_inicio"></c:url>
						<a href="${url_inicio}">- Início </a>
					</td>
				</tr>
				<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO')">
				<tr>
					<td align="left">
						<c:url value="/cliente/dadosCadastrais" var="url_dados_cadastrais"></c:url>
						<a href="${url_dados_cadastrais}">- Dados cadastrais </a><br>
					</td>
				</tr>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO')">
				<tr>
					<td align="left">
						<c:url value="/cliente/financeiro" var="url_financeiro"></c:url>
						<a href="${url_financeiro}">- Financeiro </a><br>
					</td>
				</tr>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO')">
				<tr>
					<td align="left">
						<c:url value="/cliente/fundo" var="url_fundo"></c:url>
						<a href="${url_fundo}">- Fundo </a><br>
					</td>
				</tr>
				</sec:authorize>
				
				<!-- 
				<tr>
					<td>
						<c:url value="/usuario/listar" var="url_fundo"></c:url>
						<a href="${url_fundo}">- Usuarios </a><br>
					</td>
				</tr>
				 -->
				<sec:authorize access="hasAnyRole('ROLE_INTEGRANTE_FUNDO','ROLE_ADMIN')">
				<tr>
					<td align="left">
						<c:url value="/cliente/alteracaoSenha" var="url_alterar_senha"></c:url>
						<a href="${url_alterar_senha}">- Alterar senha </a><br>
					</td>
				</tr>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<tr>
					<td align="left">
						<c:url value="/arquivos/arquivoFundo" var="url_upload_arquivo"></c:url>
						<a href="${url_upload_arquivo}">- Upload de arquivos </a><br>
					</td>
				</tr>
				</sec:authorize>
				
				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<tr>
					<td align="left">
						<c:url value="/aviso/cadastro" var="url_avisos"></c:url>
						<a href="${url_avisos}">- Avisos</a><br>
					</td>
				</tr>
				</sec:authorize>
				
				
				<tr>
					<td align="left">
						<a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">- Sair </a><br>
					</td>
				</tr>
				</table>
				</div>
			</div>
			--%>