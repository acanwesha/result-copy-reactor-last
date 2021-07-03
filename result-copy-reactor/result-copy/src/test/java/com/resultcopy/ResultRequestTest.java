package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AC089545
 * Test cases for ResultRequest.
 */
public class ResultRequestTest {
    ResultRequest resultRequest = new ResultRequest();

    /**
     * Test case for setter and getter of displayName.
     */
    @Test
    public void testDisplayName(){
        resultRequest.setDisplayName("PREGNANCY_OUTCOME");
        Assertions.assertEquals("PREGNANCY_OUTCOME",resultRequest.getDisplayName());
    }

    /**
     * Test case for setter and getter of value.
     */
    @Test
    public void testValue(){
        resultRequest.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH",resultRequest.getValue());
    }
}
