var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1 = [];
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    var shelfNumber = 4;
    $http.get('http://localhost:8080/request/request7?shelfNumber='+shelfNumber+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request1=response.data;
        console.log(response);
        /*$http.get('/storageplace/get').then(function (response){
            var storageplace = response.data;
            var selector = document.getElementById("StoragePlace");
            $(selector).empty();
            for (var i = 0; i < storageplace.length; i++) {
                var option = document.createElement("option");
                option.text = storageplace[i].idStoragePlace;
                option.value = storageplace[i].idStoragePlace;
                selector.add(option);
            }
            //selector.selectedIndex=0;
            selector.selectedIndex=2;
        });
*/        document.getElementById("ShelfNumber").value = shelfNumber;
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
       /* var index = document.getElementById("StoragePlace").selectedIndex;
        idStoragePlace= document.getElementById("StoragePlace").options[index].value;*/
        shelfNumber = document.getElementById("ShelfNumber").value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('http://localhost:8080/request/request7?shelfNumber='+shelfNumber+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request7=response.data;
            console.log(response);
        });
    };
});