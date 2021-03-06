package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import com.bunq.sdk.model.generated.object.Attachment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/**
 * This call is used to upload an attachment that can be referenced to in payment requests and
 * payments sent from a specific monetary account. Attachments supported are png, jpg and gif.
 */
public class AttachmentMonetaryAccount extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_CREATE = "user/%s/monetary-account/%s/attachment";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "AttachmentMonetaryAccount";

  /**
   * The attachment.
   */
  @Expose
  @SerializedName("attachment")
  private Attachment attachment;

  /**
   * The ID of the attachment created.
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  public static Integer create(ApiContext apiContext, byte[] bytes, Integer userId,
      Integer monetaryAccountId) {
    return create(apiContext, bytes, userId, monetaryAccountId, new HashMap<>());
  }

  /**
   * Create a new monetary account attachment. Create a POST request with a payload that contains
   * the binary representation of the file, without any JSON wrapping. Make sure you define the
   * MIME type (i.e. image/jpeg) in the Content-Type header. You are required to provide a
   * description of the attachment using the X-Bunq-Attachment-Description header.
   */
  public static Integer create(ApiContext apiContext, byte[] bytes, Integer userId,
      Integer monetaryAccountId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .post(String.format(ENDPOINT_URL_CREATE, userId, monetaryAccountId), bytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  /**
   * The attachment.
   */
  public Attachment getAttachment() {
    return this.attachment;
  }

  public void setAttachment(Attachment attachment) {
    this.attachment = attachment;
  }

  /**
   * The ID of the attachment created.
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
