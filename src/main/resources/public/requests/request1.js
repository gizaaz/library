var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1 = [];
    var faculty = "1";
    $http.get('/requests/request1?faculty='+faculty).then(function (response){
        $scope.request1=response.data;
        console.log(response);
        document.getElementById("Faculty").value = faculty;

    });

    this.update_request = function add() {
        faculty = document.getElementById("Faculty").value;
        $http.get('/request/request1?faculty='+faculty).then(function (response){
            $scope.request1=response.data;
            console.log(response);
        });
    };
});