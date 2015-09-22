package com.prottone.fizzbuzz;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class FizzBuzzStepBuilder {

    public static FirstStep newBuilder() {
        return new Steps();
    }

    private FizzBuzzStepBuilder() { }

    public interface FirstStep {
        SecondStep maxLength(int count);
    }

    public interface SecondStep {
        ThirdStep withBuzzers(Buzzer... buzzers);
    }

    public interface ThirdStep {
        BuildStep withDefaultWriterAndDelimiter();
        BuildStep withWriter(Writer writer);
        BuildStep withDelimiter(String delimiter);
        BuildStep withWriterAndDelimiter(Writer writer, String delimiter);
    }

    public interface BuildStep{
        FizzBuzz build();
    }

    private static class Steps implements FirstStep, SecondStep, ThirdStep, BuildStep {
        private int count;
        private String delimiter;
        private Set<Buzzer> buzzers = new LinkedHashSet<Buzzer>();
        private Writer writer;

        public SecondStep maxLength(int count) {
            this.count = count;
            return this;
        }

        public ThirdStep withBuzzers(Buzzer... buzzers) {
            this.buzzers.addAll(Arrays.asList(buzzers));
            return this;
        }

        public BuildStep withDefaultWriterAndDelimiter() {
            this.writer = defaultWriter();
            this.delimiter = defaultDelimiter();
            return this;
        }

        public BuildStep withWriter(Writer writer) {
            this.writer = writer;
            this.delimiter = defaultDelimiter();
            return this;
        }

        public BuildStep withDelimiter(String delimiter) {
            this.writer = defaultWriter();
            this.delimiter = delimiter;
            return this;
        }

        public BuildStep withWriterAndDelimiter(Writer writer, String delimiter) {
            this.writer = writer;
            this.delimiter = delimiter;
            return this;
        }

        private static Writer defaultWriter() {
            return new StringWriter();
        }

        private static String defaultDelimiter() {
            return FizzBuzz.NEW_LINE;
        }

        public FizzBuzz build() {
            if (count < 1) {
                throw new IllegalArgumentException("maxLength cannot be less than 1");
            }

            if (delimiter == null) {
                throw new IllegalArgumentException("delimiter cannot be null");
            }

            if (writer == null) {
                throw new IllegalArgumentException("writer cannot be null");
            }

            FizzBuzz fizzBuzz = FizzBuzz.Builder.newInstance(count)
                    .withBuzzers(buzzers.toArray(new Buzzer[buzzers.size()]))
                    .withDelimiter(delimiter)
                    .withWriter(writer)
                    .build();
            return fizzBuzz;
        }
    }
}
