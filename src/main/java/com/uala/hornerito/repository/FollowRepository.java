package com.uala.hornerito.repository;


import com.uala.hornerito.model.db.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FollowRepository extends JpaRepository<Follow, Integer>, JpaSpecificationExecutor<Follow> {

}
