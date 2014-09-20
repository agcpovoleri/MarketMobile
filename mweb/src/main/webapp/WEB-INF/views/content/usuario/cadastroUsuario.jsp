<<<<<<< Updated upstream
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<http auto-config="true" use-expressions="true">
<head>

<title>Cadastro de adesão - Dados cadastrais</title>



</head>

<body>
	${teste }
	<c:url value="/usuario/cadastrar" var="url_form" />
	<form:form id="formCadastro" action="${url_form}" method="POST" modelAttribute="formUsuario">


		<h2>
			Nome: &nbsp;
			<form:errors path="nome" cssStyle="color:red; font:12px verdana;" />
			<form:input size="69" path="nome" class="textField" />
		</h2>

		<h2>
			* E-mail: &nbsp;
			<form:errors path="email" cssStyle="color:red; font:12px verdana;" />
			<form:input size="30" maxlength="60" path="email" id="email"
				class="validate[required,custom[email]] textField" />
		</h2>

		<h2>
			* Confirmar E-mail: &nbsp <input size="30" maxlength="60"
				name="confirmemail" id="confirmacaoemail"
				class="validate[required,custom[email]] textField">
		</h2>

		<h2>
			Login:
			<form:errors path="login" cssStyle="color:red; font:12px verdana;" />
		</h2>
		<h2>
			<form:input size="30" maxlength="50" path="login"
				class="validate[required,custom[onlyLetterNumber]] textFieldCinza" />
		</h2>
		<h2>
			Senha: &nbsp;
			<form:errors path="senha" cssStyle="color:red; font:12px verdana;" />
			<form:password size="30" path="senha" id="txtNovaSenha"
				class="validate[required] textField" />
		</h2>
		<h2>
			<form:select path="idPergunta" cssStyle="text-transform: uppercase;"
				cssClass="cbxCinza">
				<form:option selected="" value="">- Selecione -</form:option>
				<form:options items="${perguntas}" itemLabel="pergunta"
					itemValue="idPergunta" />
			</form:select>
		</h2>
		<h1>Resposta:</h1>
		<form:input path="resposta" size="69"
			class="validate[funcCall[validarResposta]] cbxCinza" />

		<!-- BOTOES -->

		<a href="#" onclick="location.href='<c:url value='/login'/>'">cancelar</a>
		<a href="#" onclick="submeterFormulario();"><button type="submit" form="formCadastro" title="Cadastrar"></a>


	</form:form>

</body>
<!-- Final da página-->

</html>
=======
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
        		<div class="row">
        			<div class="col-md-12">
						<header class="content-title">
							<h1 class="title">Register Account</h1>
							<c:url value="/login" var="url_login" />
							<p class="title-desc">If you already have an account, please login at <a href="${url_login }">login page</a>.</p>
						</header>
        				<div class="xs-margin"></div><!-- space -->
						
						<c:url value="/usuario/cadastrar" var="url_form" />
						<form:form action="${url_form }" id="register-form" method="POST" modelAttribute="formUsuario">
        				<div class="row">
        					
								<div class="col-md-6 col-sm-6 col-xs-12">
									
									<fieldset>
									<h2 class="sub-title">YOUR PERSONAL DETAILS</h2>
									<div class="input-group">
										<span class="input-group-addon">
											<span class="input-icon input-icon-user"></span>
											<span class="input-text">First Name&#42;</span>
										</span>
										
										<form:input path="firstName" required="required" placeholder="Your First Name" class="form-control input-lg"/>
									</div><!-- End .input-group -->
									<div class="input-group">
										<span class="input-group-addon"><span class="input-icon input-icon-user"></span><span class="input-text">Last Name&#42;</span></span>
										<form:input path="lastName" required="required" placeholder="Your Last Name" class="form-control input-lg"/>
									</div><!-- End .input-group -->
									
									<div class="input-group">
										<span class="input-group-addon"><span class="input-icon input-icon-user"></span><span class="input-text">Username&#42;</span></span>
										<form:input  path="login" type="text" required="required" class="form-control input-lg validate[required,custom[onlyLetterNumber]]" placeholder="Username"/>
									</div><!-- End .input-group -->
									
									<div class="input-group">
										<span class="input-group-addon"><span class="input-icon input-icon-email"></span><span class="input-text">Email&#42;</span></span>
										<form:input type="text" path="email" required="required" class="form-control input-lg validate[required,custom[email]]" placeholder="Your Email"/>
									</div><!-- End .input-group -->
									<div class="input-group">
										<span class="input-group-addon"><span class="input-icon input-icon-email"></span><span class="input-text">Confirm Email&#42;</span></span>
										<input type="text" name="confirmemail" required="required" class="form-control input-lg validate[required,custom[email]]" placeholder="Your Email"/>
									</div><!-- End .input-group -->
									
									</fieldset>
																		
								</div><!-- End .col-md-6 -->
        						<div class="col-md-6 col-sm-6 col-xs-12">
									<fieldset>
										<h2 class="sub-title">YOUR PASSWORD</h2>
										<div class="input-group">
											<span class="input-group-addon"><span class="input-icon input-icon-password"></span><span class="input-text">Password&#42;</span></span>
											<form:password path="senha" required='required' class="form-control input-lg validate[required]" placeholder="Your Password"/>
										</div><!-- End .input-group -->
										<div class="input-group">
											<span class="input-group-addon"><span class="input-icon input-icon-password"></span><span class="input-text">Confirm&#42;</span></span>
											<input type="password" required class="form-control input-lg" placeholder="Your Password">
										</div><!-- End .input-group -->
									</fieldset>
								
									
								${id }
									<fieldset class="half-margin">
										<h2 class="sub-title">NEWSLETTER</h2>
											<div class="input-desc-box">
												<span class="separator icon-box">&plus;</span>I wish to subscribe to the Venedor newsletter.
											</div><!-- End .input-desc -->
										
										<div class="input-group custom-checkbox">
										 <form:checkbox path="receiveNewsletter" value="true"/> 
										 <span class="checbox-container">
										 	<i class="fa fa-check"></i>
										 </span>
										 I have reed and agree to the <a href="#">Privacy Policy</a>.
										 
										</div><!-- End .input-group -->
									</fieldset>
									
									<a href="#" onclick="location.href='<c:url value='/login'/>'">
										<input type="submit" value="CANCEL" class="btn btn-custom-1 md-margin">
									</a>
									<input type="submit" value="CREATE MY ACCCOUNT" class="btn btn-custom-2 md-margin">
								</div><!-- End .col-md-6 -->
        						
        				</div><!-- End .row -->
						
        				</form:form>
        			</div><!-- End .col-md-12 -->
        		</div><!-- End .row -->
			</div><!-- End .container -->
        
	</tiles:putAttribute>
</tiles:insertDefinition>
>>>>>>> Stashed changes
