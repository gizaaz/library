package com.japs.lab5db.repository;

import com.japs.lab5db.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Integer> {
    @Query("Select students From Students students " +
            " where students.faculty Like:faculty")
    List<Students> selectStudentsFacultyWhereFaculty(@Param("faculty") String faculty);
    @Query("Select students From Students students " +
            " where students.groupNumber Like:groupNumber")
    List<Students> selectStudentsWhereStudentsGroupNumber(@Param("groupNumber") int groupNumber);


}
