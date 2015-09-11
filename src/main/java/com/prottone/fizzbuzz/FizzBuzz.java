package com.prottone.fizzbuzz;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.*;


public final class FizzBuzz implements Runnable {

    public static final String NEW_LINE = "\r\n";
    public static final String PIPE = "|";

    private int count;
    private Buzzer[] buzzers;
    private String delimiter;
    private Writer writer;


    public FizzBuzz(final int count, final Buzzer... buzzers) {
        this.count = count;
        this.delimiter = NEW_LINE;
        this.buzzers = buzzers;
    }

    public FizzBuzz(final int count, final String delimiter, final Buzzer... buzzers) {
        this.count = count;
        this.delimiter = delimiter;
        this.buzzers = buzzers;
    }

    public FizzBuzz(final FizzBuzz.Builder builder) {
        this.count = builder.count;
        this.delimiter = builder.delimiter;
        this.buzzers = builder.buzzers.toArray(new Buzzer[builder.buzzers.size()]);
        this.writer = builder.writer;
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

    public String getDelimiter() {
        return delimiter;
    }

    public Writer getWriter() {
        return writer;
    }

    public void run() {
        String separator = delimiter;

        if (writer == null) {
            writer = defaultWriter();
        }

        try {
            for (int i = 1; i <= count; i++) {
                if (i == count) {
                    // remove separator in the last iteration
                    separator = "";
                }
                writer.write((getOutput(i) + separator));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Writer defaultWriter() {
        return new StringWriter();
    }

    /**
     * Example of the nested builder class
     */
    public static final class Builder {
        private int count = 1;
        private String delimiter = FizzBuzz.NEW_LINE;
        private Set<Buzzer> buzzers = new LinkedHashSet<Buzzer>();
        private Writer writer;

        private Builder(final int count) {
            if (count > 1) {
                this.count = count;
            }
        }

        public static Builder newInstance(final int count) {
            return new Builder(count);
        }

        public Builder withBuzzers(final Buzzer... buzzers) {
            this.buzzers.addAll(Arrays.asList(buzzers));
            return this;
        }

        public Builder withDelimiter(final String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder withWriter(Writer writer) {
            this.writer = writer;
            return this;
        }

        public FizzBuzz build() {
            if (writer == null) {
                writer = defaultWriter();
            }
            return new FizzBuzz(this);
        }
    }

}
