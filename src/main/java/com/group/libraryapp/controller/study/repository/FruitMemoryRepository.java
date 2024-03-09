package com.group.libraryapp.controller.study.repository;

import com.group.libraryapp.dto.study.d2.FruitStatusResponse;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitMemoryRepository implements FruitRepository{
    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {

    }

    @Override
    public boolean findById(long id) {
        return false;
    }

    @Override
    public void sellFruit(long id) {

    }

    @Override
    public int findByName(String name) {
        return 0;
    }

    @Override
    public FruitStatusResponse searchFruitStat(String name) {
        return null;
    }
}
