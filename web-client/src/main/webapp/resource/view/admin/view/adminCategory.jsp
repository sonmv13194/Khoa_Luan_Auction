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

<%--<div class="panel-body">
  <div class="adv-table editable-table ">
    <div class="clearfix">
      <div class="btn-group">
        <button id="editable-sample_new" class="btn green">
          Add New <i class="icon-plus"></i>
        </button>
      </div>
    </div>
    <div class="space15"></div>
    <table class="table table-striped table-hover table-binvoiceed" id="editable-sample">
      <thead>
      <tr>
        <th>Username</th>
        <th>Full Name</th>
        <th>Points</th>
        <th>Notes</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      </thead>
      <tbody>
      <tr class="">
        <td>Admin</td>
        <td> Flat Lab</td>
        <td>462</td>
        <td class="center">new user</td>
        <td><a class="edit" href="javascript:;">Edit</a></td>
        <td><a class="delete" href="javascript:;">Delete</a></td>
      </tr>

      </tbody>
    </table>
  </div>
</div>--%>
<%--
<div align="center">
  <h1>Category List</h1>
  <h3><a>New Category</a></h3>
  <form action="/admin/saveCategory" method="post">
    <table>

      <tr>
        <td>Name:</td>
        <td><input name="categoryName"/></td>
      </tr>

      <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
      </tr>
    </table>
  </form>


  <table binvoice="1">
    <th>No</th>
    <th>Name</th>
    <c:forEach var="category" items="${categoryList}" varStatus="index">
      <tr>
        <td>${index.index + 1}</td>
        <td>${category.categoryName}</td>
        <td>
          <a href="deleteCategory?id=${category.id}">Delete</a>
          &nbsp;&nbsp;&nbsp;&nbsp;

        </td>

      </tr>
    </c:forEach>
  </table>
--%>


<section id="main-content">
    <section class="wrapper">
        <!-- page start-->
        <header class="panel-heading">
            Category Table
        </header>
        <div class="panel-body">
            <form action="/admin/saveCategory" method="post">
                <div class="adv-table editable-table ">
                    <div class="clearfix">
                        <tr>
                            <td>Name:</td>
                            <td><input name="categoryName"/></td>
                        </tr>
                        <div class="btn-group">
                            <button id="editable-sample_new" class="btn green"><input type="submit" value="Add new">
                                <i class="icon-plus"></i>
                            </button>
                        </div>

                    </div>
                    <div class="space15"></div>
                    <table class="table table-striped table-hover table-binvoiceed" id="editable-sample">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Category Name</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categoryList}" varStatus="index">
                            <tr class="">
                                <td>${index.index + 1}</td>
                                <td>${category.categoryName}</td>
                                <td><a class="delete" href="deleteCategory?id=${category.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>

    </section>
    <!-- page end-->
</section>
</section>

</div>


