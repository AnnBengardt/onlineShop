package com.AnnaMarunko.onlineShop.controller;

import com.AnnaMarunko.onlineShop.entity.Item;
import com.AnnaMarunko.onlineShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @PostMapping("/api/item")
    public ResponseEntity<?> create(@RequestBody Item item){
        itemService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/item")
    public ResponseEntity<List<Item>> findALL(){
        final List<Item> itemList = itemService.findAll();
        return itemList != null && !itemList.isEmpty()
                ? new ResponseEntity<>(itemList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/item/{id}")
    public ResponseEntity<Optional<Item>> find(@PathVariable(name = "id")Long id){
        final Optional<Item> item = itemService.find(id);
        return item!=null
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/item/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "id")Long id, @RequestBody Item itemUpdate){
        return itemService.find(id).map(item -> {
            item.setItemName(itemUpdate.getItemName());
            item.setArticleNumber(itemUpdate.getArticleNumber());
            item.setCountry(itemUpdate.getCountry());
            item.setManufacturer(itemUpdate.getManufacturer());
            itemService.update(item);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

}
