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


    public static void main(String[] args){

        FizzBuzz[] fizzBuzzs = new FizzBuzz[]{
                new FizzBuzz(15, Buzzers.FIZZ),
                new FizzBuzz(15, Buzzers.FIZZ, Buzzers.BUZZ),
                new FizzBuzz(15, Buzzers.FIZZ, Buzzers.WOOF),
                new FizzBuzz(55, Buzzers.FOO),
                new FizzBuzz(105, Buzzers.FIZZ, Buzzers.BUZZ, Buzzers.WOOF, Buzzers.FOO)
        };

        for(FizzBuzz fizzBuzz : fizzBuzzs) {
            System.out.println("===========");
            fizzBuzz.run();
        }

    }
}
