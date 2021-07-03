package com.resultcopy.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;

public class CategoryPostTest {
    CategoryPost categoryPost = new CategoryPost();
    @Mock
    List<CategoryPostResult> resultList;

    /**
     * Test for setter getter of displayName.
     */
    @Test
     public void testCategoryDisplayName(){
         categoryPost.setDisplayName("DELIVERY_INFORMATION");
         Assertions.assertEquals("DELIVERY_INFORMATION",categoryPost.getDisplayName());
     }

    /**
     * Test for setter getter of displayName.
     */
    @Test
    public void testResult(){
        categoryPost.setResult(resultList);
        Assertions.assertEquals(resultList,categoryPost.getResult());
    }

    /**
     * Test the constructor for displayName.
     */
    @Test
    public void testDisplayNameConstructor(){
        Assertions.assertNotNull(categoryPost.displayName("DELIVERY_INFORMATION"));
    }

    /**
     * Test the constructor for displayName.
     */
    @Test
    public void testResultConstructor(){
        Assertions.assertNotNull(categoryPost.result(resultList));
    }

    /**
     * Test for toString method
     */
    @Test
    public void testToStringReturnString(){
        Assertions.assertEquals(categoryPost.toString(), "class CategoryPost {\n" +
                "    displayName: null\n" +
                "    result: null\n" +
                "}");
    }

    @Test
    public void testHashCode()
    {
        Assertions.assertNotEquals(12345, categoryPost.hashCode());
    }
    @Test
    public void testPatientDetailsEquals()
    {

        Assertions.assertEquals(false, categoryPost.equals(0));
        Assertions.assertEquals(true, categoryPost.equals(categoryPost));
        CategoryPost categoryPostDetails = new CategoryPost();
        Assertions.assertEquals(true,categoryPost.equals(categoryPostDetails));
    }
}
