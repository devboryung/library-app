package com.group.libraryapp.dto.study.d1;

public class CalculatorRequest {

    private int number1;
    private int number2;

    public CalculatorRequest(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}
