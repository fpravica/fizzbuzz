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

    /**
     * Returns "Woof" if index divisible by 7
     */
    public static final Buzzer WOOF = new Buzzer() {
        private static final String OUT = "Woof";
        public String execute(final int index) {
            return (index % 7 == 0) ? OUT : "";
        }
        @Override
        public String toString() {
            return OUT;
        }
    };

    /**
     *  Returns "Foo" for 11, 22, 33, 44, 55...
     */
    public static final Buzzer FOO = new Buzzer() {
        private static final String OUT = "Foo";
        public String execute(final int index) {
            String sameDigits = "^([0-9])\\1+$";
            boolean isMatching = String.valueOf(index).matches(sameDigits);
            return (isMatching) ? OUT : "";
        }
        @Override
        public String toString() {
            return OUT;
        }
    };
}
