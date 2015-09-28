package com.prottone.fizzbuzz;

import com.prottone.fizzbuzz.custom.BuzzersAll;
import com.prottone.fizzbuzz.extras.BuzzersExtra;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

import static com.prottone.fizzbuzz.custom.BuzzersAll.*;


public class FizzBuzzTest extends TestCase{

    private void printResult(String result){
            System.out.println(result);
    }

    public void testFIZZ_BUZZ_WOOF_FOO_BAR() throws IOException {
        // given
        int maxIndex = 112;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, FizzBuzz.PIPE, BuzzersAll.FIZZ, BuzzersAll.BUZZ, BuzzersAll.WOOF, BuzzersAll.FOO, BuzzersAll.BAR);

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);


        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("Bar", arr[1]);
        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Woof", arr[6]);
        Assert.assertEquals("Bar", arr[7]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("FizzBuzz", arr[14]);
        Assert.assertEquals("Bar", arr[15]);
        Assert.assertEquals("Bar", arr[63]);
        Assert.assertEquals("Foo", arr[87]);
        Assert.assertEquals("FizzBuzzWoof", arr[104]);
        Assert.assertEquals("FizzFoo", arr[110]);
    }

    public void testFizz() throws IOException {
        // given
        int maxIndex = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, FizzBuzz.PIPE, BuzzersAll.FIZZ);

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);

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
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);

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
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);

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
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("6", arr[5]);
        Assert.assertEquals("9", arr[8]);
        Assert.assertEquals("10", arr[9]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("Foo", arr[21]);
        Assert.assertEquals("Foo", arr[32]);
        Assert.assertEquals("Foo", arr[43]);
        Assert.assertEquals("Foo", arr[54]);
        Assert.assertEquals("Foo", arr[65]);
        Assert.assertEquals("Foo", arr[87]);
        Assert.assertEquals("Foo", arr[98]);
        Assert.assertEquals("100", arr[99]);
        Assert.assertEquals("110", arr[109]);
        Assert.assertEquals("Foo", arr[110]);
        Assert.assertEquals("Foo", arr[221]);
    }

    public void testBar() throws IOException {
        // given
        int maxIndex = 256;
        FizzBuzz fizzBuzz = new FizzBuzz(maxIndex, BuzzersExtra.BAR);

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        //printResult(result);

        Assert.assertEquals("Bar", arr[7]);
        Assert.assertEquals("Bar", arr[15]);
        Assert.assertEquals("Bar", arr[31]);
        Assert.assertEquals("Bar", arr[63]);
        Assert.assertEquals("Bar", arr[127]);
        Assert.assertEquals("Bar", arr[255]);
    }

    public void testPipeWoofAndDelimiter() throws IOException {
        // given
        FizzBuzz fizzBuzz = new FizzBuzz(15, FizzBuzz.PIPE, FIZZ, WOOF, BAR);

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);

        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("Bar", arr[1]);
        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Woof", arr[6]);
        Assert.assertEquals("Bar", arr[7]);
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("Woof", arr[13]);
        Assert.assertEquals("Fizz", arr[14]);
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
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        printResult(result);

        Assert.assertEquals(delimiter, fizzBuzz.getDelimiter());
        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("Bar", arr[1]);
        Assert.assertEquals("Fizz", arr[2]);
        Assert.assertEquals("Bar", arr[3]);
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("Bar", arr[7]);
        Assert.assertEquals("Foo", arr[10]);
        Assert.assertEquals("FizzBuzz", arr[14]);
        Assert.assertEquals("Bar", arr[15]);
        Assert.assertEquals("Foo", arr[21]);
        Assert.assertEquals("Bar", arr[31]);
        Assert.assertEquals("Bar", arr[63]);
        Assert.assertEquals("FooFizz", arr[98]);
        Assert.assertEquals("FooFizz", arr[110]);
        Assert.assertEquals("Bar", arr[127]);
        Assert.assertEquals("FooFizz", arr[221]);
        Assert.assertEquals("Bar", arr[255]);
    }
}
