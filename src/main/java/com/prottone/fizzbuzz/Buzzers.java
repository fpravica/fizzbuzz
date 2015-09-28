package com.prottone.fizzbuzz;


public final class Buzzers {

    /**
     * Disabled instantiation
     */
    private Buzzers() { }

    /**
     * Returns "Fizz" if index divisible by 3
     */
    public static final Buzzer FIZZ = new Buzzer() {
        public String execute(final int index) {
            return (index % 3 == 0) ? toString() : "";
        }
        @Override
        public String toString() {
            return "Fizz";
        }
    };

    /**
     * Returns "Buzz" if index divisible by 5
     */
    public static final Buzzer BUZZ = new Buzzer() {
        public String execute(final int index) {
            return (index % 5 == 0) ? toString() : "";
        }
        @Override
        public String toString() {
            return "Buzz";
        }
    };
}
