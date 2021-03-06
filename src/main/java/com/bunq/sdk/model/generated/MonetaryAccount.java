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
 * Used to show the MonetaryAccounts that you can access. Currently the only MonetaryAccount
 * type is MonetaryAccountBank. See also: monetary-account-bank.<br/><br/>Notification filters
 * can be set on a monetary account level to receive callbacks. For more information check the
 * <a href="/api/2/page/callbacks">dedicated callbacks page</a>.
 */
public class MonetaryAccount extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_READ = "user/%s/monetary-account/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "MonetaryAccount";

  /**
   */
  @Expose
  @SerializedName("MonetaryAccountBank")
  private MonetaryAccountBank monetaryAccountBank;

  public static MonetaryAccount get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId) {
    return get(apiContext, userId, monetaryAccountId, new HashMap<>());
  }

  /**
   * Get a specific MonetaryAccount.
   */
  public static MonetaryAccount get(ApiContext apiContext, Integer userId,
      Integer monetaryAccountId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_READ, userId, monetaryAccountId), customHeaders);

    return fromJson(MonetaryAccount.class, new String(responseBytes));
  }

  public static List<MonetaryAccount> list(ApiContext apiContext, Integer userId) {
    return list(apiContext, userId, new HashMap<>());
  }

  /**
   * Get a collection of all your MonetaryAccounts.
   */
  public static List<MonetaryAccount> list(ApiContext apiContext, Integer userId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId), customHeaders);

    return fromJsonList(MonetaryAccount.class, new String(responseBytes));
  }

  /**
   */
  public MonetaryAccountBank getMonetaryAccountBank() {
    return this.monetaryAccountBank;
  }

  public void setMonetaryAccountBank(MonetaryAccountBank monetaryAccountBank) {
    this.monetaryAccountBank = monetaryAccountBank;
  }

}
