package com.resultcopy.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;

public class CategoryPostResultTest {
    CategoryPostResult categoryPostResult = new CategoryPostResult();

    /**
     * Test for setter and getter of result display name.
     */
    @Test
    public void testResultDisplayName(){
        categoryPostResult.setDisplayName("PREGNANCY_OUTCOME");
        Assertions.assertEquals("PREGNANCY_OUTCOME",categoryPostResult.getDisplayName());
    }

    /**
     * Test for setter and getter of result Value.
     */
    @Test
    public void testResultValue(){
        categoryPostResult.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH",categoryPostResult.getValue());
    }

    /**
     * Test for Result Display name constructor.
     */
    @Test
    public void testResultDisplayNameConstructor(){
        Assertions.assertNotNull(categoryPostResult.displayName("PREGNANCY_OUTCOME"));
    }

    /**
     * Test for Result Value constructor.
     */
    @Test
    public void testResultValueConstructor(){
        Assertions.assertNotNull(categoryPostResult.value("VAGINAL_BIRTH"));
    }

    /**
     * Test for toString method
     */
    @Test
    public void testToStringReturnString(){
        Assertions.assertEquals(categoryPostResult.toString(), "class CategoryPostResult {\n" +
                "    displayName: null\n" +
                "    value: null\n" +
                "}");
    }

    @Test
    public void testHashCode()
    {
        Assertions.assertNotEquals(12345, categoryPostResult.hashCode());
    }
    @Test
    public void testPatientDetailsEquals()
    {

        Assertions.assertEquals(false, categoryPostResult.equals(0));
        Assertions.assertEquals(true, categoryPostResult.equals(categoryPostResult));
        CategoryPostResult categoryPostResultDetails = new CategoryPostResult();
        Assertions.assertEquals(true, categoryPostResult.equals(categoryPostResultDetails));
    }
}
