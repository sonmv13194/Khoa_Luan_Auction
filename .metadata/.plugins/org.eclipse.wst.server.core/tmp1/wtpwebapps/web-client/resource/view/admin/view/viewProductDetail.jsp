<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="container" class="">
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <section class="panel">
                <header class="panel-heading">
                    Product Detail
                </header>
                <div class="panel-body">
                    <div class="adv-table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered"
                               id="hidden-table-info">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Image</th>
                                <th>ProductDetail Name</th>
                                <th>Status</th>
                                <th class="hidden-phone">Price</th>
                                <th class="hidden-phone">Quantity</th>
                                <th>Description</th>
                                <th>Supplyer</th>
                                <th>Image Name</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="productDetail" items="${listProductDetails}">
                                <c:set var="i" value="1" />
                                <tr class="gradeX">
                                    <td>${i}</td>
                                    <td><img
                                            src="/uploaded-image/${productDetail.getProductImages().get(0).getUrl()}"
                                            style="width:50px;height:50px"></td>
                                    <td>${productDetail.productDetailName}</td>
                                    <td>${productDetail.productDetailStatus}</td>
                                    <td class="hidden-phone">${productDetail.productDetailPrice}</td>
                                    <td class="center hidden-phone">${productDetail.productDetailQuantity}</td>
                                    <td>${productDetail.description}</td>
                                    <td>${productDetail.supplyer}</td>
                                    <td>${productDetail.productImages.get(0).url}</td>
                                    <td class="center hidden-phone">
                                        <a
                                            href='<c:url value="/admin/viewProductImages"><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'>
                                        <button class="btn btn-primary">View</button>
                                    </a>
                                        <a
                                            href='<c:url value="/admin/updateProduct"><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'>
                                        <button class="btn btn-success">Update</button>
                                    </a>
                                        <a
                                                href='<c:url value="/admin/deleteProductDetail"><c:param name="productId" value="${productDetail.product.id}"/><c:param name="productDetailId" value="${productDetail.id}"/></c:url>'>
                                            <button class="btn btn-danger">Delete</button>
                                        </a>
                                    </td>
                                </tr>
                                <c:set var="i" value="${i+1}"></c:set>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
            <!-- page end-->
        </section>
    </section>
    <!--main content end-->
</section>



