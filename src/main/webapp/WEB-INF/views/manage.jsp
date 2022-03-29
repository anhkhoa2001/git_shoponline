<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Manage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta content="Premium Multipurpose Admin & Dashboard Template" name="description" />
    <meta content="" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <!-- jvectormap -->
    <link href="<c:url value="/resources/manage/css/jquery-jvectormap-2.0.2.css" />" rel="stylesheet">

    <!-- App css -->
    <link href="<c:url value="/resources/manage/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/manage/css/icons.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/manage/css/metisMenu.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/manage/css/daterangepicker.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/manage/css/app.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/manage/css/style.css" />" rel="stylesheet" type="text/css" />

</head>

<body class="">
    <!-- Left Sidenav -->
    <div class="left-sidenav">
        <!-- LOGO -->
        <div class="brand">
            <a href="#" class="logo">
                <span>
                    <img src="<c:url value="/resources/manage/images/logo-sm.png" />" alt="logo-small" class="logo-sm">
                </span>
                <span>
                    <img src="<c:url value="/resources/manage/images/logo.png" />" alt="logo-large" class="logo-lg logo-light">
                    <img src="<c:url value="/resources/manage/images/logo-dark.png" />" alt="logo-large" class="logo-lg logo-dark">
                </span>
            </a>
        </div>
        <!--end logo-->
        <div class="menu-content h-100" data-simplebar>
             <ul class="metismenu left-sidenav-menu">
                 <li>
                     <a href="#" onclick="changeState(this, 'home')"> 
                         <i data-feather="home" class="align-self-center menu-icon"></i>
                         <span >Dashboard</span>
                     </a>
                 </li>
                 <li>
                     <a href="#" onclick="changeState(this, 'product')"> 
                         <i class="dripicons-list"></i>
                         <span>Products</span>
                     </a>
                 </li>
                 <li>
                     <a href="#" onclick="changeState(this, 'order')"> 
                         <i class="dripicons-basket"></i>
                         <span>Orders</span>
                     </a>
                 </li>
                 <li>
                     <a href="#" onclick="changeState(this, 'contact')"> 
                         <i class="dripicons-document-edit"></i>
                         <span>Contact</span>
                     </a>
                 </li>
             </ul>
         </div>
    </div>
    <!-- end left-sidenav-->
    

    <div class="page-wrapper">
        <!-- Top Bar Start -->
        <div class="topbar">            
            <!-- Navbar -->
            <nav class="navbar-custom">    
                <ul class="list-unstyled topbar-nav float-end mb-0">                   
                    <!-- notification -->
                    <li class="dropdown notification-list">
                        <a onclick="test()" class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="false" aria-expanded="false">
                            <i data-feather="bell" class="align-self-center topbar-icon"></i>
                            <span class="badge bg-danger rounded-pill noti-icon-badge noti-count">${countNoti }</span>
                        </a>

                        <div class="dropdown-menu dropdown-menu-end dropdown-lg pt-0">
                            <h6 class="dropdown-item-text font-15 m-0 py-3 border-bottom d-flex justify-content-between align-items-center">
                                Notifications <span class="badge bg-primary rounded-pill noti-count">${countNoti }</span>
                            </h6> 
                            <div style="height: auto" class="notification-menu" data-simplebar>
                                <!-- item-->
                                <a href="#" class="dropdown-item py-3">
                                    <small class="float-end text-muted ps-2">ago</small>
                                    <div class="media">
                                        <div class="avatar-md bg-soft-primary">
                                            <i data-feather="shopping-cart" class="align-self-center icon-xs"></i>
                                        </div>
                                        <div class="media-body align-self-center ms-2 text-truncate">
                                            <h6 class="my-0 fw-normal text-dark"><i>Khoa</i> order is placed</h6>
                                            <small class="text-muted mb-0">Lorem ipsum, dolor sit amet consectetur.</small>
                                        </div><!--end media-body-->
                                    </div><!--end media-->
                                </a><!--end-item-->
                            </div>
                            <!-- All-->
                        </div>
                    </li>
                    <!-- avatar -->
                    <li class="dropdown">
                        <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="false" aria-expanded="false">
                            <span class="ms-1 nav-user-name hidden-sm">Nick</span>
                            <img src="<c:url value="/resources/manage/images/users/user-5.jpg" />" alt="profile-user" class="rounded-circle thumb-xs" />                                 
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item" href="#"><i data-feather="user" class="align-self-center icon-xs icon-dual me-1"></i> Profile</a>
                            <a class="dropdown-item" href="#"><i data-feather="settings" class="align-self-center icon-xs icon-dual me-1"></i> Settings</a>
                            <div class="dropdown-divider mb-0"></div>
                            <a class="dropdown-item" href="/myspring/logout"><i data-feather="power" class="align-self-center icon-xs icon-dual me-1"></i> Logout</a>
                        </div>
                    </li>
                </ul><!--end topbar-nav-->
    
                <ul class="list-unstyled topbar-nav mb-0">                        
                    <li>
                        <button class="nav-link button-menu-mobile">
                            <i data-feather="menu" class="align-self-center topbar-icon"></i>
                        </button>
                    </li>                        
                </ul>
            </nav>
            <!-- end navbar-->
        </div>
        <!-- Top Bar End -->

        <!-- Page Content-->
        <div class="page-content">

            <!-- home -->
            <div class="container-fluid home open">
                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-title-box">
                            <div class="row">
                                <div class="col">
                                    <h4 class="page-title">Analytics</h4>
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="">Dastone</a></li>
                                        <li class="breadcrumb-item">/  Dashboard</li>
                                    </ol>
                                </div><!--end col-->
                                <div class="col-auto align-self-center">
                                    <a href="#" class="btn btn-sm btn-outline-primary" id="Dash_Date">
                                        <span class="ay-name" id="Day_Name">Today:</span>&nbsp;
                                        <span class="" id="Select_date">Jan 11</span>
                                        <i data-feather="calendar" class="align-self-center icon-xs ms-1"></i>
                                    </a>
                                </div><!--end col-->  
                            </div><!--end row-->                                                              
                        </div><!--end page-title-box-->
                    </div><!--end col-->
                </div><!--end row-->
                <!-- end page title end breadcrumb -->
                <div class="row">
                    <div class="col-lg-9">
                        <div class="row justify-content-center">
                            <div class="col-md-6 col-lg-3">
                                <div class="card report-card">
                                    <div class="card-body">
                                        <div class="row d-flex justify-content-center">
                                            <div class="col">
                                                <p class="text-dark mb-0 fw-semibold">Orders</p>
                                                <h3 class="m-0">${count }</h3>
                                                <p class="mb-0 text-truncate text-muted">
                                                	<span class="text-success">
                                                		<i class="mdi mdi-trending-up"></i>8.5%
                                                	</span> New Orders Today
                                               	</p>
                                            </div>
                                            <div class="col-auto align-self-center">
                                                <div class="report-main-icon bg-light-alt">
                                                    <i data-feather="users" class="align-self-center text-muted icon-sm"></i>  
                                                </div>
                                            </div>
                                        </div>
                                    </div><!--end card-body--> 
                                </div><!--end card--> 
                            </div> <!--end col--> 
                            <div class="col-md-6 col-lg-3">
                                <div class="card report-card">
                                    <div class="card-body">
                                        <div class="row d-flex justify-content-center">                                                
                                            <div class="col">
                                                <p class="text-dark mb-0 fw-semibold">Products</p>
                                                <h3 class="m-0">${totalQuantity }</h3>
                                                <p class="mb-0 text-truncate text-muted"><span class="text-success"><i class="mdi mdi-trending-up"></i>1.5%</span> Total Products Today</p>
                                            </div>
                                            <div class="col-auto align-self-center">
                                                <div class="report-main-icon bg-light-alt">
                                                    <i data-feather="clock" class="align-self-center text-muted icon-sm"></i>  
                                                </div>
                                            </div> 
                                        </div>
                                    </div><!--end card-body--> 
                                </div><!--end card--> 
                            </div> <!--end col--> 
                            <div class="col-md-6 col-lg-3">
                                <div class="card report-card">
                                    <div class="card-body">
                                        <div class="row d-flex justify-content-center">                                                
                                            <div class="col">
                                                <p class="text-dark mb-0 fw-semibold">Price</p>
                                                <h3 class="m-0">$ ${totalPrice }</h3>
                                                <p class="mb-0 text-truncate text-muted"><span class="text-danger"><i class="mdi mdi-trending-down"></i>35%</span> Total Price Today</p>
                                            </div>
                                            <div class="col-auto align-self-center">
                                                <div class="report-main-icon bg-light-alt">
                                                    <i data-feather="activity" class="align-self-center text-muted icon-sm"></i>  
                                                </div>
                                            </div> 
                                        </div>
                                    </div><!--end card-body--> 
                                </div><!--end card--> 
                            </div> <!--end col--> 
                            <div class="col-md-6 col-lg-3">
                                <div class="card report-card">
                                    <div class="card-body">
                                        <div class="row d-flex justify-content-center">
                                            <div class="col">  
                                                <p class="text-dark mb-0 fw-semibold">Customer</p>                                         
                                                <h3 class="m-0">5</h3>
                                                <p class="mb-0 text-truncate text-muted"><span class="text-success"><i class="mdi mdi-trending-up"></i>10.5%</span> Completions Weekly</p>
                                            </div>
                                            <div class="col-auto align-self-center">
                                                <div class="report-main-icon bg-light-alt">
                                                    <i data-feather="briefcase" class="align-self-center text-muted icon-sm"></i>  
                                                </div>
                                            </div> 
                                        </div>
                                    </div><!--end card-body--> 
                                </div><!--end card--> 
                            </div> <!--end col-->                               
                        </div><!--end row-->
                        <div class="card">
                            <div class="card-header">
                                <div class="row align-items-center">
                                    <div class="col">                      
                                        <h4 class="card-title">Overview</h4>                      
                                    </div><!--end col-->
                                    <div class="col-auto"> 
                                        <div class="dropdown">
                                            <a href="#" class="btn btn-sm btn-outline-light dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                               This Year<i class="las la-angle-down ms-1"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a class="dropdown-item" href="#">Today</a>
                                                <a class="dropdown-item" href="#">Last Week</a>
                                                <a class="dropdown-item" href="#">Last Month</a>
                                                <a class="dropdown-item" href="#">This Year</a>
                                            </div>
                                        </div>               
                                    </div><!--end col-->
                                </div>  <!--end row-->                                  
                            </div><!--end card-header-->
                            <div class="card-body">
                                <canvas id="myChart1"></canvas>
                            </div><!--end card-body--> 
                        </div><!--end card--> 
                    </div><!--end col-->
                    <div class="col-lg-3">
                        <div class="card">
                            <div class="card-header">
                                <div class="row align-items-center">
                                    <div class="col">                      
                                        <h4 class="card-title">Device</h4>                      
                                    </div><!--end col-->
                                    
                                    <div class="col-auto"> 
                                        <div class="dropdown">
                                            <a href="#" class="btn btn-sm btn-outline-light dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                               All<i class="las la-angle-down ms-1"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a class="dropdown-item" href="#">Smart Phone</a>
                                                <a class="dropdown-item" href="#">Laptop</a>
                                                <a class="dropdown-item" href="#">Tablet</a>
                                            </div>
                                        </div>         
                                    </div><!--end col-->
                                </div>  <!--end row-->                                  
                            </div><!--end card-header-->
                            <div class="card-body">
                                <div class="text-center">
                                    <canvas id="myChart2"></canvas>
                                    <h6 class="bg-light-alt py-3 px-2 mb-0">
                                        <i data-feather="calendar" class="align-self-center icon-xs me-1"></i>
                                        01 January 2020 to 31 December 2020
                                    </h6>
                                </div>  
                                <div class="table-responsive mt-2">
                                    <table class="table border-dashed mb-0 one">
                                        <thead>
	                                        <tr>
	                                            <th>Device</th>
	                                            <th class="text-end">Total</th><!-- tổng số tiền sản phẩm đã bán được -->
	                                            <th class="text-end">Quantity</th><!-- tổng số sản phẩm -->
	                                            <th class="text-end">Avg</th><!-- trung bình -->
	                                        </tr>
                                        </thead>
                                        <tbody>
	                                        
                                        </tbody>
                                    </table><!--end /table-->
                                </div><!--end /div-->                                 
                            </div><!--end card-body--> 
                        </div><!--end card--> 
                    </div> <!--end col--> 
                </div><!--end row-->

                
                <div class="row">                        
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <div class="row align-items-center">
                                    <div class="col">                      
                                        <h4 class="card-title">Top customers</h4>                      
                                    </div><!--end col-->                                        
                                </div>  <!--end row-->                                  
                            </div><!--end card-header-->
                            <div class="card-body">
                                <div class="table-responsive browser_users">
                                    <table class="table mb-0 two">
                                        <thead class="table-light">
                                            <tr>
                                                <th class="border-top-0">Name</th>
                                                <th class="border-top-0">Email</th>
                                                <th class="border-top-0">Quantity</th>
                                                <th class="border-top-0">Amount purchased</th>
                                                <th class="border-top-0">Created</th>
                                            </tr><!--end tr-->
                                        </thead>
                                        <tbody>
                                                 
                                        </tbody>
                                    </table> <!--end table-->                                               
                                </div><!--end /div-->
                            </div><!--end card-body--> 
                        </div><!--end card--> 
                    </div> <!--end col-->   
                    
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <div class="row align-items-center">
                                    <div class="col">                      
                                        <h4 class="card-title">Top products</h4>                      
                                    </div><!--end col-->                                        
                                </div>  <!--end row-->                                  
                            </div><!--end card-header-->
                            <div class="card-body">
                                <div class="table-responsive browser_users">
                                    <table class="table mb-0 three">
                                        <thead class="table-light">
                                            <tr>
                                                <th class="border-top-0">Name</th>
                                                <th class="border-top-0">Code</th>
                                                <th class="border-top-0">Price</th>
                                                <th class="border-top-0">Quantity sold</th>
                                            </tr><!--end tr-->
                                        </thead>
                                        <tbody>
                                                    
                                        </tbody>
                                    </table> <!--end table-->                                               
                                </div><!--end /div--> 
                            </div><!--end card-body--> 
                        </div><!--end card--> 
                    </div> <!--end col-->
                </div><!--end row-->
                

            </div><!-- container -->


            <!-- list - product -->
            <div class="container-fluid product">
                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-title-box">
                            <div class="row">
                                <div class="col">
                                    <h4 class="page-title">Products</h4>
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Dastone</a></li>
                                        <li class="breadcrumb-item"><a href="#">/</a></li>
                                        <li class="breadcrumb-item active">List</li>
                                    </ol>
                                </div><!--end col-->  
                                <div class="col-auto align-self-center">
                                    <label for="">Search</label><input class="search-products" type="text" style="margin-left: 12px">
                                </div><!--end col-->  
                                <div class="col-auto align-self-center element-product">
                                    <button type="button" onclick="dropdownItem(this, 'product')" class="btn btn-light dropdown-toggle">Add Product <i class="mdi mdi-chevron-down"></i></button>
                                    <div class="dropdown-menu product">
                                        <a class="dropdown-item" href="#" onclick="openItem(this, 'laptop')" >Laptop</a>
                                        <a class="dropdown-item" href="#" onclick="openItem(this, 'phone')">Smart Phone</a>
                                        <a class="dropdown-item" href="#" onclick="openItem(this, 'tablet')">Tablet</a>
                                    </div>
                                </div><!--end col--> 
                            </div><!--end row-->                                                              
                        </div><!--end page-title-box-->
                    </div><!--end col-->
                </div><!--end row-->
                <!-- end page title end breadcrumb -->
                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="datatable" class="table table-bordered">
                                <thead>
	                                <tr>
	                                    <th>Product Name</th>
	                                    <th>Category</th>
	                                    <th>Quantity</th>
	                                    <th>Price</th>
	                                    <th>Status</th>
	                                    <th>Avai.Color</th>
	                                    <th>Action</th>
	                                </tr>
                                </thead>
                                <tbody class = "product">
	                                
                                </tbody>
                            </table>        
                        </div>
                    </div> <!-- end col -->
                </div> <!-- end row -->
				<div class = "content_bot">
                            
                </div>
            </div><!-- container -->
			
			 <!-- order -->
                <div class="container-fluid order">
                    <!-- Page-Title -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="row">
                                    <div class="col">
                                        <h4 class="page-title">Order</h4>
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#">Dastone</a></li>
                                            <li class="breadcrumb-item"><a href="#">/</a></li>
                                            <li class="breadcrumb-item active">Order</li>
                                        </ol>
                                    </div><!--end col-->
                                </div><!--end row-->                                                              
                            </div><!--end page-title-box-->
                        </div><!--end col-->
                    </div><!--end row-->
                    <!-- end page title end breadcrumb -->
                    <div class="row">
                        <div class="col-12">
                            <div class="table-responsive">
                                <table id="datatable" class="table table-bordered">
                                    <thead>
	                                    <tr>
	                                    	<th>Ordinal</th>
	                                        <th>Info</th>
	                                        <th>Quantity</th>
	                                        <th>Amount</th>
	                                        <th>Status</th>
	                                        <th>Created</th>
	                                        <th>Action</th>
	                                    </tr>
                                    </thead>
                                    <tbody class = "orders">
                                    
                                    </tbody>
                                </table>        
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row -->
					<div class = "content_bot">
                            
                        </div>
                </div><!-- container -->

                <!-- contact -->
                <div class="container-fluid contact">
                    <!-- Page-Title -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="row">
                                    <div class="col">
                                        <h4 class="page-title">Contact</h4>
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#">Dastone</a></li>
                                            <li class="breadcrumb-item"><a href="#">/</a></li>
                                            <li class="breadcrumb-item active">Contact</li>
                                        </ol>
                                    </div><!--end col-->
                                </div><!--end row-->                                                              
                            </div><!--end page-title-box-->
                        </div><!--end col-->
                    </div><!--end row-->
                    <!-- end page title end breadcrumb -->
                    <div class="row">
                        <div class="col-12">
                            <div class="table-responsive">
                                <table id="datatable" class="table table-bordered">
                                    <thead>
	                                    <tr>
	                                    	<th>Ordinal</th>
	                                        <th>Info</th>
	                                        <th>Username</th>
	                                        <th>Password</th>
	                                        <th>Created</th>
	                                        <th>Phone</th>
	                                        <th>Address</th>
	                                        <th>Role</th>
	                                        <th>Action</th>
	                                    </tr>
                                    </thead>
                                    <tbody class = "contact">
                                    
                                    </tbody>
                                </table>        
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row -->
					<div class = "content_bot">
                            
                        </div>
                </div><!-- container -->
                
                
               	<div class="input_content add phone tablet">
		            <div class = "input_content_grid">
		                <i class="dripicons-cross" onclick="closeItem(this, 'phone')"></i>
		                <h2 class="title">Add Smart Phone</h2>
		                <div class = "name">
		                    <label for="@">Name: </label>
		                    <input type="text" name = "name">
		                </div>
		                <div class = "code">
		                    <label for="@">Code: </label>
		                    <input type="text" name="code">
		                </div>
		                <div class = "price">
		                    <label for="@">Price: </label>
		                    <input type="number" name = "price">
		                </div>
		                <div class = "quantity">
		                    <label for="@">Quantity: </label>
		                    <input type="number" name = "quantity">
		                </div>
		                <div class = "screen">
		                    <label for="@">Screen: </label>
		                    <input type="text" name = "screen">
		                </div>
		                <div class="front">
		                    <label for="@">Front Camera: </label>
		                    <input type="text" name="front">
		                </div>
		                <div class="back">
		                    <label for="@">Back Camera: </label>
		                    <input type="text" name="back">
		                </div>
		                <div class="ram">
		                    <label for="@">RAM: </label>
		                    <input type="text" name="ram">
		                </div>
		                <div class="chip">
		                    <label for="@">Chip: </label>
		                    <input type="text" name="chip">
		                </div>
		                <div class="memory">
		                    <label for="@">Memory: </label>
		                    <input type="text" name="memory">
		                </div>
		                <div class="image">
		                    <label for="@">Image: </label>
		                    <input type="file" name="image" style="border: none;" >
		                </div>
		                <div class = "submit">
		                    <button type="submit" onclick="submitFormAddProduct(this, 'phone')" >Nhập</button>
		                </div>
		            </div>
		        </div>
		
		
		        <div class="input_content add laptop">
		            <div class = "input_content_grid">
		                <i class="dripicons-cross" onclick="closeItem(this, 'laptop')"></i>
		                <h2 class="title">Add Laptop</h2>
		                <div class = "name">
		                    <label for="@">Name: </label>
		                    <input type="text" name = "name">
		                </div>
		                <div class = "code">
		                    <label for="@">Code: </label>
		                    <input type="text" name="code">
		                </div>
		                <div class = "price">
		                    <label for="@">Price: </label>
		                    <input type="number" name = "price">
		                </div>
		                <div class = "quantity">
		                    <label for="@">Quantity: </label>
		                    <input type="number" name = "quantity">
		                </div>
		                <div class = "display">
		                    <label for="@">Display: </label>
		                    <input type="text" name = "display">
		                </div>
		                <div class="cardlap">
		                    <label for="@">Card: </label>
		                    <input type="text" name="cardlap">
		                </div>
		                <div class="cpu">
		                    <label for="@">CPU: </label>
		                    <input type="text" name="cpu">
		                </div>
		                <div class="ram">
		                    <label for="@">RAM: </label>
		                    <input type="text" name="ram">
		                </div>
		                <div class="weight">
		                    <label for="@">Weight: </label>
		                    <input type="text" name="weight">
		                </div>
		                <div class="size">
		                    <label for="@">Size: </label>
		                    <input type="text" name="size">
		                </div>
		                <div class="memory">
		                    <label for="@">Memory: </label>
		                    <input type="text" name="memory">
		                </div>
		                <div class="image">
		                    <label for="@">Image: </label>
		                    <input type="file" name="image" style="border: none;" >
		                </div>
		                <div class = "submit">
		                    <button type="submit" onclick="submitFormAddProduct(this, 'laptop')" >Nhập</button>
		                </div>
		            </div>
		        </div>
		        
		        <div class="input_content edit phone tablet">
		            <div class = "input_content_grid">
		                <i class="dripicons-cross" onclick="closeItem(this, 'phone')"></i>
		                <h2 class="title">Edit Smart Phone</h2>
		                <div class = "name">
		                    <label for="@">Name: </label>
		                    <input type="text" name = "name">
		                    <input type="text" name = "id" style="display: none">
		                </div>
		                <div class = "code">
		                    <label for="@">Code: </label>
		                    <input type="text" name="code" class="code">
		                </div>
		                <div class = "price">
		                    <label for="@">Price: </label>
		                    <input type="number" name = "price" class = "price">
		                </div>
		                <div class = "quantity">
		                    <label for="@">Quantity: </label>
		                    <input type="number" name = "quantity" class = "quantity">
		                </div>
		                <div class = "screen">
		                    <label for="@">Screen: </label>
		                    <input type="text" name = "screen" class = "screen">
		                </div>
		                <div class="front">
		                    <label for="@">Front Camera: </label>
		                    <input type="text" name="front" class="front">
		                </div>
		                <div class="back">
		                    <label for="@">Back Camera: </label>
		                    <input type="text" name="back" class="back">
		                </div>
		                <div class="ram">
		                    <label for="@">RAM: </label>
		                    <input type="text" name="ram" class="ram">
		                </div>
		                <div class="chip">
		                    <label for="@">Chip: </label>
		                    <input type="text" name="chip" class="chip">
		                </div>
		                <div class="memory">
		                    <label for="@">Memory: </label>
		                    <input type="text" name="memory">
		                </div>
		                <div class="image">
		                    <img src = "" style="height: 60px; margin-right: 44px">
		                    <input type="file" name="image">
		                </div>
		                <div class = "submit">
		                    <button type="submit" onclick="submitFormEditProduct(this, 'phone')">Nhập</button>
		                </div>
		            </div>
		        </div>
		
		        <div class="input_content edit laptop">
		            <div class = "input_content_grid">
		                <i class="dripicons-cross" onclick="closeItem(this, 'laptop')"></i>
		                <h2 class="title">Edit Laptop</h2>
		                <div class = "name">
		                    <label for="@">Name: </label>
		                    <input type="text" name = "name" >
		                    <input type="text" name = "id" style="display: none">
		                </div>
		                <div class = "code">
		                    <label for="@">Code: </label>
		                    <input type="text" name="code" class="code">
		                </div>
		                <div class = "price">
		                    <label for="@">Price: </label>
		                    <input type="number" name = "price" class = "price">
		                </div>
		                <div class = "quantity">
		                    <label for="@">Quantity: </label>
		                    <input type="number" name = "quantity" class = "quantity">
		                </div>
		                <div class = "display">
		                    <label for="@">Display: </label>
		                    <input type="text" name = "display" class = "display">
		                </div>
		                <div class="cardlap">
		                    <label for="@">Card: </label>
		                    <input type="text" name="cardlap" class="cardlap">
		                </div>
		                <div class="cpu">
		                    <label for="@">CPU: </label>
		                    <input type="text" name="cpu" class="cpu">
		                </div>
		                <div class="ram">
		                    <label for="@">RAM: </label>
		                    <input type="text" name="ram" class="ram">
		                </div>
		                <div class="weight">
		                    <label for="@">Weight: </label>
		                    <input type="text" name="weight" class="weight">
		                </div>
		                <div class="size">
		                    <label for="@">Size: </label>
		                    <input type="text" name="size" class="size">
		                </div>
		                <div class="memory">
		                    <label for="@">Memory: </label>
		                    <input type="text" name="memory" class="memory">
		                </div>
		                <div class="image">
		                    <img src = "" style="height: 60px; margin-right: 44px">
		                    <input type="file" name="image">
		                </div>
		                <div class = "submit">
		                    <button type="submit" onclick="submitFormEditProduct(this, 'laptop')">Nhập</button>
		                </div>
		            </div>
		        </div>
			
            

            <footer class="footer text-center text-sm-start">
                &copy; <script>
                    document.write(new Date().getFullYear())
                </script> Dastone <span class="text-muted d-none d-sm-inline-block float-end">Crafted with <i
                        class="mdi mdi-heart text-danger"></i> by Mannatthemes</span>
            </footer><!--end footer-->
        </div>
        <!-- end page content -->
    </div>
    <!-- end page-wrapper -->

    


    <!-- jQuery  -->
    <script src="<c:url value="/resources/manage/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/metismenu.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/waves.js" />"></script>
    <script src="<c:url value="/resources/manage/js/feather.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/simplebar.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/moment.js" />"></script>
    <script src="<c:url value="/resources/manage/js/daterangepicker.js" />"></script>

    <script src="<c:url value="/resources/manage/js/jquery-jvectormap-2.0.2.min.js" />"></script>
    <script src="<c:url value="/resources/manage/js/jquery-jvectormap-us-aea-en.js" />"></script>

    <!-- App js -->
    <script src="<c:url value="/resources/manage/js/app.js" />"></script>
    <script src="<c:url value="https://cdn.jsdelivr.net/npm/chart.js" />"></script>
    <script src="<c:url value="/resources/js/manage.js" />"></script>
</body>

</html>