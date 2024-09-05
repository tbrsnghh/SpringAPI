package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final List<Store> storeList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        long id = counter.incrementAndGet();
        Store newStore = new Store(id, store.name(), store.address());
        storeList.add(newStore);
        return newStore;
    }

    @GetMapping("/{id}")
    public Store getStore(@PathVariable long id) {
        return storeList.stream()
                .filter(store -> store.id() == id)
                .findFirst()
                .orElse(null); // Hoặc bạn có thể ném ra một lỗi nếu không tìm thấy
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeList;
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable long id) {
        storeList.removeIf(store -> store.id() == id);
    }
}