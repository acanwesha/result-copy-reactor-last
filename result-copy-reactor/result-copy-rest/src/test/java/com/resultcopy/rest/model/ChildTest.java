package com.resultcopy.rest.model;

import com.resultcopy.rest.model.Child;
import com.resultcopy.rest.model.PatientDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AC089545
 * Test case for Child.
 */
public class ChildTest {
  Child child = new Child();
  List<PatientDetails> childList = null;
  @Mock
  List<PatientDetails> listChild;
  /**
   * Test case for the setters and getters.
   */
  @Test
  public void testChildResponse() {
    PatientDetails patientDetailsResponse = new PatientDetails();
    childList = new ArrayList<>();
    patientDetailsResponse.setId(1);
    patientDetailsResponse.setFirstName("AARAV");
    patientDetailsResponse.setLastName("ESPINOSA");
    patientDetailsResponse.setMrn("MX123");
    patientDetailsResponse.setFin("MH123");
    childList.add(patientDetailsResponse);
    child.setChildDetails(childList);
    Assertions.assertEquals(childList, child.getChildDetails());
  }

  /**
   * Tests for constructor childDetails.
   */
  @Test
  public void testConstructor() {
    Assertions.assertNotNull(child.childDetails(childList));
  }

  /**
   * Test for toString method
   */
  @Test
  public void testToStringReturnString(){
    Assertions.assertEquals(child.toString(), "class Child {\n" +
            "    childDetails: null\n" +
            "}");
  }

  /**
   * Test for equals method
   */
  @Test public void testEqualsTrue() {
    Object object = null;;
    Assertions.assertEquals(child.equals(object), false);
  }
  @Test
  public void testHashCode()
  {
    Assertions.assertNotEquals(12345, child.hashCode());
  }
  @Test
  public void testPatientDetailsEquals()
  {

    Assertions.assertEquals(false, child.equals(0));
    Assertions.assertEquals(true, child.equals(child));
    Child childDetails = new Child();
    Assertions.assertEquals(true,child.equals(childDetails));
  }
}
