package com.resultcopy.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * List of categories available as a part of patient reports.
 */
@Schema(description = "List of categories available as a part of patient reports.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class Category   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("result")
  private List<Result> result = null;

  /**
   * Constructor for category id.
   * @param id Unique identifier for a category.
   * @return id {@link Category} Returns the Identifier for category.
   */
  public Category id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for category.
   * @return id {@link Category} Returns the identifier set for category.
   **/
  @JsonProperty("id")
  @Schema(example = "20", description = "Identifier for category.")
  public Integer getId() {
    return id;
  }

  /**
   * Setter for Category Identifier.
   * @param id Unique identifier for category.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  public Category displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Name of the category.
   * @return displayName
   **/
  @JsonProperty("displayName")
  @Schema(example = "DELIVERY_INFORMATION", description = "Name of the category.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Category result(List<Result> result) {
    this.result = result;
    return this;
  }

  /**
   * List of result details documented for the mother patient.
   * @return result
   **/
  @JsonProperty("result")
  @Schema(description = "List of result details documented for the mother patient.")
  @Valid
  public List<Result> getResult() {
    return result;
  }

  public void setResult(List<Result> result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.id, category.id) &&
        Objects.equals(this.displayName, category.displayName) &&
        Objects.equals(this.result, category.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
