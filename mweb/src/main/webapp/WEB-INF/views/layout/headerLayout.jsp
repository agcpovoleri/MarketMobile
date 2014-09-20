<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<header id="header">
	<div id="header-top">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="header-top-left">
						<ul id="top-links" class="clearfix">
							<li><a href="#" title="My Wishlist"><span
									class="top-icon top-icon-pencil"></span><span
									class="hide-for-xs">My Wishlist</span></a></li>
							<li><a href="#" title="My Account"><span
									class="top-icon top-icon-user"></span><span class="hide-for-xs">My
										Account</span></a></li>
							<li><a href="cart.html" title="My Cart"><span
									class="top-icon top-icon-cart"></span><span class="hide-for-xs">My
										Cart</span></a></li>
							<li><a href="checkout.html" title="Checkout"><span
									class="top-icon top-icon-check"></span><span
									class="hide-for-xs">Checkout</span></a></li>
							<security:authorize access="hasAnyRole('ROLE_ADMIN')">		
							<li><a href="${ctx}/logout" title="Aministration Área"><span
									class="top-icon top-icon-check"></span><span
									class="hide-for-xs"><b>Administation</b></span></a></li>
							</security:authorize>				
								
						</ul>
					</div>
					<!-- End .header-top-left -->
					<div class="header-top-right">

						<div class="header-top-dropdowns pull-right">
							<div class="btn-group dropdown-money">
								<button type="button" class="btn btn-custom dropdown-toggle"
									data-toggle="dropdown">
									<span class="hide-for-xs">US Dollar</span><span
										class="hide-for-lg">$</span>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a href="#"><span class="hide-for-xs">Euro</span><span
											class="hide-for-lg">&euro;</span></a></li>
									<li><a href="#"><span class="hide-for-xs">Pound</span><span
											class="hide-for-lg">&pound;</span></a></li>
								</ul>
							</div>
							<!-- End .btn-group -->
							<div class="btn-group dropdown-language">
								<button type="button" class="btn btn-custom dropdown-toggle"
									data-toggle="dropdown">
									<span class="flag-container"><img
										src="${ctx}/static/images/england-flag.png"
										alt="flag of england"></span> <span class="hide-for-xs">English</span>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a href="#"><span class="flag-container"><img
												src="${ctx}/static/images/italy-flag.png"
												alt="flag of england"></span><span class="hide-for-xs">Italian</span></a></li>
									<li><a href="#"><span class="flag-container"><img
												src="${ctx}/static/images/spain-flag.png"
												alt="flag of italy"></span><span class="hide-for-xs">Spanish</span></a></li>
									<li><a href="#"><span class="flag-container"><img
												src="${ctx}/static/images/france-flag.png"
												alt="flag of france"></span><span class="hide-for-xs">French</span></a></li>
									<li><a href="#"><span class="sm-separator"><img
												src="${ctx}/static/images/germany-flag.png"
												alt="flag of germany"></span><span class="hide-for-xs">German</span></a></li>
								</ul>
							</div>
							<!-- End .btn-group -->
						</div>
						<!-- End .header-top-dropdowns -->

						<div class="header-text-container pull-right">
							<p class="header-text">Welcome to Venedor!</p>
							<p class="header-link">
								
								<security:authorize ifNotGranted="ROLE_USER">
									<a href="${ctx}/login">login</a>&nbsp;or&nbsp;
									<a href="${ctx}/usuario/novo">Create an account</a> &nbsp;
								</security:authorize>
								
								<security:authorize ifAnyGranted="ROLE_USER">
									<a href="${ctx}/logout">logout</a>
								</security:authorize>

								
						</div>
						</p>
					</div>
					<!-- End .pull-right -->
				</div>
				<!-- End .header-top-right -->
			</div>
			<!-- End .col-md-12 -->
		</div>
		<!-- End .row -->
	</div>
	<!-- End .container -->
	</div>
	<!-- End #header-top -->

	<div id="inner-header">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-sm-5 col-xs-12 logo-container">
					<h1 class="logo clearfix">
						<span>Responsive eCommerce Template</span> <a href="index.html"
							title="Venedor eCommerce Template"><img
							src="${ctx}/static/images/logo.png"
							alt="Venedor Commerce Template" width="238" height="76"></a>
					</h1>
				</div>
				<!-- End .col-md-5 -->
				<div class="col-md-7 col-sm-7 col-xs-12 header-inner-right">

					<div class="header-box contact-infos pull-right">
						<ul>
							<li><span class="header-box-icon header-box-icon-skype"></span>venedor_support</li>
							<li><span class="header-box-icon header-box-icon-email"></span><a
								href="mailto:venedor@gmail.com">venedor@gmail.com</a></li>
						</ul>
					</div>
					<!-- End .contact-infos -->

					<div class="header-box contact-phones pull-right clearfix">
						<span class="header-box-icon header-box-icon-earphones"></span>
						<ul class="pull-left">
							<li>+(404) 158 14 25 78</li>
							<li>+(404) 851 21 48 15</li>
						</ul>
					</div>
					<!-- End .contact-phones -->

				</div>
				<!-- End .col-md-7 -->
			</div>
			<!-- End .row -->
		</div>
		<!-- End .container -->

		<tiles:insertAttribute name="menu" />

	</div>
	<!-- End #inner-header -->
</header>
<!-- End #header -->
