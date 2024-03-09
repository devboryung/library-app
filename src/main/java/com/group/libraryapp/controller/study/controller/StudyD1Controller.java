package com.group.libraryapp.controller.study.controller;

import com.group.libraryapp.dto.study.d1.AddNumbersRequest;
import com.group.libraryapp.dto.study.d1.CalculatorRequest;
import com.group.libraryapp.dto.study.d1.CalculatorResponse;
import com.group.libraryapp.dto.study.d1.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class StudyD1Controller {


    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculateTwoNumber(CalculatorRequest request) {

        int sum = getSum(request);
        int minus = getMinus(request);
        int multiply = getMultiply(request);

        CalculatorResponse result = new CalculatorResponse(sum, minus, multiply);

        return result;
    }

    public int getSum(CalculatorRequest request) {
        return request.getNumber1() + request.getNumber2();
    }
    public int getMinus(CalculatorRequest request) {
        return request.getNumber1() - request.getNumber2();
    }

    public int getMultiply(CalculatorRequest request) {
        return request.getNumber1() * request.getNumber2();
    }



    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(@RequestParam String date) {

        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return new DayOfTheWeekResponse(dayOfWeek.toString());
    }


    @PostMapping("/api/v1/addNumbers")
    public int addNumbers(@RequestBody AddNumbersRequest request) {
        List<Integer> numbers = request.getNumbers();
        
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        
        return sum;
    }
}
