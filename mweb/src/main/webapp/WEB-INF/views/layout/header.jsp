<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />

<tiles:insertDefinition name="headerTemplate">
	<tiles:putAttribute name="menu">

		<div id="main-nav-container">
			<div class="container">
				<div class="row">
					<div class="col-md-12 clearfix">

						<nav id="main-nav">
							<div id="responsive-nav">
								<div id="responsive-nav-button">
									Menu <span id="responsive-nav-button-icon"></span>
								</div>
								<!-- responsive-nav-button -->
							</div>
							<ul class="menu clearfix">
								<li><a class="active" href="index.html">HOME</a>
									<ul>
																				<li><a href="#">Headers</a>
											<ul>
												<li><a href="header1.html">Header Version 1</a></li>
												<li><a href="header2.html">Header Version 2</a></li>
												<li><a href="header3.html">Header Version 3</a></li>
												<li><a href="header4.html">Header Version 4</a></li>
												<li><a href="header5.html">Header Version 5</a></li>
												<li><a href="header6.html">Header Version 6</a></li>
												<li><a href="header7.html">Header Version 7</a></li>
											</ul></li>
										<li><a href="#">Footers</a>
											<ul>
												<li><a href="footer1.html">Footer Version 1</a></li>
												<li><a href="footer2.html">Footer Version 2</a></li>
												<li><a href="footer3.html">Footer Version 3</a></li>
											</ul></li>
										<li><a href="product.html">Product</a></li>
										<li><a href="cart.html">Cart</a></li>
										<li><a href="category.html">Category</a>
											<ul>
												<li><a href="category-list.html">Category list</a></li>
												<li><a href="category.html">Category Banner 1</a></li>
												<li><a href="category-banner-2.html">Category
														Banner 2</a></li>
												<li><a href="category-banner-3.html">Category
														Banner 3</a></li>
											</ul></li>
										<li><a href="blog.html">Blog</a>
											<ul>
												<li><a href="blog.html">Right Sidebar</a></li>
												<li><a href="blog-sidebar-left.html">Left Sidebar</a></li>
												<li><a href="blog-sidebar-both.html">Both Sidebar</a></li>
												<li><a href="single.html">Blog Post</a></li>
											</ul></li>
										<li><a href="checkout.html">Checkout</a></li>
										<li><a href="aboutus.html">About Us</a></li>
										<li><a href="register-account.html">Register Account</a></li>
										<li><a href="compare-products.html">Compare Products</a></li>
										<li><a href="login.html">Login</a></li>
										<li><a href="404.html">404 Page</a></li>
									</ul></li>
								<li class="mega-menu-container"><a href="#">Products</a>
									<div class="mega-menu clearfix">
										<div class="col-5">
											<a href="category.html" class="mega-menu-title">Clothing</a>
											<!-- End .mega-menu-title -->
											<ul class="mega-menu-list clearfix">
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Jeans &amp; Trousers</a></li>
												<li><a href="#">Blouses &amp; Shirts</a></li>
												<li><a href="#">Tops &amp; T-Shirts</a></li>
												<li><a href="#">Jackets &amp; Coats</a></li>
												<li><a href="#">Skirts</a></li>
											</ul>
										</div>
										<!-- End .col-5 -->
										<div class="col-5">
											<a href="category.html" class="mega-menu-title">Shoes</a>
											<!-- End .mega-menu-title -->
											<ul class="mega-menu-list clearfix">
												<li><a href="#">Formal Shoes</a></li>
												<li><a href="#">Casual Shoes</a></li>
												<li><a href="#">Sandals</a></li>
												<li><a href="#">Boots</a></li>
												<li><a href="#">Wide Fit</a></li>
												<li><a href="#">Slippers</a></li>
											</ul>
										</div>
										<!-- End .col-5 -->
										<div class="col-5">
											<a href="category.html" class="mega-menu-title">Accessories</a>
											<!-- End .mega-menu-title -->
											<ul class="mega-menu-list clearfix">
												<li><a href="#">Bags &amp; Purses</a></li>
												<li><a href="#">Belts</a></li>
												<li><a href="#">Gloves</a></li>
												<li><a href="#">Jewellery</a></li>
												<li><a href="#">Sunglasses</a></li>
												<li><a href="#">Hair Accessories</a></li>
											</ul>
										</div>
										<!-- End .col-5 -->
										<div class="col-5">
											<a href="category.html" class="mega-menu-title">Sports</a>
											<!-- End .mega-menu-title -->
											<ul class="mega-menu-list clearfix">
												<li><a href="#">Sport Tops &amp; Vests</a></li>
												<li><a href="#">Swimwear</a></li>
												<li><a href="#">Footwear</a></li>
												<li><a href="#">Sports Underwear</a></li>
												<li><a href="#">Bags</a></li>
											</ul>
										</div>
										<!-- End .col-5 -->

										<div class="col-5">
											<a href="category.html" class="mega-menu-title">Maternity</a>
											<!-- End .mega-menu-title -->
											<ul class="mega-menu-list clearfix">
												<li><a href="#">Tops &amp; Skirts</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Trousers &amp; Shorts</a></li>
												<li><a href="#">Knitwear</a></li>
												<li><a href="#">Jackets &amp; Coats</a></li>
											</ul>
										</div>
										<!-- End .col-5 -->
									</div>
									<!-- End .mega-menu --></li>

								<li><a href="#">DEALS</a>
									<ul>
										<li><a href="#">Last Deals</a>
											<ul>
												<li><a href="#">By Section</a></li>
												<li><a href="#">By Gender</a></li>
												<li><a href="#">Custom</a></li>
											</ul></li>
										<li><a href="#">Favourites</a></li>
										
									</ul></li>
								<li><a href="#">Portfolio</a>
									<ul>
										<li><a href="single-portfolio.html">Image Post</a></li>
												<li><a href="single-portfolio-gallery.html">Gallery
														Post</a></li>
												<li><a href="single-portfolio-video.html">Video
														Post</a></li>
									</ul></li>
								
								<li><a href="#">FAQ</a>
									<ul>
										<li><a href="contact.html">Contact Us</a></li>
										<li><a href="${ctx}/about">About Us</a></li>
									</ul>
								</li>
								
							</ul>

						</nav>

						<div id="quick-access">
							<div class="dropdown-cart-menu-container pull-right">
								<div class="btn-group dropdown-cart">
									<button type="button" class="btn btn-custom dropdown-toggle"
										data-toggle="dropdown">
										<span class="cart-menu-icon"></span> 0 item(s) <span
											class="drop-price">- $0.00</span>
									</button>

									<div
										class="dropdown-menu dropdown-cart-menu pull-right clearfix"
										role="menu">
										<p class="dropdown-cart-description">Recently added
											item(s).</p>
										<ul class="dropdown-cart-product-list">
											<li class="item clearfix"><a href="#"
												title="Delete item" class="delete-item"><i
													class="fa fa-times"></i></a> <a href="#" title="Edit item"
												class="edit-item"><i class="fa fa-pencil"></i></a>
												<figure>
													<a href="product.html"><img
														src="${ctx}/static/images/products/thumbnails/item12.jpg" alt="phone 4"></a>
												</figure>
												<div class="dropdown-cart-details">
													<p class="item-name">
														<a href="product.html">Cam Optia AF Webcam </a>
													</p>
													<p>
														1x <span class="item-price">$499</span>
													</p>
												</div>
												<!-- End .dropdown-cart-details --></li>
											<li class="item clearfix"><a href="#"
												title="Delete item" class="delete-item"><i
													class="fa fa-times"></i></a> <a href="#" title="Edit item"
												class="edit-item"><i class="fa fa-pencil"></i></a>
												<figure>
													<a href="product.html"><img
														src="${ctx}/static/products/thumbnails/item13.jpg" alt="phone 2"></a>
												</figure>
												<div class="dropdown-cart-details">
													<p class="item-name">
														<a href="product.html">Iphone Case Cover Original</a>
													</p>
													<p>
														1x <span class="item-price">$499<span
															class="sub-price">.99</span></span>
													</p>
												</div>
												<!-- End .dropdown-cart-details --></li>
										</ul>

										<ul class="dropdown-cart-total">
											<li><span class="dropdown-cart-total-title">Shipping:</span>$7</li>
											<li><span class="dropdown-cart-total-title">Total:</span>$1005<span
												class="sub-price">.99</span></li>
										</ul>
										<!-- .dropdown-cart-total -->
										<div class="dropdown-cart-action">
											<p>
												<a href="${ctx}/cart" class="btn btn-custom-2 btn-block">Cart</a>
											</p>
											<p>
												<a href="${ctx}/checkout" class="btn btn-custom btn-block">Checkout</a>
											</p>
										</div>
										<!-- End .dropdown-cart-action -->

									</div>
									<!-- End .dropdown-cart -->
								</div>
								<!-- End .btn-group -->
							</div>
							<!-- End .dropdown-cart-menu-container -->

							<form class="form-inline quick-search-form" role="form"
								action="#">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Search here">
								</div>
								<!-- End .form-inline -->
								<button type="submit" id="quick-search" class="btn btn-custom"></button>
							</form>
							
						</div>
						<!-- End #quick-access -->
					</div>
					<!-- End .col-md-12 -->
				</div>
				<!-- End .row -->
			</div>
			<!-- End .container -->
		</div>
		<!-- End #nav -->
	</tiles:putAttribute>
</tiles:insertDefinition>