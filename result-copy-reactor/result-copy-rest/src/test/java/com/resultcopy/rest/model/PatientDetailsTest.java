package com.resultcopy.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.mockito.Matchers.any;

/**
 * @author AC089545
 * Test case for PatientDetailsResponse.
 */
public class PatientDetailsTest {
  PatientDetails patientDetails = new PatientDetails();

  /**
   *  Test case for the setter and getter for Id.
   */
  @Test
  public void testPatientDetailsId() {
    patientDetails.setId(1);
    Assertions.assertEquals(1, patientDetails.getId());
  }

  /**
   * Test case for the setter and getter for FirstName.
   */
  @Test
  public void testPatientDetailsFirstName() {
    patientDetails.setFirstName("EMMA");
    Assertions.assertEquals("EMMA", patientDetails.getFirstName());
  }

  /**
   * Test case for the setter and getter for LastName.
   */
  @Test
  public void testPatientDetailsLastName() {
    patientDetails.setLastName("ESPINOSA");
    Assertions.assertEquals("ESPINOSA", patientDetails.getLastName());
  }

  /** Test case for the setter and getter for Mrn. */
  @Test
  public void testPatientDetailsMrn() {
    patientDetails.setMrn("MX123");
    Assertions.assertEquals("MX123", patientDetails.getMrn());
  }

  /** Test case for the setter and getter for Fin. */
  @Test
  public void testPatientDetailsFin() {
    patientDetails.setFin("MH123");
    Assertions.assertEquals("MH123", patientDetails.getFin());
  }

  /** Test case for the setter and getter for Fin. */
  @Test
  public void testPatientDetailsDateTime() {
   patientDetails.setResultCopiedDateTime(new Date());
   Assertions.assertEquals(new Date().getTime(),patientDetails.getResultCopiedDateTime().getTime());
  }

  /** Test for constructor Id. */
  @Test
  public void testConstructorId() {
    Assertions.assertNotNull(patientDetails.id(1));
  }

  /** Test for constructor FirstName. */
  @Test
  public void testConstructorFirstName() {
    Assertions.assertNotNull(patientDetails.firstName("EMMA"));
  }

  /** Test for constructor LastName. */
  @Test
  public void testConstructorLastName() {
    Assertions.assertNotNull(patientDetails.lastName("ESPINOSA"));
  }

  /** Test for constructor Mrn. */
  @Test
  public void testConstructorMrn() {
    Assertions.assertNotNull(patientDetails.mrn("MX123"));
  }

  /** Test for constructor Fin. */
  @Test
  public void testConstructorFin() {
    Assertions.assertNotNull(patientDetails.fin("MH123"));
  }

  /** Test for toString method */
  @Test
  public void testToStringReturnString(){
    Assertions.assertEquals(patientDetails.toString(), "class PatientDetails {\n" +
            "    id: null\n" +
            "    firstName: null\n" +
            "    lastName: null\n" +
            "    mrn: null\n" +
            "    fin: null\n" +
            "}");
  }

  @Test
  public void testHashCode()
  {
    Assertions.assertNotEquals(12345, patientDetails.hashCode());
  }
  @Test
  public void testPatientDetailsEquals()
  {
    Assertions.assertEquals(false, patientDetails.equals(0));
    Assertions.assertEquals(true, patientDetails.equals(patientDetails));
    PatientDetails patient = new PatientDetails();
    Assertions.assertEquals(true,patient.equals(patientDetails));
  }
}
