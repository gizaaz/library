var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2 = [];
    var groupNumber = "2";
    $http.get('http://localhost:8080/request/request2?groupNumber='+groupNumber).then(function (response){
        $scope.request2=response.data;
        console.log(response);
        document.getElementById("groupNumber").value = groupNumber;
    });

    this.update_request = function add() {
        groupNumber = document.getElementById("groupNumber").value;
        $http.get('http://localhost:8080/request/request2?groupNumber='+groupNumber).then(function (response){
            $scope.request2=response.data;
            console.log(response);
        });
    };
});