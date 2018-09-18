app
.controller(
	'uploadPOD',
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
			
			/* Show Success Message */
			$scope.showEmailEntrySuccessMessage = function(message) {
				$scope.successMessagesEmailEntry = message;
				$timeout(function() {
					$scope.successMessagesEmailEntry = null;
					$scope.errorMessagesEmailEntry = null;
				}, 30000);
			};

			/* Show Error Message */
			$scope.showEmailEntryErrorMessage = function(message) {
				$scope.errorMessagesEmailEntry = message;
				$timeout(function() {
					$scope.successMessagesEmailEntry = null;
					$scope.errorMessagesEmailEntry = null;
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
			
			
			

			/*$scope.showErrorMessage("Failed to Load Problem Category Subcategory Data.");
			$scope.showSuccessMessage("Test");*/
			
			$scope.emailaddress = "";
			$scope.msisdn = "";
			
			$scope.gotoLandingPage = function(){
				window.location = "index";
			}
			
			
			$scope.submit = function(){
				//$scope.showSuccessMessage("Data Successfully Saved.");
				$scope.showErrorMessage("File Processing Error.");
			}
			
			$scope.emailEntry = function(){
				$scope.showEmailEntrySuccessMessage("Data Successfully Inserted.");
			}
			
		} ]);