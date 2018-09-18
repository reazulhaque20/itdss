<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//JSP code
long ts = (new Date()).getTime();  //Used to prevent JS/CSS caching
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/app.js/controller/LoginController.js"></script>
</head>
<body ng-controller="loginController">

	<div class="login-box">
            <div class="white-box">
                <form class="form-horizontal form-material" id="loginform" action="">
                    <h3 class="box-title m-b-20">Sign In</h3>
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input id="userName" autofocus="" class="form-control" style="color: white;" type="text" required="" ng-model="userName" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input id="password" class="form-control" style="color: white;" type="password" required="" ng-model="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <a href="#" id="" class="text-dark pull-right">
                            	<i class="fa fa-lock m-r-5"></i> Forgot pwd?
                            </a>
                        </div>
                    </div>
                    <div class="form-group text-center m-t-20">
                        <div class="col-xs-12">
                            <button id="loginBtn" ng-click="login()" class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" type="button">Log In</button>
                        </div>
                    </div>
                    <!-- <div class="form-group m-b-0">
                        <div class="col-sm-12 text-center">
                            <p>Don't have an account? <a href="registration" class="text-primary m-l-5"><b>Sign Up</b></a></p>
                        </div>
                    </div> -->
                </form>
            </div>
        </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    $('#password').keypress(function(e){
      if(e.keyCode==13)
      $('#loginBtn').click();
    });
    
});
</script>
</html>