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