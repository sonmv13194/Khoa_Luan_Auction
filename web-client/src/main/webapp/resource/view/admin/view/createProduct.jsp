<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:if test="${checkCreate == 'productNew'}">
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
                                <form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST"
                                      enctype="multipart/form-data" action="/admin/createProductPost">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="text" hidden="hidden" name="productId" value="${productId}">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Name</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="productName" type="text"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Category Name</label>
                                        <select id="username" name="categoryId">
                                            <c:forEach var="category" items="${listCategory}">
                                                <option value="${category.getId()}">${category.getCategoryName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">product status</label>
                                        <div class="col-lg-6">
                                            <select name="productStatus">
                                                <option value="1">1</option>
                                                <option value="0">0</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Description</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="lastname" name="description" type="text"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Price</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="password" name="priceProduct" type="number"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Quantity</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="quantityProduct" name="quantityProduct"
                                                   type="number" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Supplyer</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="email" name="supplyerProduct" type="text"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Product Image</label>
                                        <div class="col-lg-6">
                                            <input id="password122" type="file" name="uploadImage" required="required"/>
                                            <span style="color:red">${message}</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
</c:if>
<c:if test="${checkCreate == 'productDetailNew'}">
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
                                <form class="cmxform form-horizontal tasi-form" id="signupForm1" method="POST"
                                      enctype="multipart/form-data" action="/admin/createProductPost">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Id</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname11" name="productId" type="text"
                                                   value="${productId}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2">Product Name</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname1" name="productName" type="text"
                                                   value="${productName}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">Category Name</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname12" name="categoryId" type="text"
                                                   value="CategoryID"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">product status</label>
                                        <div class="col-lg-6">
                                            <select name="productStatus">
                                                <option value="1">1</option>
                                                <option value="0">0</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Description</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="lastname1" name="description" type="text"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Price</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="password1" name="priceProduct"
                                                   type="number" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2">Quantity</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="quantityProduct1" name="quantityProduct"
                                                   type="number" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">supplyer</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="email1" name="supplyerProduct" type="text"
                                                   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">Product Image</label>
                                        <div class="col-lg-6">
                                            <input id="password11" type="file" name="uploadImage" required="required"/>
                                            <span style="color:red">${message}</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-6">
                                            <button class="btn btn-danger" type="submit">Save</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
</c:if>