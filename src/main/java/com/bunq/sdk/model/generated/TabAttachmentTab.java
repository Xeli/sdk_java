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
 * This call is used to view an attachment that is linked to a tab.
 */
public class TabAttachmentTab extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_READ = "tab/%s/attachment/%s";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "TabAttachmentTab";

  /**
   * The id of the attachment.
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  /**
   * The timestamp of the attachment's creation.
   */
  @Expose
  @SerializedName("created")
  private String created;

  /**
   * The timestamp of the attachment's last update.
   */
  @Expose
  @SerializedName("updated")
  private String updated;

  /**
   * The attachment.
   */
  @Expose
  @SerializedName("attachment")
  private Attachment attachment;

  public static TabAttachmentTab get(ApiContext apiContext, String tabUuid,
      Integer tabAttachmentTabId) {
    return get(apiContext, tabUuid, tabAttachmentTabId, new HashMap<>());
  }

  /**
   * Get a specific attachment. The header of the response contains the content-type of the
   * attachment.
   */
  public static TabAttachmentTab get(ApiContext apiContext, String tabUuid,
      Integer tabAttachmentTabId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_READ, tabUuid, tabAttachmentTabId), customHeaders);

    return fromJson(TabAttachmentTab.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The id of the attachment.
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The timestamp of the attachment's creation.
   */
  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * The timestamp of the attachment's last update.
   */
  public String getUpdated() {
    return this.updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
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

}
