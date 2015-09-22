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
        private static final String OUT = "Fizz";
        public String execute(final int index) {
            return (index % 3 == 0) ? OUT : "";
        }
        @Override
        public String toString() {
            return OUT;
        }
    };

    /**
     * Returns "Buzz" if index divisible by 5
     */
    public static final Buzzer BUZZ = new Buzzer() {
        private static final String OUT = "Buzz";
        public String execute(final int index) {
            return (index % 5 == 0) ? OUT : "";
        }
        @Override
        public String toString() {
            return OUT;
        }
    };
}
