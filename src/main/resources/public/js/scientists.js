var App = angular.module('App',[]);

App.controller('Scientist',function ($http,$scope) {
    var time = performance.now();
    $http.get('/scientist/get').then(function (response){
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.scientist=response.data;
        console.log(response);
    });

    this.startInsertScientist = function startUpdate() {
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



    this.insertToScientist = function add() {
        var scientistn = document.getElementById("ScientistName").value;
        var orgn = document.getElementById("OrganizationName").value;
        var scnl = document.getElementById("ScientificLevel").value;
        var topic = document.getElementById("Topic").value;

        var indexReaders = document.getElementById("Readers").selectedIndex;
        var Readers_id = document.getElementById("Readers").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/scientist/insert',
            data: {
                scientistName:scientistn,
                organizationName:orgn,
                scientificLevel:scnl,
                topic:topic,
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

    this.startUpdateScientist = function startUpdate(idScientist,scientistname,organizationname,scientificlevel,topic,readers) {
        document.getElementById("ScientistIdUPD").value = idScientist;
        document.getElementById("ScientistNameUPD").value = scientistname;
        document.getElementById("OrganizationNameUPD").value = organizationname;
        document.getElementById("ScientificLevelUPD").value = scientificlevel;
        document.getElementById("TopicUPD").value = topic;




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

    this.updateScientist = function update() {
        var id = document.getElementById("ScientistIdUPD").value;
        var scientistn = document.getElementById("ScientistNameUPD").value;
        var orgn = document.getElementById("OrganizationNameUPD").value;
        var scnl = document.getElementById("ScientificLevelUPD").value;
        var topic = document.getElementById("TopicUPD").value;


        var indexReaders = document.getElementById("ReadersUPD").selectedIndex;
        var Readers_id = document.getElementById("ReadersUPD").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/scientist/update?id=' + id,
            data: {
                scientistName:scientistn,
                organizationName:orgn,
                scientificLevel:scnl,
                topic:topic,
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

    this.delFromScientist = function del(id) {
        var time = performance.now();
        $http.get('/scientist/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

