package com.prottone.fizzbuzz;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Filip on 28.7.2015..
 */
public class FizzBuzz {
    private int count;
    private Buzzer[] buzzers;
    private String delimiter = NEW_LINE;
    public static final String NEW_LINE = "\r\n";
    public static final String PIPE = "|";


    public FizzBuzz(int count, Buzzer... buzzers){
        this.count = count;
        this.buzzers = buzzers;
    }

    public FizzBuzz(int count, String delimiter, Buzzer... buzzers){
        this.count = count;
        this.delimiter = delimiter;
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

    public void run(OutputStream os) throws IOException {
        String separator = delimiter;
        for (int i = 1; i <= count; i++) {
            if (isLastElement(i, count)){
                separator = "";
            }
            os.write((getOutput(i) + separator).getBytes(StandardCharsets.UTF_8));
        }
    }

    private boolean isLastElement(int index, int length){
        return index == length;
    }

    public String getDelimiter(){
        return delimiter;
    }

}
