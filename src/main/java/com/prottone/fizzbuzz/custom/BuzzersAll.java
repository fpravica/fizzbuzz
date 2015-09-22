package com.prottone.fizzbuzz.custom;

import com.prottone.fizzbuzz.Buzzer;
import com.prottone.fizzbuzz.Buzzers;
import com.prottone.fizzbuzz.extras.BuzzersExtra;
import com.prottone.fizzbuzz.util.SimpleUtils;

/**
 * Wrapper Class that contains all the available Buzzer implementations
 * from "original" Buzzers class and extras package
 */
public enum BuzzersAll implements Buzzer {

    /**
     * Returns "Fizz" if index divisible by 3
     */
    FIZZ {
        public String execute(final int index) {
            return Buzzers.FIZZ.execute(index);
        }
    },
    /**
     * Returns "Buzz" if index divisible by 5
     */
    BUZZ {
        public String execute(final int index) {
            return Buzzers.BUZZ.execute(index);
        }
    },
    /**
     *  Returns "Foo" for 11, 22, 33, 44, 55...
     */
    FOO {
        public String execute(final int index) {
            return BuzzersExtra.FOO.execute(index);
        }
    },
    /**
     * Returns "Woof" if index divisible by 7
     */
    WOOF {
        public String execute(final int index) {
            return BuzzersExtra.WOOF.execute(index);
        }
    },
    /**
     *  This is true if and only if one or both
     *  of (5*x^2 + 4) or (5*x^2 - 4) are a perfect square.
     */
    FIBONACCI {
        public String execute(final int index) {
            return BuzzersExtra.FIBONACCI.execute(index);
        }
    },
    /**
     * For 2, 4, 8, 16, 32 ... return "Bar"
     * x(n)=2^n  so  n=log(x)/log(2) => n is a counter so it must be an integer
     */
    BAR {
        public String execute(final int index) {
            return BuzzersExtra.BAR.execute(index);
        }
    },
    /**
     * Return Waka for  number divisible by 13
     */
    WAKA {
        public String execute(final int index) {
            return BuzzersExtra.WAKA.execute(index);
        }
    },
    /**
     * Return "Sumo" if sum of digits is an odd number
     * when number of digits > 1
     */
    SUMO {
        public String execute(final int index) {
            int sum = 0;
            int num = index;
            while (num != 0) {
                sum += num % TENS; // add last digit to the sum
                num /= TENS; // cut last digit
            }
            return ((index >= TENS) && (sum % 2 != 0)) ? toString() : "";
        }
    },
    /**
     * Return "Halo" if a multiplication of digits is divisible by 8.
     * Otherwise return an empty string
     */
    HALO {
        public String execute(final int index) {
            int result = 1;
            int number = index;
            while (number != 0) {
                result *= number % TENS; // add last digit to the result
                number /= TENS; // cut last digit
            }
            return ((result > 0) && (result % 8 == 0)) ? toString() : "";
        }
    };

    private static final int TENS = 10;

    public String toString() {
        return SimpleUtils.capitalize(name());
    }
}
