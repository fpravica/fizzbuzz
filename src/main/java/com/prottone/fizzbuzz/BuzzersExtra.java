package com.prottone.fizzbuzz;


public enum BuzzersExtra implements Buzzer {

    /**
     * 2, 4, 8, 16, 32
     * x(n)=2^n  so  n=log(x)/log(2)
     * n must be an integer (whole number)
     */
    BAR {
        public String execute(final int num) {
            double res = (Math.log(num) / Math.log(2));
            return ((res % 1 == 0) && num > 1) ? toString() : "";
        }
    },
    /**
     * Return Waka for  number divisible by 13
     */
    WAKA {
        public String execute(final int num) {
            return (num % 13 == 0) ? toString() : "";
        }
    },
    /**
     *  This is true if and only if one or both
     *  of (5*x^2 + 4) or (5*x^2 - 4) are a perfect square.
     */
    FIBONACCI {
        public String execute(final int num) {
            double exp1 = Math.sqrt(5 * Math.pow(num, 2) + 4);
            double exp2 = Math.sqrt(5 * Math.pow(num, 2) - 4);
            boolean isFibonacci = (exp1 % 1 == 0 || exp2 % 1 == 0);
            return isFibonacci ? toString() : "";
        }
    };

    public String toString(){
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }

}
