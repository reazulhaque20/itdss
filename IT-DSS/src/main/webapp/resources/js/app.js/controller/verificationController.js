app.controller('verificationController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'NgTableParams',
	'$location',
	'url',
	function($scope,$http,$timeout,$filter, NgTableParams, $location, url){

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
//		url+"updateVerification/"+ib_need+"/"+client+"/"+mail+"/"+msisdn
		$scope.verification = {
				
		};
		$scope.saveRequest = function(client, mail, msisdn){
//			console.log(ib_need+"- "+client+"- "+mail+"- "+msisdn);
//			var t = url+"updateVerification/"+ib_need+"/"+client+"/"+mail+"/"+msisdn;
			$scope.verification.client = client;
			$scope.verification.mail = mail;
			$scope.verification.msisdn = msisdn;
			console.log($scope.verification);
			$http.post(url+"updateVerification/",$scope.verification).then(
			function(response){
				console.log(response.data.message);
				$scope.showSuccessMessage(response.data.message);
				$timeout(function() {
					//window.location.replace("https://www.banglalink.net/en");
				}, 3000);
			},
			function(errResponse){
				console.log("Error");
				$scope.showErrorMessage("Error While Processing Your Request.");
			}
			);
		};
		
		$scope.reazul = function(){
			$scope.a = "Yes";
			$scope.b = "abcd";
			$scope.c = "reaz@reaz.com";
			$scope.d = "8801962424653";
			
			$http.get(url + '/updateVerification/',$scope.verification).then(
			function(response){
				console.log(response.data.message);
			},
			function(errResponse){
				console.log("Error");
			}
			);
		};
		
		$scope.getMsisdnList = function(emailAddress){
			
			$http.post(url + 'getMsisdn/',emailAddress).then(
			function(response){
				var data = response.data;
				
				$scope.tableParams = new NgTableParams({}, { dataset: data});
			},
			function(){
				
			}
			);
			
		};
		$scope.isValid = false;
		$scope.isValid = function(isVal){
			if(isVal == 'invalid'){
				$scope.isValid = false;
			}else{
				$scope.isValid = true;
			}
		};
		
		$scope.checkTabsData = function(msisdn){
			$http.get(url + "/checkTABSData/"+msisdn).then(
					function(response){
						console.log(response.data.message);
						if(angular.equals(response.data.message,'PREPAID')){
							$scope.show = false;
						}else{
							$scope.show = true;
						}
						
					},
					function(errResponse){
						$scope.show = true;
					}
					);
		}
	}
]);