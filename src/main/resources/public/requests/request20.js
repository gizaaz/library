var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request20 = [];

    $http.get('/request/request20').then(function (response){
        $scope.request20=response.data;
        console.log(response);
    });




});