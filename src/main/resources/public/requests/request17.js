var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request17 = [];
    var bookAuthor = "1";
    $http.get('/request/request17?bookAuthor='+bookAuthor).then(function (response){
        $scope.request17=response.data;
        console.log(response);
        document.getElementById("bookAuthor").value = bookAuthor;
    });

    this.update_request = function add() {
        bookAuthor = document.getElementById("bookAuthor").value;
        $http.get('/request/request17?bookAuthor='+bookAuthor).then(function (response){
            $scope.request17=response.data;
            console.log(response);
        });
    };
});