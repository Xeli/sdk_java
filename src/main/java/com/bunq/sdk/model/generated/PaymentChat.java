package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manage the chat connected to a payment.
 */
public class PaymentChat extends BunqModel {

  /**
   * Field constants.
   */
  public static final String FIELD_LAST_READ_MESSAGE_ID = "last_read_message_id";

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_CREATE = "user/%s/monetary-account/%s/payment/%s/chat";
  private static final String ENDPOINT_URL_UPDATE = "user/%s/monetary-account/%s/payment/%s/chat/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/payment/%s/chat";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "ChatConversationPayment";

  /**
   * The id of the chat conversation.
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  /**
   * The timestamp when the chat was created.
   */
  @Expose
  @SerializedName("created")
  private String created;

  /**
   * The timestamp when the chat was last updated.
   */
  @Expose
  @SerializedName("updated")
  private String updated;

  /**
   * The total number of unread messages in this conversation.
   */
  @Expose
  @SerializedName("unread_message_count")
  private Integer unreadMessageCount;

  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer paymentId) {
    return create(apiContext, requestMap, userId, monetaryAccountId, paymentId, new HashMap<>());
  }

  /**
   * Create a chat for a specific payment.
   */
  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer paymentId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient
        .post(String.format(ENDPOINT_URL_CREATE, userId, monetaryAccountId, paymentId),
            requestBytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  public static PaymentChat update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer paymentId, Integer paymentChatId) {
    return update(apiContext, requestMap, userId, monetaryAccountId, paymentId, paymentChatId,
        new HashMap<>());
  }

  /**
   * Update the last read message in the chat of a specific payment.
   */
  public static PaymentChat update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer paymentId, Integer paymentChatId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient.put(
        String.format(ENDPOINT_URL_UPDATE, userId, monetaryAccountId, paymentId, paymentChatId),
        requestBytes, customHeaders);

    return fromJson(PaymentChat.class, new String(responseBytes), OBJECT_TYPE);
  }

  public static List<PaymentChat> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer paymentId) {
    return list(apiContext, userId, monetaryAccountId, paymentId, new HashMap<>());
  }

  /**
   * Get the chat for a specific payment.
   */
  public static List<PaymentChat> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer paymentId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, paymentId),
            customHeaders);

    return fromJsonList(PaymentChat.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The id of the chat conversation.
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The timestamp when the chat was created.
   */
  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * The timestamp when the chat was last updated.
   */
  public String getUpdated() {
    return this.updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  /**
   * The total number of unread messages in this conversation.
   */
  public Integer getUnreadMessageCount() {
    return this.unreadMessageCount;
  }

  public void setUnreadMessageCount(Integer unreadMessageCount) {
    this.unreadMessageCount = unreadMessageCount;
  }

}
