<%--
  Created by IntelliJ IDEA.
  User: levuhuy
  Date: 12/6/16
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page">
            <div class="row">
                <!-- Sign-in -->
                <div class="col-md-6 col-sm-6 sign-in">
                    <h4 class="">Sign in</h4>
                    <p class="">Hello, Welcome to your account.</p>
                    <div class="social-sign-in outer-top-xs">
                        <a href="#" class="facebook-sign-in"><i class="fa fa-facebook"></i> Sign In with Facebook</a>
                        <a href="#" class="twitter-sign-in"><i class="fa fa-twitter"></i> Sign In with Twitter</a>
                    </div>
                    <c:url value="/j_spring_security_check" var="loginUrl" />
                    <form class="register-form outer-top-xs" role="form" action="${loginUrl }" method="post">
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">User Name <span>*</span></label>
                            <input type="text" name="username" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
                        </div>
                        <div class="form-group">
                            <label class="info-title" for="exampleInputPassword1">Password <span>*</span></label>
                            <input type="password" name="password" class="form-control unicase-form-control text-input" id="exampleInputPassword1" >
                        </div>
                        <div class="radio outer-xs">
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Remember me!
                            </label>
                            <a href="#" class="forgot-password pull-right">Forgot your Password?</a>
                        </div>
                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Login</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>

                </div>

                <!-- Sign-in -->

                <!-- create a new account -->
                <div class="col-md-6 col-sm-6 create-new-account">
                    <h4 class="checkout-subtitle">Create a new account</h4>
                    <p class="text title-tag-line">Create your new account.</p>
                    <form class="register-form outer-top-xs" role="form" method="POST" action="/admin/createUser">
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">User Name <span>*</span></label>
                            <input type="text" class="form-control unicase-form-control text-input" id="username" name="username" >
                        </div>
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">Email <span>*</span></label>
                            <input type="email" class="form-control unicase-form-control text-input" id="email" name="email" >
                        </div>

                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">Phone Number <span>*</span></label>
                            <input type="text" class="form-control unicase-form-control text-input" id="phone" name="phone">
                        </div>
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">Password <span>*</span></label>
                            <input type="text" class="form-control unicase-form-control text-input" id="password" name="password" >
                        </div>
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">Confirm Password <span>*</span></label>
                            <input type="text" class="form-control unicase-form-control text-input" id="confirm_password" name="confirm_password" >
                        </div>
                        <div class="form-group">
                            <label class="info-title" for=exampleInputEmail1>Address<span>*</span></label>
                            <input type="text" class="form-control unicase-form-control text-input" id="address" name="address" >
                        </div>
                        <div class="form-group">
                            <label class="info-title" for=exampleInputEmail1>Birthday<span>*</span></label>
                            <input type="date" class="form-control unicase-form-control text-input" id="birthay" name="birthday">
                        </div>
                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Sign Up</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>


                </div>

                <!-- create a new account -->			</div><!-- /.row -->
        </div><!-- /.sigin-in-->
    </div><!-- /.container -->
</div><!-- /.body-content -->