<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resource/images/logo/favicon.ico"/>" rel="shortcut icon" type="image/x-icon">
	<title><tiles:getAsString name="title" /></title>
	<link href="<c:url value="/resource/css/header.css" />" rel="stylesheet">
	<link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resource/font-awesome-4.5.0/css/font-awesome.css" />" rel="stylesheet">
	<link href="<c:url value="/resource/css/font-awesome-4.6.3/css/font-awesome.min.css" />" rel="stylesheet">
 	<link href="<c:url value="/resource/css/home-body.css" />" rel="stylesheet">
	<link href="<c:url value="/resource/css/profile.css" />" rel="stylesheet">

	<title>Instrument</title>
	</head>
<body>

    <header>
    	<tiles:insertAttribute name="header" />
    </header>
    <tiles:insertAttribute name="body" />
    <footer>
    	<tiles:insertAttribute name="footer" />
    </footer>
    <script src="<c:url value="/resource/js/jquery-1.9.1.min.js"/>"></script>
    <script src="<c:url value="/resource/js/home/home.js"/>" type="text/javascript"></script>    
    <script src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>
 	
</body>
</html>