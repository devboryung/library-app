package com.group.libraryapp.dto.study.d2;

import java.time.LocalDate;
import java.util.Date;

public class FruitSaveRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
