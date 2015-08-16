package com.prottone.fizzbuzz;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class BuzzersAllTest extends BuzzersTestBase{

    public void testFIZZ(){
        // given
        Buzzer buzzer = BuzzersAll.FIZZ;

        // when
        List<Integer> triggers = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39);
        List<Integer> triggers2 = Arrays.asList(99, 102, 105, 108, 111, 114, 117, 120);

        // then: Print Fizz for every index divisible by 3. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testBUZZ() {
        // given
        Buzzer buzzer = BuzzersAll.BUZZ;

        // when
        List<Integer> triggers = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
        List<Integer> triggers2 = Arrays.asList(95, 100, 105, 110, 115);

        // then: Print Buzz for every index divisible by 5. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testWOOF() {
        // given
        Buzzer buzzer = BuzzersAll.WOOF;

        // when
        List<Integer> triggers = Arrays.asList(7, 14, 21, 28, 35, 42, 49);
        List<Integer> triggers2 = Arrays.asList(70, 77, 84, 91, 98, 105, 112);

        // then: Print Woof for every index divisible by 7. Otherwise the empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testFOO() {
        // given
        Buzzer buzzer = BuzzersAll.FOO;

        // when
        List<Integer> triggers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 333, 444, 555, 666, 777, 888, 999, 1111, 2222);

        // then: Print Foo for every number with all the same digits(eg.11, 22, 33, ..., 111, 222, ...)
        assertResults(buzzer, triggers);
    }

    public void testBar() {
        // given
        Buzzer buzzer = BuzzersAll.BAR;

        // when
        List<Integer> triggers = Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048);

        // then: Return Bar for index of 2^n. Otherwise empty string
        assertResults(buzzer, triggers);
    }

    public void testWAKA() throws IOException {
        // given
        Buzzer buzzer = BuzzersAll.WAKA;

        // when
        List<Integer> triggers = Arrays.asList(13, 26, 39, 52, 65, 78, 91, 104, 117);

        // then: Return "Waka" for index divisible by 13. Otherwise empty string
        assertResults(buzzer, triggers);
    }

    public void testFIBONACCI(){
        // given
        Buzzer buzzer = BuzzersAll.FIBONACCI;

        // when
        List<Integer> triggers = Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

        // then: Return "Fibonacci" for index in Fibonacci seq. Otherwise empty string
        assertResults(buzzer, triggers);
    }

    public void testSUMO(){
        // given
        Buzzer buzzer = BuzzersAll.SUMO;

        // when
        List<Integer> triggers = Arrays.asList(12, 14, 16, 18, 21, 23, 25, 27, 29, 30);
        List<Integer> triggers2 = Arrays.asList(96, 98, 100, 102, 104, 106, 108, 111);

        // then:  Return "Sumo" if sum of digits is an odd number, when number of digits > 1. Otherwise return an empty string
        assertResults(buzzer, triggers);
        assertResults(buzzer, triggers2);
    }

    public void testHALO(){
        // given
        Buzzer buzzer = BuzzersAll.HALO;

        // when
        List<Integer> triggers = Arrays.asList(8, 18, 24, 28, 38, 42, 44, 46, 48, 58);

        // then: Return "Halo" if the multiplication of digits is divisible by 8. Otherwise return an empty string
        assertResults(buzzer, triggers);
    }
}