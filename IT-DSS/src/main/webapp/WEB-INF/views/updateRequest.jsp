<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/bower_components/dropify/dist/css/dropify.min.css">
<script type="text/javascript" src="resources/js/app.js/controller/updateRequestController.js">
</script>
</head>
<body ng-controller="updateRequest">
<div class="alert alert-success alert-dismissible" ng-if="showUploadMsg">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>${success }</strong>
  </div><div>
  '${sessionScope.userRole}'
  </div>
<div class="row">
<form name="emailForm">
	<div class="row">
		<div class="col-md-9s">
			<div class="form-group">
				<label class="control-label">MSISDN</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="ti-mobile"></i></div>
					<input type="text" id="msisdn" ng-model="msisdn"  class="form-control" placeholder="MSISDN" ng-required="true" /> <span ng-show="tabs">{{tabsMsg}}</span>
				</div>
			</div>
		</div>
		<!-- <div class="col-md-7">
			<div class="form-group">
				<label class="control-label">Email Address</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="ti-email"></i></div>
					<input type="text" class="form-control" ng-model="email" placeholder="Email Address"/>
				</div>
			</div>
		</div> -->
	</div>
	<!-- <div class="row">
		<div class="col-md-5">
			<div class="form-group">
				<label class="control-label">Email Type</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="ti-shine"></i></div>
					<select class="form-control">
						<option value="">Select</option>
						<option value="Primary">Primary</option>
						<option value="Secondary">Secondary</option>
					</select>
				</div>
			</div>
		</div>
	</div> -->
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-actions">
				<button type="submit" class="btn btn-success" ng-click="search(msisdn)" ng-disabled="emailForm.$invalid || searchBtn"> Search</button>&nbsp;&nbsp;
			</div>
		</div>
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

<!-- New Forms -->


</div>

<div class="row">
<div class="col-md-6" ng-show="showEmailEntry">
                        <div class="white-box">
                            <h3 class="box-title m-b-0">E-Mail Request Entry</h3>
                            <!-- <p class="text-muted m-b-30 font-13"> Bootstrap Elements </p> -->
                            <div class="row">
                                <div class="col-sm-12 col-xs-12">
                                    <form>
                                        <div class="form-group">
                                            <label for="exampleInputuname">MSISDN</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-user"></i></div>
                                                <input type="text" class="form-control" id="exampleInputuname" ng-model="updateEmailAddress.customers.msisdn" ng-blur="checkTABSData()" placeholder="MSISDN"> </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Primary Email address</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-email"></i></div>
                                                <input type="email" class="form-control" id="exampleInputEmail1" ng-model="updateEmailAddress.emailAddress" placeholder="Primary Email address"> </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Secondary Email address</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-email"></i></div>
                                                <input type="email" class="form-control" id="exampleInputEmail1" ng-model="updateEmailAddress.secondEmailAddress" placeholder="Secondary Email address"> </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputpwd1">Product</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-lock"></i></div>
                                                <input type="text" class="form-control" id="exampleInputpwd1" ng-model="updateEmailAddress.customers.product" placeholder="Product"> </div>
                                        </div> 
                                        <div class="form-group" ng-if="'${sessionScope.userRole}' == ">
                                            <label for="exampleInputpwd1">Product</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-lock"></i></div>
                                                <input type="text" class="form-control" id="exampleInputpwd1" ng-model="updateEmailAddress.customers.product" placeholder="Product"> </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputpwd2">Bill Cycle</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="ti-lock"></i></div>
                                                <select class="form-control" ng-model="updateEmailAddress.customers.billCycle">
	                                                        	<option value="">Select</option>
	                                                            <option value="BG-21">BG-21</option>
	                                                            <option value="BG-28">BG-28</option>
	                                                            <option value="BG-30">BG-30</option>
	                                                            <option value="BG-31">BG-31</option>
	                                            </select>
                                            </div>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-success waves-effect waves-light m-r-10" ng-click="emailEntry(updateEmailAddress)">Submit</button>
                                        <button type="submit" class="btn btn-inverse waves-effect waves-light">Cancel</button>
                                        
                                        <div class="row">
    	<div id="successMssages" class="alert alert-success"
					data-ng-show="successMessagesEmailEntry"
					data-ng-bind="successMessagesEmailEntry">
		</div>
		<div id="errorMessages" class="alert alert-danger"
					data-ng-show="errorMessagesEmailEntry"
					data-ng-bind="errorMessagesEmailEntry">
		</div>
</div>



                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="col-md-6" ng-show="false">
                        <div class="white-box">
                            <h3 class="box-title m-b-0">Email Request Update</h3>
                            <div class="row">
                                <div class="col-sm-12 col-xs-12">
                                    <form>
                                        <div class="form-group">
                                            <label for="exampleInputuname">User Name</label>
                                            <div class="input-group">
                                                <input type="text" class="form-control" id="exampleInputuname" placeholder="Username">
                                                <div class="input-group-addon"><i class="ti-user"></i></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Email address</label>
                                            <div class="input-group">
                                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                                                <div class="input-group-addon"><i class="ti-email"></i></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputpwd1">Password</label>
                                            <div class="input-group">
                                                <input type="password" class="form-control" id="exampleInputpwd1" placeholder="Enter pwd">
                                                <div class="input-group-addon"><i class="ti-lock"></i></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputpwd2">Confirm Password</label>
                                            <div class="input-group">
                                                <input type="password" class="form-control" id="exampleInputpwd2" placeholder="Enter pwd">
                                                <div class="input-group-addon"><i class="ti-lock"></i></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox checkbox-success">
                                                <input id="checkbox2" type="checkbox">
                                                <label for="checkbox2"> Remember me </label>
                                            </div>
                                        </div>
                                        <div class="text-right">
                                            <button type="submit" class="btn btn-success waves-effect waves-light m-r-10">Submit</button>
                                            <button type="submit" class="btn btn-inverse waves-effect waves-light">Cancel</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
</div>

<form method="post" action="updateRequest" enctype="multipart/form-data">
<div class="row">
		<div class="col-md-12">
		    
		        <input name="file" id="fileToUpload" type="file" id="input-file-now" class="dropify"/>
		    
		</div>                    
	</div>
    <br/>                    
       <div class="form-actions">
	    <div class="row">
	        <div class="col-md-12">
	            <div class="row">
	                <div class="col-md-offset-3 col-md-9">
	                    <button type="submit" class="btn btn-info"> <i class="fa fa-check"></i> Upload</button>
	                    <button type="button" class="btn btn-danger"><i class="fa fa-home"></i> Cancel</button>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
    </form>
    

     
     
 </div>
</body>
<script src="resources/bower_components/dropify/dist/js/dropify.min.js"></script>
<script>
    $(document).ready(function() {
        // Basic
        $('.dropify').dropify();
        // Translated
        $('.dropify-fr').dropify({
            messages: {
                default: 'Glissez-déposez un fichier ici ou cliquez',
                replace: 'Glissez-déposez un fichier ou cliquez pour remplacer',
                remove: 'Supprimer',
                error: 'Désolé, le fichier trop volumineux'
            }
        });
        // Used events
        var drEvent = $('#input-file-events').dropify();
        drEvent.on('dropify.beforeClear', function(event, element) {
            return confirm("Do you really want to delete \"" + element.file.name + "\" ?");
        });
        drEvent.on('dropify.afterClear', function(event, element) {
            alert('File deleted');
        });
        drEvent.on('dropify.errors', function(event, element) {
            console.log('Has Errors');
        });
        var drDestroy = $('#input-file-to-destroy').dropify();
        drDestroy = drDestroy.data('dropify')
        $('#toggleDropify').on('click', function(e) {
            e.preventDefault();
            if (drDestroy.isDropified()) {
                drDestroy.destroy();
            } else {
                drDestroy.init();
            }
        })
    });
    </script>
    

</html>