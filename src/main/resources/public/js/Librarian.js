var App = angular.module('App',[]);

App.controller('Librarian',function ($http,$scope) {
    $http.get('/librarian/get').then(function (response){
        $scope.librarian=response.data;
      //  
    });
    this.insertToLibrarian = function add() {
        var name = document.getElementById("LibrarianName").value;
        var time1 = document.getElementById("TimeOfVisit").value;
        var halln = document.getElementById("HallNumber").value;
        var libn = document.getElementById("LibraryNumber").value;

        var req = {
            method: 'POST',
            url: '/librarian/insert',
            data: {
                librarianName: name,
                timeOfVisit: time1,
                hallNumber:halln,
                libraryNumber:libn
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.startUpdateLibrarian = function startUpdate(idLibrarian,LibrarianName,TimeOfVisit,HallNumber,LibraryNumber) {
        document.getElementById("LibraryIdUPD").value = idLibrarian;
        document.getElementById("TimeOfVisitUPD").value = TimeOfVisit;
        document.getElementById("LibrarianNameUPD").value = LibrarianName;
        document.getElementById("LibraryNumberUPD").value = LibraryNumber;
        document.getElementById("HallNumberUPD").value = HallNumber;

    };

    this.updateLibrarian = function update() {
        var id = document.getElementById("LibraryIdUPD").value;
        var halln = document.getElementById("HallNumberUPD").value
        var time1 = document.getElementById("TimeOfVisitUPD").value;
        var name = document.getElementById("LibrarianNameUPD").value;
        var libn = document.getElementById("LibraryNumberUPD").value;

        var req = {
            method: 'POST',
            url: '/librarian/update?id=' + id,
            data: {
                librarianName: name,
                timeOfVisit: time1,
                hallNumber:halln,
                libraryNumber:libn

            }
        };
        //console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromLibrarian = function del(id) {
        $http.get('/librarian/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

