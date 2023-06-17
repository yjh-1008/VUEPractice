package com.example.gallery.backend.repository;

import com.example.gallery.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item,Integer>{


}
