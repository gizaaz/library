package com.japs.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @Column(name = "containment_ofabook")
    private String containmentOfABook;

    @Column(name = "book_edition")
    private String bookEdition;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_year")
    private int bookYear;

    @Column(name = "book_genre")
    private String bookGenre;

    @Column(name = "book_type")
    private String bookType;

    @Column(name = "inventory_number")
    private int inventoryNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "librarian_id_librarian", insertable = false, updatable = false)
    private Librarian librarian;

    @Column(name = "librarian_id_librarian")
    private Integer librarian_idLibrarian;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deliveryndeleting_id_deliveryn_deleting", insertable = false, updatable = false)
    private DeliveryNDeleting deliveryndeleting;

    @Column(name = "deliveryndeleting_id_deliveryn_deleting")
    private int deliveryndeleting_idDeliveryNDeleting;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storageplace_id_storage_place", insertable = false, updatable = false)
    private StoragePlace storageplace;

    @Column(name = "storageplace_id_storage_place")
    private int storageplace_idStoragePlace;

    public Book() {

    }

    public Book(String containmentOfABook, String bookEdition, String bookAuthor, int bookYear, String bookGenre, String bookType, int inventoryNumber, Librarian librarian, Integer librarian_idLibrarian, DeliveryNDeleting deliveryndeleting, int deliveryndeleting_idDeliveryNDeleting, StoragePlace storageplace, int storageplace_idStoragePlace) {
        this.containmentOfABook = containmentOfABook;
        this.bookEdition = bookEdition;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookGenre = bookGenre;
        this.bookType = bookType;
        this.inventoryNumber = inventoryNumber;
        this.librarian = librarian;
        this.librarian_idLibrarian = librarian_idLibrarian;
        this.deliveryndeleting = deliveryndeleting;
        this.deliveryndeleting_idDeliveryNDeleting = deliveryndeleting_idDeliveryNDeleting;
        this.storageplace = storageplace;
        this.storageplace_idStoragePlace = storageplace_idStoragePlace;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getContainmentOfABook() {
        return containmentOfABook;
    }

    public void setContainmentOfABook(String containmentOfABook) {
        this.containmentOfABook = containmentOfABook;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Integer getLibrarian_idLibrarian() {
        return librarian_idLibrarian;
    }

    public void setLibrarian_idLibrarian(Integer librarian_idLibrarian) {
        this.librarian_idLibrarian = librarian_idLibrarian;
    }

    public DeliveryNDeleting getDeliveryndeleting() {
        return deliveryndeleting;
    }

    public void setDeliveryndeleting(DeliveryNDeleting deliveryndeleting) {
        this.deliveryndeleting = deliveryndeleting;
    }

    public int getDeliveryndeleting_idDeliveryNDeleting() {
        return deliveryndeleting_idDeliveryNDeleting;
    }

    public void setDeliveryndeleting_idDeliveryNDeleting(int deliveryndeleting_idDeliveryNDeleting) {
        this.deliveryndeleting_idDeliveryNDeleting = deliveryndeleting_idDeliveryNDeleting;
    }

    public StoragePlace getStorageplace() {
        return storageplace;
    }

    public void setStorageplace(StoragePlace storageplace) {
        this.storageplace = storageplace;
    }

    public int getStorageplace_idStoragePlace() {
        return storageplace_idStoragePlace;
    }

    public void setStorageplace_idStoragePlace(int storageplace_idStoragePlace) {
        this.storageplace_idStoragePlace = storageplace_idStoragePlace;
    }
}

