package com.japs.lab5db.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

    @Entity
    @Table(name = "students")
    @EntityListeners(AuditingEntityListener.class)
    public class Students {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_students")
        private int idStudents;

        @Column(name = "student_name")
        private String studentName;

        @Column(name = "educational_place_name")
        private String educationalPlaceName;

        @Column(name = "faculty")
        private String faculty;

        @Column(name = "group_number")
        private int groupNumber;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "readers_id_readers", insertable = false, updatable = false)
        private Readers readers;

        @Column(name = "readers_id_readers")
        private int readers_idReaders;
        public Students(){}

        public Students(String studentName, String educationalPlaceName, String faculty, int groupNumber, Readers readers, int readers_idReaders) {
            this.studentName = studentName;
            this.educationalPlaceName = educationalPlaceName;
            this.faculty = faculty;
            this.groupNumber = groupNumber;
            this.readers = readers;
            this.readers_idReaders = readers_idReaders;
        }

        public int getIdStudents() {
            return idStudents;
        }

        public void setIdStudents(int idStudents) {
            this.idStudents = idStudents;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getEducationalPlaceName() {
            return educationalPlaceName;
        }

        public void setEducationalPlaceName(String educationalPlaceName) {
            this.educationalPlaceName = educationalPlaceName;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public int getGroupNumber() {
            return groupNumber;
        }

        public void setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
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





