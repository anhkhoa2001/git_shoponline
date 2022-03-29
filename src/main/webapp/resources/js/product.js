////////////////////////////////////////////////////////////
let linkAPI = "";
let cmID = 0;
let countProduct = 0;

if(type === 'phone') {
	linkAPI = "/myspring/apiphone";
	cmID = 1;
} else if(type === 'tablet') {
	linkAPI = "/myspring/apitablet";
	cmID = 2;
} else if(type === 'laptop') {
	linkAPI = "/myspring/apilaptop";
	cmID = 3;
}


fetch(linkAPI, {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
    countProduct = data.length;
	document.querySelector("#main .products").innerHTML = updateProduct(data);
	document.querySelector("#main .menu-input-max").innerHTML = 'The highest price is $' + getMaxPrice(data);
});

function getMaxPrice(data) {
	let maxPrice = -1;
	for(let d of data) {
		if(maxPrice <= d.priceDola) {
			maxPrice = d.priceDola;
		}
	}
	return maxPrice;
}

function updateProduct(data) {
	let dataHTML = "";
	for(let d of data) {
		dataHTML += "<div class = \"product-1\">\r\n"
				+ "                        <div class=\"product__header\">\r\n"
				+ "                            <img src=\""+ d.image +"\"   >\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"product__footer\">\r\n"
				+ "                            <h3>"+ d.name +"</h3>\r\n"
				+ "                            <div class=\"rating\">\r\n"
				+ "                                <svg>\r\n"
				+ "                                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
				+ "                                </svg>\r\n"
				+ "                                <svg>\r\n"
				+ "                                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
				+ "                                </svg>\r\n"
				+ "                                <svg>\r\n"
				+ "                                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
				+ "                                </svg>\r\n"
				+ "                                <svg>\r\n"
				+ "                                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
				+ "                                </svg>\r\n"
				+ "                                <svg>\r\n"
				+ "                                    <use xlink:href=\"<c:url value=\"/resources/images/sprite.svg#icon-star-empty\" />\"></use>\r\n"
				+ "                                </svg>\r\n"
				+ "                            </div>\r\n"
				+ "                            <div class=\"product__price\">\r\n"
				+ "                                <h4>$"+ d.priceDola +"</h4>\r\n"
				+ "                            </div>\r\n"
				+ "                            <a href=\"/myspring/home/product/details?code="+ d.code +"\"><button type=\"submit\" class=\"product__btn\">Watch Now</button></a>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>";
	}
	return dataHTML;
}


fetch("/myspring/apicategory?cmID=" + cmID, {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
	updateListCategory(document.querySelector("#main .menu-check"), data);
});

let objectCategory = {
	
}

function getSizeByArray(oldData) {
	var countGeneral = 0;
	var dataJSON = {
		"id": array,
		"top": parseInt(objectPrice.top),
		"bot": parseInt(objectPrice.bot),
		"sort": objectSort,
		"count": countProduct
	}
	fetch(linkAPI + "/size", { 
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
		countGeneral = data;
		if(oldData.length == countGeneral) {
			document.querySelector("#main #load-more").style.display = 'none';
		} else {
			document.querySelector("#main #load-more").style.display = 'inline-block';
		}
	});
}

function updateListCategory(element, data) {
	let dataHTML = "";
	for(let d of data) {
		let size = d.sizePhoneTabs == 0 ? d.sizeLaptops : d.sizePhoneTabs;
		dataHTML +=   "					<span>\r\n"
					+ "                    <input class = \"check-type\" type=\"checkbox\" name=\"category\" id=\""+ d.id +"\" onclick=\"myChecked(this, "+ d.id +");\" value=\""+ d.id +"\">\r\n"
					+ "                    <p>"+ d.line +"</p>\r\n"
					+ "                    <h5>("+ size +")</h5>\r\n"
					+ "                  </span>";
	}
	objectCategory = data;
	element.innerHTML += dataHTML;
	console.log(objectCategory)
}

let array = [];

function myChecked(element, id) {
	console.log(element.checked + " " + id);
	if(element.checked) {
		array[array.length++] = id;
	} else {
		array = array.filter(item => item !== id);
	}
	var dataJSON = {
		"id": array,
		"top": parseInt(objectPrice.top),
		"bot": parseInt(objectPrice.bot),
		"sort": objectSort,
		"count": countProduct
	}
	fetch(linkAPI, {
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
		getSizeByArray(data);
		document.querySelector("#main .products").innerHTML = updateProduct(data);
	});
}

let objectPrice = {
	"top": 0,
	"bot": 0
}

let objectSort = {
	"type": "default",
	"value": "default"
};

function checkPrice() {
	let priceBot = document.querySelector("#price-bot").value == "" ? 0 : document.querySelector("#price-bot").value;
	let priceTop = document.querySelector("#price-top").value == "" ? 0 : document.querySelector("#price-top").value;
	
	objectPrice.top = priceTop;
	objectPrice.bot = priceBot;
	
	var dataJSON = {
		"id": array,
		"top": parseInt(objectPrice.top),
		"bot": parseInt(objectPrice.bot),
		"sort": objectSort,
		"count": countProduct
	}
	console.log(JSON.stringify(dataJSON));
	
	fetch(linkAPI, { 
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
	  	getSizeByArray(data);
		document.querySelector("#main .products").innerHTML = updateProduct(data);
	});
}

function Reset() {
	document.querySelector("#price-bot").value = "";
	document.querySelector("#price-top").value = "";
	objectPrice.top = 0;
	objectPrice.bot = 0;
}


function sortProduct(element) {
	let type = (element.value === "top" || element.value === "bot") ? "price" : "name";
	console.log(element.value);
	objectSort.type = type;
	objectSort.value = element.value;
	
	var dataJSON = {
		"id": array,
		"top": parseInt(objectPrice.top),
		"bot": parseInt(objectPrice.bot),
		"sort": objectSort,
		"count": countProduct
	}
	console.log(JSON.stringify(dataJSON));
	
	fetch(linkAPI, { 
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		document.querySelector("#main .products").innerHTML = updateProduct(data);
	});
}

function loadMore() {
	countProduct += 9;
	var dataJSON = {
		"id": array,
		"top": parseInt(objectPrice.top),
		"bot": parseInt(objectPrice.bot),
		"sort": objectSort,
		"count": countProduct
	}
	
	fetch(linkAPI, { 
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
		getSizeByArray(data);
		document.querySelector("#main .products").innerHTML = updateProduct(data);
	});
}


