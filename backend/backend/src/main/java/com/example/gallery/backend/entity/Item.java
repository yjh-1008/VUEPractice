package com.example.gallery.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
@Getter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;

}
