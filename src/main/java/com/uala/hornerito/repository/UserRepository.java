package com.uala.hornerito.repository;


import com.uala.hornerito.model.db.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    Users findUserById(int id);

}
