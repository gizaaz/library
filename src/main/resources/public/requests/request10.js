var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request10 = [];
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    var librarianName = "George";
    $http.get('/request/request10?librarianName='+librarianName+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request10=response.data;
        console.log(response);
        
       document.getElementById("librarianName").value = librarianName;
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
        librarianName = document.getElementById("librarianName").value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('/request/request10?librarianName='+librarianName+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request10=response.data;
            console.log(response);
        });
    };
});