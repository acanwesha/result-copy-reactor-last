package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;

/**
 * @author AC089545
 * Test cases for setter and getter of CategoryRequest.
 */
public class CategoryRequestTest {

    @Mock
    List<ResultRequest> resultRequests;
    @Mock
    CategoryRequest categoryRequest = new CategoryRequest();

    /**
     * Test case for setter and getter of display name.
     */
    @Test
    public void testDisplayName(){
        categoryRequest.setDisplayName("DELIVERY_INFORMATION");
        Assertions.assertEquals("DELIVERY_INFORMATION",categoryRequest.getDisplayName());
    }

    /**
     * Test case of setter and getter of result list.
     */
    @Test
    public void testResultList(){
        categoryRequest.setResult(resultRequests);
        Assertions.assertEquals(resultRequests,categoryRequest.getResult());
    }
}
