var App = angular.module('App',[]);

App.controller('StoragePlace',function ($http,$scope) {
    $http.get('/storageplace/get').then(function (response){
        $scope.storageplace=response.data;
        
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
        $http(req).then(function (resp) {

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
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromStoragePlace  = function del(id) {
        $http.get('/storageplace/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

