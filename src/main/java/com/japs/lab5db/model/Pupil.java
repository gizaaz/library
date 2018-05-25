package com.japs.lab5db.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
    @Table(name = "pupil")
    @EntityListeners(AuditingEntityListener.class)
    public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pupil")
    private int idPupil;

    @Column(name = "pupil_name")
    private String pupilName;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "grade")
    private int grade;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "readers_id_readers", insertable = false, updatable = false)
    private Readers readers;

    @Column(name = "readers_id_readers")
    private int readers_idReaders;

    public Pupil() {
    }

    public Pupil(String pupilName, String schoolName, int grade, Readers readers, int readers_idReaders) {
        this.pupilName = pupilName;
        this.schoolName = schoolName;
        this.grade = grade;
        this.readers = readers;
        this.readers_idReaders = readers_idReaders;
    }

    public int getIdPupil() {
        return idPupil;
    }

    public void setIdPupil(int idPupil) {
        this.idPupil = idPupil;
    }

    public String getPupilName() {
        return pupilName;
    }

    public void setPupilName(String pupilName) {
        this.pupilName = pupilName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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


