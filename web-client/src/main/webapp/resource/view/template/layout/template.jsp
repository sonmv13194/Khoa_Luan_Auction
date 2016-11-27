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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title"/></title>
    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resource/themes/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resource/themes/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${contextPath}/resource/themes/css/font-awesome.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="${contextPath}/resource/themes/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resource/themes/css/style-responsive.css" rel="stylesheet"/>

    <title>Instrument</title>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<tiles:insertAttribute name="body"/>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
<!-- js placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resource/themes/js/jquery.js"></script>
<script src="${contextPath}/resource/themes/js/bootstrap.min.js"></script>

</body>
</html>