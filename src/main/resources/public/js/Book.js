var App = angular.module('App',[]);

App.controller('Book',function ($http,$scope) {
    $http.get('/book/get').then(function (response){
        $scope.book=response.data;
        console.log(response);
    });

    this.startInsertBook = function startUpdate() {
        $http.get('/deliveryndeleting/get').then(function (response) {
            var deliveryndeleting = response.data;
            var selector = document.getElementById("DNDBookName");
            $(selector).empty();
            for (var i = 0; i < deliveryndeleting.length; i++) {
                var option = document.createElement("option");
                option.text = deliveryndeleting[i].bookName;
                option.value = deliveryndeleting[i].idDeliveryNDeleting;
                selector.add(option);

            }
        });

        $http.get('/storageplace/get').then(function (response) {
            var storageplace = response.data;
            var selector = document.getElementById("StoragePlace");
            $(selector).empty();
            for (var i = 0; i < storageplace.length; i++) {
                var option = document.createElement("option");
                option.text = storageplace[i].idStoragePlace;
                option.value = storageplace[i].idStoragePlace;
                selector.add(option);

            }
        });

        $http.get('/librarian/get').then(function (response) {
            var librarian = response.data;
            var selector = document.getElementById("LibrarianName");
            $(selector).empty();
            for (var i = 0; i < librarian.length; i++) {
                var option = document.createElement("option");
                option.text = librarian[i].librarianName;
                option.value = librarian[i].idLibrarian;
                selector.add(option);

            }
        });

    };


    this.insertToBook = function add() {
        var containmentOfABook = document.getElementById("ContainmentOfABook").value;
        var bookEdition = document.getElementById("BookEdition").value;
        var bookAuthor = document.getElementById("BookAuthor").value;
        var bookYear = document.getElementById("BookYear").value;
        var bookGenre = document.getElementById("BookGenre").value;
        var bookType = document.getElementById("BookType").value;
        var inventoryNumber = document.getElementById("InventoryNumber").value;

        var indexDeliveryAndDeleting = document.getElementById("DNDBookName").selectedIndex;
        var deliveryAndDeleting_id = document.getElementById("DNDBookName").options[indexDeliveryAndDeleting].value;

        var indexStoragePlace = document.getElementById("StoragePlace").selectedIndex;
        var storagePlace_id = document.getElementById("StoragePlace").options[indexStoragePlace].value;

        var indexLibrarianName = document.getElementById("LibrarianName").selectedIndex;
        var librarianName_id = document.getElementById("LibrarianName").options[indexLibrarianName].value;



        var req = {
            method: 'POST',
            url: '/book/insert',
            data: {
                containmentOfABook:containmentOfABook,
                bookEdition:bookEdition,
                bookAuthor:bookAuthor,
                bookYear:bookYear,
                bookGenre:bookGenre,
                bookType:bookType,
                deliveryndeleting_idDeliveryNDeleting:deliveryAndDeleting_id,
                storageplace_idStoragePlace:storagePlace_id,
                librarian_idLibrarian:librarianName_id,
                inventoryNumber:inventoryNumber

            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.startUpdateBook = function startUpdate(idBook,containmentOfABook,bookEdition,bookAuthor,bookYear,bookGenre,bookType,deliveryndeleting,storageplace,librarian,inventorynumber) {
        document.getElementById("BookIdUPD").value = idBook;
        document.getElementById("ContainmentOfABookUPD").value = containmentOfABook;
        document.getElementById("BookEditionUPD").value = bookEdition;
        document.getElementById("BookAuthorUPD").value = bookAuthor;
        document.getElementById("BookYearUPD").value = bookYear;
        document.getElementById("BookGenreUPD").value = bookGenre;
        document.getElementById("BookTypeUPD").value = bookType;
        document.getElementById("InventoryNumberUPD").value = inventorynumber;

        $http.get('/deliveryndeleting/get').then(function (response) {
            var deliveryndeletings = response.data;
            var selector = document.getElementById("DNDBookNameUPD");
            $(selector).empty();
            for (var i = 0; i < deliveryndeletings.length; i++) {
                var option = document.createElement("option");
                if (deliveryndeletings[i].idDeliveryNDeleting == deliveryndeleting){
                    option.selected = 'selected';
                }
                option.text = deliveryndeletings[i].bookName;
                option.value = deliveryndeletings[i].idDeliveryNDeleting;
                selector.add(option);

            }
        });

        $http.get('/storageplace/get').then(function (response) {
            var storageplaces = response.data;
            var selector = document.getElementById("StoragePlaceUPD");
            $(selector).empty();
            for (var i = 0; i < storageplaces.length; i++) {
                var option = document.createElement("option");
                if (storageplaces[i].idStoragePlace == storageplace){
                    option.selected = 'selected';
                }
                option.text = storageplaces[i].idStoragePlace;
                option.value = storageplaces[i].idStoragePlace;
                selector.add(option);

            }
        });

        $http.get('/librarian/get').then(function (response) {
            var librarians = response.data;
            var selector = document.getElementById("LibrarianNameUPD");
            $(selector).empty();
            for (var i = 0; i < librarians.length; i++) {
                var option = document.createElement("option");
                if (librarians[i].idLibrarians == librarian){
                    option.selected = 'selected';
                }
                option.text = librarians[i].librarianName;
                option.value = librarians[i].idLibrarian;
                selector.add(option);

            }
        });



    };

    this.updateBook = function update() {
        var id = document.getElementById("BookIdUPD").value;
        var containmentOfABook = document.getElementById("ContainmentOfABookUPD").value;
        var bookEdition = document.getElementById("BookEditionUPD").value;
        var bookAuthor = document.getElementById("BookAuthorUPD").value;
        var bookYear = document.getElementById("BookYearUPD").value;
        var bookGenre = document.getElementById("BookGenreUPD").value;
        var bookType = document.getElementById("BookTypeUPD").value;
        var inventoryNumber = document.getElementById("InventoryNumberUPD").value;

        var indexDeliveryAndDeleting = document.getElementById("DNDBookNameUPD").selectedIndex;
        var deliveryAndDeleting_id = document.getElementById("DNDBookNameUPD").options[indexDeliveryAndDeleting].value;

        var indexStoragePlace = document.getElementById("StoragePlaceUPD").selectedIndex;
        var storagePlace_id = document.getElementById("StoragePlaceUPD").options[indexStoragePlace].value;

        var indexLibrarianName = document.getElementById("LibrarianNameUPD").selectedIndex;
        var librarianName_id = document.getElementById("LibrarianNameUPD").options[indexLibrarianName].value;


        var req = {
            method: 'POST',
            url: '/book/update?id=' + id,
            data: {
                containmentOfABook:containmentOfABook,
                bookEdition:bookEdition,
                bookAuthor:bookAuthor,
                bookYear:bookYear,
                bookGenre:bookGenre,
                bookType:bookType,
                deliveryndeleting_idDeliveryNDeleting:deliveryAndDeleting_id,
                storageplace_idStoragePlace:storagePlace_id,
                librarian_idLibrarian:librarianName_id,
                inventoryNumber:inventoryNumber

            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.delFromBook = function del(id) {
        $http.get('/book/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

