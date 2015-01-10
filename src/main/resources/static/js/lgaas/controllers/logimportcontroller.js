'use strict';

/**
 * LogImportController
 * @constructor
 */
var LogImportController = function($scope, $http) {
    $scope.sampleCheck = function() {
    	var page = "../runcontroller/specificationlist/"+1;
	    $http.get(page)
	    .success(function(response) {
	    	alert(response);
	    })
    };
    
    $scope.sampleCheck();
    

};