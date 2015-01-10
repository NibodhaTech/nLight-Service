
var app = angular.module("myApp",["ngRoute","ui.directives"]);
 app.config(function($routeProvider){
	$routeProvider
		.when('/nextnav-form',{templateUrl:'nextnav-form.html',controller:'nextNavFormCtrl'})
		.otherwise({redirectTo:'/nextnav-form'})
 });
 






 