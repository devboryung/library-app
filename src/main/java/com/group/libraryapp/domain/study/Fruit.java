package com.group.libraryapp.domain.study;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "study_fruit")
public class Fruit {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "warehousingDate")
    private LocalDate warehousingDate;

    private Long price;

    private boolean sold;

    public Fruit() {}

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isSold() {
        return sold;
    }

    public void updateSold(boolean isSold) {
        this.sold = isSold;
    }
}
