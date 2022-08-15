<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<title>Movie Admin</title>
	<!-- Bootstrap Styles-->
	<link href="/assets/admin/css/bootstrap.css" rel="stylesheet" />
	 <!-- FontAwesome Styles-->
	<link href="/assets/admin/css/font-awesome.css" rel="stylesheet" />
	<!-- chart -->
	
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- checkbox & radio -->
	<link href="/assets/admin/css/select2.min.css" rel="stylesheet" >
	<link href="/assets/admin/css/checkbox3.min.css" rel="stylesheet" >
	
	<!-- Custom Styles-->
	<link href="/assets/admin/css/custom-styles.css" rel="stylesheet" />
	<!-- Common Styles -->
	<link href="/assets/common/css/common.css" rel="stylesheet" />
	<!-- Google Fonts-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	
	<script src="/assets/common/js/jquery-1.10.2.js"></script>
	<script src="/assets/common/js/jquery.form.js"></script>
	<!-- Bootstrap Js -->
	<script src="/assets/admin/js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="/assets/admin/js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="/assets/admin/js/custom-scripts.js"></script>
	<!-- common js -->
	<script src="/assets/common/js/common.js"></script>
	<!-- datepicker css -->
	<script src="/assets/common/js/jquery-ui.js"></script> <!-- Air datepicker js -->
	<script src="/assets/common/js/jquery-ui-datepicker.js"></script> <!-- Air datepicker js -->
	<script>
	$(".datepicker").datepicker({
		language: 'ko'
	});
	</script>
	<script>
	
	</script>
	<!-- ck editor -->
	<script src="/ckeditor/ckeditor.js"></script>
	
	    
</head>
<body>
		
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/admin" style="border-right: 1px solid #ccc;">
					<img src="/assets/admin/img/logo.png" class="top-logo" style="display:block;margin:-25px auto;"> 
				</a>
				<div id="sideNav" href="">
					<i class="fa fa-bars icon"></i> 
				</div>
			</div>
		
			<ul class="nav navbar-top-links navbar-right mr-20">
				<li class="">
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
						<i class="fa fa-user fa-fw"></i> 
						<span class="current-user">${currentUser.userId}</span> 
						<i class="fa fa-caret-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="/admin/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		
		
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
			
					
					<li class="li-menu">
						<a href="/admin/user/list"><i class="fa fa-dashboard"></i>User</a>
						</li>

					<li class="li-menu">
						<a href="/admin/board/list"><i class="fa fa-edit"></i>Board</a>
						<ul class="nav nav-second-level">
						 
							<li>
								<a href="/admin/board/list">board</a>
							</li>
						</ul> 
					</li>
					
					
					<li class="li-menu">
						<a href="/admin/notice"><i class="fa fa-comment"></i>--</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="#">--</a>
							</li>  
						</ul>						
					</li>
					
					
					
					<li class="li-menu">
						<a href="site setting"><i class="fa fa-group"></i> 사이트설정</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="#">a</a>
							</li>
						</ul>
					</li>
				</ul>
			
			</div>
		
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
		
			<tiles:insertAttribute name="body" />
			
			
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	
	<div class="modal fade" id="modal-progress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">PROGRESS</h4>
				</div>
				<div class="modal-body">
					<div class="progress-bar"></div>
					<div class="clearfix"></div>
					<h1 class="count"></h1>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/jsp/include/common-layout.jsp"/>
	
	<iframe id="downloadFrame" name="downloadFrame" frameborder="0" style="display:none;" title="빈 프레임"></iframe>

</body>
</html>
