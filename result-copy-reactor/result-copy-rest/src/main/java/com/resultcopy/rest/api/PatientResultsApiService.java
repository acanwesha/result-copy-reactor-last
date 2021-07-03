package com.resultcopy.rest.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/**
 * This is an abstract class where the methods of class PatientResultApi is defined.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")
public abstract class PatientResultsApiService {

    /**
     * This is an abstract method used to access the patient and child results by patientId.
     * @param patientId {@link String} This is the unique identifier for a patient.
     * @param securityContext {@link SecurityContext} This the security context set.
     * @throws NotFoundException  throws NotFoundException when the BabyResult class is not found.
     * @return The method returns the response generated from the patient get method.
     */
    public abstract Response patientResultsPatientIdGet(String patientId,SecurityContext securityContext) throws NotFoundException, IOException;
}
