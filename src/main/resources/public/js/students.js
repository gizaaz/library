var App = angular.module('App',[]);

App.controller('Students',function ($http,$scope) {
    $http.get('/students/get').then(function (response){
        $scope.students=response.data;
        
    });

    this.startInsertStudents = function startUpdate() {
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



    this.insertToStudents = function add() {
        var studentsn = document.getElementById("StudentsName").value;
        var edpln = document.getElementById("EducationalPlaceName").value;
        var faculty = document.getElementById("Faculty").value;
        var groupn = document.getElementById("GroupNumber").value;

        var indexReaders = document.getElementById("Readers").selectedIndex;
        var Readers_id = document.getElementById("Readers").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/students/insert',
            data: {
                studentName:studentsn,
                educationalPlaceName:edpln,
                faculty:faculty,
                groupNumber:groupn,
                readers_idReaders:Readers_id
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.startUpdateStudents = function startUpdate(idStudents,studentsname,educationalPlaceName,faculty,group,readers) {
        document.getElementById("StudentsIdUPD").value = idStudents;
        document.getElementById("StudentsNameUPD").value = studentsname;
        document.getElementById("EducationalPlaceNameUPD").value = educationalPlaceName;
        document.getElementById("FacultyUPD").value = faculty;
        document.getElementById("GroupNumberUPD").value = group;





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

    this.updateStudents = function update() {
        var id = document.getElementById("StudentsIdUPD").value;
        var studentsn = document.getElementById("StudentsNameUPD").value;
        var edpln = document.getElementById("EducationalPlaceNameUPD").value;
        var faculty = document.getElementById("FacultyUPD").value;
        var group = document.getElementById("GroupNumberUPD").value;


        var indexReaders = document.getElementById("ReadersUPD").selectedIndex;
        var Readers_id = document.getElementById("ReadersUPD").options[indexReaders].value;

        var req = {
            method: 'POST',
            url: '/students/update?id=' + id,
            data: {
                studentName:studentsn,
                educationalPlaceName:edpln,
                faculty:faculty,
                groupNumber:group,
                readers_idReaders:Readers_id
            }
        };
        //console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromStudents = function del(id) {
        $http.get('/students/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

