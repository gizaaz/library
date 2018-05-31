package com.japs.lab5db.repository;

import com.japs.lab5db.model.Scientist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScientistRepository extends JpaRepository<Scientist,Integer> {
    @Query("Select scientist From Scientist scientist " +
            " where scientist.organizationName Like:organizationName")
    List<Scientist> selectScientistWhereOrganization(@Param("organizationName") String organizationName);


}
