<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="resources/js/app.js/controller/requestDetails.js">
</script>
</head>
<body ng-controller="requestDetails">
<form>
	<div class="row">
	
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label">MSISDN</label> <input type="text"
					id="firstName" ng-model="msisdn" class="form-control" placeholder="MSISDN">
			</div>
		</div>
		<!--/span-->
		<div class="col-md-8">
			<div class="form-group">
				<label class="control-label">Email Address</label> <input type="text"
					id="emailaddress" ng-model="emailaddress" class="form-control" placeholder="12n">
			</div>
		</div>
		
	</div>
	<div class="row">
	<div class="form-actions">
		<button type="submit" class="btn btn-success"> Save</button>&nbsp;&nbsp;
        <button type="button" class="btn btn-default" ng-click="gotoLandingPage()">Cancel</button>
        </div>
	</div>
</form>
</body>
</html>