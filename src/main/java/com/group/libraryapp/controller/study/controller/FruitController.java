package com.group.libraryapp.controller.study.controller;

import com.group.libraryapp.controller.study.service.FruitService;
import com.group.libraryapp.domain.study.FruitNotSalesMapping;
import com.group.libraryapp.dto.study.d2.FruitSaveRequest;
import com.group.libraryapp.dto.study.d2.FruitStatusResponse;
import com.group.libraryapp.dto.study.d2.FruitSellRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitSaveRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void sellFruit(@RequestBody FruitSellRequest request) {
        fruitService.sellFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitStatusResponse searchFruitStat(@RequestParam String name) {
        return fruitService.searchFruitStat(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public ResponseEntity<Map<String,Integer>> countFruit(@RequestParam String name) {
        Long count = fruitService.countFruit(name);

        Map<String, Integer> response = new HashMap<>();
        response.put("count", count.intValue());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitNotSalesMapping> notSalesList(@RequestParam String option, @RequestParam long price) {
        return fruitService.notSalesList(option, price);
    }
}