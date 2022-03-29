let totalPrice = 0;
let totalQuantity = 0;

function getAllProductInLocalStorage() {
	var values = [];
	var keys = Object.keys(localStorage);

	for(var k of keys) {
		if(localStorage.getItem(k) == username) {
			values[values.length++] = {
				"key": k,
				"value": localStorage.getItem(k)
			}
		}
	}
	console.log(values.length);
	return values;
}



function updateListProduct(data) {
	let dataHTML = "";
	for(var d of data) {
		totalPrice += parseInt(d.priceDola);
		dataHTML += "<tr class = \"product__1\">\r\n"
				+ "                                        <td class=\"product__thumbnail\">\r\n"
				+ "                                            <a href=\"/myspring/home/product/details?code="+ d.code +"\">\r\n"
				+ "                                                <img src=\""+ d.image +"\" alt=\"\">\r\n"
				+ "                                            </a>\r\n"
				+ "                                        </td>\r\n"
				+ "                                        <td class=\"product__name\">\r\n"
				+ "                                            <a href=\"/myspring/home/product/details?code="+ d.code +"\">"+ d.name +"</a>\r\n"
				+ "                                        </td>\r\n"
				+ "                                        <td class=\"product__price\">\r\n"
				+ "                                            <div class=\"price\">\r\n"
				+ "                                                <span class=\"unit__price\">$"+ d.priceDola +"</span>\r\n"
				+ "                                            </div>\r\n"
				+ "                                        </td>\r\n"
				+ "											\r\n"
				+ "                                        <td class=\"product__subtotal\">\r\n"
				+ "                                            <div class=\"price\">\r\n"
				+ "                                                <span class=\"new__price\">$"+ d.priceDola +"</span>\r\n"
				+ "                                            </div>\r\n"
				+ "                                            <a onclick=\"deleteProduct(this, '"+ d.code +"', '"+ d.priceDola +"')\" class=\"remove__cart-item\">\r\n"
				+ "                                                <svg>\r\n"
				+ "                                                    <use xlink:href=\"/myspring/resources/images/sprite.svg#icon-trash\"></use>\r\n"
				+ "                                                </svg>\r\n"
				+ "                                            </a>\r\n"
				+ "                                        </td>\r\n"
				+ "                                    </tr>";
	}
	document.querySelector("#main #list-product").innerHTML = dataHTML;
	totalQuantity = parseInt(data.length);
	updateCartTotal(totalPrice, totalQuantity);
}

fetch("/myspring/apicart", { 
	method: 'PUT',
	headers: {
	    'Content-Type': 'application/json',
	},
	body: JSON.stringify(getAllProductInLocalStorage()),
})
.then(response => response.json())
.then(data => {
  	console.log(data);
	updateListProduct(data);
});


function minusProduct(element, price) {
    console.log(element.parentElement.children[1].value);
    var count = element.parentElement.children[1].value;
    if(count > 1) {
        count--;
    }
    element.parentElement.children[1].value = count;
    price = parseInt(price);
	totalPrice = totalPrice - price;
	totalQuantity--;
    element.parentElement.parentElement.parentElement.parentElement.children[4].children[0].children[0].innerHTML = '$' + price*count;
	updateCartTotal(totalPrice, totalQuantity);
}

function plusProduct(element, price) {
    console.log(element.parentElement.children[1].value);
    var count = element.parentElement.children[1].value;
    if(count < 10) {
        count++;
    }
    element.parentElement.children[1].value = count;
    price = parseInt(price);
	totalPrice = totalPrice + price;
	totalQuantity++;
    element.parentElement.parentElement.parentElement.parentElement.children[4].children[0].children[0].innerHTML = '$' + price*count;
	updateCartTotal(totalPrice, totalQuantity);
}

function deleteProduct(element, code, priceDola) {
    element.parentElement.parentElement.remove();
	localStorage.removeItem(code);
	var price = element.parentElement.children[0].children[0].innerHTML;
	price = price.substring(1);
	totalPrice -= parseInt(price);
	totalQuantity -= (parseInt(priceDola)/parseInt(price)).toFixed();
	updateCartTotal(totalPrice, totalQuantity);
}

function updateCartTotal(tp, tq) {
	const elementSubTotal = document.querySelector("#main .cart__totals #sub__total");
	const elementSale = document.querySelector("#main .cart__totals #sale");
	const elementShipping = document.querySelector("#main .cart__totals #shipping");
	const elementTotal = document.querySelector("#main .cart__totals #total");
	
	elementSubTotal.innerHTML = '$' + tp;
	elementSale.innerHTML = tq + '%';
	elementShipping.innerHTML = '$' + tq;
	var total = parseInt(tp) + parseInt(tq) - parseInt(((tq/100)*tp).toFixed());
	elementTotal.innerHTML = '$' + total;
}






