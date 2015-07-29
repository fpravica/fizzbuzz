package com.prottone.fizzbuzz;

/**
 * Created by Filip on 28.7.2015..
 */
public class Buzzers {

    public static final Buzzer FIZZ = new Buzzer() {
        public String execute(int index) {
            return (index % 3 == 0) ? "Fizz" : "";
        }
    };

    public static final Buzzer BUZZ = new Buzzer() {
        public String execute(int index) {
            return (index % 5 == 0) ? "Buzz" : "";
        }
    };

    public static final Buzzer WOOF = new Buzzer() {
        public String execute(int index) {
            return (index % 7 == 0) ? "Woof" : "";
        }
    };

    public static final Buzzer FOO = new Buzzer() {
        public String execute(int index) {
            return (index % 11 == 0) ? "Foo" : "";
        }
    };

}
