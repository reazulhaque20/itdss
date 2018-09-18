<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/app.js/controller/verificationController.js"></script>
<style>
.ng-table-pager {
    display: none;
}
#blBanner{
width : 100%;
height : 0%;
}
</style>
</head>
<body ng-controller="verificationController" ng-init="isValid('${requestScope.isValid}')">
<div ng-if="isValid">
<div ng-init="getMsisdnList('${requestScope.mail}')"></div>
<div ng-init="checkTabsData('${requestScope.msisdn}')"></div>
<div class="row">
<img class="img-responsive" id="blBanner" src="resources/images/bl4g.jpg"/>
</div>
<p><h1>Welcome to Banglalink Email Verification System</h1></p>
<p><h3>You've verified Email address for below listed Number(s)</h3></p>
<div class="row">
				<div class="col-md-12" id="exportable">
					<br>
					<table id="ib" ng-table="tableParams" class="table table-bordered" show-filter="false">
					    <tr ng-repeat="emailAddressData in $data">
					        <td title="'MSISDN'" filter="{ name: 'text'}" sortable="'name'">
					            {{emailAddressData.customers.msisdn}}</td>
					        <td title="'Primary Email Address'" filter="{ emailAddress: 'text'}" sortable="'emailAddress'">
					            {{emailAddressData.emailAddress}}</td>
					    </tr>
					</table>
				</div>
			</div>

<hr>
<div ng-if="show">
<div class="row">
<div class="col-md-6">
<div class="form-group">
    <label for="exampleInputpwd2">Do You want E-Bill To ${requestScope.mail}? </label>
    <div class="input-group">
        <div class="input-group-addon"><i class="ti-lock"></i></div>
        <select class="form-control" ng-model="verification.ib_need">
                 	<option value="">Select</option>
                     <option value="Yes">Yes</option>
                     <option value="Yes">No</option>
     </select>
    </div>
    <button type="button" ng-click="saveRequest('${requestScope.client}','${requestScope.mail}','${requestScope.msisdn}')" class="btn btn-success waves-effect waves-light m-r-10"><i class="fa fa-home"></i> Confirm</button>
</div>
</div>
</div>
</div>
<div class="row">
    	<div id="successMssages" class="alert alert-success"
					data-ng-show="successMessages"
					data-ng-bind="successMessages">
		</div>
		<div id="errorMessages" class="alert alert-danger"
					data-ng-show="errorMessages"
					data-ng-bind="errorMessages">
		</div>
</div>
</div>
</body>
</html>