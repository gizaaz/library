var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request8 = [];
    $http.get('http://localhost:8080/request/request8?=').then(function (response){
        $scope.request8=response.data;
        console.log(response);

    });

    this.update_request = function add() {
        /* var index = document.getElementById("StoragePlace").selectedIndex;
         idStoragePlace= document.getElementById("StoragePlace").options[index].value;*/
        $http.get('http://localhost:8080/request/request8?=').then(function (response){
            $scope.request8=response.data;
            console.log(response);
        });
    };
});