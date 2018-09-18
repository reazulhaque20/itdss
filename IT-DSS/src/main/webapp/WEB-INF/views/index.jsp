<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Index Page</title>
<script type="text/javascript" src="resources/js/app.js/controller/landingController.js">
</script>
</head>
<body ng-controller="landingController">
<div ng-init="loadGridData();"></div>
	<div class="col-md-12">
    	<div class="panel panel-info">
    		<div class="panel-heading"> Pending Request for Email Address Update</div>
    	</div>
    </div>
	<table ng-table="customerEmailAddresss" class="table" show-filter="true">
	    <tr ng-repeat="customerEmailAddress in $data">
	    	<td title="''"><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#emailAddressModal" ng-click="updateEmailAddress(customerEmailAddress)">Details</button></td>
	        <td title="'MSISDN'" filter="{ msisdn: 'text'}" sortable="'msisdn'">
	            {{customerEmailAddress.customers.msisdn}}</td>
	        <td title="'Product'" filter="{ product: 'text'}" sortable="'product'">
	            {{customerEmailAddress.customers.product}}</td>
	        <td title="'Bill Cycle'" filter="{ billCycle: 'text'}" sortable="'billCycle'">
	            {{customerEmailAddress.customers.billCycle}}</td>
	        <td title="'Primary Email Address'" filter="{ emailAddress: 'text'}" sortable="'emailAddress'">
	            {{customerEmailAddress.emailAddress}}</td>
	        <td title="'Secondary Email Address'" filter="{ secondEmailAddress: 'text'}" sortable="'secondEmailAddress'">
	            {{customerEmailAddress.secondEmailAddress}}</td>
	    </tr>
	</table>
	
	    <div class="col-md-12">
    	<div class="panel panel-info">
    		<div class="panel-heading"> Pending Request for specific Item Wise Bill</div>
    	</div>
    </div>
    <table ng-table="ibRequests" class="table" show-filter="true">
	    <tr ng-repeat="ibRequest in $data">
	    	<td title="''"><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#ibModal" ng-click="ibDetails(ibRequest)">Details</button></td>
	        <td title="'MSISDN'" filter="{ msisdn: 'text'}" sortable="'name'">
	            {{ibRequest.msisdn}}</td>
	        <td title="'Email Address'" filter="{ emailAddress: 'text'}" sortable="'age'">
	            {{ibRequest.emailAddress}}</td>
	        <td title="'Bill Group'" filter="{ billGroup: 'text'}" sortable="'age'">
	            {{ibRequest.billGroup}}</td>
	        <td title="'Year'" filter="{ year 'text'}" sortable="'age'">
	            {{ibRequest.year}}</td>
	        <td title="'Month'" filter="{ month 'text'}" sortable="'age'">
	            {{ibRequest.month}}</td>
	    </tr>
	</table>
	
	<div id="ibModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title">IB Approval Window</h4> </div>
                                        <div class="modal-body">
                                            <form>
                                                <div class="form-group">
                                                    <label for="recipient-name" class="control-label">MSISDN:</label>
                                                    <input type="text" class="form-control" id="msisdn" ng-model="ibApproval.msisdn" ng-disabled="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Bill Group:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.billGroup">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Year:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.year">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Month:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.month">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Email Address:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.emailAddress">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">IB Delivery Type:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.deliveryType">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">IB Delivery Charge:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.deliveryCharge">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Remarks:</label>
                                                    <!-- <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.deliveryCharge"> -->
                                                    <textarea class="form-control" rows="4" cols="2" ng-model="ibApproval.remarks"></textarea>
                                                    <span class="form-control">Character Remaining: {{1000 - ibApproval.remarks.length}}</span>
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Action:</label>
                                                    <select class="form-control" ng-model="ibApproval.status">
	                                                        	<option value="">Select</option>
	                                                            <option value="Open">Open</option>
	                                                            <option value="Approved">Delivered Successfully</option>
	                                                            <option value="Reject">Reject</option>
	                                                        </select>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-danger waves-effect waves-light" ng-click="updateIbRequest(ibApproval)">Save changes</button>
                                        </div>
                                        
                                        <div id="successMssages" class="alert alert-success" data-ng-show="successMessages" data-ng-bind="successMessages"></div>
										<div id="errorMessages" class="alert alert-danger" data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
                                    </div>
                                </div>
                            </div>
                            
           <!-- Modal For Email Address Update -->
           <div id="emailAddressModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
           	<div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title">Email Address Approval Window</h4> </div>
                                        <div class="modal-body">
                                            <form>
                                                <div class="form-group">
                                                    <label for="recipient-name" class="control-label">MSISDN:</label>
                                                    <input type="text" class="form-control" id="msisdn" ng-model="emailApproval.customers.msisdn" ng-disabled="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Primary Email Address:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="emailApproval.emailAddress">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Secondary Email Address:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="emailApproval.secondEmailAddress">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Product:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="emailApproval.customers.product">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Bill Cycle:</label>
                                                    <input type="text" class="form-control" id="bill-group" ng-model="emailApproval.customers.billCycle">
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Remarks:</label>
                                                    <!-- <input type="text" class="form-control" id="bill-group" ng-model="ibApproval.deliveryCharge"> -->
                                                    <textarea class="form-control" rows="4" cols="2" ng-model="emailApproval.remarks"></textarea>
                                                    <span class="form-control">Character Remaining: {{1000 - emailApproval.remarks.length}}</span>
                                                </div>
                                                <div class="form-group">
                                                    <label for="message-text" class="control-label">Action:</label>
                                                    <select class="form-control" ng-model="emailApproval.isapproved">
	                                                        	<option value="">Select</option>
	                                                            <option value="Open">Open</option>
	                                                            <option value="Approved">Approved</option>
	                                                            <option value="Reject">Reject</option>
	                                                        </select>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-danger waves-effect waves-light" ng-click="sendUpdateEmailAddress(emailApproval)">Save changes</button>
                                        </div>
                                        
                                        <div id="successMssages" class="alert alert-success" data-ng-show="successMessages" data-ng-bind="successMessages"></div>
										<div id="errorMessages" class="alert alert-danger" data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
                                    </div>
                                </div>
           </div>
	
</body>
</html>