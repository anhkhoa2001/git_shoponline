
<div class="navigation">
      <div class="container">
        <nav class="nav">
          <div class="nav__hamburger">
            <svg>
              <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-menu" />"></use>
            </svg>
          </div>

          <div class="nav__logo">
            <a href="/myspring" class="scroll-link">
              PHONE
            </a>
          </div>

          <div class="nav__menu">
            <div class="menu__top">
              <span class="nav__category">PHONE</span>
              <c:if test = "${isLog && account.role == 'ADMIN' }">
	              <a href="#" class="close__toggle">
	                <svg>
	                  <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-cross" />"></use>
	                </svg>
	              </a>
              </c:if>
              
            </div>
            <ul class="nav__list">
              <li class="nav__item">
                	<a href="/myspring" class="nav__link scroll-link">Home</a>
              </li>
              <li class="nav__item">Category
                  <ul class = "nav__link nav__dropdown dropdown__animation">
                      <li><a href="/myspring/product?type=phone">Smart Phone</a></li>
                      <li><a href="/myspring/product?type=tablet">Tablet</a></li>
                      <li><a href="/myspring/product?type=laptop">Laptop</a></li>
                      <li><a href="">Accessory</a></li>
                      <li><a href="">Watch</a></li>
                  </ul>
              </li>
              <li class="nav__item">
                <a href="#news" class="nav__link scroll-link">Blog</a>
              </li>
              <li class="nav__item">
                <a href="#contact" class="nav__link scroll-link">Contact</a>
              </li>
            </ul>
          </div>

          <div class="nav__icons">
			<c:if test = "${isLog && account.role == 'ADMIN' }">
				<a href="/myspring/manage" class="icon__item">
					<i class="fas fa-tasks"></i>
				</a>
			</c:if>
            <c:if test = "${!isLog }"> 
	            <a href="/myspring/login" class="icon__item">
	              <svg class="icon__user">
	                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-user" />"></use>
	              </svg>
	            </a>
            </c:if>

            <a href="/myspring/home/search" class="icon__item">
              <svg class="icon__search">
                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-search" />"></use>
              </svg>
            </a>
			<c:if test = "${isLog && account.role == 'CUSTOMER' }">
				<a href="/myspring/home/cart" class="icon__item">
	              <svg class="icon__cart">
	                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-shopping-basket" />"></use>
	              </svg>
	              <span id="cart__total" class = "cart_total">0</span>
	            </a>
			</c:if>
			<c:if test = "${isLog && account.role == 'ADMIN' }">
				<a href="#" class="icon__item">
	              <i class="fas fa-bell"></i>
	              <span id="cart__total" class = "noti_total">0</span>
	            </a>
			</c:if>
            <c:if test = "${isLog }"> 
	            <a href="/myspring/logout" class="icon__item">
	              <i class="fas fa-sign-in-alt"></i>
	            </a>
            </c:if>
          </div>
        </nav>
      </div>
    </div>
    
<script type="text/javascript">
	function getAllProductInLocalStorage(username) {
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
	let usernameFake = "${account.username}";
	if(usernameFake == 0) {
		
	} else {
		document.querySelector(".cart_total").innerHTML = getAllProductInLocalStorage(usernameFake).length;
	}
</script>