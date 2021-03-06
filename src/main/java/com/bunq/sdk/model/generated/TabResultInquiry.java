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
 * Used to view TabResultInquiry objects belonging to a tab. A TabResultInquiry is an object
 * that holds details on both the tab and a single payment made for that tab.
 */
public class TabResultInquiry extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_READ = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-result-inquiry/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/tab-result-inquiry";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "TabResultInquiry";

  /**
   * The Tab details.
   */
  @Expose
  @SerializedName("tab")
  private Tab tab;

  /**
   * The payment made for the Tab.
   */
  @Expose
  @SerializedName("payment")
  private Payment payment;

  public static TabResultInquiry get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Integer tabResultInquiryId) {
    return get(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, tabResultInquiryId,
        new HashMap<>());
  }

  /**
   * Used to view a single TabResultInquiry belonging to a tab.
   */
  public static TabResultInquiry get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid, Integer tabResultInquiryId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient.get(String
        .format(ENDPOINT_URL_READ, userId, monetaryAccountId, cashRegisterId, tabUuid,
            tabResultInquiryId), customHeaders);

    return fromJson(TabResultInquiry.class, new String(responseBytes), OBJECT_TYPE);
  }

  public static List<TabResultInquiry> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, new HashMap<>());
  }

  /**
   * Used to view a list of TabResultInquiry objects belonging to a tab.
   */
  public static List<TabResultInquiry> list(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Integer cashRegisterId, String tabUuid,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient.get(
        String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId, tabUuid),
        customHeaders);

    return fromJsonList(TabResultInquiry.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The Tab details.
   */
  public Tab getTab() {
    return this.tab;
  }

  public void setTab(Tab tab) {
    this.tab = tab;
  }

  /**
   * The payment made for the Tab.
   */
  public Payment getPayment() {
    return this.payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

}
