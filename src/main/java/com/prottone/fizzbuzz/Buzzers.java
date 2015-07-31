package com.prottone.fizzbuzz;

/**
 * Created by Filip on 28.7.2015..
 */
public class Buzzers {

    /**
     * Returns "Fizz" if index divisible by 3
     */
    public static final Buzzer FIZZ = new Buzzer() {
        public String execute(int index) {
            return (index % 3 == 0) ? "Fizz" : "";
        }
    };

    /**
     * Returns "Buzz" if index divisible by 5
     */
    public static final Buzzer BUZZ = new Buzzer() {
        public String execute(int index) {
            return (index % 5 == 0) ? "Buzz" : "";
        }
    };

    /**
     * Returns "Woof" if index divisible by 7
     */
    public static final Buzzer WOOF = new Buzzer() {
        public String execute(int index) {
            return (index % 7 == 0) ? "Woof" : "";
        }
    };

    /**
     *  Returns "Foo" for 11, 22, 33, 44, 55...
     */
    public static final Buzzer FOO = new Buzzer() {
        public String execute(int index) {
            String sameDigits = "^([0-9])\\1*$";
            return (String.valueOf(index).matches(sameDigits) && index > 10) ? "Foo" : "";
        }
    };

}
