<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
              <form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST" action="/admin/createProductPost">
                <div class="form-group ">
                  <label for="firstname" class="control-label col-lg-2">Product Name</label>
                  <div class="col-lg-6">
                    <input class=" form-control" id="firstname" name="productName" type="text" />
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
                    <input class=" form-control" id="lastname1" name="productStatus" type="text" />
                  </div>
                </div>
                <div class="form-group ">
                  <label for="lastname" class="control-label col-lg-2">Description</label>
                  <div class="col-lg-6">
                    <input class=" form-control" id="lastname" name="description" type="text" />
                  </div>
                </div>
                <div class="form-group ">
                  <label for="password" class="control-label col-lg-2">Price</label>
                  <div class="col-lg-6">
                    <input class=" form-control" id="password" name="priceProduct" type="text" />
                  </div>
                </div>
                <div class="form-group ">
                  <label for="lastname" class="control-label col-lg-2">Quantity</label>
                  <div class="col-lg-6">
                    <input class=" form-control" id="quantityProduct" name="quantityProduct" type="text" />
                  </div>
                </div>
                <div class="form-group ">
                  <label for="email" class="control-label col-lg-2">supplyer</label>
                  <div class="col-lg-6">
                    <input class=" form-control" id="email" name="supplyerProduct" type="text" />
                  </div>
                </div>
                <div class="form-group ">
                  <label class="control-label col-lg-2">Type Product</label>
                  <div class="col-lg-6">
                    <select name="kindProduct">
                        <option value="">Hot</option>
                        <option value="">New</option>
                        <option value="">Sell Off</option>
                    </select>
                  </div>
                </div>
                <div class="form-group ">
                  <label for="password" class="control-label col-lg-2">Product Image</label>
                  <div class="col-lg-6">
                    <input id="password1" name="image" type="file" />
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-6">
                    <button class="btn btn-danger" type="submit">Save</button>
                    <button class="btn btn-default" type="button">Cancel</button>
                  </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
              </form>
            </div>
          </div>
        </section>
      </div>
    </div>
    <!-- page end-->
  </section>
</section>