package com.uala.hornerito.repository;


import com.uala.hornerito.model.db.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer>, JpaSpecificationExecutor<Tweet> {

    Tweet getTweetById(int id);

    @Query("SELECT t FROM Tweet t JOIN Follow f ON t.userId = f.followingId WHERE f.userId = :userId AND t.createDate >= :interval")
    List<Tweet> getTimelineByUserId(@Param("userId") int userId, @Param("interval") Timestamp interval);

}
