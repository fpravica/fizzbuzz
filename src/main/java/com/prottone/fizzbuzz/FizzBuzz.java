package com.prottone.fizzbuzz;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


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

    /**
     * Example of the nested builder class
     */
    public static final class Builder{
        private int length = 0;
        private String delimiter = FizzBuzz.NEW_LINE;
        private List<Buzzer> buzzers = new ArrayList<Buzzer>();

        private Builder(final int length) {
            this.length = length;
        }

        public static Builder getNew(final int length) {
            return new Builder(length);
        }

        public Builder withBuzzer(final Buzzer buzzer) {
            buzzers.add(buzzer);
            return this;
        }

        public Builder withDelimiter(final String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public FizzBuzz build() {
            return new FizzBuzz(length, delimiter, buzzers.toArray(new Buzzer[buzzers.size()]));
        }
    }

}
