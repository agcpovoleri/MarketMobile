<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	
       	<section id="content" class="no-content">
        	
        	<div class="lg-margin"></div><!-- Space -->
        	<div class="container">
        		<div class="row">
        			<div class="col-md-12">
        				<div class="no-content-comment">
                            <h2>404</h2>
                            <h3>It's not my fault buddy! <br> I think you got lost.</h3>
                        </div><!-- End .no-content-comment -->
        			</div><!-- End .col-md-12 -->
        		</div><!-- End .row -->
			</div><!-- End .container -->
        
        </section><!-- End #content -->
	
	</tiles:putAttribute>
</tiles:insertDefinition>
