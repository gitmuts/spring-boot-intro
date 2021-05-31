package com.gitmuts.testmwallet.repo;

import com.gitmuts.testmwallet.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    List<User> findByLastName(String lastName);
}
