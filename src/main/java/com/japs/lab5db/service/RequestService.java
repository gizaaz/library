package com.japs.lab5db.service;

import com.japs.lab5db.model.*;
import com.japs.lab5db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class RequestService implements IRequest {
    @Autowired
    LibrarianRepository librarianRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    ScientistRepository scientistRepository;
    @Autowired
    ReadersRepository readersRepository;
    @Autowired
    LibraryItselfRepository libraryItselfRepository;

    @Override
    public List<Book> selectShelfNumberAndVisitingDateFromBook(int shelfNumber, LocalDate date1, LocalDate date2) {
        return bookRepository.selectShelfNumberAndVisitingDateFromBook(shelfNumber, date1, date2);
    }

    @Override
    public List<Students> selectStudentsFacultyWhereFaculty(String faculty) {
        return studentsRepository.selectStudentsFacultyWhereFaculty(faculty);
    }

    @Override
    public List<Students> selectStudentsWhereStudentsGroupNumber(int groupNumber) {
        return studentsRepository.selectStudentsWhereStudentsGroupNumber(groupNumber);
    }

    @Override
    public List<Scientist> selectScientistWhereOrganization(String organizationName) {
        return scientistRepository.selectScientistWhereOrganization(organizationName);
    }

    @Override
    public List<Readers> selectReadersWhereDate() {
        return readersRepository.selectReadersWhereDate();
    }

    @Override
    public List<Readers> selectReadersLibrarian(String librarianName) {

        return readersRepository.selectReadersLibrarian(librarianName);
    }

    @Override
    public List<Readers> selectReadersLibrarianAndDate(String librarianName, LocalDate firstDate, LocalDate secondDate) {

        return readersRepository.selectReadersLibrarianAndDate(librarianName, firstDate, secondDate);
    }

    @Override
    public List<Book> selectDelivery(LocalDate date1, LocalDate date2) {

        return bookRepository.selectDelivery(date1, date2);
    }

    @Override
    public List<Book> selectDelete(LocalDate date1, LocalDate date2) {

        return bookRepository.selectDelivery(date1, date2);
    }

    @Override
    public List<Librarian> selectLibrarians(int hallNumber, int libraryNumber) {

        return librarianRepository.selectLibrarians(hallNumber, libraryNumber);
    }

    @Override
    public List<Readers> selectAbsentReaders(LocalDate date1, LocalDate date2) {

        return readersRepository.selectAbsentReaders(date1, date2);

    }
    @Override
    public List<Book> selectNumber(String containmentOfABook) {

        return bookRepository.selectNumber(containmentOfABook);

    }
    @Override
    public List<Book> selectNumberYear(int bookYear) {

        return bookRepository.selectNumberYear(bookYear);

    }


    public List<AmountBook> selectAmountBook() {
        List<Book> books = bookRepository.selectBooks();
        List<Long> amount = bookRepository.selectAmount();
        List<AmountBook>list = new ArrayList<>();
        for (int i = 0; i < (amount.size()+1)/2 ; i++) {
            list.add(new AmountBook(amount.get(i),books.get(i)));
        }
        return list;
    }
    @Override
    public List<Book> selectBookSelectAll() {

        return bookRepository.selectBookSelectAll();

    }
    @Override
    public List<Book> selectGenreSelector(String bookGenre) {

        return bookRepository.selectGenreSelector(bookGenre);

    }
    @Override
    public List<Book> selectAuthor(String bookAuthor) {

        return bookRepository.selectAuthor(bookAuthor);

    }




}
