app.controller('ibRequestController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'$location',
	'url',
	function($scope,$http,$timeout,$filter,$location, url){

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
		$scope.ibRequests = {};
		$scope.months = [];
		$scope.saveIbRequest = function(){
			console.log("Save: ",$scope.ibRequest);
			console.log($scope.example8model.length);
			
			if($scope.example8model.length >= 1){
				for(var i = 0; i < $scope.example8model.length; i++ ){
					$scope.months.push($scope.example8model[i].id);
				}
					//$scope.ibRequest.months = $scope.months;//[i].id;
					$scope.ibRequests.ibRequest = $scope.ibRequest;
					$scope.ibRequests.months = $scope.months;
					$http.post(url+"submitIbRequest/",$scope.ibRequests).then(
					function(response){
						$scope.showSuccessMessage(response.data.message);
					},
					function(errResponse){
						console.log("Error");
						$scope.showErrorMessage("Error to keep IB Request.");
					}
					);
				//}
			}
		};
		
		$scope.example8model = []; 
		  //$scope.example8data = [ {id: "January", label: "Janyary"}, {id: "February", label: "February"}, {id: "March", label: "March"}, {id: "April", label: "April"}, {id: "May", label: "May"}, {id: "June", label: "June"}, {id: "July", label: "July"}, {id: "August", label: "August"}, {id: "September", label: "September"}, {id: "October", label: "October"}, {id: "November", label: "November"}, {id: "December", label: "December"} ]; 
		  $scope.example8settings = { 
				/*checkBoxes: true, 
				dynamicTitle: false, */
				showUncheckAll: true, 
				showCheckAll: true ,
				styleActive: true
		  };
		  
		  $scope.loadYearDD = function(){
			  $http.get(url + "loadDD/MONTH" ).then(
				function(response){
					console.log(response.data);
					$scope.example8data = response.data;
				},
				function(errResponse){
					consoloe.log(errResponse);
				}
			  );
		  };
		  
		  $scope.loadYearDD();
		
		
	}
]);