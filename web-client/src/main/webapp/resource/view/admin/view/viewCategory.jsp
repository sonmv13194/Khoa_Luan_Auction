<%--
  Created by IntelliJ IDEA.
  User: bink
  Date: 29-Nov-16
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="container" class="">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <section class="panel">
                <header class="panel-heading"> Category</header>
                <div class="panel-body">
                    <div class="adv-table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered"
                               id="hidden-table-info">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Category Name</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="category" items="${categoryList}" varStatus="index">
                                <tr class="gradeX">
                                    <td>${index.index + 1}</td>
                                    <td>${category.categoryName}</td>
                                    <td><a class="delete" href="deleteCategory?id=${category.id}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </section>
            <!-- page end-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            New Category
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST"
                                      commandName="category" action="/admin/saveCategory">
                                    <div class="form-group ">
                                        <label class="control-label col-lg-2">Category Name</label>
                                        <div class="col-lg-10">
                                            <input class="form-control" id="categoryName" name="categoryName" type="text"
                                                   placeholder="Category Name"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                        </div>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>

                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </section>
    </section>
</section>