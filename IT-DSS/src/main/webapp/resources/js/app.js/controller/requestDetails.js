app
	.controller(
		'requestDetails',
		[
			'$scope',
			'$http',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http,
				$timeout, $filter, NgTableParams, $location) {

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
				
				
				
				$scope.loadGridData = function() {
					var data = null;
					$scope.tableParams = new NgTableParams({}, {
						dataset : $scope.sampleFridData
					});
				};
				
				$scope.gotoDetailsPage = function(){
					window.location = "requestDetails?requestID=10";
				}
				
				
				

				$scope.showErrorMessage("Failed to Load Problem Category Subcategory Data.");
				$scope.showSuccessMessage("Test");
				
				$scope.emailaddress = "reazul.haque@banglalink.net";
				$scope.msisdn = "1962424653";
				
				$scope.gotoLandingPage = function(){
					window.location = "index";
				}
				
			} ]);