var App = angular.module('App',[]);

App.controller('LibraryItself',function ($http,$scope) {
    $http.get('/libraryitself/get').then(function (response){
        $scope.libraryitself=response.data;
        
    });

    this.startInsertLibraryItself = function startUpdate() {
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

        $http.get('/book/get').then(function (response) {
            var book = response.data;
            var selector = document.getElementById("Book");
            $(selector).empty();
            for (var i = 0; i < book.length; i++) {
                var option = document.createElement("option");
                option.text = book[i].containmentOfABook;
                option.value = book[i].idBook;
                selector.add(option);

            }
        });


    };



    this.insertToLibraryItself = function add() {
        var visdate = document.getElementById("VisitingDate").value;
        var isdate = document.getElementById("IssuingDate").value;
        var time = document.getElementById("Time").value;

        var indexReaders = document.getElementById("Readers").selectedIndex;
        var Readers_id = document.getElementById("Readers").options[indexReaders].value;

        var indexBook = document.getElementById("Book").selectedIndex;
        var Book_id = document.getElementById("Book").options[indexBook].value;

        var req = {
            method: 'POST',
            url: '/libraryitself/insert',
            data: {
                visitingDate:visdate,
                issuingDate:isdate,
                time:time,
                readers_idReaders:Readers_id,
                book_idBook:Book_id

            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.startUpdateLibraryItself = function startUpdate(idLibraryItself,visitingDate,issuingDate,time,readers,book) {
        document.getElementById("LibraryItselfIdUPD").value = idLibraryItself;
        document.getElementById("VisitingDateUPD").value = visitingDate;
        document.getElementById("IssuingDateUPD").value = issuingDate;
        document.getElementById("TimeUPD").value = time;



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
        $http.get('/book/get').then(function (response) {
            var books = response.data;
            var selector = document.getElementById("BookUPD");
            $(selector).empty();
            for (var i = 0; i < books.length; i++) {
                var option = document.createElement("option");
                if (books[i].containmentOfABook == book){
                    option.selected = 'selected';
                }
                option.text = books[i].containmentOfABook;
                option.value = books[i].idBook;
                selector.add(option);

            }
        });


    };

    this.updateLibraryItself = function update() {
        var id = document.getElementById("LibraryItselfIdUPD").value;
        var visDate = document.getElementById("VisitingDateUPD").value;
        var isDate = document.getElementById("IssuingDateUPD").value;
        var time = document.getElementById("TimeUPD").value;

        var indexReaders = document.getElementById("ReadersUPD").selectedIndex;
        var Readers_id = document.getElementById("ReadersUPD").options[indexReaders].value;

        var indexBook = document.getElementById("BookUPD").selectedIndex;
        var Book_id = document.getElementById("BookUPD").options[indexBook].value;

        var req = {
            method: 'POST',
            url: '/libraryitself/update?id=' + id,
            data: {
                visitingDate:visDate,
                issuingDate:isDate,
                time:time,
                readers_idReaders:Readers_id,
                book_idBook:Book_id


            }
        };
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromLibraryItself = function del(id) {
        $http.get('/libraryitself/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

