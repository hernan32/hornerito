package com.uala.hornerito.repository;


import com.uala.hornerito.model.db.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TweetRepository extends JpaRepository<Tweet, Integer>, JpaSpecificationExecutor<Tweet> {

    Tweet getTweetById(int id);

}
