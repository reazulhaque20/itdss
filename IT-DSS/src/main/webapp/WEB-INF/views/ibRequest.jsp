<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="resources/js/app.js/controller/ibRequestController.js"></script>
</head>
<body ng-controller="ibRequestController">
<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-info">
                            <div class="panel-heading"> Request for specific Item Wise Bill</div>
                            <div class="panel-wrapper collapse in" aria-expanded="true">
                                <div class="panel-body">
                                    <form>
                                        <div class="form-body">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">MSISDN</label>
                                                        <div class="input-group">
                                                        	<div class="input-group-addon"><i class=" icon-screen-smartphone"></i></div>
                                                        	<input type="text" id="msisdn" ng-model="ibRequest.msisdn" class="form-control" placeholder="MSISDN" ng-disabled="false">
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">Bill Group</label>
                                                        <div class="input-group">
	                                                        <div class="input-group-addon"><i class="icon-refresh"></i></div>
	                                                        <select class="form-control" ng-model="ibRequest.billGroup">
	                                                        	<option value="">Select</option>
	                                                            <option value="BG-21">BG-21</option>
	                                                            <option value="BG-28">BG-28</option>
	                                                            <option value="BG-30">BG-30</option>
	                                                            <option value="BG-31">BG-31</option>
	                                                        </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">Year</label>
                                                        <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                                        <select class="form-control" ng-model="ibRequest.year">
                                                        <option value="">Select</option>
                                                            <option value="2017">2017</option>
                                                            <option value="2018">2018</option>
                                                        </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">Month</label>
                                                        <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                                        <div ng-dropdown-multiselect="" options="example8data" selected-model="example8model" extra-settings="example8settings"></div>
                                                        <!-- <select class="form-control" ng-model="ibRequest.month">
                                                        	<option value="">Select</option>
                                                            <option value="January">January</option>
                                                            <option value="February">February</option>
                                                            <option value="March">March</option>
                                                            <option value="April">April</option>
                                                            <option value="May">May</option>
                                                            <option value="June">June</option>
                                                            <option value="July">July</option>
                                                            <option value="August">August</option>
                                                            <option value="September">September</option>
                                                            <option value="October">October</option>
                                                            <option value="November">November</option>
                                                            <option value="December">December</option>
                                                        </select> -->
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">IB Delivery Type</label>
                                                        <div class="radio-list">
                                                            <label class="radio-inline p-0">
                                                                <div class="radio radio-info">
                                                                    <input type="radio" name="deliveryType" ng-model="ibRequest.deliveryType" value="IB By Curier">
                                                                    <label for="radio1">IB By Curier</label>
                                                                </div>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <div class="radio radio-info">
                                                                    <input type="radio" name="deliveryType" value="IB By Email" ng-model="ibRequest.deliveryType">
                                                                    <label for="radio2">IB By Email </label>
                                                                </div>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">Email Address</label>
                                                        <div class="input-group">
                                                        	<div class="input-group-addon"><i class="ti-email "></i></div>
                                                        	<input type="text" id="email" class="form-control" placeholder="Email Address" ng-model="ibRequest.emailAddress">
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label">IB Delivery Charge</label>
                                                        <div class="radio-list">
                                                            <label class="radio-inline p-0">
                                                                <div class="radio radio-info">
                                                                    <input type="radio" name="deliveryCharge" ng-model="ibRequest.deliveryCharge" id="radio1" value="Not Free">
                                                                    <label for="radio1">Not Free</label>
                                                                </div>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <div class="radio radio-info">
                                                                    <input type="radio" checked="checked" ng-model="ibRequest.deliveryCharge" name="deliveryCharge" id="radio2" value="Free">
                                                                    <label for="radio2" >Free </label>
                                                                </div>
                                                            </label>
                                                        </div>
                                                </div>
                                            </div>
                                            </div>
                                            <!--/row-->
                                        </div>
                                        <div class="form-actions">
                                            <button type="button" class="btn btn-success" ng-click="saveIbRequest()"> <i class="fa fa-check"></i> Save</button>
                                            <button type="button" class="btn btn-default">Cancel</button>
                                        </div>
                                        <br/>
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
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
</body>
</html>