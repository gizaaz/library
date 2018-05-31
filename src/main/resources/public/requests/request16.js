var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request16 = [];
    var bookYear = "1";
    $http.get('http://localhost:8080/request/request16?bookYear='+bookYear).then(function (response){
        $scope.request16=response.data;
        console.log(response);
        document.getElementById("bookYear").value = bookYear;
    });

    this.update_request = function add() {
        bookYear = document.getElementById("bookYear").value;
        $http.get('http://localhost:8080/request/request16?bookYear='+bookYear).then(function (response){
            $scope.request16=response.data;
            console.log(response);
        });
    };
});