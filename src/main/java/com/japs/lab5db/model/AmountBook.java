package com.japs.lab5db.model;

public class AmountBook {
    long amount;
    Book book;


    public AmountBook(long amount, Book book) {
        this.amount = amount;
        this.book = book;
    }

    public AmountBook() {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}