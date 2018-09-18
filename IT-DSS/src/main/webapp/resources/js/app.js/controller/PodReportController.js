app.controller('podReportController',[
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
		
			
			/*$http.get(url + '/ibReport/'+$scope.fromDate+'/'+$scope.toDate+'/'+$scope.msisdn+'/'+$scope.status).then(
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
			
			);
		}*/
		$scope.getArray= [];
		$scope.l1 = {
				msisdn: null,
				name: null,
				address: null
		}
		$scope.showReport = function(){
			if(angular.isUndefined($scope.msisdn)){
				$scope.showErrorMessage("Please Select MSISDN.");
				return;
			}
			$http.get(url + '/podReport/'+$scope.msisdn).then(
			function(response){
				$scope.pod = response.data.listuploadpod;
				var data = response.data.listuploadpod;
				$scope.tableParams = new NgTableParams({}, { dataset: data});
				if($scope.pod != null){
					for(var i = 0; i < $scope.pod.length; i++){
						$scope.l1.msisdn = $scope.pod[i].msisdn;
						$scope.l1.name = $scope.pod[i].name;
						$scope.l1.address = $scope.pod[i].address;
						
						$scope.getArray[i] = $scope.l1;
						$scope.l1 = {
								msisdn: null,
								name: null,
								address: null
						}
					}
				}
			},
			function(errResponse){
				$scope.showErrorMessage("No Record Found.");
			}
			);
		}
	}
]);