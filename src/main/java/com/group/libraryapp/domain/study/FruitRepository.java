package com.group.libraryapp.domain.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Long countByName(String name);
    @Query("SELECT SUM(price) FROM Fruit WHERE name = ?1 AND sold = true")
    Long sumPriceBySoldIsTrueAndName(String name);
    @Query("SELECT SUM(price) FROM Fruit WHERE name = ?1 AND sold = false")
    Long sumPriceBySoldIsFalseAndName(String name);


    List<FruitNotSalesMapping> findFruitBySoldFalseAndPriceGreaterThanEqual(Long price);
    List<FruitNotSalesMapping> findFruitBySoldFalseAndPriceLessThanEqual(Long price);
}
