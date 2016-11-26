<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<section class="panel">
			<header class="panel-heading"> User </header>
			<div class="panel-body">
				<div class="adv-table editable-table ">
					<div class="clearfix">
						<div class="btn-group pull-right">
							<button class="btn dropdown-toggle" data-toggle="dropdown">
								Tools <i class="icon-angle-down"></i>
							</button>
							<ul class="dropdown-menu pull-right">
								<li><a href="#">Print</a></li>
								<li><a href="#">Save as PDF</a></li>
								<li><a href="#">Export to Excel</a></li>
							</ul>
						</div>
					</div>
					<div class="space15"></div>

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Category</th>
								<th>Parent</th>
								<th>Delete</th>
							</tr>
						</thead>
						<c:forEach items="${categoryEntities }" var="categoryEntity">
							<tbody>
								<tr class="">
									<td>${categoryEntity.id }</td>
									<td>${categoryEntity.category }</td>
									<td>${categoryEntity.parent.parent }</td>
									<td><a class="delete"
										href="${contextPath }/admin/deleteCategory?id=${categoryEntity.id }">Delete</a></td>
								</tr>

							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="span4">
				<header class="panel-heading"> Add </header>
				<h2>${message}</h2>
				<div class="panel-body">
					<div class=" form">
						<form action="addCategory" method="POST"
							class="cmxform form-horizontal tasi-form">
							<fieldset>
								<div class="form-group ">
									<label for="ccomment" class="control-label col-lg-2">Name</label>
									<div class="col-lg-10">
										<input type="text" name="category"
											placeholder="Enter your category" class=" form-control" />
										<br>
									</div>
								</div>
								<div class="form-group ">
									<label for="ccomment" class="control-label col-lg-2">Parent:</label>
									<div class="col-lg-10">
										<c:forEach items="${parents }" var="parent">
											<label class="radio-inline"><input
												value="${parent.parent }" type="radio" name="parent">${parent.parent }</label>
										</c:forEach>
										<br>
									</div>
								</div>
								<hr>
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<button class="btn btn-danger" type="submit">Save</button>
										<button class="btn btn-default" type="button">Cancel</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</section>
		<!-- page end-->
	</section>
</section>
<!--main content end-->