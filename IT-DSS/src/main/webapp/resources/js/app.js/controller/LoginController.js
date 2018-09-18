app.controller('loginController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'$location',
	'$window',
	'url',
	function($scope,$http,$timeout,$filter,$location, $window, url){
		$scope.testMsg = "Test Message";
		
		$scope.login = function(){
			console.log("User Name: ", $scope.userName);
			console.log("Password: ", $scope.password);
			$http.get(url+"login/"+$scope.userName+"/"+$scope.password).then(
				function(response){
					console.log("Service Consume");
					console.log(response.data);
					window.location = "index";
				},
				function(errResponse){
					console.log("Get Error from Service");
					console.log("Need to print a message in front end.");
					console.log(errResponse);
					console.log("dfdfd");
				}
			);
		};
	}
]);