package com.example.demo.Models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by student on 6/29/17.
 */
public interface EducationRepository extends CrudRepository<Education, Integer> {

    Education findAllByCollege(String college);

    @Query(value = "select education.college from education;", nativeQuery = true)
    public Iterable<Integer>findById(@Param("college") String college);

}




