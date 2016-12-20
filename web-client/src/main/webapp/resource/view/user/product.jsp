<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="#">Home</a></li>
                <li class='active'>Handbags</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div>
<!-- /.breadcrumb -->
<div class="body-content outer-top-xs">
    <div class='container'>
        <div class='row'>
            <div class='col-md-3 sidebar'>
                <div class="sidebar-module-container">

                    <div class="sidebar-filter">
                        <!-- ============================================== SIDEBAR CATEGORY ============================================== -->
                        <div class="sidebar-widget wow fadeInUp">
                            <h3 class="section-title">shop by</h3>
                            <div class="widget-header">
                                <h4 class="widget-title">Category</h4>
                            </div>
                            <div class="sidebar-widget-body">
                                <div class="accordion">
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseOne" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Camera
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseOne" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseTwo" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Desktops
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseTwo" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseThree" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Pants
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseThree" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseFour" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Bags
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseFour" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseFive" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Hats
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseFive" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a href="#collapseSix" data-toggle="collapse"
                                               class="accordion-toggle collapsed">
                                                Accessories
                                            </a>
                                        </div><!-- /.accordion-heading -->
                                        <div class="accordion-body collapse" id="collapseSix" style="height: 0px;">
                                            <div class="accordion-inner">
                                                <ul>
                                                    <li><a href="#">gaming</a></li>
                                                    <li><a href="#">office</a></li>
                                                    <li><a href="#">kids</a></li>
                                                    <li><a href="#">for women</a></li>
                                                </ul>
                                            </div><!-- /.accordion-inner -->
                                        </div><!-- /.accordion-body -->
                                    </div><!-- /.accordion-group -->

                                </div><!-- /.accordion -->
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== SIDEBAR CATEGORY : END ============================================== -->

                        <!-- ============================================== PRICE SILDER============================================== -->
                        <div class="sidebar-widget wow fadeInUp">
                            <div class="widget-header">
                                <h4 class="widget-title">Price Slider</h4>
                            </div>
                            <div class="sidebar-widget-body m-t-10">
                                <div class="price-range-holder">
                                <span class="min-max">
                                     <span class="pull-left">$200.00</span>
                                     <span class="pull-right">$800.00</span>
                                </span>
                                    <input type="text" id="amount"
                                           style="border:0; color:#666666; font-weight:bold;text-align:center;">

                                    <input type="text" class="price-slider" value="">

                                </div><!-- /.price-range-holder -->
                                <a href="#" class="lnk btn btn-primary">Show Now</a>
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== PRICE SILDER : END ============================================== -->
                        <!-- ============================================== MANUFACTURES============================================== -->
                        <div class="sidebar-widget wow fadeInUp">
                            <div class="widget-header">
                                <h4 class="widget-title">Manufactures</h4>
                            </div>
                            <div class="sidebar-widget-body">
                                <ul class="list">
                                    <li><a href="#">Forever 18</a></li>
                                    <li><a href="#">Nike</a></li>
                                    <li><a href="#">Dolce & Gabbana</a></li>
                                    <li><a href="#">Alluare</a></li>
                                    <li><a href="#">Chanel</a></li>
                                    <li><a href="#">Other Brand</a></li>
                                </ul>
                                <!--<a href="#" class="lnk btn btn-primary">Show Now</a>-->
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== MANUFACTURES: END ============================================== -->
                        <!-- ============================================== COLOR============================================== -->
                        <div class="sidebar-widget wow fadeInUp">
                            <div class="widget-header">
                                <h4 class="widget-title">Colors</h4>
                            </div>
                            <div class="sidebar-widget-body">
                                <ul class="list">
                                    <li><a href="#">Red</a></li>
                                    <li><a href="#">Blue</a></li>
                                    <li><a href="#">Yellow</a></li>
                                    <li><a href="#">Pink</a></li>
                                    <li><a href="#">Brown</a></li>
                                    <li><a href="#">Teal</a></li>
                                </ul>
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== COLOR: END ============================================== -->
                        <!-- ============================================== COMPARE============================================== -->
                        <div class="sidebar-widget wow fadeInUp outer-top-vs">
                            <h3 class="section-title">Compare products</h3>
                            <div class="sidebar-widget-body">
                                <div class="compare-report">
                                    <p>You have no <span>item(s)</span> to compare</p>
                                </div><!-- /.compare-report -->
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== COMPARE: END ============================================== -->
                        <!-- ============================================== PRODUCT TAGS ============================================== -->
                        <div class="sidebar-widget product-tag wow fadeInUp outer-top-vs">
                            <h3 class="section-title">Product tags</h3>
                            <div class="sidebar-widget-body outer-top-xs">
                                <div class="tag-list">
                                    <a class="item" title="Phone" href="category.html">Phone</a>
                                    <a class="item active" title="Vest" href="category.html">Vest</a>
                                    <a class="item" title="Smartphone" href="category.html">Smartphone</a>
                                    <a class="item" title="Furniture" href="category.html">Furniture</a>
                                    <a class="item" title="T-shirt" href="category.html">T-shirt</a>
                                    <a class="item" title="Sweatpants" href="category.html">Sweatpants</a>
                                    <a class="item" title="Sneaker" href="category.html">Sneaker</a>
                                    <a class="item" title="Toys" href="category.html">Toys</a>
                                    <a class="item" title="Rose" href="category.html">Rose</a>
                                </div><!-- /.tag-list -->
                            </div><!-- /.sidebar-widget-body -->
                        </div><!-- /.sidebar-widget -->
                        <!-- ============================================== PRODUCT TAGS : END ============================================== -->
                        <!-- <!-- ============================================== Testimonials============================================== -->
                        <div class="sidebar-widget  wow fadeInUp outer-top-vs ">
                            <div id="advertisement" class="advertisement">
                                <div class="item">
                                    <div class="avatar"><img
                                            src="${contextPath}/resource/view/template/assets/images/testimonials/member1.png"
                                            alt="Image"></div>
                                    <div class="testimonials"><em>"</em> Vtae sodales aliq uam morbi non sem lacus port
                                        mollis. Nunc condime tum metus eud molest sed consectetuer.<em>"</em></div>
                                    <div class="clients_author">John Doe <span>Abc Company</span></div>
                                    <!-- /.container-fluid -->
                                </div><!-- /.item -->

                                <div class="item">
                                    <div class="avatar"><img
                                            src="${contextPath}/resource/view/template/assets/images/testimonials/member3.png"
                                            alt="Image"></div>
                                    <div class="testimonials"><em>"</em>Vtae sodales aliq uam morbi non sem lacus port
                                        mollis. Nunc condime tum metus eud molest sed consectetuer.<em>"</em></div>
                                    <div class="clients_author">Stephen Doe <span>Xperia Designs</span></div>
                                </div><!-- /.item -->

                                <div class="item">
                                    <div class="avatar"><img
                                            src="${contextPath}/resource/view/template/assets/images/testimonials/member2.png"
                                            alt="Image"></div>
                                    <div class="testimonials"><em>"</em> Vtae sodales aliq uam morbi non sem lacus port
                                        mollis. Nunc condime tum metus eud molest sed consectetuer.<em>"</em></div>
                                    <div class="clients_author">Saraha Smith <span>Datsun &amp; Co</span></div>
                                    <!-- /.container-fluid -->
                                </div><!-- /.item -->

                            </div><!-- /.owl-carousel -->
                        </div>

                        <!-- ============================================== Testimonials: END ============================================== -->

                        <div class="home-banner">
                            <img src="${contextPath}/resource/view/template/assets/images/banners/LHS-banner.jpg"
                                 alt="Image">
                        </div>

                    </div><!-- /.sidebar-filter -->
                </div><!-- /.sidebar-module-container -->
            </div><!-- /.sidebar -->
            <div class='col-md-9'>
                <!-- ========================================== SECTION – HERO ========================================= -->

                <div id="category" class="category-carousel hidden-xs">
                    <div class="item">
                        <div class="image">
                            <img src="${contextPath}/resource/view/template/assets/images/sliders/01.jpg" alt=""
                                 class="img-responsive">
                        </div>
                        <div class="container-fluid">
                            <div class="caption vertical-top text-left">
                                <div class="big-text">
                                    Big Sale
                                </div>

                                <div class="excerpt hidden-sm hidden-md">
                                    Save up to 49% off
                                </div>
                                <div class="excerpt-normal hidden-sm hidden-md">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit
                                </div>

                            </div><!-- /.caption -->
                        </div><!-- /.container-fluid -->
                    </div>
                </div>


                <!-- ========================================= SECTION – HERO : END ========================================= -->
                <div class="clearfix filters-container m-t-10">
                    <div class="row">
                        <div class="col col-sm-6 col-md-2">
                            <div class="filter-tabs">
                                <ul id="filter-tabs" class="nav nav-tabs nav-tab-box nav-tab-fa-icon">
                                    <li class="active">
                                        <a data-toggle="tab" href="#grid-container"><i class="icon fa fa-th-large"></i>Grid</a>
                                    </li>
                                    <li><a data-toggle="tab" href="#list-container"><i class="icon fa fa-th-list"></i>List</a>
                                    </li>
                                </ul>
                            </div><!-- /.filter-tabs -->
                        </div><!-- /.col -->
                        <div class="col col-sm-12 col-md-6">
                            <div class="col col-sm-3 col-md-6 no-padding">
                                <div class="lbl-cnt">
                                    <span class="lbl">Sort by</span>
                                    <div class="fld inline">
                                        <div class="dropdown dropdown-small dropdown-med dropdown-white inline">
                                            <button data-toggle="dropdown" type="button" class="btn dropdown-toggle">
                                                Position <span class="caret"></span>
                                            </button>

                                            <ul role="menu" class="dropdown-menu">
                                                <li role="presentation"><a href='#'>position</a></li>
                                                <li role="presentation"><a
                                                        href='<c:url value="product"><c:param name="check" value="productPriceAsc"/></c:url>'>Product
                                                    Price:ASC</a></li>
                                                <li role="presentation"><a
                                                        href='<c:url value="product"><c:param name="check" value="productPriceDesc"/></c:url>'>Product
                                                    Price:DESC</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- /.fld -->
                                </div><!-- /.lbl-cnt -->
                            </div><!-- /.col -->
                            <div class="col col-sm-3 col-md-6 no-padding">
                                <div class="lbl-cnt">
                                    <span class="lbl">Show</span>
                                    <div class="fld inline">
                                        <div class="dropdown dropdown-small dropdown-med dropdown-white inline">
                                            <button data-toggle="dropdown" type="button" class="btn dropdown-toggle">
                                                1 <span class="caret"></span>
                                            </button>

                                            <ul role="menu" class="dropdown-menu">
                                                <li role="presentation"><a href="#">1</a></li>
                                                <li role="presentation"><a href="#">2</a></li>
                                                <li role="presentation"><a href="#">3</a></li>
                                                <li role="presentation"><a href="#">4</a></li>
                                                <li role="presentation"><a href="#">5</a></li>
                                                <li role="presentation"><a href="#">6</a></li>
                                                <li role="presentation"><a href="#">7</a></li>
                                                <li role="presentation"><a href="#">8</a></li>
                                                <li role="presentation"><a href="#">9</a></li>
                                                <li role="presentation"><a href="#">10</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- /.fld -->
                                </div><!-- /.lbl-cnt -->
                            </div><!-- /.col -->
                        </div><!-- /.col -->
                        <div class="col col-sm-6 col-md-4 text-right">
                            <div class="pagination-container">
                                <ul class="list-inline list-unstyled">
                                    <li class="prev"><a href="#"><i class="fa fa-angle-left"></i></a></li>
                                    <li><a href="#">1</a></li>
                                    <li class="active"><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li class="next"><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                </ul><!-- /.list-inline -->
                            </div><!-- /.pagination-container -->        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div>
                <div class="search-result-container ">
                    <div id="myTabContent" class="tab-content category-list">
                        <div class="tab-pane active " id="grid-container">
                            <div class="category-product">
                                <div class="row">
                                    <c:forEach var="productDetail" items="${listProductDetail}">
                                        <div class="col-sm-6 col-md-4 wow fadeInUp">
                                            <div class="products">

                                                <div class="product">
                                                    <div class="product-image">
                                                        <div class="image">
                                                            <a href='<c:url value="detail.html"><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'><img
                                                                    src="/uploaded-image/${productDetail.productImages.get(0).url}"
                                                                    alt=""></a>
                                                        </div><!-- /.image -->

                                                        <div class="tag new"><span>new</span></div>
                                                    </div><!-- /.product-image -->


                                                    <div class="product-info text-left">
                                                        <h3 class="name"><a
                                                                href="detail.html">${productDetail.product.productName}</a>
                                                        </h3>
                                                        <div class="rating rateit-small"></div>
                                                        <div class="description"></div>

                                                        <div class="product-price">
                                                        <span class="price">
                                                            $ ${productDetail.productDetailPrice}				</span>
                                                            <span class="price-before-discount">$ ${productDetail.productDetailPrice}</span>

                                                        </div><!-- /.product-price -->

                                                    </div><!-- /.product-info -->
                                                    <div class="cart clearfix animate-effect">
                                                        <div class="action">
                                                            <ul class="list-unstyled">
                                                                <li class="add-cart-button btn-group">
                                                                    <a data-toggle="tooltip"
                                                                       href="${contextPath}/cart/addCart?product_id=${productDetail.id }"
                                                                       class="btn btn-primary icon" type="button"
                                                                       title="Add Cart">
                                                                        <i class="fa fa-shopping-cart"></i>
                                                                    </a>
                                                                    <a href="">
                                                                        <button class="btn btn-primary cart-btn"
                                                                                type="button">Add to cart
                                                                        </button>
                                                                    </a>
                                                                </li>

                                                                <li class="lnk wishlist">
                                                                    <a class="add-to-cart" href="detail.html"
                                                                       title="Wishlist">
                                                                        <i class="icon fa fa-heart"></i>
                                                                    </a>
                                                                </li>

                                                                <li class="lnk">
                                                                    <a class="add-to-cart" href="detail.html"
                                                                       title="Compare">
                                                                        <i class="fa fa-signal"></i>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div><!-- /.action -->
                                                    </div><!-- /.cart -->
                                                </div><!-- /.product -->

                                            </div><!-- /.products -->
                                        </div>
                                        <!-- /.item -->

                                    </c:forEach>
                                </div><!-- /.row -->
                            </div><!-- /.category-product -->

                        </div><!-- /.tab-pane -->

                        <div class="tab-pane " id="list-container">
                            <div class="category-product">

                                <c:forEach var="productDetail" items="${listProductDetail}">
                                    <div class="category-product-inner wow fadeInUp">
                                        <div class="products">
                                            <div class="product-list product">
                                                <div class="row product-list-row">
                                                    <div class="col col-sm-4 col-lg-4">
                                                        <div class="product-image">
                                                            <div class="image">
                                                                    <%--<img src="${contextPath}/resource/view/template/assets/images/products/p3.jpg" alt="">--%>
                                                                <a href='<c:url value="detail.html"><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'><img
                                                                        src="/uploaded-image/${productDetail.productImages.get(0).url}"
                                                                        alt=""></a>
                                                            </div>
                                                        </div><!-- /.product-image -->
                                                    </div><!-- /.col -->
                                                    <div class="col col-sm-8 col-lg-8">
                                                        <div class="product-info">
                                                            <h3 class="name"><a
                                                                    href="detail.html">${productDetail.product.productName}</a>
                                                            </h3>
                                                            <div class="rating rateit-small"></div>
                                                            <div class="product-price">
					<span class="price">
						$ ${productDetail.productDetailPrice}					</span>
                                                                <span class="price-before-discount">$ ${productDetail.productDetailPrice}</span>

                                                            </div><!-- /.product-price -->
                                                            <div class="description m-t-10">Suspendisse posuere arcu
                                                                diam, id accumsan eros pharetra ac. Nulla enim risus,
                                                                facilisis bibendum gravida eget, lacinia id purus.
                                                                Suspendisse posuere arcu diam, id accumsan eros pharetra
                                                                ac. Nulla enim risus, facilisis bibendum gravida eget.
                                                            </div>
                                                            <div class="cart clearfix animate-effect">
                                                                <div class="action">
                                                                    <ul class="list-unstyled">
                                                                        <li class="add-cart-button btn-group">
                                                                            <button class="btn btn-primary icon"
                                                                                    data-toggle="dropdown"
                                                                                    type="button">
                                                                                <i class="fa fa-shopping-cart"></i>
                                                                            </button>
                                                                            <button class="btn btn-primary cart-btn"
                                                                                    type="button">Add to cart
                                                                            </button>

                                                                        </li>

                                                                        <li class="lnk wishlist">
                                                                            <a class="add-to-cart" href="detail.html"
                                                                               title="Wishlist">
                                                                                <i class="icon fa fa-heart"></i>
                                                                            </a>
                                                                        </li>

                                                                        <li class="lnk">
                                                                            <a class="add-to-cart" href="detail.html"
                                                                               title="Compare">
                                                                                <i class="fa fa-signal"></i>
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </div><!-- /.action -->
                                                            </div><!-- /.cart -->

                                                        </div><!-- /.product-info -->
                                                    </div><!-- /.col -->
                                                </div><!-- /.product-list-row -->
                                                <div class="tag new"><span>new</span></div>
                                            </div><!-- /.product-list -->
                                        </div><!-- /.products -->
                                    </div>
                                    <!-- /.category-product-inner -->

                                </c:forEach>

                            </div><!-- /.category-product -->
                        </div><!-- /.tab-pane #list-container -->
                    </div><!-- /.tab-content -->
                    <div class="clearfix filters-container">

                        <div class="text-right">
                            <div class="pagination-container">
                                <ul class="list-inline list-unstyled">
                                    <li class="prev"><a href="#"><i class="fa fa-angle-left"></i></a></li>
                                    <li><a href="#">1</a></li>
                                    <li class="active"><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li class="next"><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                </ul><!-- /.list-inline -->
                            </div><!-- /.pagination-container -->                            </div><!-- /.text-right -->

                    </div><!-- /.filters-container -->

                </div><!-- /.search-result-container -->

            </div><!-- /.col -->
        </div><!-- /.row -->
        <!-- ============================================== BRANDS CAROUSEL ============================================== -->


    </div><!-- /.body-content -->
    <!-- ============================================================= FOOTER ============================================================= -->