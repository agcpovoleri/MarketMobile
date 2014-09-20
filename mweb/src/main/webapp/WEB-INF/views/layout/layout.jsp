<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/inc/meta.jsp"/>
<title>MarketMobile - Início</title>


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


</html>