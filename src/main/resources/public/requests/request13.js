var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request13 = [];
    var hallNumber = "1";
    var libraryNumber = "1";

    $http.get('/request/request13?hallNumber='+hallNumber+'&libraryNumber='+libraryNumber).then(function (response){
        $scope.request13=response.data;
        console.log(response);
        document.getElementById("hallNumber").value = hallNumber;
        document.getElementById("libraryNumber").value = libraryNumber;

    });

    this.update_request = function add() {
        hallNumber = document.getElementById("hallNumber").value;
        libraryNumber = document.getElementById("libraryNumber").value;
        $http.get('/request/request13?hallNumber='+hallNumber+'&libraryNumber='+libraryNumber).then(function (response){
            $scope.request13=response.data;
            console.log(response);
        });
    };
});