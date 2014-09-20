<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>MarketMobile</TITLE>

</HEAD>


<BODY>
	<h1>MarketMobile</h1>
	<c:url value="/logout" var="logoutUrl" />
	<c:set var="view" value="/WEB-INF/views"></c:set>
	
	<jsp:include page="${view}/layout/header.jsp" />
	<ul>
		<li><a href="${logoutUrl}" >Logout</a></li>
		<li><%= request.getContextPath() %></li>
	</ul>
	<p>
		O jeito mais f�cil de realizar suas compras online sem se preocupar com todos inconveni�ntes que atrapalham o seu dia a dia.
		Seu pedido pode ser buscado na loja no horario agendado ou voc� poder� recebe-las sem sair do desconforto da sua casa no hor�rio mais adequado.
	</p>
	
	<h2>Miss�o</h2>
	<p>Oferecer uma plataforma simplificada de venda online para diferentes estabelecimentos comerciais onde os usu�rios 
		tenham facilidade de comprar e agendar a entrega de seus produtos, bem como as empresas associadas maximizar suas vendas.</p>
	
	<h2>Vis�o</h2>
	<p>Estar entre um dos principais meios de compra online de produtos a n�vel local nas cidades gerando valor a clientes e colaboradores.</p>
	
	<h2>Valores</h2>
	<p>Nosso relacionamento com clientes e colaboradores deve ser transparente e baseado na responsabilidade e confian�a entre as partes.</p>
</BODY>
	
</HTML>


