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
 * Once your CashRegister has been activated you can create a QR code for it. The visibility of
 * a tab can be modified to be linked to this QR code. If a user of the bunq app scans this QR
 * code, the linked tab will be shown on his device.
 */
public class CashRegisterQrCode extends BunqModel {

  /**
   * Field constants.
   */
  public static final String FIELD_STATUS = "status";

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_CREATE = "user/%s/monetary-account/%s/cash-register/%s/qr-code";
  private static final String ENDPOINT_URL_UPDATE = "user/%s/monetary-account/%s/cash-register/%s/qr-code/%s";
  private static final String ENDPOINT_URL_READ = "user/%s/monetary-account/%s/cash-register/%s/qr-code/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/qr-code";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "TokenQrCashRegister";

  /**
   * The id of the created QR code. Use this id to get the RAW content of the QR code with:
   * ../qr-code/{id}/content
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  /**
   * The timestamp of the QR code's creation.
   */
  @Expose
  @SerializedName("created")
  private String created;

  /**
   * The timestamp of the TokenQrCashRegister's last update.
   */
  @Expose
  @SerializedName("updated")
  private String updated;

  /**
   * The status of this QR code. If the status is "ACTIVE" the QR code can be scanned to see the
   * linked CashRegister and tab. If the status is "INACTIVE" the QR code does not link to a
   * anything.
   */
  @Expose
  @SerializedName("status")
  private String status;

  /**
   * The CashRegister that is linked to the token.
   */
  @Expose
  @SerializedName("cash_register")
  private CashRegister cashRegister;

  /**
   * Holds the Tab object. Can be TabUsageSingle, TabUsageMultiple or null
   */
  @Expose
  @SerializedName("tab_object")
  private Tab tabObject;

  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId) {
    return create(apiContext, requestMap, userId, monetaryAccountId, cashRegisterId,
        new HashMap<>());
  }

  /**
   * Create a new QR code for this CashRegister. You can only have one ACTIVE CashRegister QR code
   * at the time.
   */
  public static Integer create(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient
        .post(String.format(ENDPOINT_URL_CREATE, userId, monetaryAccountId, cashRegisterId),
            requestBytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  public static Integer update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId,
      Integer cashRegisterQrCodeId) {
    return update(apiContext, requestMap, userId, monetaryAccountId, cashRegisterId,
        cashRegisterQrCodeId, new HashMap<>());
  }

  /**
   * Modify a QR code in a given CashRegister. You can only have one ACTIVE CashRegister QR code
   * at the time.
   */
  public static Integer update(ApiContext apiContext, Map<String, Object> requestMap,
      Integer userId, Integer monetaryAccountId, Integer cashRegisterId,
      Integer cashRegisterQrCodeId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    byte[] responseBytes = apiClient.put(String
        .format(ENDPOINT_URL_UPDATE, userId, monetaryAccountId, cashRegisterId,
            cashRegisterQrCodeId), requestBytes, customHeaders);

    return processForId(new String(responseBytes));
  }

  public static CashRegisterQrCode get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, Integer cashRegisterQrCodeId) {
    return get(apiContext, userId, monetaryAccountId, cashRegisterId, cashRegisterQrCodeId,
        new HashMap<>());
  }

  /**
   * Get the information of a specific QR code. To get the RAW content of the QR code use
   * ../qr-code/{id}/content
   */
  public static CashRegisterQrCode get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, Integer cashRegisterQrCodeId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient.get(String
            .format(ENDPOINT_URL_READ, userId, monetaryAccountId, cashRegisterId, cashRegisterQrCodeId),
        customHeaders);

    return fromJson(CashRegisterQrCode.class, new String(responseBytes), OBJECT_TYPE);
  }

  public static List<CashRegisterQrCode> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, new HashMap<>());
  }

  /**
   * Get a collection of QR code information from a given CashRegister
   */
  public static List<CashRegisterQrCode> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId),
            customHeaders);

    return fromJsonList(CashRegisterQrCode.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The id of the created QR code. Use this id to get the RAW content of the QR code with:
   * ../qr-code/{id}/content
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The timestamp of the QR code's creation.
   */
  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * The timestamp of the TokenQrCashRegister's last update.
   */
  public String getUpdated() {
    return this.updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  /**
   * The status of this QR code. If the status is "ACTIVE" the QR code can be scanned to see the
   * linked CashRegister and tab. If the status is "INACTIVE" the QR code does not link to a
   * anything.
   */
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * The CashRegister that is linked to the token.
   */
  public CashRegister getCashRegister() {
    return this.cashRegister;
  }

  public void setCashRegister(CashRegister cashRegister) {
    this.cashRegister = cashRegister;
  }

  /**
   * Holds the Tab object. Can be TabUsageSingle, TabUsageMultiple or null
   */
  public Tab getTabObject() {
    return this.tabObject;
  }

  public void setTabObject(Tab tabObject) {
    this.tabObject = tabObject;
  }

}
