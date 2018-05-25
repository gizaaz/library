package com.japs.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "storageplace")
    @EntityListeners(AuditingEntityListener.class)
    public class StoragePlace {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id_storagePlace")
        private int idStoragePlace;

        @Column(name = "hall_number")
        private int hallNumber;

        @Column(name = "rack_number")
        private int rackNumber;

        @Column(name = "shelf_number")
        private int shelfNumber;

        public StoragePlace() {
        }

        public StoragePlace(int hallNumber, int rackNumber, int shelfNumber) {
            this.hallNumber = hallNumber;
            this.rackNumber = rackNumber;
            this.shelfNumber = shelfNumber;
        }

        public int getIdStoragePlace() {
            return idStoragePlace;
        }

        public void setIdStoragePlace(int idStoragePlace) {
            this.idStoragePlace = idStoragePlace;
        }

        public int getHallNumber() {
            return hallNumber;
        }

        public void setHallNumber(int hallNumber) {
            this.hallNumber = hallNumber;
        }

        public int getRackNumber() {
            return rackNumber;
        }

        public void setRackNumber(int rackNumber) {
            this.rackNumber = rackNumber;
        }

        public int getShelfNumber() {
            return shelfNumber;
        }

        public void setShelfNumber(int shelfNumber) {
            this.shelfNumber = shelfNumber;
        }



   /*

    spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/lab5db
spring.datasource.username=root
spring.datasource.password=root
    */
    }

