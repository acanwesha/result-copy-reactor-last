
package com.resultcopy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author AC089545
 * Demographic information.
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDetailsResponse {
  private Integer id;
  private String firstName;
  private String lastName;
  private String mrn;
  private String fin;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Date resultCopiedDateTime;
}
