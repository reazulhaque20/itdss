<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/app.js/controller/EmailAddreessReportController.js"></script>
<link rel="stylesheet" href="resources/css/datetimepicker/jquery.datetimepicker.css">
</head>
<body ng-controller="emailAddressReportController">
<div class="row">
	<div class="col-md-12">
		<div class="white-box">
			<h3><b>IB Report</b></h3>
			<hr>
			<div class="row">
				<div class="col-lg-3">
					<label class="m-t-20">Select From Date:</label>
					<input type="text" id="fromDate" class="form-control" ng-blur="getFromDate()" ng-model="fromDate" />
				</div>
				
				<div class="col-lg-3">
					<label class="m-t-20">Select To Date:</label>
					<input type="text" id="toDate" class="form-control" ng-blur="getToDate()" ng-model="toDate" />
				</div>
				
				<div class="col-lg-3">
					<label class="m-t-20">Select MSISDN:</label>
					<input type="text" id="msisdn" class="form-control" ng-model="msisdn" />
				</div>
				
				<div class="col-lg-3">
					<label class="m-t-20">Select Email Address:</label>
					<input type="text" id="emailAddress" class="form-control" ng-model="emailAddress" />
				</div>
				
				<div class="col-lg-3">
					<label class="m-t-20">Select Verification Status:</label>
					<input type="text" id="verificationStatus" class="form-control" ng-model="verificationStatus" />
				</div>
			</div>
			<hr>
			<br>
			<div class="row">
				<div class="col-md-5">
					<button type="button" class="btn btn-primary" ng-click="showReport()">Show</button>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12" id="exportable">
					<br>
					<table id="ib" ng-table="tableParams" class="table table-bordered" show-filter="false" export-csv="csv" separator=";">
					    <tr ng-repeat="emailAddressData in $data">
					        <td title="'MSIDN'" filter="{ name: 'text'}" sortable="'name'">
					            {{emailAddressData.customers.msisdn}}</td>
					        <td title="'Primary Email Address'" filter="{ emailAddress: 'text'}" sortable="'emailAddress'">
					            {{emailAddressData.emailAddress}}</td>
					        <td title="'Bill Group'" filter="{ billCycle: 'number'}" sortable="'billCycle'">
					            {{emailAddressData.customers.billCycle}}</td>
					        <td title="'Source'" filter="{ billCycle: 'number'}" sortable="'billCycle'">
					            {{emailAddressData.customers.media}}</td>
					        <td title="'EBILL'" filter="{ billCycle: 'number'}" sortable="'billCycle'">
					            {{emailAddressData.customers.interestedforebill}}</td>
					        <td title="'COURIER'" filter="{ billCycle: 'number'}" sortable="'billCycle'">
					            {{emailAddressData.customers.interestedforcourier}}</td>
					        <td title="'CNC'" filter="{ cnc: 'text'}" sortable="'cnc'">
					            {{emailAddressData.customers.cnc}}</td>
					        <td title="'USER_ID'" filter="{ createdby: 'text'}" sortable="'createdby'">
					            {{emailAddressData.customers.createdby}}</td>
					        <td title="'ENTRY DATE'" filter="{ createddate: 'date'}" sortable="'createddate'">
					            {{emailAddressData.customers.createddate}}</td>
					    </tr>
					</table>
					<button class="btn btn-info" ng-if="true" ng-csv="getArray"
					csv-header="['MSIDN','Primary Email Address','Bill Group','Source','EBILL','COURIER','CNC','USER_ID','ENTRY DATE']" filename="Email_Address_Data.csv">Export</button>
				</div>
			</div>
			
		</div>
	</div>
</div>
<div id="successMssages" class="alert alert-success" data-ng-show="successMessages" data-ng-bind="successMessages"></div>
<div id="errorMessages" class="alert alert-danger" data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>

<script src="resources/js/datetimepicker/jquery.datetimepicker.full.js"></script>
<script>
	$('#fromDate').datetimepicker(
			{
				timepicker:false,
				format : 'd-M-y'
			});

	$('#toDate').datetimepicker(
			{
				timepicker:false,
				format : 'd-M-y'
			});
</script>
</body>
</html>