var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3 = [];
    var organizationName = "Apple";
    $http.get('/request/request3?organizationName='+organizationName).then(function (response){
        $scope.request3=response.data;
        console.log(response);
        document.getElementById("organizationName").value = organizationName;
    });

    this.update_request = function add() {
        organizationName = document.getElementById("organizationName").value;
        $http.get('/request/request3?organizationName='+organizationName).then(function (response){
            $scope.request3=response.data;
            console.log(response);
        });
    };
});