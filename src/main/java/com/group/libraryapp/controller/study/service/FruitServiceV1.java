package com.group.libraryapp.controller.study.service;

import com.group.libraryapp.controller.study.repository.FruitRepository;
import com.group.libraryapp.dto.study.d2.FruitSaveRequest;
import com.group.libraryapp.dto.study.d2.FruitStatusResponse;
import com.group.libraryapp.dto.study.d2.FruitSellRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV1 {

    private final FruitRepository fruitRepository;

    public FruitServiceV1(@Qualifier("fruitMemoryRepository") FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitSaveRequest request) {
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void sellFruit(FruitSellRequest request) {
        if (fruitRepository.findById(request.getId())) {
            throw new IllegalArgumentException();
        }

        fruitRepository.sellFruit(request.getId());
    }

    public FruitStatusResponse searchFruitStat(String name) {

        int count = fruitRepository.findByName(name);

        if (count <= 0) {
            throw new IllegalArgumentException();
        }

        return fruitRepository.searchFruitStat(name);
    }

}
