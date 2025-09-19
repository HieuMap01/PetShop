<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phẩm</title>

    <%-- CSS --%>
    <jsp:include page = "/WEB-INF/views/customer/layout/css.jsp"></jsp:include>

</head>

<body>
    <div class="wrapper">
        <!-- header-->
		<jsp:include page ="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
		<!-- end header-->
        <main class="main">
            <div class="main__breadcrumb">
                <div class="container">
                    <div class="bread-crumb">
                        <span><a href="${env }/customer/index.html">Trang chủ</a></span>
                        <span><a href="${env }/customer/danhmuc.html">Danh mục sản phẩm</a></span>
                        <span><a href="${env }/customer/sanpham.html">Sản phẩm</a></span>
                    </div>
                </div>
            </div>
            <div class="main__section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 none block">
                            <div class="section__sidebar-widget">
                                <div class="widget__inner">
                                    <div class="widget__list">
                                        <h3 class="widget__title">Search</h3>
                                        <div class="widget__search-box">
                                            <input type="text" placeholder="Tìm kiếm..." class="widget__input">
                                            <button class="search-icon">
                                                <i class='bx bx-search'></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="widget__list">
                                        <h3 class="widget__title">Danh mục</h3>
                                        <div class="widget__list-body">
                                            <ul class="sidebar-list">
                                                <li><a href="#">Tất cả sảm phẩm</a></li>
                                                <li><a href="#">Chó Alaska Malamute (29)</a></li>
                                                <li><a href="#">Chó Corgi (18)</a></li>
                                                <li><a href="#">Chó Poodle (20)</a></li>
                                                <li><a href="#">Mèo Anh (Dài + Ngắn) (3)</a></li>
                                                <li><a href="#">Sản phẩm mới (8)</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="widget__list">
                                        <h3 class="widget__title">Tags</h3>
                                        <div class="widget__list-body">
                                            <ul class="tags">
                                                <li><a href="#">Dogs</a></li>
                                                <li><a href="#">Cats</a></li>
                                                <li><a href="#">Alaska</a></li>
                                                <li><a href="#">Thức ăn</a></li>
                                                <li><a href="#">Hubby</a></li>
                                                <li><a href="#">Animals</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9 col-12">
                            <div class="section__product-detail">
                                <div class="row">
                                    <div class="col-12 col-lg-5">
                                        <div class="product__detail-img">
                                            <div class="swiper myProduct">
                                                <div class="swiper-wrapper">
                                                    <div class="swiper-slide">
                                                        <img src="${env }/customer/img/products/4.jpeg" alt=""
                                                            class="swiper__product-img">
                                                    </div>
                                                    <div class="swiper-slide">
                                                        <img src="${env }/customer/img/products/2.jpeg" alt=""
                                                            class="swiper__product-img">
                                                    </div>
                                                    <div class="swiper-slide">
                                                        <img src="${env }/customer/img/products/8.jpeg" alt=""
                                                            class="swiper__product-img">
                                                    </div>
                                                    <div class="swiper-slide">
                                                        <img src="${env }/customer/img/products/7.jpeg" alt=""
                                                            class="swiper__product-img">
                                                    </div>
                                                </div>
                                                <!-- <div class="swiper-button-next"></div>
                                                <div class="swiper-button-prev"></div> -->
                                                <div class="swiper-pagination"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-7">
                                        <div class="product__detail-summery">
                                            <div class="product__header mb-10">
                                                <h2 class="product__header-title">SAMOYED TRẮNG XINH</h2>
                                            </div>
                                            <div class="product__price mb-10">
                                                <span class="curr__price">15.000.000đ</span>
                                                <span class="old__price">20.000.000đ</span>
                                            </div>
                                            <div class="product__code mb-10">
                                                <span>Mã đơn hàng: ABC123</span>
                                            </div>
                                            <div class="product__inventroy mb-10">
                                                <span class="inventroy-title">Tình trạng: </span>
                                                <span class="inventory__varient">Còn hàng</span>
                                            </div>
                                            <div class="product__quantity mb-10">
                                                <span>
                                                    Số lượng:
                                                </span>
                                                <div class="quantity__plus mb-10">
                                                    <input type="number" name="" id="">
                                                </div>
                                            </div>
                                            <div class="product__cart-button">
                                                <div class="add__to__cart">
                                                    <a href="#" class="add-cart-link">Add to cart</a>
                                                </div>
                                                <a href="#" class="add-cart-heart">
                                                    <i class='bx bx-heart'></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- chi tiết sản phẩm -->
                            <div class="section__product-description">
                                <h2 class="detail__heading">
                                    Chi tiết sản phẩm
                                </h2>
                                <div class="detail__text">
                                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur nulla
                                        voluptatum dolor, quidem quaerat saepe in. Obcaecati voluptatem ea sapiente,
                                        neque soluta incidunt harum a facilis possimus fuga distinctio voluptates. Lorem
                                        ipsum dolor sit amet consectetur, adipisicing elit. Maiores esse sequi at eius
                                        cumque. Temporibus architecto sunt aperiam corporis corrupti repellendus
                                        doloremque itaque recusandae facere provident voluptate dolore, nulla mollitia?
                                        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Deserunt, fugit
                                        adipisci. Quasi laboriosam sapiente, explicabo repellat, nemo ex tempore
                                        deserunt a accusamus quas deleniti debitis obcaecati, fugiat reiciendis mollitia
                                        architecto? Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia eos
                                        magni eius eligendi distinctio? Debitis porro veritatis perferendis officia
                                        iusto nostrum quisquam ducimus, consequuntur accusantium doloribus quibusdam
                                        voluptatum recusandae magnam?
                                    </p>
                                </div>
                            </div>

                            <!-- sản phẩm tương tự -->
                            <div class="related__products">
                                <div class="main__products-title">
                                    <p>Sản phẩm tương tự</p>
                                </div>
                                <div class="row">
                                    <div class="swiper myRelated">
                                        <div class="swiper-wrapper">
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/3.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/7.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/4.jpeg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/2.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/8.jpeg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/6.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/4.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/8.jpg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="swiper-slide">
                                                <div class="product">
                                                    <div class="thumb">
                                                        <a href="${env }/customer/sanpham.html" class="image">
                                                            <img src="${env }/customer/img/products/5.jpeg" class="fit-img zoom-img">
                                                        </a>
                                                        <span class="badges">
                                                            <span class="sale">-20%</span>
                                                        </span>
                                                    </div>
                                                    <div class="content">
                                                        <a href="${env }/customer/sanpham.html" class="content-link">
                                                            <h5 class="title">Chó mèo</h5>
                                                        </a>
                                                        <span class="price">
                                                            <span class="old">20.000.000đ</span>
                                                            <span class="new">15.000.000đ</span>
                                                        </span>
                                                        <span class="symbol">
                                                            <a href="#"><i class='bx bx-heart'></i></a>
                                                            <a href="#"><i class='bx bx-cart'></i></a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="swiper-button-next next"></div>
                                        <div class="swiper-button-prev prev"></div>
                                        <div class="swiper-pagination"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-- footer -->
		<jsp:include page ="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
		<!-- end footer-->

        <div class="scroll__top">
            <i class='bx bx-up-arrow-alt'></i>
        </div>

		<!-- mobileMenu-->
		<jsp:include page ="/WEB-INF/views/customer/layout/mobileMenu.jsp"></jsp:include>
		<!-- end mobileMenu-->
    </div>

    <%-- JS --%>
    <jsp:include page = "/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>

</html>