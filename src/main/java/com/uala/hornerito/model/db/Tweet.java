package com.uala.hornerito.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false, updatable = false)
    private Timestamp createDate;

    public Tweet() {
        this.createDate = new Timestamp(System.currentTimeMillis());
    }
}
