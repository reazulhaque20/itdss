app
	.controller(
		'landingController',
		[
			'$scope',
			'$http',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',
			'url',

			function($scope, $http,
				$timeout, $filter, NgTableParams, $location, url) {

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
					$http.get(url + "getLandingData").then(
					function(response){
						console.log("Data");
						console.log(response.data);
						$scope.langingData = response.data;
						$scope.ibRequests = new NgTableParams({}, {
							dataset : $scope.langingData.listIbRequest
						});
						
						$scope.customerEmailAddresss = new NgTableParams({}, {
							dataset : $scope.langingData.listCustomerEmailAddress
						});
					},
					function(errResponse){
						
					}
					);
					
					
					
				};
				
				$scope.gotoDetailsPage = function(){
					window.location = "requestDetails?requestID=10";
				}

				
				$scope.ibApproval = {};
				$scope.ibDetails = function(ibRequest){
					console.log(ibRequest);
					$scope.ibApproval = ibRequest;
				};
				
				$scope.updateIbRequest = function(ibApproval){
					console.log(ibApproval);
					
					$http.post(url + "updateIbRequest/", ibApproval).then(
					function(response){
						console.log(response.data.message);
						$scope.showSuccessMessage("IB Request Updated Successfully.");
						$timeout(function() {
							$scope.successMessages = null;
							$scope.errorMessages = null;
							$('#ibModal').modal('hide');
							window.location.reload();
						}, 2000);
						
					},
					function(errResponse){
						console.log("Failed to update IB Request.");
						$scope.showErrorMessage("Failed to update IB Request.");
					}
					);
				};
				$scope.emailApproval = {};
				$scope.updateEmailAddress = function(customerEmailAddressApproval){
					console.log(customerEmailAddressApproval);
					$scope.emailApproval = customerEmailAddressApproval;
				}

				$scope.sendUpdateEmailAddress = function(emailAddress){
					console.log(emailAddress);
					$http.post(url + "emailAddressUpdateFromlanding/", emailAddress).then(
					function(response){
						$scope.showSuccessMessage("Email Address Request Updated Successfully.");
						$timeout(function() {
							$scope.successMessages = null;
							$scope.errorMessages = null;
							$('#emailAddressModal').modal('hide');
							window.location.reload();
						}, 2000);
					},
					function(errResponse){
						$scope.showErrorMessage("Failed to update Email Address Request.");
					}
					);
				}
			} ]);