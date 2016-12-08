<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="main-content">
  <section class="wrapper">
    <!-- page start-->
    <div class="row">
      <div class="col-lg-12">
        <section class="panel">
          <header class="panel-heading">
            Update Product
          </header>
          <div class="panel-body">
            <div class="form">
              <form:form class="cmxform form-horizontal tasi-form" id="signupForm" method="POST" action="/admin/updateProductPost">
                <form:input type="hidden"  value="${productDetail.id}" path="id" />
                <div class="form-group ">
                  <label for="firstname" class="control-label col-lg-2">Description</label>
                  <div class="col-lg-6">
                    <form:input class=" form-control" id="firstname" type="text" required="required" value="${productDetail.description}" path="description"/>
                  </div>
                </div>
                <div class="form-group ">
                  <label for="password" class="control-label col-lg-2">Price</label>
                  <div class="col-lg-6">
                    <form:input class="form-control" id="password"  type="text"  value="${productDetail.productDetailPrice}" required="required"  path="productDetailPrice"/>
                  </div>
                </div>
                <div class="form-group ">
                  <label for="lastname" class="control-label col-lg-2">Quantity</label>
                  <div class="col-lg-6">
                    <form:input class=" form-control" id="quantityProduct" name="quantityProduct" type="text" value="${productDetail.productDetailQuantity}" required="required"  path="productDetailQuantity" />
                  </div>
                </div>
                <div class="form-group ">
                  <label for="lastname" class="control-label col-lg-2">Status</label>
                  <div class="col-lg-6">
                    <form:select path="productDetailStatus">
                        <form:option value="1">1</form:option>
                        <form:option value="0">0</form:option>
                    </form:select>
                  </div>
                </div>
                <div class="form-group">
                  <label for="email" class="control-label col-lg-2">Supplyer</label>
                  <div class="col-lg-6">
                    <form:input class=" form-control" id="email" type="text" required="required" value="${productDetail.supplyer}" path="supplyer"/>
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-6">
                    <button class="btn btn-danger" type="submit">Update</button>
                    <button class="btn btn-default" type="button">Cancel</button>
                  </div>
                </div>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
              </form:form>
            </div>
          </div>
        </section>
      </div>
    </div>
    <!-- page end-->
  </section>
</section>