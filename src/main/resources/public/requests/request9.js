var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request9 = [];
    var librarianName = "George";
    $http.get('http://localhost:8080/request/request9?librarianName='+librarianName).then(function (response){
        $scope.request9=response.data;
        console.log(response);
        document.getElementById("librarianName").value = librarianName;
    });

    this.update_request = function add() {
        librarianName = document.getElementById("librarianName").value;
        $http.get('http://localhost:8080/request/request9?librarianName='+librarianName).then(function (response){
            $scope.request9=response.data;
            console.log(response);
        });
    };
});