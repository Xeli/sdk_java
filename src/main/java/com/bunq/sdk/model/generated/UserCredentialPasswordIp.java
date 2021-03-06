package com.bunq.sdk.model.generated;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.BunqModel;
import com.bunq.sdk.model.generated.object.PermittedDevice;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create a credential of a user for server authentication, or delete the credential of a user
 * for server authentication.
 */
public class UserCredentialPasswordIp extends BunqModel {

  /**
   * Endpoint constants.
   */
  private static final String ENDPOINT_URL_READ = "user/%s/credential-password-ip/%s";
  private static final String ENDPOINT_URL_LISTING = "user/%s/credential-password-ip";

  /**
   * Object type.
   */
  private static final String OBJECT_TYPE = "CredentialPasswordIp";

  /**
   * The status of the credential.
   */
  @Expose
  @SerializedName("status")
  private String status;

  /**
   * When the status is PENDING_FIRST_USE: when the credential expires.
   */
  @Expose
  @SerializedName("expiry_time")
  private String expiryTime;

  /**
   * When the status is PENDING_FIRST_USE: the value of the token.
   */
  @Expose
  @SerializedName("token_value")
  private String tokenValue;

  /**
   * When the status is ACTIVE: the details of the device that may use the credential.
   */
  @Expose
  @SerializedName("permitted_device")
  private PermittedDevice permittedDevice;

  public static UserCredentialPasswordIp get(ApiContext apiContext, Integer userId,
      Integer userCredentialPasswordIpId) {
    return get(apiContext, userId, userCredentialPasswordIpId, new HashMap<>());
  }

  /**
   */
  public static UserCredentialPasswordIp get(ApiContext apiContext, Integer userId,
      Integer userCredentialPasswordIpId, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_READ, userId, userCredentialPasswordIpId), customHeaders);

    return fromJson(UserCredentialPasswordIp.class, new String(responseBytes), OBJECT_TYPE);
  }

  public static List<UserCredentialPasswordIp> list(ApiContext apiContext, Integer userId) {
    return list(apiContext, userId, new HashMap<>());
  }

  /**
   */
  public static List<UserCredentialPasswordIp> list(ApiContext apiContext, Integer userId,
      Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] responseBytes = apiClient
        .get(String.format(ENDPOINT_URL_LISTING, userId), customHeaders);

    return fromJsonList(UserCredentialPasswordIp.class, new String(responseBytes), OBJECT_TYPE);
  }

  /**
   * The status of the credential.
   */
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * When the status is PENDING_FIRST_USE: when the credential expires.
   */
  public String getExpiryTime() {
    return this.expiryTime;
  }

  public void setExpiryTime(String expiryTime) {
    this.expiryTime = expiryTime;
  }

  /**
   * When the status is PENDING_FIRST_USE: the value of the token.
   */
  public String getTokenValue() {
    return this.tokenValue;
  }

  public void setTokenValue(String tokenValue) {
    this.tokenValue = tokenValue;
  }

  /**
   * When the status is ACTIVE: the details of the device that may use the credential.
   */
  public PermittedDevice getPermittedDevice() {
    return this.permittedDevice;
  }

  public void setPermittedDevice(PermittedDevice permittedDevice) {
    this.permittedDevice = permittedDevice;
  }

}
