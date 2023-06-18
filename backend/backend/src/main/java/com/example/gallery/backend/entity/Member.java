package com.example.gallery.backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length =50, nullable = false, unique = true)
    private String email;

    @Column(length =100, nullable = false)
    private String password;

}
