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
                <th>Information</th>
                <th>Description</th>
              </tr>
              </thead>
              <tbody>
                <tr class="gradeX">
                  <td>ID :</td>
                  <td>${productDetail.id}</td>
                </tr>
                <tr class="gradeX">
                  <td>Description :</td>
                  <td>${productDetail.description}</td>
                </tr>
                <tr class="gradeX">
                  <td>Status :</td>
                  <td>${productDetail.productDetailStatus}</td>
                </tr>
                <tr class="gradeX">
                  <td>Price :</td>
                  <td class="hidden-phone">${productDetail.productDetailPrice}</td>
                </tr>
                <tr class="gradeX">
                  <td>Quantity :</td>
                  <td class="hidden-phone">${productDetail.productDetailQuantity}</td>
                </tr>
                <tr class="gradeX">
                  <td>Suppyler :</td>
                  <td>${productDetail.supplyer}</td>
                </tr>
                <tr class="gradeX">
                  <td>Images</td>
                  <td>
                    <c:forEach var="productImages" items="${productDetail.productImages}">
                      <img src="${contextPath}/resource/images/${productImages.url}" style="width:50px;height:50px">
                    </c:forEach>
                  </td>
                </tr>
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



