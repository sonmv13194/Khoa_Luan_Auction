<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@ page language="java" contentType="text/html; charset=UTF-8"         pageEncoding="UTF-8" %><%@page session="true" %><div class="breadcrumb">    <div class="container">        <div class="breadcrumb-inner">            <ul class="list-inline list-unstyled">                <li><a href="home.html">Home</a></li>                <li class='active'>Login</li>            </ul>        </div><!-- /.breadcrumb-inner -->    </div><!-- /.container --></div><!-- /.breadcrumb --><div class="body-content">    <div class="container">        <div class="sign-in-page">            <div class="row">                <!-- Sign-in -->                <div class="col-md-6 col-sm-6 sign-in">                    <h4 class="">Sign in</h4>                    <div class="social-sign-in outer-top-xs">                        <a href="#" class="facebook-sign-in"><i class="fa fa-facebook"></i> Sign In with Facebook</a>                        <a href="#" class="twitter-sign-in"><i class="fa fa-twitter"></i> Sign In with Twitter</a>                    </div>                    <c:if test="${not empty error}">                        <div>${error}</div>                    </c:if>                    <c:if test="${not empty message}">                        <div>${message}</div>                    </c:if>                    <c:url value="/j_spring_security_check" var="loginUrl"/>                    <form class="register-form outer-top-xs" role="form" id="login" action="${loginUrl }?targetUrl=${targetUrl}" method="post">                        <div class="form-group">                            <label class="info-title" for="exampleInputEmail1">Username <span>*</span></label>                            <input type="text" name="username" class="form-control unicase-form-control text-input"                                   id="exampleInputEmail1">                        </div>                        <div class="form-group">                            <label class="info-title" for="exampleInputPassword1">Password <span>*</span></label>                            <input type="password" name="password" class="form-control unicase-form-control text-input"                                   id="exampleInputPassword1">                        </div>                        <div class="radio outer-xs">                            <c:if test="${empty loginUpdate}">                                <label>                                    <input type="checkbox" name="remember-me" />Remember                                    me!                                </label>                            </c:if>                            <a href="#" class="forgot-password pull-right">Forgot your Password?</a>                        </div>                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Login</button>                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                    </form>                </div>                <!-- Sign-in -->                <!-- create a new account -->                <div class="col-md-6 col-sm-6 create-new-account">                    <h4 class="checkout-subtitle">Create a new account</h4>                    <form:form class="register-form outer-top-xs" role="form" method="POST" commandName="userForm"                               action="/registration">                        <div class="form-group">                            <label class="info-title">User Name <span>*</span></label>                            <form:input path="username" class="form-control unicase-form-control text-input"                                        id="username" name="username"/>                        </div>                        <div class="form-group">                            <label class="info-title">Email <span>*</span></label>                            <form:input path="email" class="form-control unicase-form-control text-input" id="email"                                        name="email"/>                        </div>                        <div class="form-group">                            <label class="info-title">Phone Number <span>*</span></label>                            <form:input path="phone" class="form-control unicase-form-control text-input" id="phone"                                        name="phone"/>                        </div>                        <div class="form-group">                            <label class="info-title">Password <span>*</span></label>                            <form:password path="password" class="form-control unicase-form-control text-input"                                           id="password" name="password"/>                        </div>                        <div class="form-group">                            <label class="info-title">Confirm Password <span>*</span></label>                            <input type="password" class="form-control unicase-form-control text-input"                                   id="confirm_password" name="confirm_password"/>                        </div>                        <div class="form-group">                            <label class="info-title">Address<span>*</span></label>                            <form:input path="address" class="form-control unicase-form-control text-input" id="address"                                        name="address"/>                        </div>                        <div class="form-group">                            <label class="info-title">Birthday<span>*</span></label>                            <form:input path="birthday" class="form-control unicase-form-control text-input"                                        id="birthay" name="birthday"/>                        </div>                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Sign Up</button>                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                    </form:form>                </div><!-- create a new account -->            </div><!-- /.row -->        </div><!-- /.sigin-in-->    </div><!-- /.body-content --></div><!-- /#top-banner-and-menu -->