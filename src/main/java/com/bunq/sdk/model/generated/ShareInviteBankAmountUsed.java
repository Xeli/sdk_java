package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import java.util.HashMap;
import java.util.Map;

/**
 * When you have connected your monetary account bank to a user, and given this user a (for
 * example) daily budget of 10 EUR. If this users has used his entire budget or part of it, this
 * call can be used to reset the amount he used to 0. The user can then spend the daily budget
 * of 10 EUR again.
 */
public class ShareInviteBankAmountUsed extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_DELETE = "user/%s/monetary-account/%s/share-invite-bank-inquiry/%s/amount-used/%s";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "ShareInviteBankAmountUsed";

  public static void delete(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer shareInviteBankInquiryId, Integer shareInviteBankAmountUsedId) {
    delete(apiContext, userId, monetaryAccountId, shareInviteBankInquiryId,
        shareInviteBankAmountUsedId, new HashMap<>());
  }

  /**
   * Reset the available budget for a bank account share. To be called without any ID at the end
   * of the path.
   */
  public static void delete(ApiContext apiContext, Integer userId, Integer monetaryAccountId,
      Integer shareInviteBankInquiryId, Integer shareInviteBankAmountUsedId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    apiClient.delete(String
        .format(ENDPOINT_URL_DELETE, userId, monetaryAccountId, shareInviteBankInquiryId,
            shareInviteBankAmountUsedId), customHeaders);
  }

}
