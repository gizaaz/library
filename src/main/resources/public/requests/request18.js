var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request18 = [];
    var bookGenre = "2";
    $http.get('/request/request18?bookGenre='+bookGenre).then(function (response){
        $scope.request18=response.data;
        console.log(response);
        $http.get('/book/get').then(function (response){
            var book = response.data;
            var selector = document.getElementById("bookGenre");
            $(selector).empty();
            for (var i = 0; i < book.length; i++) {
                var option = document.createElement("option");
                option.text = book[i].bookGenre;
                option.value = book[i].bookGenre;
                selector.add(option);
            }
            selector.selectedIndex=0;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("bookGenre").selectedIndex;
        bookGenre= document.getElementById("bookGenre").options[index].value;
        $http.get('/request/request18?bookGenre='+bookGenre).then(function (response){
            $scope.request18=response.data;
            console.log(response);
        });
    };
});