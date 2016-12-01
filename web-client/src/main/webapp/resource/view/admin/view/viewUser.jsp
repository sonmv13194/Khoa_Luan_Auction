<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                        <div class="btn-group">
                            <button id="editable-sample_new" class="btn green">
                                Add New <i class="icon-plus"></i>
                            </button>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
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
                        </tr>
                        </thead>
                        <c:forEach items="${listUsers}" var="user">
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
                            <td>${user.created}</td>
                            <td><a class="edit" href="javascript:;">Edit</a></td>
                            <td><a class="delete" href="javascript:;">Delete</a></td>
                        </tr>

                        </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>
        <!-- page end-->
    </section>
</section>
