var App = angular.module('App',[]);

App.controller('StoragePlace',function ($http,$scope) {
    var time = performance.now();
    $http.get('/storageplace/get').then(function (response){
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.storageplace=response.data;
        console.log(response);
    });
    this.insertToStoragePlace = function add() {
        var halln = document.getElementById("HallNumber").value;
        var rackn = document.getElementById("RackNumber").value;
        var shelfn = document.getElementById("ShelfNumber").value;


        var req = {
            method: 'POST',
            url: '/storageplace/insert',
            data: {
                hallNumber: halln,
                rackNumber: rackn,
                shelfNumber:shelfn,

            }
        };
        console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            console.log(resp);
            time = performance.now() - time;
            console.log('Додавання новго запису = ', time);
            alert("-----");
            window.location.reload();
        })
    };

    this.startUpdateStoragePlace  = function startUpdate(idStoragePlace,HallNumber,RackNumber,ShelfNumber) {
        document.getElementById("StoragePlaceIdUPD").value = idStoragePlace;
        document.getElementById("HallNumberUPD").value = HallNumber;
        document.getElementById("RackNumberUPD").value = RackNumber;
        document.getElementById("ShelfNumberUPD").value = ShelfNumber;

    };

    this.updateStoragePlace  = function update() {
        var id = document.getElementById("StoragePlaceIdUPD").value;
        var halln = document.getElementById("HallNumberUPD").value
        var rackn = document.getElementById("RackNumberUPD").value;
        var shelfn = document.getElementById("ShelfNumberUPD").value;

        var req = {
            method: 'POST',
            url: '/storageplace/update?id=' + id,
            data: {
                hallNumber: halln,
                rackNumber: rackn,
                shelfNumber:shelfn,


            }
        };
        //console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.delFromStoragePlace  = function del(id) {
        var time = performance.now();
        $http.get('/storageplace/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

