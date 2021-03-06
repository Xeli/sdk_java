package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import com.bunq.sdk.model.generated.object.Amount;
import com.bunq.sdk.model.generated.object.AttachmentPublic;
import com.bunq.sdk.model.generated.object.AttachmentTab;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * After you’ve created a Tab using /tab-usage-single or /tab-usage-multiple you can add items
 * and attachments using tab-item. You can only add or modify TabItems of a Tab which status is
 * OPEN. The amount of the TabItems will not influence the total_amount of the corresponding
 * Tab. However, if you've created any TabItems for a Tab the sum of the amounts of these items
 * must be equal to the total_amount of the Tab when you change its status to
 * PAYABLE/WAITING_FOR_PAYMENT.
 */
public class TabItemShop extends BunqModel {

  /**
   * Field constants.
   */
  public static final String FIELD_DESCRIPTION = "description";
  public static final String FIELD_EAN_CODE = "ean_code";
  public static final String FIELD_AVATAR_ATTACHMENT_UUID = "avatar_attachment_uuid";
  public static final String FIELD_TAB_ATTACHMENT = "tab_attachment";
  public static final String FIELD_QUANTITY = "quantity";
  public static final String FIELD_AMOUNT = "amount";

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_CREATE = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-item";
  private static final String ENDPOINT_URL_UPDATE = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-item/%s";
  private static final String ENDPOINT_URL_DELETE = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-item/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-item";
  private static final String ENDPOINT_URL_READ = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-item/%s";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "TabItem";

  /**
   * The id of the created TabItem.
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  /**
   * The TabItem's brief description.
   */
  @Expose
  @SerializedName("description")
  private String description;

  /**
   * The TabItem's EAN code.
   */
  @Expose
  @SerializedName("ean_code")
  private String eanCode;

  /**
   * A struct with an AttachmentPublic UUID that used as an avatar for the TabItem.
   */
  @Expose
  @SerializedName("avatar_attachment")
  private AttachmentPublic avatarAttachment;

  /**
   * A list of AttachmentTab attached to the TabItem.
   */
  @Expose
  @SerializedName("tab_attachment")
  private List<AttachmentTab> tabAttachment;

  /**
   * The quantity of the TabItem.
   */
  @Expose
  @SerializedName("quantity")
  private BigDecimal quantity;

  /**
   * The money amount of the TabItem.
   */
  @Expose
  @SerializedName("amount")
  private Amount amount;

  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId, String tabUuid) {
    return create(apiContext, requestMap, userId, monetaryAccountId, cashRegisterId, tabUuid,
        new HashMap<>());
  }

  /**
   * Create a new TabItem for a given Tab.
   */
  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient.post(
        String.format(ENDPOINT_URL_CREATE, userId, monetaryAccountId, cashRegisterId, tabUuid),
        requestBytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  public static Integer update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Integer tabItemShopId) {
    return update(apiContext, requestMap, userId, monetaryAccountId, cashRegisterId, tabUuid,
        tabItemShopId, new HashMap<>());
  }

  /**
   * Modify a TabItem from a given Tab.
   */
  public static Integer update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Integer tabItemShopId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient.put(String
        .format(ENDPOINT_URL_UPDATE, userId, monetaryAccountId, cashRegisterId, tabUuid,
            tabItemShopId), requestBytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  public static void delete(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Integer tabItemShopId) {
    delete(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, tabItemShopId,
        new HashMap<>());
  }

  /**
   * Delete a specific TabItem from a Tab. This request returns an empty response.
   */
  public static void delete(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Integer tabItemShopId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    apiClient.delete(String
        .format(ENDPOINT_URL_DELETE, userId, monetaryAccountId, cashRegisterId, tabUuid,
            tabItemShopId), customHeaders);
  }

  public static List<TabItemShop> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, new HashMap<>());
  }

  /**
   * Get a collection of TabItems from a given Tab.
   */
  public static List<TabItemShop> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient.get(
        String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId, tabUuid),
        customHeaders);

    return fromJsonList(TabItemShop.class, new String(responseBytes), OBJECT_TYPE);
  }

  public static TabItemShop get(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Integer tabItemShopId) {
    return get(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, tabItemShopId,
        new HashMap<>());
  }

  /**
   * Get a specific TabItem from a given Tab.
   */
  public static TabItemShop get(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Integer tabItemShopId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient.get(String
        .format(ENDPOINT_URL_READ, userId, monetaryAccountId, cashRegisterId, tabUuid,
            tabItemShopId), customHeaders);

    return fromJson(TabItemShop.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The id of the created TabItem.
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The TabItem's brief description.
   */
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The TabItem's EAN code.
   */
  public String getEanCode() {
    return this.eanCode;
  }

  public void setEanCode(String eanCode) {
    this.eanCode = eanCode;
  }

  /**
   * A struct with an AttachmentPublic UUID that used as an avatar for the TabItem.
   */
  public AttachmentPublic getAvatarAttachment() {
    return this.avatarAttachment;
  }

  public void setAvatarAttachment(AttachmentPublic avatarAttachment) {
    this.avatarAttachment = avatarAttachment;
  }

  /**
   * A list of AttachmentTab attached to the TabItem.
   */
  public List<AttachmentTab> getTabAttachment() {
    return this.tabAttachment;
  }

  public void setTabAttachment(List<AttachmentTab> tabAttachment) {
    this.tabAttachment = tabAttachment;
  }

  /**
   * The quantity of the TabItem.
   */
  public BigDecimal getQuantity() {
    return this.quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  /**
   * The money amount of the TabItem.
   */
  public Amount getAmount() {
    return this.amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

}
