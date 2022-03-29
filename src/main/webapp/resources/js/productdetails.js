function addToCart() {
	var values = [];
	var keys = Object.keys(localStorage);

	for(var k of keys) {
		values[values.length++] = {
			"key": k,
			"value": localStorage.getItem(k)
		}
	}
	
	fetch("/myspring/product/details/addtocart?code=" + code, {
	    method: 'GET',
	}).then(resp => {
	    if(resp.status === 200) {
	        return resp.json();
	    }
	}).then(data => {
		var o = {
			"key": code,
			"value": username
		}
		localStorage.setItem(o.key, o.value);
		var count = 0;
		for(var v of values) {
			if(JSON.stringify(v) === JSON.stringify(o)) {
				count++;
			}
		}
		console.log(count == 1);
	    if(data == 1) {
			alert("Thêm sản phẩm vào giỏ hàng thành công!!")
		} else {
			alert("Vui lòng đăng nhập!!");
			window.location.replace("/myspring/login");
		}
	});
}

function shopNow() {
	localStorage.clear();
}