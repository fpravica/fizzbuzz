package com.prottone.fizzbuzz;

import com.prottone.fizzbuzz.custom.BuzzersAll;
import org.junit.Assert;


public class FizzBuzzStepBuilderTest extends BuzzersTestBase {

    public void testFor_FIZZ_BUZZ_WithDefaultWriterAndDelimiter() {
        //given
        int maxLength = 15;

        FizzBuzz fizzBuzz = FizzBuzzStepBuilder.newBuilder()
                .maxLength(maxLength)
                .withBuzzers(BuzzersAll.FIZZ, BuzzersAll.BUZZ)
                .withDefaultWriterAndDelimiter()
                .build();

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("2", arr[1]);
        Assert.assertEquals("Fizz", arr[2] );
        Assert.assertEquals("4", arr[3] );
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("7", arr[6] );
        Assert.assertEquals("8", arr[7] );
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("FizzBuzz", arr[14]);
    }

    public void testFor_FIZZ_BUZZ_WithPipeDelimiter() {
        //given
        int maxLength = 15;
        String delimiter = FizzBuzz.PIPE;
        FizzBuzz fizzBuzz = FizzBuzzStepBuilder.newBuilder()
                .maxLength(maxLength)
                .withBuzzers(BuzzersAll.FIZZ, BuzzersAll.BUZZ)
                .withDelimiter(delimiter)
                .build();

        // when
        fizzBuzz.run();
        String result = fizzBuzz.getWriter().toString();

        // then
        String[] arr = result.split("\\" + fizzBuzz.getDelimiter());
        Assert.assertEquals("1", arr[0]);
        Assert.assertEquals("2", arr[1]);
        Assert.assertEquals("Fizz", arr[2] );
        Assert.assertEquals("4", arr[3] );
        Assert.assertEquals("Buzz", arr[4]);
        Assert.assertEquals("Fizz", arr[5]);
        Assert.assertEquals("7", arr[6] );
        Assert.assertEquals("8", arr[7] );
        Assert.assertEquals("Fizz", arr[8]);
        Assert.assertEquals("Buzz", arr[9]);
        Assert.assertEquals("Fizz", arr[11]);
        Assert.assertEquals("FizzBuzz", arr[14]);
    }

    public void testWriterValidation() {
        //given
        int maxLength = 15;
        IllegalArgumentException expectedException = new IllegalArgumentException("writer cannot be null");
        Exception actualException = null;

        // when
        try {
            FizzBuzz fizzBuzz = FizzBuzzStepBuilder.newBuilder()
                    .maxLength(maxLength)
                    .withBuzzers(BuzzersAll.FIZZ)
                    .withWriter(null)
                    .build();
        } catch (Exception e) {
            actualException = e;
        }

        // then
        Assert.assertNotNull(actualException);
        Assert.assertTrue(actualException instanceof IllegalArgumentException);
        Assert.assertTrue(actualException.getMessage().equals(expectedException.getMessage()));
    }


}