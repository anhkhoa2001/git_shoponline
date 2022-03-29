<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Checkout</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="<c:url value="/resources/fonts/material-design-iconic-font/css/material-design-iconic-font.css" />">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="<c:url value="/resources/vendor/date-picker/css/datepicker.min.css" />">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="<c:url value="/resources/css/checkout/style.css" />">
	</head>
	<body>
		<div class="wrapper">
            <form action="" id="wizard">
        		<!-- SECTION 1 -->
                <h4></h4>
                <section>
                    <h3>Basic details</h3>
                	<div class="form-row">
                        <div class="form-holder">
                            <i class="zmdi zmdi-account"></i>
                            <input type="text" class="form-control first-name" placeholder="First Name">
                        </div>
                        <div class="form-holder">
                            <i class="zmdi zmdi-account"></i>
                            <input type="text" class="form-control last-name" placeholder="Last Name">
                        </div>
                	</div>
                    <div class="form-row">
                        <div class="form-holder">
                            <i class="zmdi zmdi-email"></i>
                            <input type="text" class="form-control email" placeholder="Email ID">
                        </div>
                        <div class="form-holder">
                            <i class="zmdi zmdi-smartphone-android"></i>
                            <input type="text" class="form-control phone" placeholder="Phone Number">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-holder">
                            <i class="zmdi zmdi-map"></i>
                            <input type="text" class="form-control residence" placeholder="Residence">
                        </div>
                        <div class="form-group">
                            <div class="form-holder">
                                <i class="zmdi zmdi-pin"></i>
                                <input type="text" class="form-control district" placeholder="District">
                            </div>
                            <div class="form-holder">
                                <i class="zmdi zmdi-pin-drop"></i>
                                <input type="text" class="form-control city" placeholder="City">
                            </div>
                        </div>
                    </div>
                </section>

                <!-- SECTION 3 -->
                <h4></h4>
                <section class = "list-product">
                    <h3 style="margin-bottom: 16px;">My Cart</h3>
                    <table style="margin-bottom: 40px" cellspacing="0" class="table-cart shop_table shop_table_responsive cart woocommerce-cart-form__contents table" id="shop_table">
                        <thead>
                            <th >Image</th>
                            <th >Product Detail</th>
                            <th >Quantity</th>
                            <th >Total Price</th>
                        </thead>
                        <tbody>
                        	<c:if test = "${product != null }">
                        		<tr>
	                                <td class="product-thumb">
	                                    <a href="#" class="item-thumb">
	                                        <img src="<c:url value="${product.image }" />" alt="">
	                                    </a>
	                                </td>
	                                <td class="product-detail" data-title="Product Detail">
	                                    <div style="margin-left: 24px">
	                                        <a href="#">${product.name }</a>
	                                        <span>$ ${product.priceDola }</span>
	                                    </div>
	                                </td>
	                                <td class="product-quantity" data-title="Quantity">
	                                    <div class="quantity">
	                                    	<span class="plus" onclick = "quantityPlus(this, ${product.priceDola })">+</span>
	                                        <input type="number" id="quantity_5b4f198d958e1" class="input-text qty text" step="1" min="0" max="" name="cart[5934c1ec0cd31e12bd9084d106bc2e32][qty]" value="1" title="Qty" size="4" pattern="[0-9]*" inputmode="numeric" />
	                                    	<span class="minus" onclick = "quantityMinus(this, ${product.priceDola })">-</span>
	                                    </div>
	                                </td>
	                                <td class="total-price" data-title="Total Price">
	                                    <span class="woocommerce-Price-amount amount">
	                                        <span class="woocommerce-Price-currencySymbol">$ ${product.priceDola }</span>
	                                    </span>
	                                </td>
	                            </tr>
                        	</c:if>
                        </tbody>
                    </table>
                </section>

                <!-- SECTION 4 -->
                <h4></h4>
                <section>
                    <h3>Cart Totals</h3>
                    <div class="cart_totals">
                        <table cellspacing="0" class="shop_table shop_table_responsive">
                            <tr class="cart-subtotal">
                                <th>Subtotal</th>
                                <td data-title="Subtotal">
                                    <span class="woocommerce-Price-amount amount">
                                        <span class="woocommerce-Price-currencySymbol cart_sub_total">$</span>
                                    </span>
                                </td>
                            </tr>
                            <tr class="cart-subtotal shipping">
                                <th>Shipping:</th>
                                <td data-title="Subtotal">
                                    <span class="woocommerce-Price-amount amount">
                                        <span class="woocommerce-Price-currencySymbol cart_shipping">$</span>
                                    </span>
                                </td>
                            </tr>
                            <tr class="cart-sales">
                                <th>Sales:</th>
                                <td data-title="Subtotal">
                                    <span class="woocommerce-Price-amount amount">
                                        <span class="woocommerce-Price-currencySymbol cart_sales">4</span>
                                    </span>
                                </td>
                            </tr>
                            <tr class="order-total border-0">
                                <th>Total</th>
                                <td data-title="Total">
                                    <span class="woocommerce-Price-amount amount">
                                        <span class="woocommerce-Price-currencySymbol cart_total">$</span>
                                    </span>
                                </td>
                            </tr>
                        </table>
                    </div>
                    
                </section>
            </form>
		</div>

		<script src="<c:url value="/resources/js/checkout/jquery-3.3.1.min.js" />"></script>
		
		<!-- JQUERY STEP -->
		<script src="<c:url value="/resources/js/checkout/jquery.steps.js" />"></script>
		<script>
			let code = '${product.code }';
			let username = '${account.username}';
			let product = {};
			if(username == '') {
				product = {
					"code": '${product.code }',
					"name": '${product.name }',
					"price": '${product.price }',
					"image": '${product.image }',
					"quantity": 1,
					"totalPrice": parseInt('${product.priceDola }')*1,
					"cid": '${product.category.id}'
				}
			}
			console.log(product);
		</script>
		<script src="<c:url value="/resources/js/checkout/checkout.js" />"></script>
</body>
</html>