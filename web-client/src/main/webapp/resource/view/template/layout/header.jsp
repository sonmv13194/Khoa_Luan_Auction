<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<header class="header-style-1">

    <!-- ============================================== TOP MENU ============================================== -->
    <div class="top-bar animate-dropdown">
        <div class="container">
            <div class="header-top-inner">
                <div class="cnt-account">
                    <ul class="list-unstyled">
                        <li><a href="${contextPath}/cart"><i class="icon fa fa-shopping-cart"></i>My Cart</a></li>
                        <li><a href="${contextPath}/checkout"><i class="icon fa fa-check"></i>Checkout</a></li>
                        <li>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="${contextPath }/login">Login/Register</a></li>
                        </c:if>
                        <c:url value="/logout" var="logoutUrl"/>
                        <form id="logout" action="${logoutUrl}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <span>Hello, ${pageContext.request.userPrincipal.name}</span>
                            <a href="javascript:document.getElementById('logout').submit()">Logout</a>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="${contextPath }/admin">Admin Page</a></li>
                            </sec:authorize>
                        </c:if>
                        </li>
                    </ul>
                </div><!-- /.cnt-account -->

                <div class="cnt-block">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown"><span
                                    class="value">USD </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">USD</a></li>
                                <li><a href="#">INR</a></li>
                                <li><a href="#">GBP</a></li>
                            </ul>
                        </li>

                        <li class="dropdown dropdown-small">
                            <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown"><span
                                    class="value">English </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">French</a></li>
                                <li><a href="#">German</a></li>
                            </ul>
                        </li>
                    </ul><!-- /.list-unstyled -->
                </div><!-- /.cnt-cart -->
                <div class="clearfix"></div>
            </div><!-- /.header-top-inner -->
        </div><!-- /.container -->
    </div><!-- /.header-top -->
    <!-- ============================================== TOP MENU : END ============================================== -->
    <div class="main-header">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
                    <!-- ============================================================= LOGO ============================================================= -->
                    <div class="logo">
                        <a href="/">

                            <img src="${contextPath}/resource/view/template/assets/images/logo.png" alt="">

                        </a>
                    </div><!-- /.logo -->
                    <!-- ============================================================= LOGO : END ============================================================= -->
                </div><!-- /.logo-holder -->

                <div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
                    <!-- /.contact-row -->
                    <!-- ============================================================= SEARCH AREA ============================================================= -->
                    <div class="search-area">
                        <form>
                            <div class="control-group">

                                <ul class="categories-filter animate-dropdown">
                                    <li class="dropdown">

                                        <a class="dropdown-toggle" data-toggle="dropdown" href="product.html">Categories
                                            <b class="caret"></b></a>

                                        <ul class="dropdown-menu" role="menu">
                                            <li class="menu-header">Food</li>
                                            <c:forEach var="category" items="${listCategory}">
                                                <li role="presentation">
                                                    <a role="menuitem" tabindex="-1" href="category.html">- ${category.categoryName}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </ul>

                                <input class="search-field" placeholder="Search here..." name="searchProductDetail"/>

                                <a class="search-button" href="#"></a>

                            </div>
                        </form>
                    </div><!-- /.search-area -->
                    <!-- ============================================================= SEARCH AREA : END ============================================================= -->
                </div><!-- /.top-search-holder -->

                <div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">
                    <!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->

                    <div class="dropdown dropdown-cart"><a href="#" class="dropdown-toggle lnk-cart"
                                                           data-toggle="dropdown">
                        <div class="items-cart-inner">
                            <div class="basket"><i class="glyphicon glyphicon-shopping-cart"></i></div>
                            <div class="basket-item-count"><span class="count">${countItem}</span></div>
                            <div class="total-price-basket"><span class="lbl">cart -</span> <span
                                    class="total-price"> <span class="sign">$</span><span
                                    class="value">${sessionScope.total}</span> </span></div>
                        </div>
                    </a>
                        <ul class="dropdown-menu">
                            <li>
                                <c:forEach var="cart" items="${sessionScope.cartSession}">
                                    <div class="cart-item product-summary">
                                        <div class="row">
                                            <div class="col-xs-4">
                                                <div class="image"><a href="detail.html"><img
                                                        src="/uploaded-image/${cart.productDetail.productImages.get(0).url}" alt=""></a>
                                                </div>
                                            </div>
                                            <div class="col-xs-7">
                                                <h3 class="name"><a
                                                        href="index.php?page-detail">${cart.productDetail.product.productName} </a>
                                                </h3>
                                                <div class="price">$ ${cart.productDetail.productDetailPrice }</div>
                                                <p>(x ${cart.quantity})</p>
                                            </div>
                                            <div class="col-xs-1 action"><a
                                                    href='<c:url value="${contextPath }/cart/removeCartInHome"><c:param name="product_id" value="${cart.productDetail.id}" /></c:url>'><i
                                                    class="fa fa-trash"></i></a></div>
                                        </div>
                                    </div>
                                    <!-- /.cart-item -->
                                </c:forEach>
                                <div class="clearfix"></div>
                                <hr>
                                <div class="clearfix cart-total">
                                    <div class="pull-right"><span class="text">Sub Total :</span><span
                                            class='price'>$ ${sessionScope.total}</span></div>
                                    <div class="clearfix"></div>
                                    <a href="${contextPath}/checkout"
                                       class="btn btn-upper btn-primary btn-block m-t-20">Checkout</a></div>
                                <!-- /.cart-total-->

                            </li>
                        </ul>
                        <!-- /.dropdown-menu-->
                    </div>
                </div>

                <!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->
            </div><!-- /.top-cart-row -->
        </div><!-- /.row -->

    </div><!-- /.container -->

    </div><!-- /.main-header -->

    <!-- ============================================== NAVBAR ============================================== -->
    <div class="header-nav animate-dropdown">

        <div class="container">

            <div class="yamm navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button data-target="#mc-horizontal-menu-collapse" data-toggle="collapse"
                            class="navbar-toggle collapsed" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="nav-bg-class">

                    <div class="navbar-collapse collapse" id="mc-horizontal-menu-collapse">

                        <div class="nav-outer">

                            <ul class="nav navbar-nav">
                                <li class="active dropdown yamm-fw">
                                    <a href="home.html" data-hover="dropdown" class="dropdown-toggle"
                                       data-toggle="dropdown">Home</a>
                                </li>
                                <c:forEach var="categoryNew" items="${listCategory}">
                                    <li class="dropdown yamm mega-menu">
                                        <a href="home.html" data-hover="dropdown" class="dropdown-toggle" data-toggle="dropdown">${categoryNew.categoryName}</a>
                                        <ul class="dropdown-menu conta	iner">
                                            <li>
                                                <div class="yamm-content ">
                                                    <div class="row">
                                                        <c:forEach var="product" items="${listProduct}">
                                                            <c:if test="${product.category.id == categoryNew.id}">
                                                                <div class="col-xs-12 col-sm-6 col-md-2 col-menu">
                                                                    <h2 class="title">${product.productName}</h2>
                                                                    <ul class="links">
                                                                        <c:forEach var="productDetail" items="${product.productDetails}">
                                                                            <li><a href='<c:url value="product"><c:param name="check" value="${product.id}" /></c:url>'>${productDetail.productDetailName}</a></li>
                                                                        </c:forEach>
                                                                    </ul>
                                                                </div><!-- /.col -->
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>

                                            </li>
                                        </ul>

                                    </li>
                                </c:forEach>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">Pages</a>
                                    <ul class="dropdown-menu pages">
                                        <li>
                                            <div class="yamm-content">
                                                <div class="row">

                                                    <div class="col-xs-12 col-menu">
                                                        <ul class="links">
                                                            <li><a href="/">Home</a></li>
                                                            <li><a href='<c:url value="product"><c:param name="check" value="all"/></c:url>'>Product Details</a></li>
                                                            <li><a href='<c:url value="detail.html"><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'>Detail</a></li>
                                                            <li><a href="confirmCheckout">Shopping Cart Summary</a></li>
                                                            <li><a href="confirmCheckout">Checkout</a></li>
                                                            <li><a href="blog.html">Blog</a></li>
                                                            <li><a href="blog-details.html">Blog Detail</a></li>
                                                            <li><a href="contact.html">Contact</a></li>
                                                            <li><a href="sign-in.html">Sign In</a></li>
                                                            <li><a href="my-wishlist.html">Wishlist</a></li>
                                                            <li><a href="terms-conditions.html">Terms and Condition</a></li>
                                                            <li><a href="track-orders.html">Track Orders</a></li>
                                                            <li><a href="product-comparison.html">Product-Comparison</a></li>
                                                            <li><a href="faq.html">FAQ</a></li>
                                                            <li><a href="404.html">404</a></li>

                                                        </ul>
                                                    </div>



                                                </div>
                                            </div>
                                        </li>



                                    </ul>
                                </li>

                                <%-- <li class="dropdown  navbar-right special-menu">
                                     <a href="#">Todays offer</a>
                                 </li>
 --%>

                            </ul><!-- /.navbar-nav -->

                            <div class="clearfix"></div>
                        </div><!-- /.nav-outer -->

                    </div><!-- /.navbar-collapse -->


                </div><!-- /.nav-bg-class -->

            </div><!-- /.navbar-default -->

        </div><!-- /.container-class -->

    </div><!-- /.header-nav -->
    <!-- ============================================== NAVBAR : END ============================================== -->

</header>

<!-- ============================================== HEADER : END ============================================== -->