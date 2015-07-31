package com.prottone.fizzbuzz;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * Created by Filip on 28.7.2015..
 */
public class FizzBuzzTest extends TestCase{

    private void printResult(String[] arr, String delimiter){
        for(int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + delimiter);
        }
    }

    public void testAll() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(112, Buzzers.FIZZ, Buzzers.BUZZ, Buzzers.WOOF, Buzzers.FOO);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fizzBuzz.run(baos);
        String result = baos.toString(StandardCharsets.UTF_8.name());
        baos.close();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("2", arr[1]);
        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Woof", arr[6]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("FizzBuzz", arr[14]);
        Assert.assertEquals("FizzBuzzWoof", arr[104]);
        Assert.assertEquals("FizzFoo", arr[110]);
    }

    public void testFizz() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(15, Buzzers.FIZZ);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fizzBuzz.run(baos);
        baos.close();
        String result = baos.toString(StandardCharsets.UTF_8.name());

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("Fizz", arr[14]);
    }

    public void testFizzBuzz() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(15, Buzzers.FIZZ, Buzzers.BUZZ);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fizzBuzz.run(baos);
        baos.close();
        String result = baos.toString(StandardCharsets.UTF_8.name());

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("Fizz", arr[2] );
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("FizzBuzz", arr[14]);
    }

    public void testFoo() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(112, Buzzers.FOO);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fizzBuzz.run(baos);
        baos.close();
        String result = baos.toString(StandardCharsets.UTF_8.name());

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("6", arr[5]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("Foo", arr[21]);
        Assert.assertEquals("Foo", arr[32]);
        Assert.assertEquals("Foo", arr[43]);
        Assert.assertEquals("Foo", arr[54]);
        Assert.assertEquals("Foo", arr[98]);
        Assert.assertEquals("110", arr[109]);
        Assert.assertEquals("Foo", arr[110]);
    }

    public void testPipeWoofAndDelimiter() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(15, FizzBuzz.PIPE, Buzzers.FIZZ, Buzzers.WOOF);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //OutputStream baos = System.out;
        fizzBuzz.run(baos);
        baos.close();
        String result = baos.toString(StandardCharsets.UTF_8.name());

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Woof", arr[6]);
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("Woof", arr[13]);
        Assert.assertEquals("Fizz", arr[14]);
    }

}
