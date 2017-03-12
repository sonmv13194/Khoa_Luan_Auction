<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="main-content-detail">
	<div class="container">
		<div class="row">
			<div class="content-detail-title">
				<h2 class="content-paget-title-item">Chi tiết sản phẩm</h2>
			</div>
			<div class="col-sm-9">
				<div class="row">
					<div class="col-sm-4">
						<div class="detail-product-item">
							<div class="tab-content">
								<div class="tab-pane active" id="imageContainer">
									<div class="product-detail-image">
										<img id="imageContainer" name="image_main"
											src="resource/images/banner/${singleProduct.image }">
									</div>
									<ul class="nav navbar-nav">
										<c:forEach var="image" items="${singleProduct.imageItem }">
											<li class="image-list"><img
												src="resource/images/banner/${image.link_image }"
												style="width: 80px; height: 100px; padding: 5px"></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="detail-product-infor">
							<h2 class="detail-product-name"
								style="font-family: 'Bitter', serif">${singleProduct.name }</h2>
							<p class="detail-product-name"
								style="font-family: 'Bitter', serif">Mã sản phẩm
								:${singleProduct.idproduct }</p>
							<div class="product-detail">
								<label>Người đăng:<a href="#">Shinmu13194</a></label>| <label
									class="memberpost-infor" style="font-weight: 100; color: #333;">Quảng
									Nam</label> <label class="memberpost-infor"
									style="font-weight: 100; color: #333;">01665102292</label>
							</div>
							<div class="detail-product-share">
								<ul class="product-share">
									<li><a href="#" class="face-share"><i
											class="fa fa-facebook"></i></a></li>
									<li><a href="#" class="ins-share"><i
											class="fa fa-instagram"></i></a></li>
									<li><a href="#" class="twit-share"><i
											class="fa fa-twitter"></i></a></li>
								</ul>
							</div>
							<div class="product-detail-view">
								<label><i class="glyphicon glyphicon-eye-open"></i> Lượt
									xem : ${singleProduct.view}</label>
								<p>(Còn lại ${singleProduct.quantity} sản phẩm)</p>
							</div>
							<div class="product-detail-price">
								<h2>
									<fmt:formatNumber value="${singleProduct.price}" type="number" />
									đ
								</h2>
							</div>
							<div class="product-detail-description">
								<p>${singleProduct.description }</p>
							</div>
							<div class="box-detail-information">
								<form class="form-detail-information">
									<div class="form-detail-size">
										<label>Thời gian đấu:
											<button class="btn btn-success">12:20:30</button>
										</label>
									</div>
									<p>
										<br>
									</p>
									<div class="form-detail-quantity">
										<label>Giá đấu:</label> <input
											class="form-control input-field" type="text">

									</div>
									<div class="form-detail-addcart">
										<div class="submit-button">
											<a href="#" class="btn submit-btn"
												style="background: green; border-color: green"> <span><i
													class=""></i> Bắt đầu đấu giá </span>
											</a>
										</div>
										<div class="submit-button"
											style="margin-left: 175px; margin-top: -55px">
											<a
												href="${pageContext.request.contextPath }/cart?idproduct=${singleProduct.idproduct}"
												class="btn submit-btn"
												style="background: #00509d; border-color: #00509d"> <span><i
													class=""></i> Thêm vào giỏ hàng </span>
											</a>
										</div>
									</div>
									<p>
										<br>
									</p>

								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="product-informore">
							<ul class="nav nav-tabs more-infor">
								<li class="active"><a href="#detail">Chi tiết sản phẩm</a>
								</li>
								<li><a href="#">Đánh giá sản phẩm</a></li>
								<li><a href="#">Bình luận-Hỏi đáp</a></li>
							</ul>
							<div class="tab-content-detail">
								<div class="tab-pane active" id="detail">
									<div class="tab-descript">
										<p>${singleProduct.description }</p>
										<img src="resource/images/banner/${singleProduct.image }">
									</div>
								</div>
							</div>
						</div>
						<div class="product-detail-relat">
							<div class="detail-rela-title">
								<h2 class="content-paget-title-item">Sản phẩm liên quan</h2>
							</div>
							<div class="product-relat-slide">
								<ul>
									<li><img src="resource/images/banner/shope-add2.jpg">
									</li>
									<li><img src="resource/images/banner/one-helf1.jpg">
									</li>
									<li><img src="resource/images/banner/shope-add1.jpg">
									</li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<h2 style="font-size: 20px; font-weight: bold;">Đánh giá và
									nhận xét cho sản phẩm ${singleProduct.name }</h2>
								<c:choose>
									<c:when test="${pageContext.request.userPrincipal==null }">
										<div class="alert alert-success">
											<strong>Cảnh báo!</strong> Bạn phải đăng nhập mới được bình
											luận sản phẩm này
										</div>
									</c:when>
									<c:otherwise>
										<div class="widget-area no-padding blank" id="">
											<div class="status-upload">
												<form:form commandName="CommentDto"
													action="${pageContext.request.contextPath }/comment/${singleProduct.idproduct }">
													<form:input class="form-control title-comments"
														placeholder="Nhận xét tổng quan" path="title"></form:input>
													<form:textarea
														placeholder="Viết đánh giá nhận xét cho sản phẩm này..."
														path="content"></form:textarea>
													<button type="submit" class="btn btn-success green">
														Bình luận</button>
												</form:form>
											</div>
											<!-- Status Upload  -->
										</div>
									</c:otherwise>
								</c:choose>
								<!-- Widget Area -->
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<h2 style="font-size: 20px; font-weight: bold;">Nhận xét
									sản phẩm ${singleProduct.name }</h2>
								<label>Có ${singleProduct.commentItems.size() } nhận xét</label>
								<c:forEach var="comment" items="${singleProduct.commentItems }">
									<div class="comment-items">
										<img class="img-responsive user-photo"
											src="resource/images/avatar/avartar-cmt.png"
											style="width: 31px">
										<div class="panel panel-default"
											style="margin-left: 40px; margin-top: -30px;">
											<div class="panel-heading comment-heading">
												<label><a href="#">${comment.user.username }</a></label>
												<p class="memberpost-infor">Đã comment vào 
												<fmt:formatDate value="${comment.createdate }"
													pattern="yyyy-MM-dd" />
												</p>
											</div>
											<label class="memberpost-infor">${comment.title }</label>
											<div class="content-comment">
												<p>${comment.content }</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="product-viewed">
						<div class="product-detail-viewed">
							<h2 class="content-paget-title-item">Sản phẩm đã xem</h2>
						</div>
						<ul>
							<li><a href="#"><img
									src="resource/images/banner/one-helf1.jpg"></a>
								<div class="product-viewed-conten">
									<p>Quần kaki đen nam hàn quốc</p>
								</div></li>
							<li><a href="#"><img
									src="resource/images/banner/shope-add1.jpg"></a>
								<div class="product-viewed-conten">
									<p>Quần kaki đen nam hàn quốc</p>
								</div></li>
							<li><a href="#"><img
									src="resource/images/banner/img_flower2.jpg"></a>
								<div class="product-viewed-conten">
									<p>Quần kaki đen nam hàn quốc</p>
								</div></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
