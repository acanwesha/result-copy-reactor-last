package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AC089545
 * Test cases for ChildResultResponse.
 */
public class ChildResultResponseTest {
    ChildResultResponse childResultResponse = new ChildResultResponse();

    /**
     * Test case for setter and getter of Result Id.
     */
    @Test
    public void testResultId(){
        childResultResponse.setResultId(20);
        Assertions.assertEquals(20,childResultResponse.getResultId());
    }

    /**
     * Test case for setter and getter of Child Id.
     */
    @Test
    public void testChildId(){
        childResultResponse.setChildId(12);
        Assertions.assertEquals(12,childResultResponse.getChildId());
    }

    /**
     * Test case for setter and getter of value.
     */
    @Test
    public void testValue(){
        childResultResponse.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH",childResultResponse.getValue());
    }
}
