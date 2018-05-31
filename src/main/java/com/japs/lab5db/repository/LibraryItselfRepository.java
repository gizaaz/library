package com.japs.lab5db.repository;

import com.japs.lab5db.model.LibraryItself;
import com.japs.lab5db.model.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryItselfRepository extends JpaRepository<LibraryItself,Integer> {

}
