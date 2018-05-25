package com.japs.lab5db.repository;

import com.japs.lab5db.model.LibraryItself;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryItselfRepository extends JpaRepository<LibraryItself,Integer> {
}
