<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!--HEADER-->
<div class="navbar navbar-fixed-top header_top">
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div class="row">
				<div class="col-md-2">
				<div class="header_top_left">
					<ul class="nav nav-pills">
						<li><img class="banner-img"
							src="resource/images/banner/auction.png"></li>
					</ul>
				</div>
				</div>
			<!-- 	<div class="col-sm-10">
						<div class="header_slogan">
							SẢN PHẨM MỚI NHẤT-DỊCH VỤ TỐT NHẤT-CHẤT LƯỢNG TỐT NHẤT
						</div>
							</div> -->
				</div>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<div class="header_top_right">
					<ul class="nav nav-pills">
						<c:if test="${pageContext.request.userPrincipal.name !=null }">
							<li class="personal-setting"><a
								href="${pageContext.request.contextPath }/profile"
								class="personal-profile">Chào
									${pageContext.request.userPrincipal.name}</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <img alt=""
									src="resource/images/avatar/google_avatar.png" height="27"
									width="27" data-ytimg="1" onload=";__ytRIL(this)"
									aria-hidden="true"> <!--  <b class="caret"></b> --></a>
								<ul class="dropdown-menu item-settings">
									<security:authorize access="isAuthenticated()">
										<li
											class="${current=='profile' ? 'active' : ''} personal-setting"><a
											class="personal-profile"
											href="${pageContext.request.contextPath }/profile">Trang
												cá nhân</a></li>
									</security:authorize>
									<li class="personal-setting"><a class="personal-profile"
										href=""> Cài đặt</a></li>
									<li><form id="logoutForm" method="POST"
											action="${pageContext.request.contextPath}/logout">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form></li>
									<li class="personal-setting"><a class="personal-profile"
										onclick="document.forms['logoutForm'].submit()">Đăng xuất</a></li>
								</ul></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name ==null }">
							<li><a href="login">Đăng nhập</a></li>
							<li><a href="register">Đăng ký</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<section class="header_middle">
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="header_logo">
					<a href="home"><img src="resource/images/logo/logon.png"></a>
					<a href="home"><img src="resource/images/logo/logon2.png"
						style="padding-top: 35px"></a>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="header_search">
					<form action="${pageContext.request.contextPath }/searchname"
						method="get">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" class="form-control input-lg" placeholder=""
									name="name"
									style="font-family: -webkit-pictograph; border-radius: 0px;" />
								<span class="input-group-btn">
									<button class="btn btn-info btn-lg btn-search" type="button">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="header_middle_item pull-right">
					<div class="header_middle_cart">
						<a href="${pageContext.request.contextPath }/viewcart"
							class="cart_link"> <i class="fa fa-shopping-cart cart-icon"></i>
							<b>Giỏ hàng</b> <span class="cart_quantity">${cart.size() }</span>
						</a>
					</div>
				</div>
				<div class="header_middle_call_us"></div>
			</div>
		</div>
	</div>
</section>
<nav class="navbar navbar-default menu-main" role="navigation">

	<div class="container">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#collapse">

				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>

		</div>

		<div class="collapse navbar-collapse" id="collapse">

			<ul class="nav navbar-nav menu-main-item">

				<li class="active item-active-menu"><a href="#">Danh mục
						mặt hàng</a></li>

				<li class="sub-menu-parent"><a href="#">Đang đấu giá</a></li>

				<li class="sub-menu-parent"><a href="#">Đã kết thúc</a></li>

				<li class="sub-menu-parent"><a href="#">Sắp kết thúc</a></li>

				<li class="sub-menu-parent"><a href="#" class="pull-right">Hướng
						dẫn</a></li>

			</ul>

		</div>

	</div>

</nav>
<!--    END HEADER-->