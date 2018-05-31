var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.requestAll = [];

    $http.get('/request/requestAll').then(function (response){
        $scope.requestAll=response.data;
        console.log(response);
    });




});