package com.japs.lab5db.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

    @Entity
    @Table(name = "scientist")
    @EntityListeners(AuditingEntityListener.class)
    public class Scientist {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_scientist")
        private int idScientist;

        @Column(name = "scientist_name")
        private String scientistName;

        @Column(name = "scientific_level")
        private String scientificLevel;

        @Column(name = "organization_name")
        private String organizationName;

        @Column(name = "topic")
        private String topic;


        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "readers_id_readers", insertable = false, updatable = false)
        private Readers readers;

        @Column(name = "readers_id_readers")
        private int readers_idReaders;

        public Scientist(String scientistName, String scientificLevel, String organizationName, String topic, Readers readers, int readers_idReaders) {
            this.scientistName = scientistName;
            this.scientificLevel = scientificLevel;
            this.organizationName = organizationName;
            this.topic = topic;
            this.readers = readers;
            this.readers_idReaders = readers_idReaders;
        }

        public Scientist() {
        }

        public int getIdScientist() {
            return idScientist;
        }

        public void setIdScientist(int idScientist) {
            this.idScientist = idScientist;
        }

        public String getScientistName() {
            return scientistName;
        }

        public void setScientistName(String scientistName) {
            this.scientistName = scientistName;
        }

        public String getScientificLevel() {
            return scientificLevel;
        }

        public void setScientificLevel(String scientificLevel) {
            this.scientificLevel = scientificLevel;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
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
    }
