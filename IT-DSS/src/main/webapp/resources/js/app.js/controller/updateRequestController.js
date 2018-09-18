app
.controller(
	'updateRequest',
	[
		'$scope',
		'$http',
		'$timeout',
		'$filter',
		'NgTableParams',
		'url',
		'$location',

		function($scope, $http,
			$timeout, $filter, NgTableParams, url, $location) {

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
			$scope.test = "Test";
			
			$scope.showEmailEntry = false;
			
			$scope.updateEmailAddress;
			$scope.search = function(msisdn){
				//$scope.showSuccessMessage("Data Successfully Saved.");
//				$scope.showErrorMessage("No Data Found.");
//				$scope.showEmailEntry = true;
				$http.get(url + "checkMSISDN/"+msisdn+"/").then(
				function(response){
					$scope.updateEmailAddress = response.data;
					$scope.showEmailEntry = true;
				},
				function(errResponse){
					$scope.updateEmailAddress = null;
					$scope.showEmailEntry = true;
				}
				);
			}
			
			$scope.emailEntry = function(updateEmailAddress){
				$http.post(url + "updateEmailAddress/",updateEmailAddress).then(
				function(response){
					$scope.showEmailEntrySuccessMessage(response.data.message);
				},
				function(errResponse){
					$scope.showEmailEntryErrorMessage("");
				}
				);
				//$scope.showEmailEntrySuccessMessage("Data Successfully Inserted.");
			};
			
			$scope.fileUpload = function(){
//				$scope.showErrorMessage("File Processing Error.");
			}
			$scope.tabs = false;
			$scope.tabsMsg = "";
			$scope.searchBtn = false;
			$scope.checkTABSData = function(){
				console.log("Test Data.");
				$http.get(url + "/checkTABSData/"+$scope.msisdn).then(
				function(response){
					console.log(response.data.message);
					if(angular.equals(response.data.message,'PREPAID')){
						$scope.updateEmailAddress.customers.product = 'PREPAID';
					}else{
						$scope.updateEmailAddress.customers.product = 'POSTPAID';
					}
					
				},
				function(errResponse){
					$scope.tabs = true;
					$scope.tabsMsg = "Unable to connect with TABS.";
					$scope.searchBtn = false;
				}
				);
			};
			
		} ]);