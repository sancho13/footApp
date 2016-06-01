/**
 * Created by Marseillais on 01/06/2016.
 */

var app=angular.module('helloJS',[]);

app.controller('Hello',function ($scope, $http) {
    $http.get('http://rest-service.guides.spring.io/greeting').
    success(function(data) {
        $scope.equipe = data;
    });
});