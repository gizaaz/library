package com.japs.lab5db.controller;

import com.japs.lab5db.model.*;
import com.japs.lab5db.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping("/request7")
    List<Book> selectShelfNumberAndVisitingDateFromBook(@RequestParam int shelfNumber,
                                                        @RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate, @RequestParam(value = "secondDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.selectShelfNumberAndVisitingDateFromBook(shelfNumber, firstDate, secondDate);

    }

    @RequestMapping("/request1")
    List<Students> selectStudentsWhereStudentsFaculty(@RequestParam String faculty) {
        return requestService.selectStudentsFacultyWhereFaculty(faculty);
    }

    @RequestMapping("/request2")
    List<Students> selectStudentsWhereStudentsGroupNumber(@RequestParam int groupNumber) {
        return requestService.selectStudentsWhereStudentsGroupNumber(groupNumber);
    }

    @RequestMapping("/request3")
    List<Scientist> selectScientistWhereOrganization(@RequestParam String organizationName) {
        return requestService.selectScientistWhereOrganization(organizationName);
    }

    @RequestMapping("/request8")
    List<Readers> selectReadersWhereDate() {
        return requestService.selectReadersWhereDate();
    }

    @RequestMapping("/request9")
    List<Readers> selectReadersLibrarian(@RequestParam String librarianName) {
        return requestService.selectReadersLibrarian(librarianName);
    }

    @RequestMapping("/request10")
    List<Readers> selectReadersLibrarianAndDate(@RequestParam String librarianName, @RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate, @RequestParam(value = "secondDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.selectReadersLibrarianAndDate(librarianName, firstDate, secondDate);
    }

    @RequestMapping("/request11")
    List<Book> selectDelivery(@RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate, @RequestParam(value = "secondDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.selectDelivery(firstDate, secondDate);
    }

    @RequestMapping("/request12")
    List<Book> selectDelete(@RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate, @RequestParam(value = "secondDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.selectDelivery(firstDate, secondDate);
    }

    @RequestMapping("/request13")
    List<Librarian> selectLibrarians(@RequestParam int hallNumber, @RequestParam int libraryNumber) {
        return requestService.selectLibrarians(hallNumber, libraryNumber);
    }

    @RequestMapping("/request14")
    List<Readers>     selectAbsentReaders( @RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate, @RequestParam(value = "secondDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.selectAbsentReaders(firstDate, secondDate);
    }
    @RequestMapping("/request15")
    List<Book>     selectNumber(@RequestParam String containmentOfABook){
    return requestService.selectNumber(containmentOfABook);
    }
    @RequestMapping("/request16")
    List<Book>     selectNumberYear(@RequestParam int bookYear){
        return requestService.selectNumberYear(bookYear);
    }
    @RequestMapping("/request17")
    List<Book>     selectAuthor(@RequestParam String bookAuthor){
        return requestService.selectAuthor(bookAuthor);
    }

    @RequestMapping("/request20")
    List<AmountBook> selectAmountBook(){

        return requestService.selectAmountBook();
    }
    @RequestMapping("/requestAll")
    List<Book> selectBookSelectAll(){

        return requestService.selectBookSelectAll();
    }
    @RequestMapping("/request18")
    List<Book> selectGenreSelector(String bookGenre){

        return requestService.selectGenreSelector(bookGenre);
    }



}






