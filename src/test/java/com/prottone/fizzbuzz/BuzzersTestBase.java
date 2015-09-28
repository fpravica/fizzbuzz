package com.prottone.fizzbuzz;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Collection;
import java.util.Collections;

public abstract class BuzzersTestBase extends TestCase {

    protected void assertResults(Buzzer buzzer, Collection<Integer> triggers){
        int startCount = Collections.min(triggers);
        int endCount = Collections.max(triggers);

        for(int num = startCount; num <= endCount; num++) {
            if (triggers.contains(num)){
                // for this index, buzzer should return the output equals to the buzzer toString value
                Assert.assertEquals(buzzer.toString(), buzzer.execute(num));
            } else {
                Assert.assertEquals("", buzzer.execute(num));
            }
        }
    }

}
