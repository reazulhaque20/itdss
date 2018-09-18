<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/bower_components/dropify/dist/css/dropify.min.css">
<script type="text/javascript" src="resources/js/app.js/controller/uploadPOD.js"></script>
</head>
<body ng-controller="uploadPOD">
<div>${success}</div>
	<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-info">
                            <div class="panel-heading"> POD Upload panel</div>
                            <div class="panel-wrapper collapse in" aria-expanded="true">
                                <div class="panel-body">
                                    <form method="post" action="uploadPOD" enctype="multipart/form-data">
                                        <div class="form-body">
                                            <h3 class="box-title">For Sample POD File Please <a href="download_pod_sample_file?fileName=POD_Format_BDMS.csv">Click Here</a></h3>
                                            <hr>
                                            <!-- <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Year</label>
                                                        <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                                        <select class="form-control">
                                                        <option value="">Select</option>
                                                            <option value="2017">2017</option>
                                                            <option value="2018">2018</option>
                                                        </select>
                                                        </div>
                                                     </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Month</label>
                                                        <div class="input-group">
                                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                                        <select class="form-control">
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
                                                        </select>
                                                        </div>
                                                     </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Bill Cycle</label>
                                                        <div class="input-group">
                                                        <div class="input-group-addon"><i class="icon-refresh"></i></div>
                                                        <select class="form-control">
                                                        	<option value="">Select</option>
                                                            <option value="BG-21">BG-21</option>
                                                            <option value="BG-28">BG-28</option>
                                                            <option value="BG-30">BG-30</option>
                                                            <option value="BG-31">BG-31</option>
                                                        </select>
                                                        </div>
                                                     </div>
                                                </div>
                                            </div> -->
                                            
                                            <div class="row">
		<div class="col-md-12">
		    
		        <input name="file" id="fileToUpload" type="file" id="input-file-now" class="dropify"/> <!--  class="dropify" -->
		    
		</div>                    
	</div>
                                        </div>
                    <br/>                    
       <div class="form-actions">
	    <div class="row">
	        <div class="col-md-12">
	            <div class="row">
	                <div class="col-md-offset-3 col-md-9">
	                    <button type="submit" class="btn btn-info" > <i class="fa fa-check"></i> Upload</button>
	                    <button type="button" class="btn btn-danger"><i class="fa fa-home"></i> Cancel</button>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
                                        
                                    </form>
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
                            </div>
                        </div>
                    </div>
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