var App = angular.module('App',[]);

App.controller('Deliveryndeleting',function ($http,$scope) {
    $http.get('/deliveryndeleting/get').then(function (response){
        $scope.deliveryndeleting=response.data;
        console.log(response);
    });

    this.insertToDeliveryNDeleting = function add() {
        var bookN = document.getElementById("BookName").value;
        var deliveryd = document.getElementById("DeliveryDate").value;
        var deletingd = document.getElementById("DeletingDate").value;

        var req = {
            method: 'POST',
            url: '/deliveryndeleting/insert',
            data: {
                bookName : bookN,
                deliveryDate : deliveryd,
                deletingDate: deletingd

            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.startUpdateDeliveryNDeleting = function startUpdate(deliveryndeletingId,bookN,deliveryD,deletingD) {
        document.getElementById("BookNameUPD").value = bookN;
        document.getElementById("DeliveryNDeletingIdUPD").value = deliveryndeletingId;
        document.getElementById("DeletingDateUPD").value = deletingD;
        document.getElementById("DeliveryDateUPD").value = deliveryD;
    };

    this.updateDeliveryNDeleting = function update() {
        var id = document.getElementById("DeliveryNDeletingIdUPD").value;
        var bookN = document.getElementById("BookNameUPD").value;
        var deliveryd = document.getElementById("DeliveryDateUPD").value;
        var deletingd = document.getElementById("DeletingDateUPD").value;

        var req = {
            method: 'POST',
            url: '/deliveryndeleting/update?id=' + id,
            data: {
                bookName : bookN,
                deliveryDate : deliveryd,
                deletingDate: deletingd

            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromDeliveryNDeleting = function del(id) {
        $http.get('/deliveryndeleting/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

