'use strict';

var AngularSpringApp = {};

var App = angular.module('lgaasApp', ['ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/logimport', {
        templateUrl: 'templates/logimport.html',
        controller: LogImportController
    });

    $routeProvider.when('/admin', {
        templateUrl: 'templates/admin.html',
        controller: AdminController
    });

    $routeProvider.otherwise({redirectTo: '/logimport'});
}]);