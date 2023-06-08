package com.example.gallery.backend.controller;

import com.example.gallery.backend.entity.Item;
import com.example.gallery.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @GetMapping("/api/items")
    public List<Item> getItems() {
        List<Item> items = itemRepository.findAll();
        for(Item i: items){
            System.out.println(i.getName());
        }
        return items;
    }

}
