package com.japs.lab5db.repository;

import com.japs.lab5db.model.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadersRepository extends JpaRepository<Readers,Integer> {

}
