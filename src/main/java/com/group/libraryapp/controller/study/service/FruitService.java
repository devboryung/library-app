package com.group.libraryapp.controller.study.service;

import com.group.libraryapp.domain.study.Fruit;
import com.group.libraryapp.domain.study.FruitNotSalesMapping;
import com.group.libraryapp.domain.study.FruitRepository;
import com.group.libraryapp.dto.study.d2.FruitSaveRequest;
import com.group.libraryapp.dto.study.d2.FruitStatusResponse;
import com.group.libraryapp.dto.study.d2.FruitSellRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitSaveRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    public void sellFruit(FruitSellRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        fruit.updateSold(true);
        fruitRepository.save(fruit);
    }

    public FruitStatusResponse searchFruitStat(String name) {
        Long count = countFruit(name);

        if (count<=0) throw new IllegalArgumentException();

        Long salesAmount = fruitRepository.sumPriceBySoldIsTrueAndName(name);
        Long notSalesAmount = fruitRepository.sumPriceBySoldIsFalseAndName(name);

        FruitStatusResponse fruitStatusResponse = new FruitStatusResponse();
        fruitStatusResponse.setSalesAmount(salesAmount);
        fruitStatusResponse.setNotSalesAmount(notSalesAmount);

        return fruitStatusResponse;
    }

    public Long countFruit(String name) {
        return fruitRepository.countByName(name);
    }


    public List<FruitNotSalesMapping> notSalesList(String option, long price) {
        if (option.equals("GTE")) {
            return fruitRepository.findFruitBySoldFalseAndPriceGreaterThanEqual(price);
        } else {
            return fruitRepository.findFruitBySoldFalseAndPriceLessThanEqual(price);
        }
    }
}
