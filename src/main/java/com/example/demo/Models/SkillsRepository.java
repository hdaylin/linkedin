package com.example.demo.Models;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 6/30/17.
 */
public interface SkillsRepository extends CrudRepository<Skills, Integer>{

    ArrayList<Skills> findAllByName(String name);

}
