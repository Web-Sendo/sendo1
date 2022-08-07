<%-- 
    Document   : cảt
    Created on : Aug 6, 2022, 8:49:33 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./style1.css" />
        <link
            rel="shortcut icon"
            href="https://www.sendo.vn/w3front/static/favicon.ico"
            />
    </head>

    <body>
        <noscript>
        <div class="noscript_div"></div>
        <div class="table_noscript">
            <h1>
                Xin hãy cho phép sử dụng Javascript để sử dụng đầy đủ chức năng!
            </h1>
        </div>
        </noscript>

        <div class="cart_body">
            <div class="category_product">
                <a href="">Giỏ hàng của bạn </a>
            </div>
            <div class="nav">
                <header class="header_section">
                    <div class="top-page">
                        <div class="top_page_group">
                            <div class="top_info">
                                <span onclick="pcsh1()">Tải ứng dụng</span>
                                <div style="display: none" id="qr_code" class="qr_code">
                                    <img
                                        data-src="https://media3.scdn.vn/img2/2018/5_23/R842FO.png"
                                        src="https://media3.scdn.vn/img2/2018/5_23/R842FO.png"
                                        alt="sendo-qr"
                                        class="ls-is-cached lazyloaded"
                                        />
                                    <a
                                        style="text-decoration: none"
                                        href="https://www.sendo.vn/su-kien/gioi-thieu-sendo-app/"
                                        class=""
                                        ><span class="download_text">Quét để tải ứng dụng</span></a
                                    >
                                </div>
                            </div>
                            <div class="top_info">
                                <span>
                                    <a
                                        style="text-decoration: none; color: white"
                                        href="https://help.sendo.vn/hc/vi"
                                        >Chăm sóc khách hàng</a
                                    >
                                </span>
                            </div>
                            <div class="top_info">
                                <span onclick="pcsh2()">Kiểm tra đơn hàng</span>
                                <div
                                    style="display: none"
                                    id="detail_donhang"
                                    class="detail_donhang"
                                    >
                                    <input type="text" placeholder="Nhập mã đơn hàng" />
                                    <input type="text" placeholder="Email / Số điện thoại" />
                                    <button>Kiểm Tra</button>
                                </div>
                            </div>
                        </div>
                    </div>
                  
                     <form action="SearchController">
                    <div class="container-fluid">

                        <div class="head_bar">
                            <a class="navbar-brand" href="MainController">
                                <svg class="sgv-logo">
                                <path fill="white"  d="M69.052 12.375l-3.097 16.548a44.418 44.418 0 00-.74 6.633h-4.378l.27-2.94h-.068a6.042 6.042 0 01-5.251
                                      3.008c-2.761 0-4.983-2.188-4.983-6.154 0-5.675 4.04-10.872 10.1-10.872.74 0 1.481.137 2.222.41l1.212-6.564
                                      4.713-.069zm-6.666 10.394a2.664 2.664 0 00-1.885-.547c-2.828 0-4.848 3.35-4.848 6.496 0 1.983.875 3.077 2.222 3.077
                                      1.414 0 3.03-1.436 3.636-4.581l.875-4.445zM4.481 30.017a10.123 10.123 0 005.252 1.436c1.818 0 3.501-.889
                                      3.501-2.667 0-1.299-.942-2.12-2.962-3.145-2.424-1.3-4.646-3.009-4.646-5.95 0-4.512 3.905-7.316 8.753-7.316
                                      2.693 0 4.31.616 5.252 1.163l-1.481 4.034a8.713 8.713 0 00-4.108-1.025c-2.222 0-3.366 1.162-3.366 2.393 0
                                      1.299 1.346 2.12 3.232 3.145 2.693 1.436 4.444 3.283 4.444 5.95 0 4.991-4.108 7.59-9.023 7.59-3.097 0-5.32-.821-6.33-1.573l1.482-4.035zm27.606
                                      4.308a13.756 13.756 0 01-5.992 1.3c-4.579 0-6.935-2.668-6.935-6.839 0-4.991 3.568-10.12 9.359-10.12 3.232 0 5.588 1.847 5.588 4.855
                                      0 4.171-3.972 5.676-10.436 5.54 0 .615.202 1.162.471 1.64.606.82 1.684 1.3 3.098 1.3 1.548 0 3.097-.342 4.51-1.026l.338 3.35zm-4.174-12.24c-2.222 0-3.434
                                      1.846-3.771 3.35 3.703.07 5.521-.478 5.521-1.982 0-.82-.606-1.368-1.75-1.368zm5.52 13.471l2.088-11.35c.404-2.052.74-4.24.875-5.676h4.242l-.404
                                      3.077h.068a6.707 6.707 0 015.656-3.077c2.625 0 4.107 1.64 4.107 4.444 0 .958-.135 1.847-.27 2.804l-1.818 9.778h-4.713l1.75-9.368c.135-.615.135-1.23.135-1.846 0-1.163-.404-1.915-1.548-1.915-1.549 0-3.367
                                      1.983-3.973 5.54l-1.414 7.59h-4.78zM84 25.3c0 5.95-3.973 10.325-9.561 10.325-4.107 0-6.8-2.735-6.8-6.77 0-5.675 3.904-10.325 9.56-10.325
                                      4.31.069 6.8 3.078 6.8 6.77m-11.445 3.487c0 1.915.942 3.146 2.558 3.146 2.626 0 4.04-3.83 4.04-6.633 0-1.504-.606-3.077-2.558-3.077-2.694 0-4.107 4.034-4.04 6.565"></path>
                                </svg>
                            </a>

                            <input class="input-header" name="search" type="search" placeholder="Tìm khiếm...">
                            <button style="height: 40px; margin-top: 15px;" type="submit">
                                <svg>
                                <path  d="M10 2a8 8 0 016.32 12.905l5.387 5.388-1.414 1.414-5.388-5.386A8 8 0 1110 2zm0 2a6 6 0 100 12 6 6 0 000-12z"></path>
                                </svg>
                            </button>

                            <div class ="btn_order_login" >
                                <div class="order-item">
                                    <a class="link_order" href="cart.jsp">
                                        <svg class="logo_order">
                                        <path fill="white" d="M20.946 2l.994 17.89a2 2 0 01-1.886 2.107l-.111.003H4.057a2 2 0 01-2-2c0-.055 0-.055.003-.11L3.054 2h17.892zm-1.892 2H4.946l-.889 16h15.886l-.889-16zM9 6v2.5c0 1.248 1.385 2.5 3 2.5s3-1.252 3-2.5V6h2v2.5c0 2.4-2.323 4.5-5 4.5s-5-2.1-5-4.5V6h2z"></path>
                                        </svg>
                                    </a>
                                </div>
                                <div class ="btn_login_area">
                                    <c:if test="${sessionScope.LOGIN_USER == null}">
                                        <button class="btn_login">
                                            <a href="login.jsp" class="text_login"style="text-decoration: none; color: black;">Đăng nhập</a>
                                        </button>
                                    </c:if>
                                    <c:if test="${sessionScope.LOGIN_USER != null}">
                                        <button class="btn_login">
                                            <a href="LogoutController" class="text_login"style="text-decoration: none; color: black;">Đăng xuất</a>
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                    </div>
                </form>
                </header>
            </div>
            <div class="cart">
                <div class="right-cart">
                    <div class="infor">
                        <div class="infor-cart">

                            <div class="item-product">
                                <div class="item">

                                    <c:forEach items="${sessionScope.CART}" var="c">
                                        <form action="UpdateCartController" method="POST">
                                            <div class="sub-item">
                                                <div class="name-shop">
                                                    <span>${c.product.categoryID}</span>
                                                </div>
                                                <div class="sub-item1">
                                                    <div class="infor-sub-item">
                                                        <div class="img-sub-item">
                                                            <img
                                                                class="img_cart_product"
                                                                src="${c.product.image}"
                                                                />
                                                        </div>
                                                        <div class="name-sub-item">
                                                            <span>${c.product.productName}</span>
                                                        </div>
                                                    </div>
                                                    <div class="price-sub-item">
                                                        <span>${c.product.price}</span>
                                                    </div>
                                                    <div style="width: 50px;margin-right: 20px" class="box_quantity">

                                                        <input type="text" name="quantity" value="${c.quantity}"/>
                                                        <c:set var="amount" value="${c.quantity*c.price}"/>
                                                    </div>
                                                    <div class="action-sub-item">
                                                        <button>
                                                            <a href="MainController?action=deleteCart&productID=${c.product.productID}"style="text-decoration: none;color: black ">Delete</a>
                                                        </button>
                                                    </div>
                                                    <div class="action-sub-item">   
                                                        <input type="submit" value="Update"/>
                                                        <input type="hidden" name="productID" value="${c.product.productID}"/></div>

                                                </div>
                                            </div>  
                                            <c:set var="total" value="${total+amount}"/>
                                        </form>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="left-cart">
                    <!--                    <div class="discount">
                                            <div class="span1">
                    
                                                <span>Adress<span>*</span></span>
                                              
                    
                                            </div>
                                            <div class="span2">
                    
                                            </div>
                                        </div>
                                        <hr>-->
                    <form action="CheckOutController">
                        <div class="buy">
                            <c:set value="${sessionScope.LOGIN_USER}" var="u"/>
                            <input type="hidden" value="${u.userName}" name="name">
                            <input type="hidden"  value="${u.phone}" name="phone"> 
                            <input type="hidden" name="total" value="${total}"/>
                            <input type="hidden" name="userID" value="${u.userID}"/>
                            <input type="hidden" name="address" value="${u.address}">
                            <div class="checkout">
                                <div class="total">
                                    <span>Tạm tính:</span>
                                    <span>${total}đ</span>
                                </div>
                                <div class="btn-checkout">
                                    <button type="submit" class="buy_now">Mua ngay</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="footer">
            <footer class="footer_selection">
                <section class="footer_area3">
                    <div class="detail_footer">
                        <span>
                            <h4>
                                Công ty Cổ phần Công nghệ Sen Đỏ, thành viên của Tập đoàn FPT
                                <br />
                            </h4>
                            <h5>
                                Số ĐKKD: 0312776486 - Ngày cấp: 13/05/2014, được sửa đổi lần thứ
                                6, ngày 23/05/2016.<br />
                            </h5>
                            <h5>Cơ quan cấp: Sở Kế hoạch và Đầu tư TPHCM.<br /></h5>
                            <h5>
                                Địa chỉ: Tầng 5, Tòa nhà A, Vườn Ươm Doanh Nghiệp, Lô D.01,
                                Đường Tân Thuận, Khu chế xuất Tân Thuận, Phường Tân Thuận Đông,
                                Quận 7, Thành phố Hồ Chí Minh, Việt Nam.<br />
                            </h5>
                            <h5>Email: lienhe@sendo.vn</h5>
                        </span>
                        <div class="logo_bocongthuong">
                            <a href="http://online.gov.vn/Home/WebDetails/21391">
                                <img
                                    src="https://media3.scdn.vn/img4/2020/12_16/XhpGDnvWqrlKeHLst3aS.png"
                                    alt="Bộ Công Thương"
                                    class="logo_dangky"
                                    />
                            </a>
                            <a
                                href="https://help.sendo.vn/hc/vi/articles/115001260091-L%C3%A0m-th%E1%BA%BF-n%C3%A0o-%C4%91%E1%BB%83-tr%E1%BA%A3-h%C3%A0ng"
                                >
                                <img
                                    src="https://media3.scdn.vn/img4/2020/12_16/h6lEMGIAt4Uapd0Mls34.png"
                                    alt="Bộ Công Thương - Nói không với hàng giả"
                                    class="logo_dangky"
                                    />
                            </a>
                        </div>
                    </div>
<!--                    <div class="email_footer">
                        <h6 for="subscription-email">
                            Đăng ký nhận bản tin ưu đãi khủng từ Sendo
                        </h6>
                        <form>
                            <input
                                id="subscription-email"
                                placeholder="Email của bạn là..."
                                type="text"
                                inputmode="email"
                                class="input_email_footer"
                                />

                            <button type="submit" value="Submit">
                                <h5>Đăng ký</h5>
                            </button>
                        </form>
                    </div>-->
                </section>
            </footer>
        </div>
        <script>
            function pcsh1() {
                var x = document.getElementById("qr_code");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
            function pcsh2() {
                var x = document.getElementById("detail_donhang");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
        </script>
    </body>
</html>

