var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request15 = [];
    var containmentOfABook = "Effective C++";
    $http.get('/request/request15?containmentOfABook='+containmentOfABook).then(function (response){
        $scope.request15=response.data;
        console.log(response);
        document.getElementById("containmentOfABook").value = containmentOfABook;
    });

    this.update_request = function add() {
        containmentOfABook = document.getElementById("containmentOfABook").value;
        $http.get('/request/request15?containmentOfABook='+containmentOfABook).then(function (response){
            $scope.request15=response.data;
            console.log(response);
        });
    };
});