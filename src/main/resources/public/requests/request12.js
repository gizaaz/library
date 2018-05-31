var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request12 = [];
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    $http.get('http://localhost:8080/request/request12?firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request12=response.data;
        console.log(response);
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('http://localhost:8080/request/requesе7?firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request12=response.data;
            console.log(response);
        });
    };
});