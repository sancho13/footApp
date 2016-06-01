/**
 * Created by Marseillais on 01/06/2016.
 */

var app=angular.module('helloJS',[]);


app.controller('Hello',function ($scope, $http) {

  $http.get('http://localhost:8080/equipes/1').
  success(function(data) {
      $scope.equipe = data;
  });

});