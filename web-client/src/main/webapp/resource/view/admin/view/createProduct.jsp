<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:if test="${productId == '1'}">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Create New Product
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form:form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST"
                                           enctype="multipart/form-data"
                                           action="/admin/createProductPost?${_csrf.parameterName}=${_csrf.token}">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Name</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="firstname" type="text"
                                                        required="required" path="productName"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Category Name</label>
                                        <form:select id="username" path="categoryId">
                                            <c:forEach var="category" items="${listCategory}">
                                                <option value="${category.getId()}">${category.getCategoryName()}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">product status</label>
                                        <div class="col-lg-6">
                                            <form:select path="productStatus">
                                                <option value="1">1</option>
                                                <option value="0">0</option>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Description</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="lastname" type="text"
                                                        required="required" path="description"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Price</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="password" type="number"
                                                        required="required" path="price"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Quantity</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="quantityProduct" type="number"
                                                        required="required" path="quantity"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Supplyer</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="email" type="text" required="required"
                                                        path="supplyer"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Product Image</label>
                                        <div class="col-lg-6">
                                            <form:input id="password122" type="file" required="required" path="file"/>
                                            <span style="color:red">${message}</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
</c:if>
<c:if test="${productId != '1'}">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Create New Product
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form:form class="cmxform form-horizontal tasi-form" id="signupForm1" method="POST"
                                           enctype="multipart/form-data"
                                           action="/admin/createProductDetailPost?${_csrf.parameterName}=${_csrf.token}">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Id</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="firstname11" type="text"
                                                        value="${product.id}" path="productId"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Name</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="firstname1" type="text"
                                                        value="${product.productName}" path="productName"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Category Name</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="firstname12" type="text"
                                                        value="CategoryID" path="categoryId"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">product status</label>
                                        <div class="col-lg-6">
                                            <form:select path="productStatus">
                                                <option value="1">1</option>
                                                <option value="0">0</option>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Description</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="lastname1" type="text"
                                                        required="required" path="description"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Price</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="password1" type="number"
                                                        required="required" path="price"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Quantity</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="quantityProduct1" type="number"
                                                        required="required" path="quantity"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Supplyer</label>
                                        <div class="col-lg-6">
                                            <form:input class=" form-control" id="email1" type="text"
                                                        required="required" path="supplyer"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Product Image</label>
                                        <div class="col-lg-6">
                                            <form:input id="password11" type="file" name="uploadImage"
                                                        required="required" path="file"/> <span
                                                style="color:red">${message}</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
</c:if>