package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import java.util.HashMap;
import java.util.Map;

/**
 * This call returns the raw content of the QR code that links to this Tab. When a bunq user
 * scans this QR code with the bunq app the Tab will be shown on his/her device.
 */
public class TabQrCodeContent extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/tab/%s/qr-code-content";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "TabQrCodeContent";

  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, tabUuid, new HashMap<>());
  }

  /**
   * Returns the raw content of the QR code that links to this Tab. The raw content is the binary
   * representation of a file, without any JSON wrapping.
   */
  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, String tabUuid, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);

    return apiClient.get(
        String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId, tabUuid),
        customHeaders);
  }

}
