package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 */
public class Avatar extends BunqModel {

  /**
   * The public UUID of the avatar.
   */
  @Expose
  @SerializedName("uuid")
  private String uuid;

  /**
   * The public UUID of object this avatar is anchored to.
   */
  @Expose
  @SerializedName("anchor_uuid")
  private String anchorUuid;

  /**
   * The actual image information of this avatar.
   */
  @Expose
  @SerializedName("image")
  private List<Image> image;

  public Avatar(String uuid) {
    this.uuid = uuid;
  }

  /**
   * The public UUID of the avatar.
   */
  public String getUuid() {
    return this.uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * The public UUID of object this avatar is anchored to.
   */
  public String getAnchorUuid() {
    return this.anchorUuid;
  }

  public void setAnchorUuid(String anchorUuid) {
    this.anchorUuid = anchorUuid;
  }

  /**
   * The actual image information of this avatar.
   */
  public List<Image> getImage() {
    return this.image;
  }

  public void setImage(List<Image> image) {
    this.image = image;
  }

}
