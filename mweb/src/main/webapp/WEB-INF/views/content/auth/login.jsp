<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<section id="content">
        	<div id="breadcrumb-container">
        		<div class="container">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">Login</li>
					</ul>
        		</div>
        	</div>
			<div class="container">
        		<div class="row">
        			<div class="col-md-12">
						<header class="content-title">
							<h1 class="title">Login or Create An Account</h1>
                            <div class="md-margin"></div><!-- space -->
						</header>
        			
						   <div class="row">
							   	
							   	<div class="col-md-6 col-sm-6 col-xs-12">					   		
							   		<h2>New Customer</h2>
							   		
							   	<p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                                <div class="md-margin"></div><!-- space -->
							   	
							   	<c:url value="${context}/usuario/novo" var="url_new_user" />
							   	<a href="${url_new_user }" class="btn btn-custom-2">Create An Account</a>
                                <div class="lg-margin"></div><!-- space -->
							   	</div><!-- End .col-md-6 -->
							   	<div class="col-md-6 col-sm-6 col-xs-12">					   		
							   		<h2>Registered Customers</h2>
							   		<p>If you have an account with us, please log in.</p>
							   		<div class="xs-margin"></div>
							   		
									<form id="login-form" method="POST" action="<c:url value='${context}/check' />">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="input-icon input-icon-email"></span><span class="input-text">Username or Email&#42;</span></span>
                                            <input type="text" name='username' required class="form-control input-lg" placeholder="Your Username or Email">
                                        </div><!-- End .input-group -->
                                         <div class="input-group xs-margin">
                                            <span class="input-group-addon"><span class="input-icon input-icon-password"></span><span class="input-text">Password&#42;</span></span>
                                            <input type="password" name='password' required class="form-control input-lg" placeholder="Your Password">
                                        </div><!-- End .input-group -->
                                         <div class="input-group">
		                                    <span class="input-group-addon no-minwidth">
		                                    <input type="radio" name='_spring_security_remember_me'>
		                                    </span>
		                                    <input type="text" class="form-control" placeholder="Remember me?">
		                                </div><!-- End .input-group -->
                                    <span class="help-block text-right"><a href="#">Forgot your password?</a></span>
                                    <button class="btn btn-custom-2" type="submit">LOGIN</button>
                                    
                                    </form>
                                    <div class="sm-margin"></div><!-- space -->
							   	</div><!-- End .col-md-6 -->
							   	
						   </div><!-- End.row -->
								   
        			</div><!-- End .col-md-12 -->
        		</div><!-- End .row -->
			</div><!-- End .container -->
        </section>
	</tiles:putAttribute>
</tiles:insertDefinition>
