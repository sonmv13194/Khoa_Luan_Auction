<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
								<th>Name</th>
								<th>Description</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Category</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<c:forEach items="${productEntities }" var="productEntity">
							<tbody>
								<tr class="">
									<td>${productEntity.id }</td>
									<td>${productEntity.name }</td>
									<td>${productEntity.description }</td>
									<td>${productEntity.quantity }</td>
									<td>${productEntity.price }</td>
									<td>${productEntity.category.category }</td>
									<td><a class="edit" href="">Edit</a></td>
									<td><a class="delete" href="${contextPath }/admin/product/delete?id=${productEntity.id }">Delete</a></td>
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
<!--main content end-->