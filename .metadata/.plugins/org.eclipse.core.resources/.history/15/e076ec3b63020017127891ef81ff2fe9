 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--    CONTENT-->
    <div class="content-page">
        <div class="container">
            <div class="row">
            	<div class="col-sm-3">
            		<ul class="nav nav-pills nav-stacked nav-category-main">
            		<c:forEach var="listMenu" items="${listMenu}">
            			<li class="cate-item-nav"><a href="${pageContext.request.contextPath }/category?idcategory=${listMenu.idcategory}"><span>${listMenu.name }</span></a></li>
            		</c:forEach>
            		</ul>
            	</div>
                <div class="col-sm-6">
                    <div class="slide-area">
                        <div class="wrapper">
                            <div class="slide-wrapper">
                                <div id="mainslider" class="nivoSilder">
                                    <img src="resource/images/banner/one-helf1.jpg">
                                    <img src="resource/images/banner/shope-add2.jpg">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                   <div class="wrapper-right">
                       <img src="resource/images/banner/one-helf1.jpg">
                       <img src="resource/images/banner/shope-add1.jpg">
                       <img src="resource/images/banner/shope-add2.jpg">
                    </div>
                </div>
                
            </div>
            <div class="row">
                <div class="content-page">
                    <div class="content-page-title">
                        <h2 class="content-paget-title-item">Sản phẩm</h2>
                    </div>
                    <div class="row">
                     <h4>${message}</h4>
                     <c:forEach var="listProduct" items="${listProduct }">
                        <div class="col-sm-3">
                            <div class="new-product">
                                <div class="single-product-item">
                                    <div class="single-product-image">
                                        <a href="${pageContext.request.contextPath }/detail?idproduct=${listProduct.idproduct}"><img src="resource/images/banner/${listProduct.image }"></a>
                                        <div class="overplay-content">
                                            <ul>
                                                <li>
                                                    <a href="${pageContext.request.contextPath }/detail?idproduct=${listProduct.idproduct}"><i class="fa fa-search"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-shopping-cart"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-retweet"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fa fa-heart-o"></i></a>
                                                </li> 
                                            </ul>
                                        </div>
                                    </div>
                                     <div class="single-product-showinfor">
                                        <div class="single-product-infor-name">
                                            <p>${listProduct.name }</p>
                                        </div>
                                        <div class="single-product-infor-name">
                                            <p><i class="glyphicon glyphicon-fire"> ${listProduct.view }</i> lượt xem</p>
                                        </div>
                                        <div class="single-product-inforprice">
                                            <p><fmt:formatNumber value="${listProduct.price}" type="number" />đ</p>
                                         </div>
                                        <div class="single-product-inforsale">
                                            <button class="btn btn-success btn-countdown">20:17:80</button>
                                         </div>
                                         <div class="single-product-inforreview">
                                             <span>(${listProduct.commentItems.size() } nhận xét)</span>
                                         </div>
                                         <div class="single-product-inforrating">
                                             <div class="rating-box">
                                                 <i class="fa fa-star"></i>
                                                 <i class="fa fa-star"></i>
                                                 <i class="fa fa-star"></i>
                                                 <i class="fa fa-star"></i>
                                                 <i class="fa fa-star-half-empty" style="color:gray"></i>
                                             </div>
                                         </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END CONTENT -->