package com.prottone.fizzbuzz;

import com.prottone.fizzbuzz.custom.BuzzersAll;
import com.prottone.fizzbuzz.extras.BuzzersExtra;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static com.prottone.fizzbuzz.custom.BuzzersAll.*;


public class FizzBuzzTest extends TestCase{

    private void printResult(String[] arr, String delimiter){
        for(int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + delimiter);
        }
    }

    private String runFizzBuzz(FizzBuzz fizzBuzz) throws IOException {
        fizzBuzz.run();
        return fizzBuzz.getWriter().toString();
    }

    public void testFIZZ_BUZZ_WOOF_FOO_BAR() throws IOException {
        // given
        int maxIndex = 112;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersAll.FIZZ, BuzzersAll.BUZZ, BuzzersAll.WOOF, BuzzersAll.FOO, BuzzersAll.BAR);

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals(BAR.toString(), arr[1]);
        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Woof", arr[6]);
        Assert.assertEquals(BAR.toString(), arr[7]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("FizzBuzz", arr[14]);
        Assert.assertEquals(BAR.toString(), arr[15]);
        Assert.assertEquals(BAR.toString(), arr[63]);
        Assert.assertEquals("Foo", arr[87]);
        Assert.assertEquals("FizzBuzzWoof", arr[104]);
        Assert.assertEquals("FizzFoo", arr[110]);
    }

    public void testFizz() throws IOException {
        // given
        int maxIndex = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersAll.FIZZ);

        // when
        String result = runFizzBuzz(fizzBuzz);

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
        int maxIndex = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersAll.FIZZ, BuzzersAll.BUZZ);

        // when
        String result = runFizzBuzz(fizzBuzz);

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

    public void testBuzzFizz() throws IOException {
        // given
        int maxIndex = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersAll.BUZZ, BuzzersAll.FIZZ);

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("Fizz", arr[2] );
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("BuzzFizz", arr[14]);
    }

    public void testFoo() throws IOException {
        // given
        int maxIndex = 222;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersAll.FOO);

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("6", arr[5]);
        Assert.assertEquals("9", arr[8]);
        Assert.assertEquals("10", arr[9]);
        Assert.assertEquals(FOO.toString(), arr[10]);
        Assert.assertEquals(FOO.toString(), arr[21]);
        Assert.assertEquals(FOO.toString(), arr[32]);
        Assert.assertEquals(FOO.toString(), arr[43]);
        Assert.assertEquals(FOO.toString(), arr[54]);
        Assert.assertEquals(FOO.toString(), arr[65]);
        Assert.assertEquals(FOO.toString(), arr[87]);
        Assert.assertEquals(FOO.toString(), arr[98]);
        Assert.assertEquals("100", arr[99]);
        Assert.assertEquals("110", arr[109]);
        Assert.assertEquals(FOO.toString(), arr[110]);
        Assert.assertEquals(FOO.toString(), arr[221]);
    }

    public void testBar() throws IOException {
        // given
        int maxIndex = 256;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersExtra.BAR);

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        //printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals(BAR.toString(), arr[7]);
        Assert.assertEquals(BAR.toString(), arr[15]);
        Assert.assertEquals(BAR.toString(), arr[31]);
        Assert.assertEquals(BAR.toString(), arr[63]);
        Assert.assertEquals(BAR.toString(), arr[127]);
        Assert.assertEquals(BAR.toString(), arr[255]);
    }

    public void testPipeWoofAndDelimiter() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(15, FizzBuzz.PIPE, FIZZ, WOOF, BAR);

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals(BAR.toString(), arr[1]);
        Assert.assertEquals(FIZZ.toString(), arr[2]);
        Assert.assertEquals(FIZZ.toString(), arr[5]);
        Assert.assertEquals(WOOF.toString(), arr[6]);
        Assert.assertEquals(BAR.toString(), arr[7]);
        Assert.assertEquals(FIZZ.toString(), arr[8]);
        Assert.assertEquals(FIZZ.toString(), arr[11]);
        Assert.assertEquals(WOOF.toString(), arr[13]);
        Assert.assertEquals(FIZZ.toString(), arr[14]);
    }

    public void testFizzBuzzBuilder() throws IOException {
        // given
        String delimiter = ",";
        int maxLength = 256;

        FizzBuzz fizzBuzz = FizzBuzz.Builder.newInstance(maxLength)
                .withBuzzers(FOO, BAR, FIZZ, BUZZ)
                .withDelimiter(delimiter)
                .build();

        // when
        String result = runFizzBuzz(fizzBuzz);

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(arr, fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals(BAR.toString(), arr[1]);
        Assert.assertEquals(FIZZ.toString(), arr[2]);
        Assert.assertEquals(BAR.toString(), arr[3]);
        Assert.assertEquals(BUZZ.toString(), arr[4]);
        Assert.assertEquals(FIZZ.toString(), arr[5]);
        Assert.assertEquals(BAR.toString(), arr[7]);
        Assert.assertEquals(FOO.toString(), arr[10]);
        Assert.assertEquals(FIZZ.toString() + BUZZ.toString(), arr[14]);
        Assert.assertEquals(BAR.toString(), arr[15]);
        Assert.assertEquals(FOO.toString(), arr[21]);
        Assert.assertEquals(BAR.toString(), arr[31]);
        Assert.assertEquals(BAR.toString(), arr[63]);
        Assert.assertEquals(FOO.toString( )+ FIZZ.toString(), arr[98]);
        Assert.assertEquals(FOO.toString() + FIZZ.toString(), arr[110]);
        Assert.assertEquals(BAR.toString(), arr[127]);
        Assert.assertEquals(FOO.toString() + FIZZ.toString(), arr[221]);
        Assert.assertEquals(BAR.toString(), arr[255]);
    }
}
