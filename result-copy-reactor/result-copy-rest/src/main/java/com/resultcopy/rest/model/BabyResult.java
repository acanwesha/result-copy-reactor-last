package com.resultcopy.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;

/**
 * Baby result information that is to be copied and be linked to the baby.
 */
@Schema(description = "Baby result information that is to be copied and be linked to the baby.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class BabyResult   {
  @JsonProperty("childId")
  private Integer childId = null;

  @JsonProperty("category")
  private List<CategoryPost> category = null;

  /**
   * Constructor for childId.
   * @param childId {@link BabyResult} Unique Identifier for child.
   * @return childId {@link BabyResult} returns the childId.
   */
  public BabyResult childId(Integer childId) {
    this.childId = childId;
    return this;
  }

  /**
   * Identifier for a child.
   * @return childId {@link BabyResult} returns the childId.
   */
  @JsonProperty("childId")
  @Schema(example = "35", description = "Identifier for a child.")
  public Integer getChildId() {
    return childId;
  }

  /**
   * The method sets the Child Id.
   * @param childId Unique identifier for a child.
   */
  public void setChildId(Integer childId) {
    this.childId = childId;
  }

  /**
   * Constructor for list of category.
   * @param category List of categories available as a part of patient reports that are to be copied.
   * @return return The list of category is returned.
   */
  public BabyResult category(List<CategoryPost> category) {
    this.category = category;
    return this;
  }

  /**
   * List of categories available as a part of patient reports that are to be copied.
   * @return category The category available for patient is returned.
   */
  @JsonProperty("category")
  @Schema(description = "List of categories available as a part of patient reports that are to be copied.")
  @Valid
  public List<CategoryPost> getCategory() {
    return category;
  }

  /**
   * The method sets the category.
   * @param category {@link CategoryPost} List of categories available as a part of patient reports that are to be copied.
   */
  public void setCategory(List<CategoryPost> category) {
    this.category = category;
  }

  /**
   * The method checks object equaliation.
   * @param object generated the object of babyResult.
   * @return boolean value on object equality.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    BabyResult babyResult = (BabyResult) object;
    return Objects.equals(this.childId, babyResult.childId) &&
        Objects.equals(this.category, babyResult.category);
  }

  /**
   * Hash code method.
   * @return overriding hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(childId, category);
  }

  /**
   * To string method.
   * @return to string method returns the string format of baby Result.
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("class BabyResult {\n");

    stringBuilder.append("    childId: ").append(toIndentedString(childId)).append("\n");
    stringBuilder.append("    category: ").append(toIndentedString(category)).append("\n");
    stringBuilder.append("}");
    return stringBuilder.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object object) {
    if (object == null) {
      return "null";
    }
    return object.toString().replace("\n", "\n    ");
  }
}
