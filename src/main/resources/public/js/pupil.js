var App = angular.module('App',[]);

App.controller('Pupil',function ($http,$scope) {
    var time = performance.now();
    $http.get('/pupil/get').then(function (response){
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.pupil=response.data;
        console.log(response);
    });

    this.startInsertPupil = function startUpdate() {
        $http.get('/readers/get').then(function (response) {
            var readers = response.data;
            var selector = document.getElementById("Readers");
            $(selector).empty();
            for (var i = 0; i < readers.length; i++) {
                var option = document.createElement("option");
                option.text = readers[i].idReaders;
                option.value = readers[i].idReaders;
                selector.add(option);

            }
        });

    };



    this.insertToPupil = function add() {
        var pupiln = document.getElementById("PupilName").value;
        var schooln = document.getElementById("SchoolName").value;
        var grade = document.getElementById("Grade").value;

        var indexReaders = document.getElementById("Readers").selectedIndex;
        var Readers_id = document.getElementById("Readers").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/pupil/insert',
            data: {
                pupilName:pupiln,
                schoolName:schooln,
                grade:grade,
                readers_idReaders:Readers_id

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

    this.startUpdatePupil = function startUpdate(idPupil,pupilname,schoolname,grade,readers) {
        document.getElementById("PupilIdUPD").value = idPupil;
        document.getElementById("PupilNameUPD").value = pupilname;
        document.getElementById("SchoolNameUPD").value = schoolname;
        document.getElementById("GradeUPD").value = grade;



        $http.get('/readers/get').then(function (response) {
            var readerss = response.data;
            var selector = document.getElementById("ReadersUPD");
            $(selector).empty();
            for (var i = 0; i < readerss.length; i++) {
                var option = document.createElement("option");
                if (readerss[i].idReaders == readers){
                    option.selected = 'selected';
                }
                option.text = readerss[i].idReaders;
                option.value = readerss[i].idReaders;
                selector.add(option);

            }
        });



    };

    this.updatePupil = function update() {
        var id = document.getElementById("PupilIdUPD").value;
        var pupiln = document.getElementById("PupilNameUPD").value;
        var schooln = document.getElementById("SchoolNameUPD").value;
        var grade = document.getElementById("GradeUPD").value;

        var indexReaders = document.getElementById("ReadersUPD").selectedIndex;
        var Readers_id = document.getElementById("ReadersUPD").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/pupil/update?id=' + id,
            data: {
                pupilName:pupiln,
                schoolName:schooln,
                grade:grade,
                readers_idReaders:Readers_id
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

    this.delFromPupil = function del(id) {
        var time = performance.now();
        $http.get('/pupil/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

