var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request8 = [];
    $http.get('/request/request8?=').then(function (response){
        $scope.request8=response.data;
        console.log(response);

    });

    this.update_request = function add() {
        $http.get('/request/request8?=').then(function (response){
            $scope.request8=response.data;
            console.log(response);
        });
    };
});