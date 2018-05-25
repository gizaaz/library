package com.japs.lab5db.repository;

import com.japs.lab5db.model.Scientist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientistRepository extends JpaRepository<Scientist,Integer> {

}
