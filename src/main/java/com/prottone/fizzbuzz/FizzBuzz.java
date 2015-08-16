package com.prottone.fizzbuzz;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


public final class FizzBuzz {
    public static final String NEW_LINE = "\r\n";
    public static final String PIPE = "|";
    private int count;
    private Buzzer[] buzzers;
    private String delimiter = NEW_LINE;


    public FizzBuzz(final int count, final Buzzer... buzzers) {
        this.count = count;
        this.buzzers = buzzers;
    }

    public FizzBuzz(final int count, final String delimiter, final Buzzer... buzzers) {
        this.count = count;
        this.delimiter = delimiter;
        this.buzzers = buzzers;
    }

    private String getOutput(final int i) {
        String output = "";

        for (Buzzer buzzer : buzzers) {
            output += buzzer.execute(i);
        }

        if (output.length() == 0) {
            output += i;
        }

        return output;
    }

    public void run(final OutputStream os) throws IOException {
        String separator = delimiter;
        for (int i = 1; i <= count; i++) {
            if (i == count) {
                // clear separator in the last iteration
                separator = "";
            }
            os.write((getOutput(i) + separator).getBytes(StandardCharsets.UTF_8));
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

}
