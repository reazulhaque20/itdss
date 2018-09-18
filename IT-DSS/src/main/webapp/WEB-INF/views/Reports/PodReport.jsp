<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/app.js/controller/PodReportController.js"></script>
</head>
<body ng-controller="podReportController">
<div class="row">
	<div class="col-md-12">
		<div class="white-box">
			<h3><b>POD Report</b></h3>
			<hr>
			<div class="row">
				<div class="col-lg-3">
					<label class="m-t-20">Enter MSISDN:</label>
					<input type="text" id="msisdn" class="form-control" ng-model="msisdn" placehode="Please Enter MSISDN" />
				</div>
			</div>
			<br>
			<hr>
			<div class="row">
				<div class="col-lg-5">
					<button type="button" class="btn btn-primary" ng-click="showReport()">Show</button>
				</div>
			</div>
			
			<div class="row" style="overflow: scroll">
				<div class="col-md-12" id="exportable">
				<br>
					<table id="ib" ng-table="tableParams" class="table table-bordered" show-filter="true" export-csv="csv" separator=";">
					    <tr ng-repeat="podData in $data">
					        <td title="'Category'" filter="{ category: 'text'}" sortable="'category'">
					            {{podData.category}}</td>
					        <td title="'Contrno'" filter="{ contrno: 'text'}" sortable="'contrno'">
					            {{podData.contrno}}</td>
					        <td title="'Msisdn'" filter="{ msisdn: 'text'}" sortable="'msisdn'">
					            {{podData.msisdn}}</td>
					        <td title="'Name'" filter="{ name: 'text'}" sortable="'name'">
					            {{podData.name}}</td>
					        <td title="'Address'" filter="{ address: 'text'}" sortable="'address'">
					            {{podData.address}}</td>
					        <td title="'IB/NIB'" filter="{ ibNib: 'text'}" sortable="'ibNib'">
					            {{podData.ibNib}}</td>
					        <td title="'Bill Cycle'" filter="{ billCycle: 'text'}" sortable="'billCycle'">
					            {{podData.billCycle}}</td>
					        <td title="'Month'" filter="{ month: 'text'}" sortable="'month'">
					            {{podData.month}}</td>
					        <td title="'Year'" filter="{ year: 'text'}" sortable="'year'">
					            {{podData.year}}</td>
					        <td title="'Received By'" filter="{ receivedBy: 'text'}" sortable="'receivedBy'">
					            {{podData.receivedBy}}</td>
					        <td title="'Relation'" filter="{ relation: 'text'}" sortable="'relation'">
					            {{podData.relation}}</td>
					        <td title="'Del/Return Date'" filter="{ delReturnDate: 'text'}" sortable="'delReturnDate'">
					            {{podData.delReturnDate}}</td>
					        <td title="'Del/Return By'" filter="{ delReturnBy: 'text'}" sortable="'delReturnBy'">
					            {{podData.delReturnBy}}</td>
					        <td title="'Return Reason'" filter="{ returnReason: 'text'}" sortable="'returnReason'">
					            {{podData.returnReason}}</td>
					        <td title="'Status'" filter="{ status: 'text'}" sortable="'status'">
					            {{podData.status}}</td>
					        <td title="'Courier'" filter="{ courier: 'text'}" sortable="'courier'">
					            {{podData.courier}}</td>
					    </tr>
					</table>
					<button class="btn btn-info" ng-if="true" ng-csv="getArray"
					csv-header="['Category','Contrno','Msisdn','Name','Address','IB/NIB','Bill Cycle','Month','Year','Received By','Relation','Del/Return Date','Del/Return By','Return Reason','Status','Courier']" filename="POD_Data.csv">Export</button>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="successMssages" class="alert alert-success" data-ng-show="successMessages" data-ng-bind="successMessages"></div>
<div id="errorMessages" class="alert alert-danger" data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
</body>
</html>