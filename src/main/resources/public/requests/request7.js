var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request7 = [];
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    var shelfNumber = 4;
    $http.get('/request/request7?shelfNumber='+shelfNumber+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request7=response.data;
        console.log(response);
        document.getElementById("ShelfNumber").value = shelfNumber;
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
       /* var index = document.getElementById("StoragePlace").selectedIndex;
        idStoragePlace= document.getElementById("StoragePlace").options[index].value;*/
        shelfNumber = document.getElementById("ShelfNumber").value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('/request/request7?shelfNumber='+shelfNumber+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request7=response.data;
            console.log(response);
        });
    };
});