'use strict';

var AngularSpringApp = {};

var App = angular.module('lgaasApp', ['ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/logimport', {
        templateUrl: 'templates/logimport.html',
        controller: LogImportController
    });

   /* $routeProvider.when('/login', {
        templateUrl: 'templates/login.html',
        controller: AdminController
    });
    */

    /*$routeProvider.when('/mainpage', {
        templateUrl: 'templates/mainpage.html',
        controller: MainPageController
    });*/

    $routeProvider.otherwise({redirectTo: '/logimport'});
}]);