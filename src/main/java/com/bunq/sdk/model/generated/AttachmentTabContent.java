package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import java.util.HashMap;
import java.util.Map;

/**
 * Fetch the raw content of a tab attachment with given ID. The raw content is the binary
 * representation of a file, without any JSON wrapping.
 */
public class AttachmentTabContent extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_LISTING = "user/%s/monetary-account/%s/attachment-tab/%s/content";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "AttachmentTabContent";

  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer attachmentTabId) {
    return list(apiContext, userId, monetaryAccountId, attachmentTabId, new HashMap<>());
  }

  /**
   * Get the raw content of a specific attachment.
   */
  public static byte[] list(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer attachmentTabId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);

    return apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId, monetaryAccountId, attachmentTabId),
            customHeaders);
  }

}
