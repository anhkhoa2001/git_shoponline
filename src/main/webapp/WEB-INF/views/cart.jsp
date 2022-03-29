<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&display=swap" rel="stylesheet" />

    <!-- Animate On Scroll -->
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

    <!-- Custom StyleSheet -->
    <link rel="stylesheet" href="<c:url value="/resources/css/cart.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />">

    <title>Cart</title>
</head>
<body>
    <header id="header" class="header">
        <%@ include file="/WEB-INF/views/header.jsp" %>

        <div class="page__title-area">
            <div class="container">
                <div class="page__title-container">
                    <ul class="page__titles">
                        <li>
                            <a href="/">
                                <svg>
                                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-home" />"></use>
                                </svg>
                            </a>
                        </li>
                        <li class="page__title">Cart</li>
                    </ul>
                </div>
            </div>
        </div>
    </header>

    <main id="main">
        <section class="section cart__area">
            <div class="container">
                <div class="responsive__cart-area">
                    <form class="cart__form">
                        <div class="cart__table table-responsive">
                            <table width="100%" class="table">
                                <thead>
                                    <tr>
                                        <th>PRODUCT</th>
                                        <th>NAME</th>
                                        <th>PRICE</th>
                                        <th>TOTAL</th>
                                    </tr>
                                </thead>
                                <tbody id = "list-product">
                                    
                                </tbody>
                            </table>
                        </div>

                        <div class="cart-btns">
                            <div class="continue__shopping">
                                <a href="/myspring/home">Continue Shopping</a>
                            </div>
                        </div>

                        <div class="cart__totals">
                            <h3>Cart Totals</h3>
                            <ul>
                                <li>
                                    Subtotal <span class="new__price" id = "sub__total">$250.99</span>
                                </li>
                                <li>
                                    Sale <span id = "sale">$0</span>
                                </li>
                                <li>
                                    Shipping <span id = "shipping">$0</span>
                                </li>
                                <li>
                                    Total <span class="new__price" id = "total">$250.99</span>
                                </li>
                            </ul>
                            <a href = "/myspring/home/checkout" class = "check__out">PROCEED TO CHECKOUT</a>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <%@ include file="/WEB-INF/views/footer.jsp" %>

    <!-- Animate On Scroll -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script>
		let username = "${account.username }";
	</script>
	<script src="<c:url value="/resources/js/cart.js" />"></script>
</body>
</html>