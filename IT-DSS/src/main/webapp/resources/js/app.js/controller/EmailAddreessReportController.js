app.controller('emailAddressReportController',[
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
		var startDate, endDate;
		$scope.getFromDate = function(){
			$scope.fromDate = angular.element("#fromDate").val();
			if($scope.fromDate == ''){
				$scope.showErrorMessage("Please Select From Date.");
				return;
			}
			startDate = new Date($scope.fromDate);
			console.log($scope.fromDate);
		}
		$scope.getToDate = function(){
			$scope.toDate = angular.element("#toDate").val();
			if($scope.toDate == ''){
				$scope.showErrorMessage("Please Select To Date.");
				return;
			}
			endDate = new Date($scope.toDate);
			console.log($scope.toDate);
		}
		
		$scope.getArray = [];
		$scope.l1 = {
			msisdn: null,
			emailAddress: null,
			billCycle: null
		};
		$scope.showReport = function(){
			if(angular.isUndefined(startDate)){
				$scope.showErrorMessage("Please Select From Date.");
				return;
			}
			if(angular.isUndefined(endDate)){
				$scope.showErrorMessage("Please Select To Date.");
				return;
			}
			if($scope.fromDate == ''){
				$scope.showErrorMessage("Please Select From Date.");
				return;
			}
			if($scope.toDate == ''){
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
			
			if(angular.isUndefined($scope.msisdn) || $scope.msisdn == ''){
				$scope.msisdn = "null";
			}
			if(angular.isUndefined($scope.emailAddress) || $scope.emailAddress == ''){
				$scope.emailAddress = "null";
			}
			if(angular.isUndefined($scope.verificationStatus) || $scope.verificationStatus == ''){
				$scope.verificationStatus = "null";
			}
			
			$http.get(url + '/emailAddressReport/'+$scope.fromDate+ '/'+ $scope.toDate + '/' + $scope.msisdn + '/' + $scope.emailAddress + '/'+ $scope.verificationStatus).then(
			function(response){
				$scope.eAddress = response.data.listCustomersEmailAddress;
				var data = response.data.listCustomersEmailAddress;
				$scope.tableParams = new NgTableParams({}, { dataset: data});
				
				if($scope.eAddress != null){
					for(var i = 0; i<$scope.eAddress.length; i++){
						$scope.l1.msisdn = $scope.eAddress[i].customers.msisdn;
						$scope.l1.emailAddress = $scope.eAddress[i].emailAddress;
						$scope.l1.billCycle = $scope.eAddress[i].customers.billCycle;
						
						$scope.getArray[i] = $scope.l1;
						$scope.l1 = {
								msisdn: null,
								emailAddress: null,
								billCycle: null
							};
					}
				}
				return;
			},
			function(errResponse){
				$scope.showErrorMessage("No Record Found.");
			}
			);
			
		};
	}
]);