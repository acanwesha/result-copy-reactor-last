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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Information about the child.
 */
@Schema(description = "Information about the child.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class Child   {
  @JsonProperty("childDetails")
  private List<PatientDetails> childDetails = null;

  public Child childDetails(List<PatientDetails> childDetails) {
    this.childDetails = childDetails;
    return this;
  }


  /**
   * Information of the child.
   * @return childDetails
   **/
  @JsonProperty("childDetails")
  @Schema(description = "Information of the child.")
  @Valid
  public List<PatientDetails> getChildDetails() {
    return childDetails;
  }

  public void setChildDetails(List<PatientDetails> childDetails) {
    this.childDetails = childDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Child child = (Child) o;
    return Objects.equals(this.childDetails, child.childDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Child {\n");
    
    sb.append("    childDetails: ").append(toIndentedString(childDetails)).append("\n");
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
