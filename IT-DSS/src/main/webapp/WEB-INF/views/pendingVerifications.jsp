<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/app.js/controller/pendingVerifications.js">
</script>
</head>
<body ng-controller="pendingVerifications">
<table ng-table="tableParams"  class="table table-bordered" >
        <thead>
            
            <tr>
            	<th>Action</th>
                <th>MSISDN</th>
                <th>Email Address</th>
                
            </tr>
        <thead>
        <tbody>
            <tr>
                <td data-title="" >
                    <button class="btn btn-primary" ng-click="sendVerifyMail()">Send 1st Mail</button>
                </td>
                <td data-title="'MSISDN'">
                    1962424653
                </td>
                <td data-title="Email">
                    reazul.haque@banglalink.net
                </td>
                
            </tr>
            
            <tr>
                <td data-title="" >
                    <button class="btn btn-primary" ng-click="sendVerifyMail()">Send 3rd Mail</button>
                </td>
                <td data-title="'MSISDN'">
                    1962424653
                </td>
                <td data-title="Email">
                    shakil.ahmed@banglalink.net
                </td>
                
            </tr>
        </tbody>
        </tbody>
    </table>
    
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
</body>
</html>