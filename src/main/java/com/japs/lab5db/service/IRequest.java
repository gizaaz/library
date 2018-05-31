package com.japs.lab5db.service;

import com.japs.lab5db.model.*;

import java.time.LocalDate;
import java.util.List;

public interface IRequest {
    List<Book> selectShelfNumberAndVisitingDateFromBook(int shelfNumber, LocalDate date1, LocalDate date2);
    List<Students> selectStudentsFacultyWhereFaculty(String faculty);
    List<Students> selectStudentsWhereStudentsGroupNumber(int groupNumber);
    List<Scientist> selectScientistWhereOrganization(String organizationName);
    List<Readers> selectReadersWhereDate();
    List<Readers>selectReadersLibrarian(String librarianName);
    List<Readers>selectReadersLibrarianAndDate(String librarianName,LocalDate firstDate,LocalDate secondDate);
    List<Book>selectDelivery(LocalDate date1, LocalDate date2);
    List<Book>selectDelete(LocalDate date1, LocalDate date2);
    List<Librarian> selectLibrarians(int hallNumber,int libraryNumber);
    List<Readers>selectAbsentReaders(LocalDate date1, LocalDate date2);
    List<Book>selectNumber(String containmentOfABook);
    List<Book>selectNumberYear(int bookYear);
    List<AmountBook>selectAmountBook();
    List<Book>selectBookSelectAll();
    List<Book>selectGenreSelector(String bookGenre);
    List<Book>selectAuthor(String bookAuthor);











}
