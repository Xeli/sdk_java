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
 * Once your CashRegister has been activated you can use it to create Tabs. A Tab is a template
 * for a payment. In contrast to requests a Tab is not pointed towards a specific user. Any user
 * can pay the Tab as long as it is made visible by you. The creation of a Tab happens with
 * /tab-usage-single or /tab-usage-multiple. A TabUsageSingle is a Tab that can be paid once. A
 * TabUsageMultiple is a Tab that can be paid multiple times by different users.
 */
public class Tab extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_READ = "user/%s/monetary-account/%s/cash-register/%s/tab/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/tab";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "Tab";

  /**
   */
  @Expose
  @SerializedName("TabUsageSingle")
  private TabUsageSingle tabUsageSingle;

  /**
   */
  @Expose
  @SerializedName("TabUsageMultiple")
  private TabUsageMultiple tabUsageMultiple;

  public static Tab get(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid) {
    return get(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, new HashMap<>());
  }

  /**
   * Get a specific tab. This returns a TabUsageSingle or TabUsageMultiple.
   */
  public static Tab get(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_READ, userId, monetaryAccountId, cashRegisterId, tabUuid),
            customHeaders);

    return fromJson(Tab.class, new String(responseBytes));
  }

  public static List<Tab> list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, new HashMap<>());
  }

  /**
   * Get a collection of tabs.
   */
  public static List<Tab> list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId),
            customHeaders);

    return fromJsonList(Tab.class, new String(responseBytes));
  }

  /**
   */
  public TabUsageSingle getTabUsageSingle() {
    return this.tabUsageSingle;
  }

  public void setTabUsageSingle(TabUsageSingle tabUsageSingle) {
    this.tabUsageSingle = tabUsageSingle;
  }

  /**
   */
  public TabUsageMultiple getTabUsageMultiple() {
    return this.tabUsageMultiple;
  }

  public void setTabUsageMultiple(TabUsageMultiple tabUsageMultiple) {
    this.tabUsageMultiple = tabUsageMultiple;
  }

}
