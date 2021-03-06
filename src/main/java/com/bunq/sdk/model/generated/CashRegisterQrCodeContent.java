package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import java.util.HashMap;
import java.util.Map;

/**
 * Show the raw contents of a QR code. First you need to created a QR code using
 * ../cash-register/{id}/qr-code.
 */
public class CashRegisterQrCodeContent extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/cash-register/%s/qr-code/%s/content";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "CashRegisterQrCodeContent";

  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, Integer qrCodeId) {
    return list(apiContext, userId, monetaryAccountId, cashRegisterId, qrCodeId, new HashMap<>());
  }

  /**
   * Show the raw contents of a QR code
   */
  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer cashRegisterId, Integer qrCodeId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);

    return apiClient.get(
        String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, cashRegisterId, qrCodeId),
        customHeaders);
  }

}
