<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/product.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
</head>
<body>
    <header id="header" class="header">
    	<%@ include file="/WEB-INF/views/header.jsp" %>
        <div class = "breadcrumd">
            <h1>Collection</h1>
        </div>
    </header>

    <div id = "main">
        <div class = "main-grid">
            <div class = "main-menu">
              <h2>Product Type</h2>
              <hr>
              <span class = "menu-check">
              	
              </span>
              </span>
                <h2>Price</h2>
                <hr>
                <span class = "menu-input">
                    <p class = "menu-input-max">The highest price is $9,500.00</p>
                    <p>From $</p>
                    <input type="number" name="" id="price-bot">
                    <p>To $</p>
                    <input type="number" name="" id="price-top">
                </span>
                <span>
                    <button onclick="checkPrice()">Apply</button>
                    <button onclick="Reset()">Reset</button>
                </span>
                
            </div>
            <div class = "main-products">
                <div class="products-header">
                    <span class = "products-type">
                        <a href="" class = "left"><i class="fas fa-bars"></i></a>
                        <a href="" class = "right bg"><i class="fas fa-list-ul"></i></a>
                    </span>
                    <span class = "products-sort">
                        <p>Sort by&nbsp</p>
                        <select onchange = "sortProduct(this)" name="" id="sort">
                            <option class = "option-sort" value="default">Default</option>
                            <option class = "option-sort" value="bot">Price, low to hight</option>
                            <option class = "option-sort" value="top">Price, hight to low</option>
                            <option class = "option-sort" value="az">Alphabetically, A-Z</option>
                            <option class = "option-sort" value="za">Alphabetically, Z-A</option>
                        </select>
                    </span>
                </div>
                <div class = "products" id = "list-product">  
                    
                </div>
                <c:if test = "${!loadmore }">
                	<button class = "" onclick="loadMore()" id = "load-more">Load more</button>
                </c:if>
            </div>
        </div>
    </div>

    <%@ include file="/WEB-INF/views/footer.jsp" %>
    <script type="text/javascript">

		<%
		    String type = request.getParameter("type");
		%>
		let type = '<%=type %>';
		
    </script>
    <script src="<c:url value="/resources/js/product.js" />"></script>
</body>
</html>