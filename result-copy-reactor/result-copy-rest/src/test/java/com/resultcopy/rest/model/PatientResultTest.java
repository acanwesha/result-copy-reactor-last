package com.resultcopy.rest.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

public class PatientResultTest {
 PatientResult patientResult = new PatientResult();
  @Mock
  List<Patient> patientList;

  @Mock
  Patient patient;

  @Mock
  List<Child> child;

  @Mock
  List<Category> category;

  @Test
    public void testPatientList(){
      patientResult.setPatient(patientList);
      Assertions.assertEquals(patientList,patientResult.getPatient());
  }

    @Test
    public void testPatient(){
        patientResult.setPatientt(patient);
        Assertions.assertEquals(patientList,patientResult.getPatientt());
    }

    @Test
    public void testChild(){
        patientResult.setChild(child);
        Assertions.assertEquals(child,patientResult.getChild());
    }

    @Test
    public void testCategory(){
        patientResult.setCategory(category);
        Assertions.assertEquals(category,patientResult.getCategory());
    }

    @Test
    public void testPatientListConstructor(){
        Assertions.assertNotNull(patientResult.patient(patientList));
    }

    @Test
    public void testChildListConstructor(){
        Assertions.assertNotNull(patientResult.child(child));
    }

    @Test
    public void testCategoryConstructor(){
        Assertions.assertNotNull(patientResult.category(category));
    }

    /**
     * Test for toString method
     */
    @Test
    public void testToStringReturnString(){
        Assertions.assertEquals(patientResult.toString(), "class PatientResult {\n" +
                "    patient: null\n" +
                "    patient: []\n" +
                "    child: []\n" +
                "    category: []\n" +
                "}");
    }

    @Test
    public void testHashCode()
    {
        Assertions.assertNotEquals(12345, patientResult.hashCode());
    }
    @Test
    public void testPatientDetailsEquals()
    {
        Assertions.assertEquals(false, patientResult.equals(0));
        Assertions.assertEquals(true, patientResult.equals(patientResult));
        PatientResult patientResultDetails = new PatientResult();
        Assertions.assertEquals(false,patientResultDetails.equals(patientResult));
    }
}
