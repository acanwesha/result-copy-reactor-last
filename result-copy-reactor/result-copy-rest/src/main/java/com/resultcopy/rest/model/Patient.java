/*
 * Result Copy Reactor Web Server.
 * This server contains services like getting the patient details, child details, category details of result, copy the results from mother to the child.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.resultcopy.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Information about the patient.
 */
@Schema(description = "Information about the patient.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class Patient   {
  @JsonProperty("patientDetails")
  private PatientDetails patientDetails = null;

  /**
   * Initializes the patient details.
   * @param patientDetails {@link PatientDetails}
   * @return {@link Patient}
   */
  public Patient patientDetails(PatientDetails patientDetails) {
    this.patientDetails = patientDetails;
    return this;
  }
/*
  public Patient addPatientDetailsItem(PatientDetails patientDetailsItem) {
    if (this.patientDetails == null) {
      this.patientDetails = new PatientDetails();
    }

    return this;
  }
*/
  /**
   * Information about the patient.
   * @return patientDetails
   **/
  @JsonProperty("patientDetails")
  @Schema(description = "Information about the patient.")
  @Valid
  public PatientDetails getPatientDetails() {
    return patientDetails;
  }

  public void setPatientDetails(PatientDetails patientDetails) {
    this.patientDetails = patientDetails;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");

    sb.append("    patientDetails: ").append(toIndentedString(patientDetails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
