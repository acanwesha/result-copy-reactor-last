package com.resultcopy.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
public class BabyResultTest {

    BabyResult babyResult = new BabyResult();
    @Mock
    List<CategoryPost> categoryList;

    /**
     * Test case for setter getter of Child Id
     */
    @Test
    public void testChildId(){
        babyResult.setChildId(1);
        Assertions.assertEquals(1,babyResult.getChildId());
    }

    /**
     * Test case for setter getter of Child Id
     */
    @Test
    public void testCategory(){
        babyResult.setCategory(categoryList);
        Assertions.assertEquals(categoryList,babyResult.getCategory());
    }

    /**
     * Test case for setter getter of Child Id
     */
    @Test
    public void testChildIdConstructor(){
        Assertions.assertNotNull(babyResult.childId(1));
    }

    /**
     * Test case for setter getter of Child Id
     */
    @Test
    public void testCategoryConstructor(){
        Assertions.assertNotNull(babyResult.category(categoryList));
    }

    /**
     * Test for toString method
     */
    @Test
    public void testToStringReturnString(){
        Assertions.assertEquals(babyResult.toString(), "class BabyResult {\n" +
                "    childId: null\n" +
                "    category: null\n" +
                "}");
    }
    @Test
    public void testHashCode()
    {
        Assertions.assertNotEquals(12345, babyResult.hashCode());
    }
    @Test
    public void testPatientDetailsEquals()
    {
        Object object = null;
        Assertions.assertEquals(false, babyResult.equals(0));
        Assertions.assertEquals(true, babyResult.equals(babyResult));
        BabyResult babyResultDetails = new BabyResult();
        Assertions.assertEquals(true,babyResult.equals(babyResultDetails));
    }

    @Test public void testEqualsTrue() {
        Object object = null;;
        Assertions.assertEquals(babyResult.equals(object), false);
    }
}
