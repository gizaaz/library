var App = angular.module('App',[]);

App.controller('Readers',function ($http,$scope) {
    $http.get('/readers/get').then(function (response){
        $scope.readers=response.data;

    });


    this.insertToReaders = function add() {
        var prof = document.getElementById("Profession").value;

        var req = {
            method: 'POST',
            url: '/readers/insert',
            data: {
                profession: prof

            }
        };
        console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.startUpdateReaders = function startUpdate(idReaders,profession) {
        document.getElementById("ReadersIdUPD").value = idReaders;
        document.getElementById("ProfessionUPD").value = profession;


    };

    this.updateReaders = function update() {
       var id = document.getElementById("ReadersIdUPD").value;
       var prof = document.getElementById("ProfessionUPD").value;

        var req = {
            method: 'POST',
            url: '/readers/update?id=' + id,
            data: {
               profession:prof

            }
        };
        //console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromReaders = function del(id) {
        $http.get('/readers/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

