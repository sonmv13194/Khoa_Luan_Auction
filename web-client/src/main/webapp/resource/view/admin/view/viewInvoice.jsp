<%--  Created by IntelliJ IDEA.  User: Nguyen  Date: 01/12/2016  Time: 7:43 CH  To change this template use File | Settings | File Templates.--%><%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@ page language="java" contentType="text/html; charset=UTF-8"         pageEncoding="UTF-8" %><%@page session="true" %><c:set var="contextPath" value="${pageContext.request.contextPath}"/><!--main content start--><style>    .error {        color: #ff0000;        font-style: italic;        font-weight: bold;    }</style><section id="container" class="">    <section id="main-content">        <section class="wrapper">            <!-- page start-->            <section class="panel">                <header class="panel-heading"> Order</header>                <div class="panel-body">                    <div class="adv-table">                        <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered"                               id="hidden-table-info">                            <thead>                            <tr>                                <th>Id</th>                                <th>Username</th>                                <th>Email</th>                                <th>Phone</th>                                <th>First Name</th>                                <th>Last Name</th>                                <th>Address</th>                                <th>City</th>                                <th>Status</th>                                <th>Invoice Date</th>                                <th>Details</th>                                <th>Edit</th>                                <th>Delete</th>                            </tr>                            </thead>                            <tbody>                            <c:forEach items="${invoices }" var="invoice">                                <tr class="gradeX">                                    <td>${invoice.id }</td>                                    <td>${invoice.username }</td>                                    <td>${invoice.email }</td>                                    <td class="hidden-phone">${invoice.phone }</td>                                    <td class="center hidden-phone">${invoice.firstName }</td>                                    <td class="center hidden-phone">${invoice.lastName }</td>                                    <td>${invoice.address }</td>                                    <td>${invoice.city }</td>                                    <td>${invoice.status }</td>                                    <td>${invoice.invoiceDate }</td>                                    <td><a class="edit"                                           href="${contextPath }/admin/invoiceDetail?id=${invoice.id}">Details</a></td>                                    <td><a class="edit"                                           href="${contextPath }/admin/editInvoice?id=${invoice.id}">Edit</a></td>                                    <td><a class="delete"                                           href="${contextPath }/admin/deleteInvoice?id=${invoice.id}">Delete</a></td>                                </tr>                            </c:forEach>                            </tbody>                        </table>                    </div>                </div>            </section>            <!-- page end-->        </section>    </section>    <!--main content end--></section>