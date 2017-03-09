<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<div class="breadcrumb">
  <div class="container">
    <div class="breadcrumb-inner">
      <ul class="list-inline list-unstyled">
        <li><a href="#">Home</a></li>
        <li class='active'>Handbags</li>
      </ul>
    </div>
    <!-- /.breadcrumb-inner --> 
  </div>
  <!-- /.container --> 
</div>
<!-- /.breadcrumb -->
<div class="body-content outer-top-xs">
  <div class='container'>
    <div class='row'>
      <jsp:include page="../template/layout/slider-category.jsp"/>
      <jsp:include page="../template/layout/content-category.jsp"/>
    </div>
    <!-- /.row --> 
    <jsp:include page="../template/layout/brands-carousel.jsp"/>
    <!-- ============================================== BRANDS CAROUSEL : END ============================================== -->
  </div>
  <!-- /.container --> 
  
</div>
<!-- /.body-content --> 