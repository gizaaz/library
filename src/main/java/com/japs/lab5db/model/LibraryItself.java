package com.japs.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
    @Table(name = "libraryitself")
    @EntityListeners(AuditingEntityListener.class)
    public class LibraryItself {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_libraryitself")
        private int idLibraryItself;

        @Column(name = "visiting_date")
        private LocalDate visitingDate;

        @Column(name = "issuing_date")
        private LocalDate issuingDate;

        @Column(name = "time")
        private int time;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "readers_id_readers", insertable = false, updatable = false)
        private Readers readers;

        @Column(name = "readers_id_readers")
        private int readers_idReaders;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "book_id_book", insertable = false, updatable = false)
        private Book book;

        @Column(name = "book_id_book")
        private int book_idBook;

        public LibraryItself(){}

    public LibraryItself(LocalDate visitingDate, LocalDate issuingDate, int time, Readers readers, int readers_idReaders, Book book, int book_idBook) {
        this.visitingDate = visitingDate;
        this.issuingDate = issuingDate;
        this.time = time;
        this.readers = readers;
        this.readers_idReaders = readers_idReaders;
        this.book = book;
        this.book_idBook = book_idBook;
    }


    public int getIdLibraryItself() {
        return idLibraryItself;
    }

    public void setIdLibraryItself(int idLibraryItself) {
        this.idLibraryItself = idLibraryItself;
    }

    public LocalDate getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(LocalDate visitingDate) {
        this.visitingDate = visitingDate;
    }

    public LocalDate getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(LocalDate issuingDate) {
        this.issuingDate = issuingDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Readers getReaders() {
        return readers;
    }

    public void setReaders(Readers readers) {
        this.readers = readers;
    }

    public int getReaders_idReaders() {
        return readers_idReaders;
    }

    public void setReaders_idReaders(int readers_idReaders) {
        this.readers_idReaders = readers_idReaders;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBook_idBook() {
        return book_idBook;
    }

    public void setBook_idBook(int book_idBook) {
        this.book_idBook = book_idBook;
    }
}