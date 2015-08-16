package com.prottone.fizzbuzz;

import java.util.Arrays;
import java.util.List;


public class BuzzersTest extends BuzzersTestBase{


    public void testFIZZ(){
        // given
        Buzzer buzzer = Buzzers.FIZZ;

        // when
        List<Integer> triggers = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39);
        List<Integer> triggers2 = Arrays.asList(99, 102, 105, 108, 111, 114, 117, 120);

        // then: Print Fizz for every index divisible by 3. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testBUZZ() {
        // given
        Buzzer buzzer = Buzzers.BUZZ;

        // when
        List<Integer> triggers = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
        List<Integer> triggers2 = Arrays.asList(95, 100, 105, 110, 115);

        // then: Print Buzz for every index divisible by 5. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testWOOF() {
        // given
        Buzzer buzzer = Buzzers.WOOF;

        // when
        List<Integer> triggers = Arrays.asList(7, 14, 21, 28, 35, 42, 49);
        List<Integer> triggers2 = Arrays.asList(70, 77, 84, 91, 98, 105, 112);

        // then: Print Woof for every index divisible by 7. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testFOO() {
        // given
        Buzzer buzzer = Buzzers.FOO;

        // when
        List<Integer> triggers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 333, 444, 555, 666, 777, 888, 999, 1111, 2222);

        // then: Print Foo for every number with all the same digits(eg.11, 22, 33, ..., 111, 222, ...)
        assertResults(buzzer, triggers);
    }
}