app.controller('registrationController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'$location',
	'url',
	function($scope,$http,$timeout,$filter,$location,url){
		$scope.testMSG = "Test Messages";
		$scope.url = url;
		$scope.reg;
		
		$scope.doRegistration = function(){
			console.log("Test"+ $scope.url + url);
			$http.post(url + "doRegistration/",$scope.reg).then(
			function(response){
				console.log(recponse);
			},
			function(errResponse){
				console.log(errResponse);
			}
			);
		}
	}
]);