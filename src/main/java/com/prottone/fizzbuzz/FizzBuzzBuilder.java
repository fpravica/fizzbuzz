package com.prottone.fizzbuzz;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzzBuilder {
    private int length = 0;
    private String delimiter = FizzBuzz.NEW_LINE;
    private List<Buzzer> buzzers = new ArrayList<Buzzer>();

    private FizzBuzzBuilder(final int length) {
        this.length = length;
    }

    public static FizzBuzzBuilder getNew(int length){
        return new FizzBuzzBuilder(length);
    }

    public FizzBuzzBuilder withBuzzer(final Buzzer buzzer){
        buzzers.add(buzzer);
        return this;
    }

    public FizzBuzzBuilder withDelimiter(final String delimiter){
        this.delimiter = delimiter;
        return this;
    }


    public FizzBuzz build(){
        return new FizzBuzz(length, delimiter, buzzers.toArray(new Buzzer[buzzers.size()]));
    }
}
