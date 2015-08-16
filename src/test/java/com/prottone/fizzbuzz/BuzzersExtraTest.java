package com.prottone.fizzbuzz;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class BuzzersExtraTest extends BuzzersTestBase{

    public void testBar() {
        // given
        Buzzer buzzer = BuzzersExtra.BAR;

        // when
        List<Integer> triggers = Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048);

        // then: Return Bar for index of 2^n. Otherwise empty string
        assertResults(buzzer, triggers);
    }

    public void testWAKA() throws IOException {
        // given
        Buzzer buzzer = BuzzersExtra.WAKA;

        // when
        List<Integer> triggers = Arrays.asList(13, 26, 39, 52, 65, 78, 91, 104, 117);

        // then: Return "Waka" for index divisible by 13. Otherwise empty string
        assertResults(buzzer, triggers);
    }

    public void testFIBONACCI(){
        // given
        Buzzer buzzer = BuzzersExtra.FIBONACCI;

        // when
        List<Integer> triggers = Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

        // then: Return "Fibonacci" for index in Fibonacci seq. Otherwise empty string
        assertResults(buzzer, triggers);
    }
}