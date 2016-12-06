<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!--sidebar start-->
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<li class="sub-menu"><a href="javascript:;" class="active">
					<i class="icon-th"></i> <span>Data Tables</span>
			</a>
				<ul class="sub">
					<li class="active"><a href="${contextPath }/admin/viewUser">User</a></li>
					<li><a href="${contextPath }/admin/viewProduct">ProductView</a></li>
					<li><a href="${contextPath }/admin/category">Category</a></li>
					<li><a href="${contextPath }/admin/invoice">Invoice</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="icon-shopping-cart"></i> <span>Shop</span>
			</a>
				<ul class="sub">
					<li><a href="product_list.html">List View</a></li>
					<li><a href="product_details.html">Details View</a></li>
				</ul></li>
			<li><a href="google_maps.html"> <i class="icon-map-marker"></i>
					<span>Google Maps </span>
			</a></li>
			<li><a href="//login"> <i class="icon-user"></i> <span>Login
						Page</span>
			</a></li>
		</ul>
		<!-- sidebar menu end-->
	</div>
<!--sidebar end-->