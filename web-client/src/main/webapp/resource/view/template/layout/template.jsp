<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="MediaCenter, Template, eCommerce">
    <meta name="robots" content="all">
    <title>Nhat Shop Online</title>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/bootstrap.min.css">

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/main.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/blue.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/animate.min.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/rateit.css">
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/bootstrap-select.min.css">

    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="${contextPath}/resource/view/template/assets/css/font-awesome.css">

    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,600italic,700,700italic,800'
          rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<div class="body-content outer-top-xs" id="top-banner-and-menu">
    <div class="container">
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="brands"/>
    </div>
</div>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
<!-- js placed at the end of the document so the pages load faster -->
<!-- Bootstrap Core CSS -->
<!-- JavaScripts placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resource/view/template/assets/js/jquery-1.11.1.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/bootstrap.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/bootstrap-hover-dropdown.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/owl.carousel.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/echo.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/jquery.easing-1.3.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/bootstrap-slider.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/jquery.rateit.min.js"></script>
<script type="text/javascript" src="${contextPath}/resource/view/template/assets/js/lightbox.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/bootstrap-select.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/wow.min.js"></script>
<script src="${contextPath}/resource/view/template/assets/js/scripts.js"></script>

</body>
</html>
<script>
    $(document).ready(function () {
        $('#loading').click(function () {
            $.ajax({
                type: 'POST',
                contentType: 'application/json;charset=utf-8',
                url: '/productAll',
                dataType: 'json',
                success: function (data) {
                    alert(data);
//                    //lay 1 mang nhieu doi tuong
//                    $.each(data,function(key,value)
//                    {
//                        $(#result).append('<p>'+key+'Gia Tri :'+value.properties+'</br>');
//                    });

                }
            });
        });
    });
</script>