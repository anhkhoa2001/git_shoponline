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
    <link rel="stylesheet" href="<c:url value="/resources/css/productdetail.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
    <title>${product.name }</title>
</head>

<body>
  <header id="header" class="header">
    <%@ include file="/WEB-INF/views/header.jsp" %>

    <div class="page__title-area"> 
      <div class="container">
        <div class="page__title-container">
          <ul class="page__titles">
            <li>
              <a href="/myspring">
                <svg>
                  <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-home" />"></use>
                </svg>
              </a>
            </li>
            <li class="page__title">iPhone 11</li>
          </ul>
        </div>
      </div>
    </div>
  </header>

  <main id="main">
    <div class="container">
      <!-- Products Details -->
      <section class="section product-details__section">
        <div class="product-detail__container">
          <div class="product-detail__left">
            <div class="details__container--left">
              <div class="product__pictures">
                <div class="pictures__container">
                  <img class="picture" src="<c:url value="/resources/images/products/iPhone/iphone1.jpeg" />" id="pic1" />
                </div>
                <div class="pictures__container">
                  <img class="picture" src="<c:url value="/resources/images/products/iPhone/iphone2.jpeg" />" id="pic2" />
                </div>
                <div class="pictures__container">
                  <img class="picture" src="<c:url value="/resources/images/products/iPhone/iphone3.jpeg" />" id="pic3" />
                </div>
                <div class="pictures__container">
                  <img class="picture" src="<c:url value="/resources/images/products/iPhone/iphone4.jpeg" />" id="pic4" />
                </div>
                <div class="pictures__container">
                  <img class="picture" src="<c:url value="/resources/images/products/iPhone/iphone5.jpeg" />" id="pic5" />
                </div>
              </div>
              <div class="product__picture" id="product__picture">
                <!-- <div class="rect" id="rect"></div> -->
                <div class="picture__container">
                  <img src="${product.image }" id="pic" />
                </div>
              </div>
              <div class="zoom" id="zoom"></div>
            </div>

            <div class="product-details__btn" >
               	<a class="add" href="#" onclick = "addToCart()">
	                <span>
	                  <svg>
	                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-cart-plus" />"></use>
	                  </svg>
	                </span>
	                ADD TO CART
               	</a>
             
               	<a class="buy" href="/myspring/home/checkout?code=${product.code }" >
                <span>
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-credit-card" />"></use>
                  </svg>
                </span>
                BUY NOW
              </a>
            </div>
          </div>

          <div class="product-detail__right">
            <div class="product-detail__content">
              <h3>${product.name }</h3>
              <div class="price">
                <span class="new__price">$${product.priceDola }</span>
              </div>
              <div class="product__review">
                <div class="rating">
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-star-full" />"></use>
                  </svg>
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-star-full" />"></use>
                  </svg>
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-star-full" />"></use>
                  </svg>
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-star-full" />"></use>
                  </svg>
                  <svg>
                    <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-star-empty" />"></use>
                  </svg>
                </div>
                <a href="#" class="rating__quatity">3 reviews</a>
              </div>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt
                a doloribus iste natus et facere?
                dolor sit amet consectetur adipisicing elit. Sunt
                a doloribus iste natus et facere?
              </p>
              <div class="product__info-container">
                <ul class="product__info">
                  <li class="select">
                    <div class="select__option">
                      <label for="colors">Color</label>
                      <select name="colors" id="colors" class="select-box">
                        <option value="blue">blue</option>
                        <option value="red">red</option>
                      </select>
                    </div>
                    <div class="select__option">
                      <label for="size">Inches</label>
                      <select name="size" id="size" class="select-box">
                        <option value="6.65">6.65</option>
                        <option value="7.50">7.50</option>
                      </select>
                    </div>
                  </li>
                  <li>

                    <div class="input-counter">
                      <span>Quantity:</span>
                      <div>
                        <span class="minus-btn" id = "minus-btn">
                          <svg>
                            <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-minus" />"></use>
                          </svg>
                        </span>
                        <input type="text" min="1" value="1" max="10" class="counter-btn" id = "counter-btn">
                        <span class="plus-btn" id = "plus-btn">
                          <svg>
                            <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-plus" />"></use>
                          </svg>
                        </span>
                      </div>
                    </div>
                  </li>

                  <li>
                    <span>Subtotal:</span>
                    <a href="#" class="new__price">$250.99</a>
                  </li>
                  <li>
                    <span>Brand:</span>
                    <a href="#">Apple</a>
                  </li>
                  <li>
                    <span>Product Type:</span>
                    <a href="#">Phone</a>
                  </li>
                  <li>
                    <span>Availability:</span>
                    <a href="#" class="in-stock">In Stock (7 Items)</a>
                  </li>
                </ul>
                <div class="product-info__btn">
                  <a href="#">
                    <span>
                      <svg>
                        <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-crop" />"></use>
                      </svg>
                    </span>&nbsp;
                    SIZE GUIDE
                  </a>
                  <a href="#">
                    <span>
                      <svg>
                        <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-truck" />"></use>
                      </svg>
                    </span>&nbsp;
                    SHIPPING
                  </a>
                  <a href="#">
                    <span>
                      <svg>
                        <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-envelope-o" />"></use>
                      </svg>&nbsp;
                    </span>
                    ASK ABOUT THIS PRODUCT
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="product-detail__bottom">
          <div class="title__container tabs">

            <div class="section__titles category__titles ">
              <div class="section__title detail-btn active" data-id="paramater">
                <span class="dot"></span>
                <h1 class="primary__title">Paramater</h1>
              </div>
            </div>

            <div class="section__titles">
              <div class="section__title detail-btn" data-id="description">
                <span class="dot"></span>
                <h1 class="primary__title">Description</h1>
              </div>
            </div>

            <div class="section__titles">
              <div class="section__title detail-btn" data-id="comments">
                <span class="dot"></span>
                <h1 class="primary__title">Comments</h1>
              </div>
            </div>
          </div>

          <div class="detail__content">
            <div class="content active" id="paramater">
                <h1>Paramaters</h1>
                <c:if test = "${product.category.catemenu.id == 1 || product.category.catemenu.id == 2}">
	                <p><strong>Screen: </strong>${product.screen }</p>
	                <p><strong>Back Camera: </strong>${product.backCamera }</p>
	                <p><strong>Front Camera: </strong>${product.frontCamera }</p>
	                <p><strong>Chip: </strong>${product.chip }</p>
	                <p><strong>RAM: </strong>${product.ram }</p>
	                <p><strong>Memory: </strong>${product.memory }</p>
                </c:if>
                <c:if test = "${product.category.catemenu.id == 3}">
	                <p><strong>Display: </strong>${product.display }</p>
	                <p><strong>Memory: </strong>${product.memory }</p>
	                <p><strong>CPU: </strong>${product.cpu }</p>
	                <p><strong>Card: </strong>${product.card }</p>
	                <p><strong>RAM: </strong>${product.ram }</p>
	                <p><strong>Weight: </strong>${product.weight }</p>
	                <p><strong>Size: </strong>${product.size }</p>
                </c:if>
            </div>
            <div class="content" id="description">
              <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam
                dolor, elementum etos lobortis des mollis ut risus. Sedcus faucibus an sullamcorper mattis drostique des
                commodo pharetras loremos.Donec pretium egestas sapien et mollis.
              </p>
              <h2>Sample Unordered List</h2>
              <ul>
                <li>Comodous in tempor ullamcorper miaculis</li>
                <li>Pellentesque vitae neque mollis urna mattis laoreet.</li>
                <li>Divamus sit amet purus justo.</li>
                <li>Proin molestie egestas orci ac suscipit risus posuere loremous</li>
              </ul>
              <h2>Sample Ordered Lista</h2>
              <ol>
                <li>Comodous in tempor ullamcorper miaculis</li>
                <li>Pellentesque vitae neque mollis urna mattis laoreet.</li>
                <li>Divamus sit amet purus justo.</li>
                <li>Proin molestie egestas orci ac suscipit risus posuere loremous</li>
              </ol>
              <h2>Sample Paragraph Text</h2>
              <p>Praesent vestibulum congue tellus at fringilla. Curabitur vitae semper sem, eu convallis est. Cras
                felis
                nunc commodo eu convallis vitae interdum non nisl. Maecenas ac est sit amet augue pharetra convallis nec
                danos dui. Cras suscipit quam et turpis eleifend vitae malesuada magna congue. Damus id ullamcorper
                neque. Sed vitae mi a mi pretium aliquet ac sed elit. Pellentesque nulla eros accumsan quis justo at
                tincidunt lobortis denimes loremous. Suspendisse vestibulum lectus in lectus volutpat, ut dapibus purus
                pulvinar. Vestibulum sit amet auctor ipsum.</p>
            </div>
            <div class="content" id="comments">
              <h1>Comments</h1>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main>

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/footer.jsp" %>
  <!-- Animate On Scroll -->
  <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
  <script>
  		let code = '${product.code}';
  		let username = "${account.username}";
  </script>
  <script src="<c:url value="/resources/js/productdetails.js" />"></script>
</body>
</html>