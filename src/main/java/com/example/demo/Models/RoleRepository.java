package com.example.demo.Models;

/**
 * Created by daylinhenry on 7/5/17.
 */
import org.springframework.data.repository.CrudRepository;
public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByRole(String role);

}
