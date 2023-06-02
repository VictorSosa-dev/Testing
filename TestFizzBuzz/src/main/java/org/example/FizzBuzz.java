package org.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(getNumber(i));
        }
        return numbers;

    }

    private String getNumber(int i) {
        if(i % 3 == 0 && i % 5 == 0)
            return FIZZ + BUZZ;
        else if(i % 3 == 0)
            return FIZZ;
        else if(i % 5 == 0)
            return BUZZ;
        return String.valueOf(i);
    }

}
