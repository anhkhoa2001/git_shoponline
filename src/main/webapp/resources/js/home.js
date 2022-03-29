
////////////////////////////////////////////////////////////
//lay 8 dien thoai gia cao nhat
fetch("/myspring/apiphone?count=8&type=desc", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
    console.log(data);
	updateHome(document.querySelector("#phone .list_products ul"), data);
});

function updateHome(element, data) {
	let dataHTML = "";
	for(let d of data) {
		dataHTML += "<li>\r\n"
					+ "              <div class=\"product__header\">\r\n"
					+ "                <img src=\""+ d.image +"\" alt=\"product\">\r\n"
					+ "              </div>\r\n"
					+ "              <div class=\"product__footer\">\r\n"
					+ "                <h3>"+ d.name +"</h3>\r\n"
					+ "                <div class=\"rating\">\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-empty\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"product__price\">\r\n"
					+ "                  <h4> $"+ d.priceDola +"</h4>\r\n"
					+ "                </div>\r\n"
					+ "                <a href=\"/myspring/home/product/details?code="+ d.code +"\"><button type=\"submit\" class=\"product__btn\">Watch Now</button></a>\r\n"
					+ "              </div>\r\n"
					+ "            </li>";
	}
	element.innerHTML += dataHTML;
}

////////////////////////////////////////////////////////
//lay 8 laptop gia cao nhat
fetch("/myspring/apilaptop?count=8&type=desc", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
    console.log(data);
	updateHome(document.querySelector("#laptop .list_products ul"), data);
});