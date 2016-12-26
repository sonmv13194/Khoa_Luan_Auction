<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

    #editForm label.error {
        color:#FB3A3A;
        font-weight:bold;
    }
    h1 {
        font-family: Helvetica;
        font-weight: 100;
        color:#333;
        padding-bottom:20px;
    }

</style>
<section id="container" class="">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <section class="panel">
                <header class="panel-heading"> User </header>
                <div class="panel-body">
                    <div class="adv-table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered"
                               id="hidden-table-info">
                            <thead>
                            <tr>
                                <th>User Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Birthday</th>
                                <th>Address</th>
                                <th>Last Update By</th>
                                <th>Last Update</th>
                                <th>Role</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listUser}" var="user">
                                <tr class="gradeX">
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.birthday}</td>
                                    <td>${user.address}</td>
                                    <td>${user.lastUpdatedBy}</td>
                                    <td>${user.lastUpdated}</td>
                                    <td><c:forEach items="${user.roles }"
                                                   var="role">${role.roleName }</c:forEach></td>
                                    <td><a class="edit" href="/admin/editUser?id=${user.id} #edit">Edit</a></td>
                                        <%--onclick="javascript:deleteUser(${user.id}--%>
                                    <td>
                                        <a class="delete"
                                           href="${contextPath }/admin/deleteUser?id=${user.id}"
                                           onclick="return confirm('Are you sure you want to delete this item?');">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </section>
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading" id="edit">
                            Edit User
                        </header>
                        <h2>${message}</h2>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal tasi-form" id="editForm" method="POST"
                                      commandName="user" action="/admin/editUser">


                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2"></label>

                                            <input class="form-control" id="id" name="id" type="hidden"
                                                   value="${user.id}"/>

                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Username</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="username" name="username" type="text"
                                                   value="${user.username}"/>
                                            <form:errors path="username" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Password</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="password" name="password" type="password"
                                                   value="${user.password}"/>
                                            <form:errors path="password" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Email</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="email" name="email" type="email"
                                                   value="${user.email}"/>
                                            <form:errors path="email" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="birthday" class="control-label col-lg-2">Birthday</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="birthday" name="birthday" type = "date"
                                                   value="${user.birthday}"/>
                                            <form:errors path="birthday" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">Address</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="address" name="address"
                                                   value="${user.address}"/>
                                            <form:errors path="address" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">Phone</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="phone" name="phone" value="${user.phone}"/>
                                            <form:errors path="phone" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">ROLE</label>
                                        <c:forEach items="${listRole}" var="role">
                                            <label class="radio-inline">
                                                <input type="radio" value="${role.roleName}"
                                                       name="optradio">${role.roleName}</label>
                                        </c:forEach>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
                                        </div>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>

                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>

</section>
