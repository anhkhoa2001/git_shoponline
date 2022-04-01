//////////////////////////////////////////////////////////
////////////////DASHBOARD//////////////////////////////////

fetch("/myspring/apimanage/chart?number=one", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(dataJSON => {
    console.log(dataJSON);
	const myChart1 = new Chart(document.getElementById('myChart1').getContext('2d'), {
    type: 'line',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'September', 'December'],
        datasets: [{
            label: '# of Votes',
            data: dataJSON,
            backgroundColor: ['#1761fd'],
            borderColor: ['#1761fd'],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});	
});

fetch("/myspring/apimanage/chart?number=two", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(dataJSON => {
    console.log(dataJSON);
	const myChart2 = new Chart(document.getElementById('myChart2').getContext('2d'), {
    type: 'doughnut',
    data: {
        labels: ['Smart Phone', 'Tablet', 'Laptop'],
        datasets: [{
            data: dataJSON,
            backgroundColor: ['yellow', 'blue', 'red'],
            borderColor: ['yellow', 'blue', 'red'],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
});

fetch("/myspring/apimanage/table/one", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(dataJSON => {
    console.log(dataJSON);
	var dataHTML = "";
	for(var d of dataJSON) {
		dataHTML += "								<tr>\r\n"
		+ "	                                            <td>"+ d.device +"</td>\r\n"
		+ "	                                            <td class=\"text-end\">"+ d.total +"</td>\r\n"
		+ "	                                            <td class=\"text-end\">"+ d.quantity +"</td>\r\n"
		+ "	                                            <td class=\"text-end\">"+ d.avg +"</td>\r\n"
		+ "	                                        </tr>";
	}
	document.querySelector(".table.one tbody").innerHTML = dataHTML;
});

fetch("/myspring/apimanage/table/two", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(dataJSON => {
    console.log(dataJSON);
	var dataHTML = "";
	for(var d of dataJSON) {
		dataHTML += "<tr>                                                        \r\n"
		+ "                                                <td>"+ d.name +"</td>\r\n"
		+ "                                                <td>"+ d.email +"</td>\r\n"
		+ "                                                <td>"+ d.quantity +"</td>\r\n"
		+ "                                                <td>"+ d.total +"</td>\r\n"
		+ "                                                <td>"+ d.created +"</td>\r\n"
		+ "                                            </tr> ";
	}
	document.querySelector(".table.two tbody").innerHTML = dataHTML;
});

fetch("/myspring/apimanage/table/three", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(dataJSON => {
    console.log(dataJSON);
	var dataHTML = "";
	for(var d of dataJSON) {
		dataHTML += "									<tr>\r\n"
	    + "                                                <td><img src=\""+ d.image +"\" height=\"16\" class=\"me-2\" >"+ d.name +"</td>\r\n"
	    + "                                                <td>"+ d.code +"</td>     \r\n"
	    + "                                                <td>$"+ d.price +"</td>      \r\n"
	    + "                                                <td>"+ d.quantity +"</td>\r\n"
	    + "                                            </tr>";
	}
	document.querySelector(".table.three tbody").innerHTML = dataHTML;
});


let varChangeState = null;
let states = ['home', 'product', 'order', 'contact'];
function changeState(element, type) {
	varChangeState = type;
    for(var i=1; i<4; i++) {
        element.parentElement.parentElement.children[i].children[0].style.color = '#68728c';
    }
    element.style.color = '#1761fd';
    const elementStates = document.querySelectorAll(".page-wrapper .container-fluid");
    const elementPages = document.querySelectorAll(".page-wrapper .container-fluid .content_bot");
    for(var e of elementStates) {
        e.classList.remove("open");
    }
    for(var e of elementPages) {
        addPage(e, false);
    }
    const elementState = document.querySelector(".page-wrapper .container-fluid." + type);
    elementState.classList.add('open');
	if(type == states[1]) {
		checkUpdateCountPageAccount = 0;
		checkUpdateCountPageOrders = 0;
		updateTableProduct(getUrlTableProduct(1, search));	
	} else if(type == states[2]) {
		checkUpdateCountPage = 0;
		checkUpdateCountPageAccount = 0;
		updateTableOrders(getUrlTableOrders(1));
	} else if(type == states[3]) {
		checkUpdateCountPage = 0;
		checkUpdateCountPageOrders = 0;
		updateTableAccount(getUrlTableAccount(1));
	} else {
		checkUpdateCountPage = 0;
		checkUpdateCountPageOrders = 0;
		checkUpdateCountPageAccount = 0;
	}
}


let totalPage = 12;
let countPageAppear = 5;
let isBefore = true;
let dataPage = null;

// xử lí phân trang
function handlePage(total) {
	let htmlPage;
	if(total > 7) {
		htmlPage = "            <ul class = \"paging\">\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnArrow(this, 'left')\"><span><i class=\"fas fa-chevron-left\"></i></span></li>\r\n"
					+ "                        <li class = \"btn_page active\" onclick=\"clickBtnPagingView(this, 1)\"><span>1</span></li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnPagingView(this, 2)\"><span>2</span></li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnPagingView(this, 3)\"><span>3</span></li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnPagingView(this, 4)\"><span>4</span></li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnPagingView(this, 5)\"><span>5</span></li>\r\n"
					+ "                        <li class = \"btn_page_middle\">.....</li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnPagingView(this, "+ total +")\"><span>"+ totalPage +"</span></li>\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnArrow(this, 'right')\"><span><i class=\"fas fa-chevron-right\"></i></span></li>\r\n"
					+ "                    </ul>";
	
	} else {
		htmlPage = "<ul class = \"paging\">\r\n"
					+ "                        <li class = \"btn_page\" onclick=\"clickBtnArrow(this, 'left')\"><span><i class=\"fas fa-chevron-left\"></i></span></li>\r\n"
					+ "                        <li class = \"btn_page active\" onclick=\"clickBtnPagingView(this, 1)\"><span>1</span></li>\r\n";
		for(i=2; i<=total; i++) {
			htmlPage += "<li class = \"btn_page\" onclick=\"clickBtnPagingView(this, "+ i +")\"><span>"+ i +"</span></li>\r\n";
		}
		
		htmlPage += "                    <li class = \"btn_page\" onclick=\"clickBtnArrow(this, 'right')\"><span><i class=\"fas fa-chevron-right\"></i></span></li>\r\n"
					+ "                    </ul>";
	}
	
	return htmlPage;	
}

function addPage(element, isno, total) {
    if(isno) {
        element.innerHTML = handlePage(total);
    } else {
        element.innerHTML = "";
    }
}

function createBtnPage(element, value, classname, elementBefore) {
    const liPage = document.createElement("li");
    liPage.className = classname;
    const spanPage = document.createElement("span");
    spanPage.innerHTML = value;
    liPage.setAttribute("onclick", "clickBtnPagingView(this, "+ value +")");
    liPage.appendChild(spanPage);
    element.insertBefore(liPage, elementBefore);
}

function createPageMiddle(e) {
    const element = document.createElement("li");
    element.className = "btn_page_middle";
    element.innerHTML = "....";
    e.appendChild(element);
}

function clickBtnPagingView(e, value) {
    const btnPagingActive = document.querySelector(".btn_page.active");
    const btnPagingMiddle = document.querySelector(".btn_page_middle");
    const btnPaging = document.querySelectorAll(".btn_page");
    const elementPaging = document.querySelector(".paging");

    btnPagingActive.classList.remove("active");
    e.classList.add("active");
    let count = 0;
    for(i=0; i<document.querySelectorAll(".paging li").length; i++) {
        if(document.querySelectorAll(".paging li")[i] === btnPagingMiddle) {
            count = i;
        }
    }
    console.log(isBefore);
	if(varChangeState == states[1]) {
		updateTableProduct(getUrlTableProduct(value, search));
	} else if(varChangeState == states[2]) {
		updateTableOrders(getUrlTableOrders(value));
	} else if(varChangeState == states[3]) {
		updateTableAccount(geturgetUrlTableAccount(value));
	}
    if(totalPage < 7) {
        btnPagingActive.classList.remove("active");
    } else {
        if(value >= totalPage - countPageAppear + 1 && isBefore) {
            isBefore = false;
            console.log(isBefore)
            for(i=1; i<count; i++) {
                elementPaging.removeChild(btnPaging[i]);
            }
            createBtnPage(elementPaging, 1, "btn_page", btnPagingMiddle);
            for(i=1; i<countPageAppear; i++) {
                if(totalPage + i - countPageAppear == value) {
                    createBtnPage(elementPaging, value, "btn_page active", btnPaging[count]);
                } else {
                    createBtnPage(elementPaging, totalPage + i - countPageAppear, "btn_page", btnPaging[count]);
                }
            }
        } else {
            if(!isBefore && value == 1){
                isBefore = true;
                for(i=2; i<6; i++) {
                    elementPaging.removeChild(btnPaging[i]);
                }
                for(i=2; i<=countPageAppear; i++) {
                    createBtnPage(elementPaging, i, "btn_page", btnPagingMiddle);
                }
            }
            const btnPagingFirst = btnPaging[1];
            let result = value - btnPagingFirst.firstChild.innerHTML;
            if(result == 3 && !isBefore) {
                isBefore = true;
                for(i=2; i<6; i++) {
                    elementPaging.removeChild(btnPaging[i]);
                }
                for(i=2; i<=countPageAppear; i++) {
                    if(value == i) {
                        createBtnPage(elementPaging, value, "btn_page active", btnPagingMiddle);
                    } else {
                        createBtnPage(elementPaging, i, "btn_page", btnPagingMiddle);
                    }
                }
            } else if(result == 3 && isBefore) {
                createBtnPage(elementPaging, value + result - 1, "btn_page", btnPagingMiddle);
                elementPaging.removeChild(btnPagingFirst);
            } else if(result == 4 && isBefore) {
                let index = 0;
                while(index < 2) {
                    index++;
                    createBtnPage(elementPaging, value + index, "btn_page", btnPagingMiddle);
                }
                elementPaging.removeChild(btnPagingFirst);
                elementPaging.removeChild(btnPaging[2]);
            } 
        }
    }
    
}


function clickBtnArrow(e, arrow) {
    const btnPagingActive = document.querySelector(".btn_page.active");
    const btnPagingMiddle = document.querySelector(".btn_page_middle");
    const btnPaging = document.querySelectorAll(".btn_page");
    const elementPaging = document.querySelector(".paging");
    let count = 0;
    for(i=0; i<document.querySelectorAll(".paging li").length; i++) {
        if(document.querySelectorAll(".paging li")[i] === btnPagingMiddle) {
            count = i;
        }
    }
    if(arrow == 'left') {
		if(varChangeState == states[1]) {
			updateTableProduct(getUrlTableProduct(totalPage, search));
		} else if(varChangeState == states[2]) {
			updateTableOrders(getUrlTableOrders(totalPage));
		} else if(varChangeState == states[3]) {
			updateTableAccount(geturgetUrlTableAccount(totalPage));
		}
        btnPagingActive.classList.remove("active");
        if(totalPage < 7) {
            btnPaging[1].classList.add("active");
        } else {
            if(isBefore) {
                for(i=1; i<count; i++) {
                    elementPaging.removeChild(btnPaging[i]);
                }
                createBtnPage(elementPaging, 1, "btn_page active", btnPagingMiddle);
                for(i=2; i<=countPageAppear; i++) {
                    createBtnPage(elementPaging, i, "btn_page", btnPagingMiddle);
                }
            } else {
                isBefore = true;
                for(i=1; i<6; i++) {
                    elementPaging.removeChild(btnPaging[i]);
                }
                createBtnPage(elementPaging, 1, "btn_page active", btnPagingMiddle);
                for(i=2; i<=countPageAppear; i++) {
                    createBtnPage(elementPaging, i, "btn_page", btnPagingMiddle);
                }
            }
        }
    } else {
		if(varChangeState == states[1]) {
			updateTableProduct(getUrlTableProduct(totalPage, search));
		} else if(varChangeState == states[2]) {
			updateTableOrders(getUrlTableOrders(totalPage));
		} else if(varChangeState == states[3]) {
			updateTableAccount(geturgetUrlTableAccount(totalPage));
		}
        btnPagingActive.classList.remove("active");
        if(totalPage < 7) {
            btnPaging[6].classList.add("active");
        } else {
            if(isBefore) {
                for(i=2; i<count; i++) {
                    elementPaging.removeChild(btnPaging[i]);
                }
                for(i=1; i<countPageAppear; i++) {
                    createBtnPage(elementPaging, totalPage + i - countPageAppear, "btn_page", btnPaging[6]);
                }
                isBefore = false;
            } else {
                btnPagingActive.classList.remove("active");
            }
            btnPaging[6].classList.add("active");
        }
    }
}

//////////////////////////////////////////////////////////
////////////////PRODUCT//////////////////////////////////

let dataJsonProduct = {
	"start": 0,
	"end": 9
}
let checkUpdateCountPage = 0;
let search = "";

function getUrlTableProduct(page, search) {
	dataJsonProduct.start = (page-1)*10;
	dataJsonProduct.end = page*10 -1;
	return "/myspring/apimanage/product?start="+dataJsonProduct.start+"&end="+dataJsonProduct.end+ "&search=" + search;
}

function updateTableProduct(urlData) {
	fetch(urlData, {
	    method: 'GET',
	}).then(resp => {
	    if(resp.status === 200) {
			checkUpdateCountPage++;
	        return resp.json();
	    }
	}).then(dataJSON => {
		let dataHTML = "";
		for(var d of dataJSON.data) {
			dataHTML += "						<tr>\r\n"
		   + "	                                    <td>\r\n"
		   + "	                                        <img src=\""+ d.image +"\" alt=\"\" height=\"40\">\r\n"
		   + "	                                        <p class=\"d-inline-block align-middle mb-0\">\r\n"
		   + "	                                            <a href=\"#\" class=\"d-inline-block align-middle mb-0 product-name\">"+ d.name +"</a> \r\n"
		   + "	                                            <br>\r\n"
		   + "	                                            <span class=\"text-muted font-13\">"+ d.code +"</span> \r\n"
		   + "	                                        </p>\r\n"
		   + "	                                    </td>\r\n"
		   + "	                                    <td>"+ d.line +"</td>\r\n"
		   + "	                                    <td>"+ d.quantity +"</td>\r\n"
		   + "	                                    <td>$"+ d.price +"</td>\r\n"
		   + "	                                    <td><span class=\"badge badge-soft-warning\">Stock</span></td>\r\n"
		   + "	                                    <td>\r\n"
		   + "	                                        <ul class=\"list-inline mb-0\">\r\n"
		   + "	                                            <li class=\"list-inline-item align-middle\"><i class=\"fas fa-circle text-success\"></i></li>\r\n"
		   + "	                                            <li class=\"list-inline-item align-middle\"><i class=\"fas fa-circle text-pink\"></i></li>\r\n"
		   + "	                                            <li class=\"list-inline-item align-middle\"><i class=\"fas fa-circle text-info\"></i></li>\r\n"
		   + "	                                            <li class=\"list-inline-item align-middle\"><i class=\"fas fa-circle text-warning\"></i></li>\r\n"
		   + "	                                        </ul>\r\n"
		   + "	                                    </td>\r\n"
		   + "	                                    <td>\r\n"
		  + "	                                        <a href=\"#\" onclick = \"openEditItem(this, '"+ d.lineCatemenu +"', '"+ d.code +"')\" ><i class=\"las la-pen text-secondary font-16\"></i></a>\r\n"
		   + "	                                        <a href=\"#\" onclick = \"deleteItem(this, '"+ d.lineCatemenu +"', '"+ d.code +"')\"><i class=\"las la-trash-alt text-secondary font-16\"></i></a>\r\n"
		   + "	                                    </td>\r\n"
		   + "	                                </tr>";
		}
		document.querySelector("#datatable .product").innerHTML = dataHTML;
		if(checkUpdateCountPage == 1) {
			totalPage = dataJSON.countPage;
			addPage(document.querySelector(".container-fluid.open .content_bot"), true, totalPage);
		}
	});
}


document.querySelector(".search-products").addEventListener("keyup", function(event) {
	if (event.keyCode === 13) {
		search = document.querySelector(".search-products").value;
		checkUpdateCountPage = 0;
		updateTableProduct(getUrlTableProduct(1, search));
	}
});

function dropdownItem(element, type) {
    const elementDrop = document.querySelector(".element-product .dropdown-menu.product");
    if(elementDrop.className.indexOf("show") != -1) {
        elementDrop.classList.remove("show");
    } else {
        elementDrop.classList.add("show");
    }
}

function openItem(element, type) {
    const elementItem = document.querySelector(".input_content.add." + type);
    if(type == 'tablet') {
        elementItem.children[0].children[1].innerHTML = 'Add Tablet';
    }
    if(elementItem.className.indexOf("open") != -1) {
        elementItem.classList.remove("open");
    } else {
        elementItem.classList.add("open");
    }
}


function closeItem(element, type) {
    const elementItem = document.querySelector(".input_content." + type + ".open");
    elementItem.classList.remove("open");
}


function openEditItem(element, type, code) {
	if(type.indexOf("smart") != -1) {
		type = type.split(' ')[1];
	}
	const elementItem = document.querySelector(".input_content.edit." + type);
	console.log(type);
    if(type == 'tablet') {
        elementItem.children[0].children[1].innerHTML = 'Add Tablet';
    }
    if(elementItem.className.indexOf("open") != -1) {
        elementItem.classList.remove("open");
    } else {
        elementItem.classList.add("open");
    }

	if(type != 'laptop') {
		fetch("/myspring/apimanage/product/edit?code=" + code, { 
			method: 'GET',
		})
		.then(response => response.json())
		.then(data => {
			elementItem.children[0].children[2].children[1].value = data.name;
			elementItem.children[0].children[2].children[2].value = data.phonetab_id;
			elementItem.children[0].children[3].children[1].value = data.code;
			elementItem.children[0].children[4].children[1].value = data.priceDola;
			elementItem.children[0].children[5].children[1].value = data.quantityStock;
			elementItem.children[0].children[6].children[1].value = data.screen;
			elementItem.children[0].children[7].children[1].value = data.frontCamera;
			elementItem.children[0].children[8].children[1].value = data.backCamera;
			elementItem.children[0].children[9].children[1].value = data.ram;
			elementItem.children[0].children[10].children[1].value = data.chip;
			elementItem.children[0].children[11].children[1].value = data.memory;
			elementItem.children[0].children[12].children[0].src = data.image;
		});
	} else {
		fetch("/myspring/apimanage/product/edit?code=" + code, { 
			method: 'GET',
		})
		.then(response => response.json())
		.then(data => {
			elementItem.children[0].children[2].children[1].value = data.name;
			elementItem.children[0].children[2].children[2].value = data.laptop_id;
			elementItem.children[0].children[3].children[1].value = data.code;
			elementItem.children[0].children[4].children[1].value = data.priceDola;
			elementItem.children[0].children[5].children[1].value = data.quantityStock;
			elementItem.children[0].children[6].children[1].value = data.display;
			elementItem.children[0].children[7].children[1].value = data.card;
			elementItem.children[0].children[8].children[1].value = data.cpu;
			elementItem.children[0].children[9].children[1].value = data.ram;
			elementItem.children[0].children[10].children[1].value = data.weight;
			elementItem.children[0].children[11].children[1].value = data.size;
			elementItem.children[0].children[12].children[1].value = data.memory;
			elementItem.children[0].children[13].children[0].src = data.image;
		});
	}
}
/*
function getDataJSONFormAddPhoneTab(elementItem) {
	var name = elementItem.children[0].children[2].children[1].value;
	var code = elementItem.children[0].children[3].children[1].value;
	var price = elementItem.children[0].children[4].children[1].value;
	var quantity = elementItem.children[0].children[5].children[1].value;
	var screen = elementItem.children[0].children[6].children[1].value;
	var front = elementItem.children[0].children[7].children[1].value;
	var back = elementItem.children[0].children[8].children[1].value;
	var ram = elementItem.children[0].children[9].children[1].value;
	var chip = elementItem.children[0].children[10].children[1].value;
	var memory = elementItem.children[0].children[11].children[1].value;
	var file = elementItem.children[0].children[12].children[1].value.split('\\')[2];
	
	var dataJSON = {
		"name": name,
		"code": code,
		"price": parseInt(price),
		"quantity": parseInt(quantity),
		"screen": screen,
		"front": front,
		"back": back,
		"ram": ram,
		"chip": chip,
		"memory": memory,
		"file": '/myspring/resources/images/images_shop/' + file
	}
	return dataJSON;
}

function getDataJSONFormAddLaptop(elementItem) {
	var name = elementItem.children[0].children[2].children[1].value;
	var code = elementItem.children[0].children[3].children[1].value;
	var price = elementItem.children[0].children[4].children[1].value;
	var quantity = elementItem.children[0].children[5].children[1].value;
	var display = elementItem.children[0].children[6].children[1].value;
	var card = elementItem.children[0].children[7].children[1].value;
	var cpu = elementItem.children[0].children[8].children[1].value;
	var ram = elementItem.children[0].children[9].children[1].value;
	var weight = elementItem.children[0].children[10].children[1].value;
	var size = elementItem.children[0].children[11].children[1].value;
	var memory = elementItem.children[0].children[12].children[1].value;
	var file = elementItem.children[0].children[13].children[1].value.split('\\')[2];
	
	var dataJSON = {
		"name": name,
		"code": code,
		"price": parseInt(price),
		"quantity": parseInt(quantity),
		"display": display,
		"card": card,
		"cpu": cpu,
		"ram": ram,
		"weight": parseFloat(weight),
		"size": size,
		"memory": memory,
		"file": 'http://localhost:8080/myspring/resources/images/images_shop/' + file
	}
	return dataJSON;
}*/
/*
function submitFormAddProduct(element, type) {
	const elementItem = document.querySelector(".input_content.add." + type);
	var dataJSON = null;
	if(type != 'laptop') {
		dataJSON = getDataJSONFormAddPhoneTab(elementItem);
	} else {
		dataJSON = getDataJSONFormAddLaptop(elementItem);
	}
	console.log(dataJSON);
	fetch("/myspring/apimanage/product/add?line=" + type, { 
		method: 'POST',
		headers: {
		    'Content-Type': 'application/json; charset=UTF-8',
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		if(data == '1') {
			alert("Thêm sản phẩm thành công!!");
			location.reload();
		} else {
			alert("Thêm sản phẩm thất bại!!");
			location.reload();
		}
	});
}
*/
/*
function submitFormEditProduct(element, type) {
	const elementItem = document.querySelector(".input_content.edit." + type);
	var id = elementItem.children[0].children[2].children[2].value;
	var dataJSON = null;
	if(type != 'laptop') {
		dataJSON = getDataJSONFormAddPhoneTab(elementItem);
		dataJSON.id = parseInt(id);
	} else {
		dataJSON = getDataJSONFormAddLaptop(elementItem);
		dataJSON.id = parseInt(id);
	}
	console.log(dataJSON);
	fetch("/myspring/apimanage/product/edit?line=" + type, { 
		method: 'PUT',
		headers: {
		    'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataJSON),
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		if(data == '1') {
			alert("Sửa sản phẩm thành công!!");
			location.replace("/myspring/manage");
		} else {
			alert("Sửa sản phẩm thất bại!!");
			location.replace("/myspring/manage");
		}
	});
}*/
function deleteItem(element, type, code) {
	element.parentElement.parentElement.remove();
	fetch("/myspring/apimanage/product/delete?line=" + type + "&code=" + code, { 
		method: 'GET',
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		if(data == '1') {
			alert("Xóa sản phẩm thành công!!");
			location.replace("/myspring/manage");
		} else {
			alert("Xóa sản phẩm thất bại!!");
			location.replace("/myspring/manage");
		}
	});
}
//////////////////////////////////////////////////////////
////////////////ORDER//////////////////////////////////
let checkUpdateCountPageOrders = 0;

function getUrlTableOrders(page) {
	var start = (page-1)*10;
	var end = page*10 -1;
	return "/myspring/apimanage/orders?start="+start+"&end="+end;
}

function updateTableOrders(urlData) {
	fetch(urlData, {
	    method: 'GET',
	}).then(resp => {
	    if(resp.status === 200) {
			checkUpdateCountPageOrders++;
	        return resp.json();
	    }
	}).then(dataJSON => {
		console.log(dataJSON.data);
		let dataHTML = "";
		for(var d of dataJSON.data) {
			dataHTML += "									<tr>\r\n"
					+ "	                                    	<td>"+ d.ordinal +"</td>\r\n"
					+ "	                                        <td>\r\n"
					+ "		                                        <p class=\"d-inline-block align-middle mb-0\">\r\n"
					+ "		                                            <a href=\"#\" class=\"d-inline-block align-middle mb-0 product-name\">"+ d.name +"</a> \r\n"
					+ "		                                            <br>\r\n"
					+ "		                                            <span class=\"text-muted font-13\">"+ d.email +"</span> \r\n"
					+ "		                                        </p>\r\n"
					+ "		                                    </td>\r\n"
					+ "	                                        <td>"+ d.quantity +"</td>\r\n"
					+ "	                                        <td>$"+ d.price +"</td>\r\n"
					+ "	                                        <td>Checkout</td>\r\n"
					+ "	                                        <td>"+ d.created +"</td>\r\n"
					+ "	                                        <td>\r\n"
					+ "	                                            <a href=\"#\" onclick = \"viewOrders(this, '"+ d.ordinal +"')\"><i class=\"las la-eye text-secondary font-16\"></i></a>\r\n"
					+ "	                                            <a href=\"#\" onclick = \"deleteOrders(this, '"+ d.ordinal +"')\"><i class=\"las la-trash-alt text-secondary font-16\"></i></a>\r\n"
					+ "	                                        </td>\r\n"
					+ "	                                    </tr>";
		}
		document.querySelector("#datatable .orders").innerHTML = dataHTML;
		if(checkUpdateCountPageOrders == 1) {
			totalPage = dataJSON.countPage;
			addPage(document.querySelector(".container-fluid.open .content_bot"), true, totalPage);
		}
	});
}

function deleteOrders(element, id) {
	element.parentElement.parentElement.remove();
	console.log(id);
	fetch("/myspring/apimanage/orders/delete?id=" + id, { 
		method: 'GET',
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		if(data == '1') {
			alert("Xóa đơn hàng thành công!!");
			location.replace("/myspring/manage");
		} else {
			alert("Xóa đơn hàng thất bại!!");
			location.replace("/myspring/manage");
		}
	});
}

function closeOrders(element) {
    document.querySelector(".orders_content.open").classList.remove("open");
}

function viewOrders(element, id) {
	fetch("/myspring/apimanage/orders/view?id=" + id, { 
		method: 'GET',
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		let dataHTML = "";
		for(var d of data) {
			var name = d.code.split('|||')[1];
			var code = d.code.split('|||')[0];
			var image = d.code.split('|||')[2];
			dataHTML += "<tr>\r\n"
					+ "	                            <td>\r\n"
					+ "	                                <span>\r\n"
					+ "	                                    <img src=\""+ image +"\" alt=\"\">\r\n"
					+ "	                                    <span>\r\n"
					+ "	                                        <span>"+ name +"</span>\r\n"
					+ "	                                        "+ code +"\r\n"
					+ "	                                    </span>\r\n"
					+ "	                                </span>\r\n"
					+ "	                            </td>\r\n"
					+ "	                            <td>"+ d.quantity +"</td>\r\n"
					+ "	                            <td>$"+ d.total +"</td>\r\n"
					+ "	                        </tr>";
		}
		document.querySelector(".order_product tbody").innerHTML = dataHTML;
		document.querySelector(".orders_content.orders").classList.add("open");
	});
}


/////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////CONTACT///////////////////////////////////////////////////////
let checkUpdateCountPageAccount = 0;

function getUrlTableAccount(page) {
	var start = (page-1)*10;
	var end = page*10 -1;
	return "/myspring/apimanage/account?start="+start+"&end="+end;
}

function updateTableAccount(urlData) {
	fetch(urlData, {
	    method: 'GET',
	}).then(resp => {
	    if(resp.status === 200) {
			checkUpdateCountPageAccount++;
	        return resp.json();
	    }
	}).then(dataJSON => {
		let dataHTML = "";
		for(var d of dataJSON.data) {
			dataHTML += "										<tr>\r\n"
						+ "	                                    	<td>"+ d.ordinal +"</td>\r\n"
						+ "	                                        <td>\r\n"
						+ "	                                            <p class=\"d-inline-block align-middle mb-0\">\r\n"
						+ "	                                                <a href=\"#\" class=\"d-inline-block align-middle mb-0 product-name\">"+ d.name +"</a> \r\n"
						+ "	                                                <br>\r\n"
						+ "	                                                <span class=\"text-muted font-13\">"+ d.email +"</span> \r\n"
						+ "	                                            </p>\r\n"
						+ "	                                        </td>\r\n"
						+ "	                                        <td>"+ d.username +"</td>\r\n"
						+ "	                                        <td>"+ d.password +"</td>\r\n"
						+ "	                                        <td>"+ d.created +"</td>\r\n"
						+ "	                                        <td>"+ d.phone +"</td>\r\n"
						+ "	                                        <td>"+ d.address +"</td>\r\n"
						+ "	                                        <td><span class=\"badge badge-soft-warning\">"+ d.role +"</span></td>\r\n"
						+ "	                                        <td>\r\n"
						+ "	                                            <a href=\"#\" onclick = \"deleteAccount(this, '"+ d.username +"')\"><i class=\"las la-trash-alt text-secondary font-16\"></i></a>\r\n"
						+ "	                                        </td>\r\n"
						+ "	                                    </tr>";
		}
		document.querySelector("#datatable .contact").innerHTML = dataHTML;
		if(checkUpdateCountPageAccount == 1) {
			totalPage = dataJSON.countPage;
			addPage(document.querySelector(".container-fluid.open .content_bot"), true, totalPage);
		}
	});
}


function deleteAccount(element, username) {
	element.parentElement.parentElement.remove();
	fetch("/myspring/apimanage/contact/delete?username=" + username, { 
		method: 'GET',
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		if(data == '1') {
			alert("Xóa tài khoản thành công!!");
			location.replace("/myspring/manage");
		} else {
			alert("Xóa tài khoản thất bại!!");
			location.replace("/myspring/manage");
		}
	});
}





////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////NOTIFICATION///////////////////////////////////////////////////

function test() {
	fetch("/myspring/apimanage/notification", { 
		method: 'GET',
	})
	.then(response => response.json())
	.then(data => {
	  	console.log(data);
		var dataHTML = "";
		for(var d of data) {
			dataHTML += "								<a href=\"#\" class=\"dropdown-item py-3\">\r\n"
						+ "                                    <small class=\"float-end text-muted ps-2\">ago</small>\r\n"
						+ "                                    <div class=\"media\">\r\n"
						+ "                                        <div class=\"avatar-md bg-soft-primary\">\r\n"
						+ "                                            <i data-feather=\"shopping-cart\" class=\"align-self-center icon-xs\"></i>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"media-body align-self-center ms-2 text-truncate\">\r\n"
						+ "                                            <h6 class=\"my-0 fw-normal text-dark\"><i>"+ d.name +"</i> order is placed</h6>\r\n"
						+ "                                            <small class=\"text-muted mb-0\">Lorem ipsum, dolor sit amet consectetur.</small>\r\n"
						+ "                                        </div><!--end media-body-->\r\n"
						+ "                                    </div><!--end media-->\r\n"
						+ "                                </a>";
		}
		document.querySelector(".notification-menu").innerHTML = dataHTML;
	});
	for(let d of document.querySelectorAll(".noti-count")) {
		d.innerHTML = 0;
	}
}













