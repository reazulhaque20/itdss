app.controller('ibReportController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'NgTableParams',
	'$location',
	'url',
	function($scope,$http,$timeout,$filter,NgTableParams,$location, url){

		/* Show Success Message */
		$scope.showSuccessMessage = function(message) {
			$scope.successMessages = message;
			$timeout(function() {
				$scope.successMessages = null;
				$scope.errorMessages = null;
			}, 30000);
		};

		/* Show Error Message */
		$scope.showErrorMessage = function(message) {
			$scope.errorMessages = message;
			$timeout(function() {
				$scope.successMessages = null;
				$scope.errorMessages = null;
			}, 5000);
		};
		$scope.ibRequest = {};
		var startDate, endDate;
		$scope.getFromDate = function(){
			$scope.fromDate = angular.element("#fromDate").val();
			startDate = new Date($scope.fromDate);
			console.log($scope.fromDate);
		}
		$scope.getToDate = function(){
			$scope.toDate = angular.element("#toDate").val();
			endDate = new Date($scope.toDate);
			console.log($scope.toDate);
		}
		
		
		$scope.ib = null;
		$scope.showReport = function(){
			if(angular.isUndefined(startDate)){
				$scope.showErrorMessage("Please Select From Date.");
				return;
			}
			if(angular.isUndefined(endDate)){
				$scope.showErrorMessage("Please Select To Date.");
				return;
			}
			console.log(startDate.getTime);
			var timeDiff = endDate.getTime() - startDate.getTime();//Math.abs();
			$scope.dayDifference = Math.ceil(timeDiff / (1000 * 3600 * 24));
			console.log($scope.dayDifference);
			if($scope.dayDifference < 0){
				$scope.showErrorMessage("From Date is "+Math.abs($scope.dayDifference)+" days before from To Date.");
				return;
			}
			console.log($scope.msisdn);
			console.log($scope.status);
			
			if(angular.isUndefined($scope.msisdn)){
				$scope.msisdn = "null";
			}
			if(angular.isUndefined($scope.status)){
				$scope.status = "null";
			}
			
			$http.get(url + '/ibReport/'+$scope.fromDate+'/'+$scope.toDate+'/'+$scope.msisdn+'/'+$scope.status).then(
			function(response){
				console.log(response);
				$scope.ib = response.data.ibRequestList;
				var data = response.data.ibRequestList;
				$scope.tableParams = new NgTableParams({}, { dataset: data});
				if($scope.ib != null){
					for(var i = 0; i < $scope.ib.length; i++){
						$scope.l1.msisdn = $scope.ib[i].msisdn;
						$scope.l1.billGroup = $scope.ib[i].billGroup;
						
						$scope.getArray[i] = $scope.l1;
						$scope.l1 = {
								msisdn:null,
								billGroup: null
							};
					}
				}
			},
			function(errResponse){
				$scope.showErrorMessage("No Record Found.");
			}
			);
		}
		$scope.getArray = [];
		$scope.l1 = {
			msisdn:null,
			billGroup: null
		};
		
		$scope.getHeader = function () {return ["MSISDN", "Bill Group"]};
		$scope.filename = "IB_REQUEST_Data.csv";
		$scope.separator = ",";
	}
]);