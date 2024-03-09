package com.group.libraryapp.dto.study.d1;

import java.util.List;

public class AddNumbersRequest {

    private List<Integer> numbers;

    public AddNumbersRequest() {
    }

    public AddNumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
