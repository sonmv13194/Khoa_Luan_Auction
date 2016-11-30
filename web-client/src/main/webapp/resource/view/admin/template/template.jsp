<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword"
          content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resource/view/admin/themes/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resource/view/admin/themes/css/bootstrap-reset.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${contextPath}/resource/view/admin/themes/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resource/view/admin/themes/css/style-responsive.css" rel="stylesheet"/>
</head>

<body>

<section id="container" class="">
    <tiles:insertAttribute name="header"/>
    <aside>
        <tiles:insertAttribute name="sidebar"/>
        <tiles:insertAttribute name="body"/>
    </aside>
    <tiles:insertAttribute name="footer"/>
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resource/view/admin/themes/js/jquery-1.8.3.min.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
        src="${contextPath}/resource/view/admin/themes/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.scrollTo.min.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${contextPath}/resource/view/admin/themes/js/respond.min.js"></script>

<!--common script for all pages-->
<script src="${contextPath}/resource/view/admin/themes/js/common-scripts.js"></script>
</body>
</html>
