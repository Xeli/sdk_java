package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 */
public class Pointer extends BunqModel {

  /**
   * The alias type, can be: EMAIL|PHONE_NUMBER|IBAN.
   */
  @Expose
  @SerializedName("type")
  private String type;

  /**
   * The alias value.
   */
  @Expose
  @SerializedName("value")
  private String value;

  /**
   * The alias name.
   */
  @Expose
  @SerializedName("name")
  private String name;

  public Pointer(String type, String value) {
    this.type = type;
    this.value = value;
  }

  /**
   * The alias type, can be: EMAIL|PHONE_NUMBER|IBAN.
   */
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * The alias value.
   */
  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The alias name.
   */
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
