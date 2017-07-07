package com.example.demo.Models;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daylinhenry on 7/5/17.
 */
public interface JobRepository extends CrudRepository<Job, Integer> {


   @Transactional
   @Modifying
   @Query(value = "SELECT job.employer FROM Job, Skills WHERE Job.Skill LIKE CONCAT('%', :skill,'%')", nativeQuery = true)
   List<String> findBySkillContaining(String skill);




   // Long countByTitle(String title);
 /*   @Query
    ArrayList<Job> findDistinctBySkillContaining(String Skill)*/

    /*ArrayList<Job> findAllByTitle(String title);
    ArrayList<Job> findAllByRequirementsContaining(String Skill);
    ArrayList<Job> findAllByEmployer(String username);*/

}



