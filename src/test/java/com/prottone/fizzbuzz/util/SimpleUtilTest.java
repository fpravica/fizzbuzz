package com.prottone.fizzbuzz.util;

import junit.framework.TestCase;
import org.junit.Assert;


public class SimpleUtilTest extends TestCase {

    public void testCapitalizeAllLowerCase(){
        //given
        String input = "simple";
        String expectedOutput = "Simple";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeAllUpperCase(){
        //given
        String input = "SIMPLE";
        String expectedOutput = "Simple";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeAlreadyCapitalized(){
        //given
        String input = "Simple";
        String expectedOutput = "Simple";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeOneLetterLowerCaseInput(){
        //given
        String input = "s";
        String expectedOutput = "S";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeOneLetterUpperCaseInput(){
        //given
        String input = "S";
        String expectedOutput = "S";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeEmptyInputShouldReturnEmpty(){
        //given
        String input = "";
        String expectedOutput = "";

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testCapitalizeNullInputShouldReturnNull(){
        //given
        String input = null;
        String expectedOutput = null;

        //when
        String actualOutput = SimpleUtils.capitalize(input);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

}