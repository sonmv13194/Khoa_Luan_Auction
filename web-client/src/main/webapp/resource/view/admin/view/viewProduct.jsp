<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="container" class="">
  <section id="main-content">
    <section class="wrapper">
      <!-- page start-->
      <section class="panel">
        <header class="panel-heading">
          DataTables hidden row details example
        </header>
        <div class="panel-body">
          <div class="adv-table">
            <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
              <thead>
              <tr>
                <th>Id</th>
                <th>Name</th>
                <th class="hidden-phone">Description</th>
                <th class="hidden-phone">Category_Id</th>
                <th></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="product" items="${listProducts}">
                <tr class="gradeX">
                  <td>${product.id}</td>
                  <td>${product.productName}</td>
                  <td class="hidden-phone">${product.description}</td>
                  <td class="center hidden-phone">${product.category.categoryName}</td>
                  <td class="center hidden-phone"><a href='<c:url value="/admin/updateProduct"><c:param name="productId" value="${product.id}"/></c:url>'><button class="btn btn-primary">Update</button></a> <a href='<c:url value="/admin/deleteProduct"><c:param name="productId" value="${product.id}"/></c:url>'><button class="btn btn-danger">Delete</button></a></td>
                </tr>
              </c:forEach>
              <%--<tr class="gradeC">--%>
              <%--<td>Tasman</td>--%>
              <%--<td>Internet Explorer 5.1</td>--%>
              <%--<td class="hidden-phone">Mac OS 7.6-9</td>--%>
              <%--<td class="center hidden-phone">1</td>--%>
              <%--<td class="center hidden-phone">C</td>--%>
              <%--</tr>--%>
              </tbody>
            </table>
          </div>
          <a href="/admin/createProduct"><button class="btn btn-success">Create New Product</button></a>
        </div>
      </section>
      <!-- page end-->
    </section>
  </section>
  <!--main content end-->
</section>



