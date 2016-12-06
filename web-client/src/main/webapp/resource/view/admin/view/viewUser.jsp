<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section id="main-content">
    <section class="wrapper">
        <!-- page start-->
        <section class="panel">
            <header class="panel-heading">
                Editable Table
            </header>
            <div class="panel-body">
                <div class="adv-table editable-table ">
                    <div class="clearfix">
                        <div class="btn-group pull-right">
                            <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i
                                    class="icon-angle-down"></i>
                            </button>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="#">Print</a></li>
                                <li><a href="#">Save as PDF</a></li>
                                <li><a href="#">Export to Excel</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="space15"></div>

                    <table class="table table-striped table-hover table-bordered" id="editable-sample">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Birthday</th>
                            <th>Address</th>
                            <th>Created</th>
                            <th>Last Update</th>
                            <th>Created By</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <c:forEach items="${listUser}" var="user">
                            <tbody>
                            <tr class="">
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td>${user.birthday}</td>
                                <td>${user.address}</td>
                                <td>${user.createBy}</td>
                                <td>${user.lastUpdated}</td>
                                <td>${user.createBy}</td>
                                <td><a class="edit" href="/admin/editUser?id=${user.id}">Edit</a></td>
                                    <%--onclick="javascript:deleteUser(${user.id}--%>
                                <td>
                                    <a class="delete"
                                       href="${contextPath }/admin/deleteUser?id=${user.id}">
                                        Delete
                                    </a>
                                </td>
                            </tr>

                            </tbody>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </section>


            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Edit User
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST"
                                      action="/admin/editUser">
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Username</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="username" name="username" type="text" value="${user.username}"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Password</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="password" name="password" type="password"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Email</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="email" name="email" type="email"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="birthday" class="control-label col-lg-2">Birthday</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="birthday" name="birthday" type="date"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">Address</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="address" name="address"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">Phone</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="phone" name="phone"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="address" class="control-label col-lg-2">ROLE</label>

                                            <label class="radio-inline"><input type="radio" value="${role.roleName}"
                                                                               name="optradio">${role.roleName}</label>

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
