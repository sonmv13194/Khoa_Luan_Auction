<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--main content start-->
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<section class="panel">
			<header class="panel-heading"> User </header>
			<div class="panel-body">
				<div class="">
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
								<th>Password</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Role</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<c:forEach items="${userEntities }" var="userEntity">
							<tbody>
								<tr class="">
									<td>${userEntity.id }</td>
									<td>${userEntity.username }</td>
									<td>${userEntity.password }</td>
									<td>${userEntity.address }</td>
									<td>${userEntity.phone }</td>
									<td>${userEntity.email }</td>
									<td><c:forEach items="${userEntity.roles }"
											var="roleEntity">${roleEntity.name }</c:forEach></td>
									<td><a class="edit"
										href="${contextPath }/admin/editUser?username=${userEntity.username}">Edit</a></td>
									<td><a class="delete"
										href="${contextPath }/admin/deleteUser?username=${userEntity.username }">Delete</a></td>
								</tr>

							</tbody>
						</c:forEach>
					</table>

				</div>
			</div>
			<c:if test="${userEntity.username != null }">
				<div class="span3">
					<header class="panel-heading"> Edit </header>
					<h2>${message}</h2>
					<div class="panel-body">
						<div class=" form">
							<form:form commandName="userEntity" autocomplete="off"
								id="updateUser" action="updateUser" method="POST"
								class="form-stacked">
								<fieldset>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Username</label>
										<div class="col-lg-10">
											<form:input type="text" path="username" name="username"
												placeholder="Enter your username"
												value="${userEntity.username }" class=" form-control" />
											<br>
											<form:errors path="username" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Email
											address:</label>
										<div class="col-lg-10">
											<form:input path="email" type="text" name="email"
												placeholder="Enter your email" value="${userEntity.email }"
												class=" form-control" />
											<br>
											<form:errors path="email" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Phone
											:</label>
										<div class="col-lg-10">
											<form:input type="text" path="phone" name="phone"
												placeholder="Enter your phone" value="${userEntity.phone }"
												class=" form-control" />
											<br>
											<form:errors path="phone" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Address:</label>
										<div class="col-lg-10">
											<form:input path="address" type="text" name="address"
												placeholder="Enter your address"
												value="${userEntity.address }" class=" form-control" />
											<br>
											<form:errors path="address" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Password:</label>
										<div class="col-lg-10">
											<form:input type="password" path="password" name="password"
												placeholder="Enter your password"
												value="${userEntity.password }" class=" form-control" />
											<br>
											<form:errors path="password" cssClass="error" />
										</div>
									</div>

									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Role:</label>
										<div class="col-lg-10">
											<c:forEach items="${roles }" var="role">
												<label class="radio-inline"><input
													value="${role.name }" type="radio" name="role">${role.name }</label>
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
							</form:form>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${userEntity.username == null }">
				<div class="span4">
					<header class="panel-heading"> Add </header>
					<h2>${message}</h2>
					<div class="panel-body">
						<div class=" form">
							<form:form commandName="userEntity" autocomplete="off"
								id="addUser" action="addUser" method="POST"
								class="cmxform form-horizontal tasi-form">
								<fieldset>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Username</label>
										<div class="col-lg-10">
											<form:input type="text" path="username" name="username"
												placeholder="Enter your username" class=" form-control" />
											<br>
											<form:errors path="username" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Email
											address:</label>
										<div class="col-lg-10">
											<form:input path="email" type="text" name="email"
												placeholder="Enter your email" class=" form-control" />
											<br>
											<form:errors path="email" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Phone
											:</label>
										<div class="col-lg-10">
											<form:input type="text" path="phone" name="phone"
												placeholder="Enter your phone" class=" form-control" />
											<br>
											<form:errors path="phone" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Address:</label>
										<div class="col-lg-10">
											<form:input path="address" type="text" name="address"
												placeholder="Enter your address" class=" form-control" />
											<br>
											<form:errors path="address" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Password:</label>
										<div class="col-lg-10">
											<form:input type="password" path="password" name="password"
												placeholder="Enter your password" class=" form-control" />
											<br>
											<form:errors path="password" cssClass="error" />
										</div>
									</div>
									<div class="form-group ">
										<label for="ccomment" class="control-label col-lg-2">Role:</label>
										<div class="col-lg-10">
											<c:forEach items="${roles }" var="role">
												<label class="radio-inline"><input
													value="${role.name }" type="radio" name="role">${role.name }</label>
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
							</form:form>
						</div>
					</div>
				</div>
			</c:if>
		</section>
		<!-- page end-->
	</section>
</section>
<!--main content end-->