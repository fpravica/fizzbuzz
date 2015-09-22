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
}