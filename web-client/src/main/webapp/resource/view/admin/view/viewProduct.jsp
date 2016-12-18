<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="container" class="">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <section class="panel">
                <header class="panel-heading">
                    Product
                </header>
                <div class="panel-body">
                    <div class="adv-table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered"
                               id="hidden-table-info">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Image</th>
                                <th>Name</th>
                                <th class="hidden-phone">Description</th>
                                <th class="hidden-phone">Category_Id</th>
                                <th hidden="hidden"></th>
                                <th hidden="hidden"></th>
                                <th hidden="hidden"></th>
                                <th hidden="hidden"></th>
                                <th hidden="hidden"></th>
                                <th hidden="hidden"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="i" value="1"></c:set>
                            <c:forEach var="product" items="${listProducts}">

                                <tr class="gradeX">
                                    <td>${i}</td>
                                    <td><img
                                            src="/uploaded-image/${product.getProductDetails().get(0).getProductImages().get(0).getUrl()}"
                                            style="width:50px;height:50px"></td>
                                    <td>${product.productName}</td>
                                    <td class="hidden-phone">${product.description}</td>
                                    <td class="center hidden-phone">${product.getCategory().getCategoryName()}</td>
                                    <td class="center hidden-phone"><a
                                            href='<c:url value="/admin/createProductDetail"><c:param name="productId" value="${product.id}"/></c:url>'>
                                        <button class="btn btn-success">Create</button>
                                    </a><a href='<c:url value="/admin/viewProductDetail"><c:param name="productId" value="${product.id}"/></c:url>'>
                                        <button class="btn btn-primary">Detail</button>
                                    </a>
                                        <a href='<c:url value="/admin/deleteProduct"><c:param name="productId" value="${product.id}"/></c:url>'>
                                            <button class="btn btn-danger">Delete</button>
                                        </a></td>
                                    <td hidden="hidden">${product.getProductDetails().get(0).getProductDetailStatus()}</td>
                                    <td hidden="hidden">${product.getProductDetails().get(0).getProductDetailPrice()}</td>
                                    <td hidden="hidden">${product.getProductDetails().get(0).getProductDetailQuantity()}</td>
                                    <td hidden="hidden">${product.getProductDetails().get(0).getSupplyer()}</td>
                                    <td hidden="hidden">${product.getProductDetails().get(0).getProductImages().get(0).getUrl()}</td>
                                </tr>
                                <c:set var="i" value="${i+1}"></c:set>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <a href='<c:url value="/admin/createProduct"><c:param name="checkCreate" value="productNew"></c:param><c:param name="productId" value=""/><c:param name="productName" value=""/> </c:url>'>
                        <button class="btn btn-success">Create New Product</button>
                    </a>
                </div>
            </section>
            <!-- page end-->
        </section>
    </section>
    <!--main content end-->
</section>



