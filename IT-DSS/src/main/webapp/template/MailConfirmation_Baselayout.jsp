<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/images/eliteadmin-logo-dark.png">
    <title>Welcome to BL E-Mail Repository</title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/bower_components/bootstrap-extension/css/bootstrap-extension.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="resources/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="resources/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="resources/css/colors/default-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- jQuery -->
    <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap/dist/js/tether.min.js"></script>
    <script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/bower_components/bootstrap-extension/js/bootstrap-extension.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="resources/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="resources/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="resources/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="resources/js/custom.min.js"></script>
    <!--Style Switcher -->
    <script src="resources/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
    
    <!-- Angular Stuff -->
    <script type="text/javascript" src="resources/js/angular.js"></script>
        <link href="resources/css/ng-table.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="resources/js/angular_dependency/ng-table.min.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/ng-csv.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/angularjs-dropdown-multiselect.js"></script>
	<script type="text/javascript" src="resources/js/app.js/app.js"></script>
</head>

<body ng-app="myApp">
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    
    <div id="page-wrapper">
    	<div class="container-fluid">
    		<br/>
    		<tiles:insertAttribute name="body" />
    	</div>
    </div>
    
</body>

</html>
