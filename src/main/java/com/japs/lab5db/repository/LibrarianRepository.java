package com.japs.lab5db.repository;

import com.japs.lab5db.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
    @Query("Select librarian From Librarian librarian " +
            " where librarian.hallNumber Like:hallNumber and librarian.libraryNumber Like:libraryNumber")
    List<Librarian> selectLibrarians(@Param("hallNumber") int hallNumber,@Param("libraryNumber") int libraryNumber);
}
