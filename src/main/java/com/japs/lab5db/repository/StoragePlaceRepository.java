package com.japs.lab5db.repository;

import com.japs.lab5db.model.StoragePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoragePlaceRepository extends JpaRepository<StoragePlace,Integer>{
}
