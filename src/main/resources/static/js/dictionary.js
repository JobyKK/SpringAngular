var app = angular.module('user_dict', ['ngResource', 'ngRoute']);

	/*.directive('userMenu', function(){
		return {
			restrict: 'E',
			replace: true,
			//template: '<h3>Hello World!!</h3>'
			templateUrl: '../templates/menu_panel.html'
			/*link: function($scope, iElm, iAttrs, controller) {
				scope.username = iAttrs.name;
			}
		};
	})
	.directive('dictInput', function(){
		return {
			restrict: 'E',
			replace: true,
			templateUrl: '../templates/add_dict.html'
		}
	})*/
	app.config(function($routeProvider) {
	    $routeProvider
	    .when("/user",
	        { templateUrl: "user_menu.html" })
	  })
	 .config(function($locationProvider) {
		 //$locationProvider.html5Mode(true);
	 })
	.controller('ShowUserInfo', function($scope, $http){
		$scope.name = "ivan";
		$http.get('/user/json').success(function(data){
			$scope.user = data;
		})
	})
	.controller('ShowUserDictionary', function($scope, $http){
		$http.get('/user/dicts/json').success(function(data){
			$scope.dicts = data;
		})
	})
	.controller('CreateDictionary', function($scope, $http, $location, $route, $rootScope, $window){
		$scope.dict = {	
				pairs:[]
		};
		$scope.addpairs = function(){
			$scope.rowNumber = parseInt($scope.rowNumber);
			if ($scope.rowNumber > 0 && $scope.rowNumber <= 30){
				for (var i = 0; i < $scope.rowNumber; i++){
					var pair = {};
					$scope.dict.pairs.push(pair);
				}
			}
		}
		$scope.add_dict = function(){
			//push to the server
			var res = $http.post('/user/dict', $scope.dict)
			    res.success(function(data, status, headers, config) {
			    	$window.location.reload();
			    });
				res.error(function(data, status, headers, config) {
					alert( "failure message: " + JSON.stringify({data: data}));
				});	
		}
		$scope.close_dict = function(){
			$scope.dict = {	
				pairs:[]
			};
		}
	})
	//done for create dynamic array
	//example ng-repeat="n in [] | range:100"
	.filter('range', function() {
  		return function(input, total) {
		    total = parseInt(total);
		    for (var i=0; i<total; i++)
		      input.push(i);
		    return input;
  		};
	});
