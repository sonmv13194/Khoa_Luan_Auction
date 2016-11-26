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
								<th>Username</th>
								<th>Email</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<c:forEach items="${invoiceEntities }" var="invoiceEntity">
							<tbody>
								<tr class="">
									<td>${invoiceEntity.id }</td>
									<td>${invoiceEntity.username }</td>
									<td>${invoiceEntity.email }</td>
									<td>${invoiceEntity.firstName }</td>
									<td>${invoiceEntity.lastName }</td>
									<td>${invoiceEntity.email }</td>
									<td>${invoiceEntity.phone }</td>
									<td><a class="edit" href="">Edit</a></td>
									<td><a class="delete" href="${contextPath }/admin/invoice/delete?id=${invoiceEntity.id }">Delete</a></td>
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