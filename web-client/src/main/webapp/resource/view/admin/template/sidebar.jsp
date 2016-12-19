<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="${contextPath }/admin/viewProduct">Product</a></li>
                <li><a href="${contextPath }/admin/category">Category</a></li>
                <li><a href="${contextPath }/admin/invoice">Invoice</a></li>
                <li><a href="${contextPath }/admin/discount">Discount</a></li>
            </ul>
        </li>
        <li class="sub-menu"><a href="${contextPath }/"> <i
                class="icon-shopping-cart"></i> <span>Home Page</span></a>
        </li>
        <li class="sub-menu">
        <c:url value="/logout" var="logoutUrl"/>
        <form id="logout" action="${logoutUrl}" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
            <a href="javascript:document.getElementById('logout').submit()">Logout</a>
        </li>
    </ul>
    <!-- sidebar menu end-->
</div>
<!--sidebar end-->