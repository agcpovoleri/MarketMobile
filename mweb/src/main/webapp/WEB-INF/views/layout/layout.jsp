<<<<<<< Updated upstream
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td height="250"><tiles:insertAttribute name="menu" /></td>
        <td width="350"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
=======
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/inc/meta.jsp"/>
<title>MarketMobile - In�cio</title>


<link href='//fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic%7CPT+Gudea:400,700,400italic%7CPT+Oswald:400,700,300'
	  rel='stylesheet' id="googlefont">

<jsp:include page="/WEB-INF/views/inc/common-css.jsp"/>

<!-- Favicon and Apple Icons -->
<link rel="icon" type="image/png"
	href="${ctx}/static/images/icons/icon.png">
<link rel="apple-touch-icon" sizes="57x57"
	href="${ctx}/static/images/icons/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${ctx}/static/images/icons/apple-icon-72x72.png">

<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->

<style id="custom-style">

</style>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	
	<div id="wrapper">
        <tiles:insertAttribute name="header" />
        
        <tiles:insertAttribute name="body" />
        
        
        <tiles:insertAttribute name="footer" />
    </div><!-- End #wrapper -->
    
    <a href="#" id="scroll-top" title="Scroll to Top"><i class="fa fa-angle-up"></i></a><!-- End #scroll-top -->
 
 
 	
	<!-- END -->
	<jsp:include page="/WEB-INF/views/inc/common-javascript.jsp"/> 
	

</body>


>>>>>>> Stashed changes
</html>