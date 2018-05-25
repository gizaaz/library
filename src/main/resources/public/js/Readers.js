var App = angular.module('App',[]);

App.controller('Readers',function ($http,$scope) {
    var time = performance.now();
    $http.get('/readers/get').then(function (response){
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.readers=response.data;
        console.log(response);
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
            console.log(resp);
            time = performance.now() - time;
            console.log('Додавання новго запису = ', time);
            alert("-----");
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
        var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.delFromReaders = function del(id) {
        var time = performance.now();
        $http.get('/readers/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

