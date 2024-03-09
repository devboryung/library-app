package com.group.libraryapp.controller.study.repository;

import com.group.libraryapp.dto.study.d2.FruitStatusResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitMySqlRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO study_fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public boolean findById(long id) {
        String readSql = "SELECT * FROM study_fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void sellFruit(long id) {
        String sql = "UPDATE study_fruit SET sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public int findByName(String name) {
        String readSql = "SELECT COUNT(*) FROM study_fruit WHERE name = ?";
        return jdbcTemplate.queryForObject(readSql, Integer.class, name);
    }

    public FruitStatusResponse searchFruitStat(String name) {

        String sql = "SELECT SUM(price) AS total_price, " +
                "CASE WHEN sold = 1 THEN 'salesAmount' ELSE 'notSalesAmount' END AS sold_group " +
                "FROM study_fruit WHERE name = ? GROUP BY sold";

        return jdbcTemplate.query(sql, (rs) -> {
            FruitStatusResponse fruitStatusResponse = new FruitStatusResponse();

            while (rs.next()) {
                String sold_group = rs.getString("sold_group");
                int total_price = rs.getInt("total_price");

                if ("salesAmount".equals(sold_group)) {
                    fruitStatusResponse.setSalesAmount(total_price);
                } else if ("notSalesAmount".equals(sold_group)) {
                    fruitStatusResponse.setNotSalesAmount(total_price);
                }
            }
            return fruitStatusResponse;
        }, name);
    }
}
