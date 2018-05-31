package com.japs.lab5db.repository;

import com.japs.lab5db.model.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReadersRepository extends JpaRepository<Readers,Integer> {
    @Query("Select readers From Readers readers " +
            "inner join LibraryItself libr on readers.idReaders=libr.idLibraryItself"+
            " where libr.issuingDate > libr.visitingDate ")
    List<Readers> selectReadersWhereDate();

    @Query("Select readers From Readers readers " +
            " join LibraryItself libr on readers.idReaders=libr.idLibraryItself"+
            " join Librarian libra on libr.idLibraryItself=libra.idLibrarian"+
            " where libra.librarianName Like:librarianName")
    List<Readers> selectReadersLibrarian(@Param("librarianName") String librarianName);

    @Query("Select readers From Readers readers " +
            " join LibraryItself libr on readers.idReaders=libr.idLibraryItself"+
            " join Librarian libra on libr.idLibraryItself=libra.idLibrarian"+
            " where libra.librarianName Like:librarianName And libr.visitingDate between :date1 and :date2")
    List<Readers> selectReadersLibrarianAndDate(@Param("librarianName") String librarianName,@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);

    @Query("Select readers From Readers readers " +
            " join LibraryItself libr on readers.idReaders=libr.idLibraryItself"+
            " where libr.visitingDate not  between :date1 and :date2")
    List<Readers> selectAbsentReaders(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);





}
