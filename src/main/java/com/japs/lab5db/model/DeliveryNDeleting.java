package com.japs.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

    @Entity
    @Table(name = "deliveryndeleting")
    @EntityListeners(AuditingEntityListener.class)
    public class DeliveryNDeleting {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id_deliveryndeleting")
        private int idDeliveryNDeleting;

        @Column(name = "book_name")
        private String bookName;

        @Column(name = "delivery_date")
        private LocalDate deliveryDate;

        @Column(name = "deleting_date")
        private LocalDate deletingDate;

        public DeliveryNDeleting(){

        }

        public DeliveryNDeleting(String bookName, LocalDate deliveryDate, LocalDate deletingDate) {
            this.bookName = bookName;
            this.deliveryDate = deliveryDate;
            this.deletingDate = deletingDate;
        }

        public int getIdDeliveryNDeleting() {
            return idDeliveryNDeleting;
        }

        public void setIdDeliveryNDeleting(int idDeliveryNDeleting) {
            this.idDeliveryNDeleting = idDeliveryNDeleting;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public LocalDate getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public LocalDate getDeletingDate() {
            return deletingDate;
        }

        public void setDeletingDate(LocalDate deletingDate) {
            this.deletingDate = deletingDate;
        }


        ////
   /*

    spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/lab5db
spring.datasource.username=root
spring.datasource.password=root
    */
    }

