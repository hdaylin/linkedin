package com.example.demo.Models;

/**
 * Created by daylinhenry on 7/5/17.
 */
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}