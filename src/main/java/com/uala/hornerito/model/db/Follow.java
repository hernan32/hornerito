package com.uala.hornerito.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "follow")
@NoArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "user_id", nullable = false)
    private int userId;


    @JoinColumn(name = "following_id", nullable = false)
    private int followingId;

}
