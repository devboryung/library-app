package com.group.libraryapp.controller.study.repository;

import com.group.libraryapp.dto.study.d2.FruitStatusResponse;

import java.time.LocalDate;

public interface FruitRepository {
    public void saveFruit(String name, LocalDate warehousingDate, long price);
    public boolean findById(long id);
    public void sellFruit(long id);
    public int findByName(String name);
    public FruitStatusResponse searchFruitStat(String name);
}
