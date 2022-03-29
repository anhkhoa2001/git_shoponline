<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/search.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
</head>
<body>
    <!-- Header -->
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
                    <li class="page__title">Search</li>
                </ul>
            </div>
        </div>
    </div>
</header>

<main id = "main">
    <div class = "main-grid">
        <div class = "search">
            <input type="text" name = "search">
        </div>
        <div class = "products">
            <ul id = "list-product">
	            
        	</ul>
        </div>
    </div>
</main>
<%@ include file="/WEB-INF/views/header.jsp" %>
</body>
<script src="<c:url value="/resources/js/search.js" />"></script>
</html>