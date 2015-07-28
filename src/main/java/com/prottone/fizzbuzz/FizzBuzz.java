package com.prottone.fizzbuzz;

/**
 * Created by Filip on 28.7.2015..
 */
public class FizzBuzz {
    private Buzzer[] buzzers = new Buzzer[]{};
    private int count;

    public FizzBuzz(int count, Buzzer... buzzers){
        this.count = count;
        this.buzzers = buzzers;
    }

    private String getOutput(int i){
        String output = "";

        for(Buzzer buzzer : buzzers){
            output += buzzer.execute(i);
        }

        if (output.length() == 0){
            output += i;
        }

        return output;
    }

    public void run(){
        for (int i = 1; i <= count; i++) {
            System.out.println(getOutput(i));
        }
    }


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

    /**
     *
     */
    public static void main(String[] args){

        FizzBuzz[] fizzBuzzs = new FizzBuzz[]{
                new FizzBuzz(15, FIZZ),
                new FizzBuzz(15, FIZZ, BUZZ),
                new FizzBuzz(15, FIZZ, WOOF),
                new FizzBuzz(55, FOO),
                new FizzBuzz(105, FIZZ, BUZZ, WOOF, FOO)
        };

        for(FizzBuzz fizzBuzz : fizzBuzzs) {
            System.out.println("===========");
            fizzBuzz.run();
        }

    }
}
