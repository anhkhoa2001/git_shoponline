<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!-- Google Fonts -->
	<link href="<c:url value="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&display=swap" />"  rel="stylesheet" />
	
	<!-- Carousel -->
	<link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.core.css" />" >
	<link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.theme.min.css" />" >
	<link rel="stylesheet" href="<c:url value="https://unpkg.com/aos@next/dist/aos.css" />"  />
	
	<!-- Custom StyleSheet -->
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
	<title>Home</title>
</head>
<body>
	 <!-- Header -->
  <header id="header" class="header">
    <%@ include file="/WEB-INF/views/header.jsp" %>

    <!-- Hero -->
    <div class="hero">
      <div class="glide" id="glide_1">
        <div class="glide__track" data-glide-el="track">
          <ul class="glide__slides">
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span class="">New Inspiration 2020</span>
                  <h1 class="">PHONES MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="/myspring/product?type=phone"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <div class="hero__img-container">
                    <img class="banner_01" src="<c:url value="/resources/images/banner_01.png" />" alt="banner2" />
                  </div>
                </div>
              </div>
            </li>
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span>New Inspiration 2020</span>
                  <h1>HEADPHONE MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="/myspring"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <img class="banner_02" src="<c:url value="/resources/images/headphone.png" />" alt="banner2" />
                </div>
              </div>
            </li>
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span>New Inspiration 2020</span>
                  <h1>LAPTOP MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="/myspring/product?type=laptop"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <img class="banner_02" src="<c:url value="/resources/images/laptop.png" />" alt="banner2" />
                </div>
              </div>
            </li>
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span>New Inspiration 2020</span>
                  <h1>TABLET MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="/myspring/product?type=tablet"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <img class="banner_02" src="<c:url value="/resources/images/tablet.png" />" alt="banner2" />
                </div>
              </div>
            </li>
          </ul>
        </div>

        <div class="glide__arrows" data-glide-el="controls">
          <button class="glide__arrow glide__arrow--left" data-glide-dir="<">
            <svg>
              <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-arrow-left2" />" ></use>
            </svg>
          </button>
          <button class="glide__arrow glide__arrow--right" data-glide-dir=">">
            <svg>
              <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-arrow-right2" />"></use>
            </svg>
          </button>
        </div>
      </div>
    </div>
  </header>
  <!-- End Header -->

  <!-- Main -->
  <main id="main">
    <div class="container">
      <!-- Collection -->
      <section id="collection" class="section collection">
        <div class="collection__container">
          <div class="collection__box">
            <div class="img__container">
              <img class="collection_02" src="<c:url value="/resources/img/phone/iphone13pro.png" />" alt=""/>
            </div>
            <div class="collection__content">
              <div class="collection__data">
                <span>New Colors Introduced</span>
                <h1>SMARTPHONE</h1>
                <a href="/myspring/product?type=phone">SHOP NOW</a>
              </div>
            </div>
          </div>
          <div class="collection__box">
            <div class="img__container">
              <img class="collection_01" src="<c:url value="/resources/img/tablet/tablet.png" />" alt=""/>
            </div>
            <div class="collection__content">
              <div class="collection__data">
                <span>Phone Device Presets</span>
                <h1>TABLET</h1>
                <a href="/myspring/product?type=tablet">SHOP NOW</a>
              </div>
            </div>
          </div>
          <div class="collection__box">
            <div class="img__container">
              <img class="collection_01" src="<c:url value="/resources/img/laptop/macbook.png" />" alt="">
            </div>
            <div class="collection__content">
              <div class="collection__data">
                <span>Phone Device Presets</span>
                <h1>LAPTOP</h1>
                <a href="/myspring/product?type=laptop">SHOP NOW</a>
              </div>
            </div>
          </div>
          <div class="collection__box">
            <div class="img__container">
              <img class="collection_01" src="<c:url value="/resources/img/headphone/headphone.png" />" alt="">
            </div>
            <div class="collection__content">
              <div class="collection__data">
                <span>Phone Device Presets</span>
                <h1>HEADPHONES</h1>
                <a href="/myspring">SHOP NOW</a>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Phone -->
      <section class="category_phone" id="phone">
        <div class="title_products">
          <div class="section__title active" data-id="Latest Products">
            <span class="dot"></span>
            <h1 class="primary__title">Smart Phone</h1>
          </div>
        </div>
        <div class = "list_products">
          <ul>
          
          </ul>
        </div>
      </section>
      <!-- Laptop -->
      <section class="category_laptop" id="laptop">
        <div class="title_products">
          <div class="section__title active">
            <span class="dot"></span>
            <h1 class="primary__title">Laptop</h1>
          </div>
        </div>
        <div class = "list_products">
          <ul>
            
          </ul>
        </div>
      </section>
    </div>
    <!-- Facility Section -->
    <section class="facility__section section" id="facility">
      <div class="container">
        <div class="facility__container" data-aos="fade-up" data-aos-duration="1200">
          <div class="facility__box">
            <div class="facility-img__container">
              <svg>
                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-airplane" />"></use>
              </svg>
            </div>
            <p>FREE SHIPPING WORLD WIDE</p>
          </div>

          <div class="facility__box">
            <div class="facility-img__container">
              <svg>
                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-credit-card-alt" />"></use>
              </svg>
            </div>
            <p>100% MONEY BACK GUARANTEE</p>
          </div>

          <div class="facility__box">
            <div class="facility-img__container">
              <svg>
                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-credit-card" />"></use>
              </svg>
            </div>
            <p>MANY PAYMENT GATWAYS</p>
          </div>

          <div class="facility__box">
            <div class="facility-img__container">
              <svg>
                <use xlink:href="<c:url value="/resources/images/sprite.svg#icon-headphones" />"></use>
              </svg>
            </div>
            <p>24/7 ONLINE SUPPORT</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Testimonial Section -->
    <section class="section testimonial" id="testimonial">
      <div class="testimonial__container" >
        <div class="glide" id="glide_4">
          <div class="glide__track" data-glide-el="track">
            <ul class="glide__slides">
              <li class="glide__slide">
                <div class="testimonial__box">
                  <div class="client__image">
                    <img src="<c:url value="/resources/images/profile1.jpg" />" alt="profile">
                  </div>
                  <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing
                    elit. Recusandae fuga hic nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.</p>
                  <div class="client__info">
                    <h3>John Smith</h3>
                    <span>Founder at Apple</span>
                  </div>
                </div>
              </li>
              <li class="glide__slide">
                <div class="testimonial__box">
                  <div class="client__image">
                    <img src="<c:url value="/resources/images/profile2.jpg" />" alt="profile">
                  </div>
                  <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                    quibusdam consequatur
                    eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.</p>
                  <div class="client__info">
                    <h3>John Smith</h3>
                    <span>Founder at Apple</span>
                  </div>
                </div>
              </li>
              <li class="glide__slide">
                <div class="testimonial__box">
                  <div class="client__image">
                    <img src="<c:url value="/resources/images/profile3.jpg" />" alt="profile">
                  </div>
                  <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                    quibusdam consequatur
                    eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.</p>
                  <div class="client__info">
                    <h3>John Smith</h3>
                    <span>Founder at Apple</span>
                  </div>
                </div>

              </li>
              <li class="glide__slide">
                <div class="testimonial__box">
                  <div class="client__image">
                    <img src="<c:url value="/resources/images/profile4.jpg" />" alt="">
                  </div>
                  <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                    quibusdam consequatur
                    eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.
                    hic
                    nesciunt tempore
                    quibusdam consequatur eligendi unde officia ex quae.</p>
                  <div class="client__info">
                    <h3>John Smith</h3>
                    <span>Founder at Apple</span>
                  </div>
                </div>
              </li>
            </ul>
          </div>

          <div class="glide__bullets" data-glide-el="controls[nav]">
            <button class="glide__bullet" data-glide-dir="=0"></button>
            <button class="glide__bullet" data-glide-dir="=1"></button>
            <button class="glide__bullet" data-glide-dir="=2"></button>
            <button class="glide__bullet" data-glide-dir="=3"></button>
          </div>
        </div>
      </div>
    </section>

    <!--New Section  -->
    <section class="section news" id="news">
      <div class="container">
        <div class="title_products">
          <div class="section__title active" data-id="Latest Products">
            <span class="dot"></span>
            <h1 class="primary__title">News</h1>
          </div>
        </div>
        <div class="news__container">
          <div class="glide" id="glide_5">
            <div class="glide__track" data-glide-el="track">
              <ul class="glide__slides">
                <li class="glide__slide">
                  <div class="new__card">
                    <div class="card__header">
                      <img src="<c:url value="/resources/images/news1.jpg" />" alt="">
                    </div>
                    <div class="card__footer">
                      <h3>Styling White Shirts After A Cool Day</h3>
                      <span>By Admin</span>
                      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                        provident rem sed minus natus unde vel modi!</p>
                      <a href="#"><button>Read More</button></a>
                    </div>
                  </div>
                </li>
                <li class="glide__slide">
                  <div class="new__card">
                    <div class="card__header">
                      <img src="<c:url value="/resources/images/news2.jpg" />" alt="">
                    </div>
                    <div class="card__footer">
                      <h3>Styling White Shirts After A Cool Day</h3>
                      <span>By Admin</span>
                      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                        provident rem sed minus natus unde vel modi!</p>
                      <a href="#"><button>Read More</button></a>
                    </div>
                  </div>
                </li>
                <li class="glide__slide">
                  <div class="new__card">
                    <div class="card__header">
                      <img src="<c:url value="/resources/images/news3.jpg" />" alt="">
                    </div>
                    <div class="card__footer">
                      <h3>Styling White Shirts After A Cool Day</h3>
                      <span>By Admin</span>
                      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                        provident rem sed minus natus unde vel modi!</p>
                      <a href="#"><button>Read More</button></a>
                    </div>
                  </div>
                </li>
                <li class="glide__slide">
                  <div class="new__card">
                    <div class="card__header">
                      <img src="<c:url value="/resources/images/news4.jpg" />" alt="">
                    </div>
                    <div class="card__footer">
                      <h3>Styling White Shirts After A Cool Day</h3>
                      <span>By Admin</span>
                      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                        provident rem sed minus natus unde vel modi!</p>
                      <a href="#"><button>Read More</button></a>
                    </div>
                  </div>
                </li>
                <li class="glide__slide">
                  <div class="new__card">
                    <div class="card__header">
                      <img src="<c:url value="/resources/images/news5.jpg" />" alt="">
                    </div>
                    <div class="card__footer">
                      <h3>Styling White Shirts After A Cool Day</h3>
                      <span>By Admin</span>
                      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                        provident rem sed minus natus unde vel modi!</p>
                      <a href="#"><button>Read More</button></a>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>

        </div>
      </div>
    </section>

    <!-- NewsLetter -->
    <section class="section newsletter" id="contact">
      <div class="container">
        <div class="newsletter__content">
          <div class="newsletter__data">
            <h3>SUBSCRIBE TO OUR NEWSLETTER</h3>
            <p>A short sentence describing what someone will receive by subscribing</p>
          </div>
          <form action="#">
            <input type="email" placeholder="Enter your email address" class="newsletter__email">
            <a class="newsletter__link" href="#">subscribe</a>
          </form>
        </div>
      </div>
    </section>

  </main>

  <!-- End Main -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/footer.jsp" %>

  <!-- Glide Carousel Script -->
  <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/glide.min.js" />"></script>
  <!-- Animate On Scroll -->
  <script src="<c:url value="https://unpkg.com/aos@2.3.1/dist/aos.js" />"></script>
  <script src="<c:url value="/resources/js/slider.js" />"></script>
  <script src="<c:url value="/resources/js/home.js" />"></script>
</body>
</html>