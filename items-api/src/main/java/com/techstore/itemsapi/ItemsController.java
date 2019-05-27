package com.techstore.itemsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    private ItemsRepository ItemsRepository;



    /*@GetMapping("/users/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return userRepository.findById(Integer.parseInt(id)).get();
    }
    */

    @GetMapping("/items")
    public @ResponseBody
    List<Items> getAllItems() {
        List<Items> items = new ArrayList<>();
        ItemsRepository.findAll().forEach(items::add);
        return items;
    }

    @PostMapping("/items")
    public @ResponseBody Items createItem(@RequestBody  Items items) {
        return ItemsRepository.save(items);
    }

    @DeleteMapping("/items/{itemId}")
    public @ResponseBody void deleteItems(@PathVariable String itemId) {
        ItemsRepository.deleteById(Integer.parseInt(itemId));
    }

    @PutMapping("/items/{itemId}")
    public @ResponseBody
    Items UpdateItems(@RequestBody Items items) {
        return ItemsRepository.save(items);
    }
}








