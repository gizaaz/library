package com.japs.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "librarian")
@EntityListeners(AuditingEntityListener.class)
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_librarian")
    private int idLibrarian;

    @Column(name = "librarian_name")
    private String librarianName;

    @Column(name = "time_of_visit")
    private LocalDate timeOfVisit;

    @Column(name = "hall_number")
    private int hallNumber;

    @Column(name = "library_number")
    private int libraryNumber;

    @OneToMany(mappedBy = "librarian")
    private List<Book> books;

    public Librarian() {
    }

    public Librarian(String librarianName, LocalDate timeOfVisit, int hallNumber, int libraryNumber) {
        this.librarianName = librarianName;
        this.timeOfVisit = timeOfVisit;
        this.hallNumber = hallNumber;
        this.libraryNumber = libraryNumber;
    }

    public int getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(int idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public LocalDate getTimeOfVisit() {
        return timeOfVisit;
    }

    public void setTimeOfVisit(LocalDate timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(int libraryNumber) {
        this.libraryNumber = libraryNumber;
    }
}