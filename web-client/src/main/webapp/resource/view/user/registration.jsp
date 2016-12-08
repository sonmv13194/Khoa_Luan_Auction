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


                <!-- Sign-in -->

                <!-- create a new account -->
                <div class="col-md-6 col-sm-6 create-new-account">
                    <h4 class="checkout-subtitle">Create a new account</h4>
                    <p class="text title-tag-line">Create your new account.</p>
                    <form:form class="register-form outer-top-xs" role="form" method="POST"  commandName="userForm" action="/registration">
                        <div class="form-group">
                            <label class="info-title" >User Name <span>*</span></label>
                            <form:input path="username" class="form-control unicase-form-control text-input" id="username" name="username" />
                        </div>
                        <div class="form-group">
                            <label class="info-title" >Email <span>*</span></label>
                            <form:input path="email" class="form-control unicase-form-control text-input" id="email" name="email" />
                        </div>

                        <div class="form-group">
                            <label class="info-title" >Phone Number <span>*</span></label>
                            <form:input path="phone" class="form-control unicase-form-control text-input" id="phone" name="phone" />
                        </div>
                        <div class="form-group">
                            <label class="info-title" >Password <span>*</span></label>
                            <form:password path="password" class="form-control unicase-form-control text-input" id="password" name="password" />
                        </div>
                        <div class="form-group">
                            <label class="info-title" >Confirm Password <span>*</span></label>
                            <input type="password"   class="form-control unicase-form-control text-input" id="confirm_password" name="confirm_password" />
                        </div>
                        <div class="form-group">
                            <label class="info-title" >Address<span>*</span></label>
                            <form:input path="address" class="form-control unicase-form-control text-input" id="address" name="address" />
                        </div>
                        <div class="form-group">
                            <label class="info-title" >Birthday<span>*</span></label>
                            <form:input path="birthday" class="form-control unicase-form-control text-input" id="birthay" name="birthday" />
                        </div>
                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Sign Up</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form:form>


                </div>

                <!-- create a new account -->
            </div><!-- /.row -->
        </div><!-- /.sigin-in-->
    </div><!-- /.container -->
</div><!-- /.body-content -->