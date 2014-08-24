<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<http auto-config="true" use-expressions="true">
<head>

</head>

<body>
	<h1>Obrigado por ter se cadastrado. Para entrar acesse o link abaixo:</h1>
	<c:url value="/login" var="url_action" />
	<a href="${url_action}">Ir para pagina de login</a>
</body>
<!-- Final da página-->

</html>