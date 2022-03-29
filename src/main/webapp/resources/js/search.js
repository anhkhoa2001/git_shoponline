const input = document.querySelector('input');
const elementProduct = document.getElementsByClassName("product");
const elementUL = document.getElementById("list-product");

function getData(data, key) {
	let newData = [];
	for(let d of data) {
		let name = d.name.toLowerCase();
		if(name.indexOf(key) != -1) {
			newData[newData.length++] = d;
		}
	}
	let dataHTML = "";
	for(let d of newData) {
		dataHTML += "<li class = \"product\">\r\n"
					+ "	                <div class=\"product__header\">\r\n"
					+ "	                    <img src=\""+ d.image +"\" alt=\"product\">\r\n"
					+ "	                </div>\r\n"
					+ "	                <div class=\"product__footer\">\r\n"
					+ "	                    <h3>Laptop Asus ZenBook Flip UX363EA</h3>\r\n"
					+ "	                    <div class=\"rating\">\r\n"
					+ "	                        <svg>\r\n"
					+ "	                            <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "	                        </svg>\r\n"
					+ "	                        <svg>\r\n"
					+ "	                            <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "	                        </svg>\r\n"
					+ "	                        <svg>\r\n"
					+ "	                            <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "	                        </svg>\r\n"
					+ "	                        <svg>\r\n"
					+ "	                            <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "	                        </svg>\r\n"
					+ "	                        <svg>\r\n"
					+ "	                            <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-empty\" />\"></use>\r\n"
					+ "	                        </svg>\r\n"
					+ "	                    </div>\r\n"
					+ "	                    <div class=\"product__price\">\r\n"
					+ "	                        <h4>$"+ d.priceDola +"</h4>\r\n"
					+ "	                    </div>\r\n"
					+ "	                    <a href=\"/myspring/home/product/details?code="+ d.code +"\"><button type=\"submit\" class=\"product__btn\">SHOP NOW</button></a>\r\n"
					+ "	                </div>\r\n"
					+ "	            </li>";
	}
	document.querySelector("#main #list-product").innerHTML = dataHTML;
}	


fetch("/myspring/apiproduct", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
    console.log(data);
	getData(data, "");
	input.addEventListener('input', function(e) {
	    console.log(e.target.value);
		getData(data, e.target.value);
	});
});
