package com.bunq.sdk.model;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.model.generated.UserCompany;
import com.bunq.sdk.model.generated.UserPerson;
import java.util.HashMap;

public class SessionServer extends BunqModel {

  /**
   * Endpoint name.
   */
  private static final String ENDPOINT_URL_POST = "session-server";

  /**
   * Field constants.
   */
  private static final String FIELD_SECRET = "secret";

  private Id id;
  private SessionToken sessionToken;
  private UserCompany userCompany;
  private UserPerson userPerson;

  public SessionServer(Id id, SessionToken sessionToken, UserCompany userCompany) {
    this.id = id;
    this.sessionToken = sessionToken;
    this.userCompany = userCompany;
  }

  public SessionServer(Id id, SessionToken sessionToken, UserPerson userPerson) {
    this.id = id;
    this.sessionToken = sessionToken;
    this.userPerson = userPerson;
  }

  /**
   * Create a new session for a DeviceServer. Provide the Installation token
   * in the "X-Bunq-Client-Authentication" header. And don't forget to create
   * the "X-Bunq-Client-Signature" header. The response contains a Session
   * token that should be used for as the "X-Bunq-Client-Authentication" header
   * for all future API calls. The ip address making this call needs to match
   * the ip address bound to your API key.
   */
  public static SessionServer create(ApiContext apiContext) {
    ApiClient apiClient = new ApiClient(apiContext);
    byte[] requestBytes = generateRequestBodyBytes(apiContext.getApiKey());
    byte[] responseBytes = apiClient.post(ENDPOINT_URL_POST, requestBytes, new HashMap<>());

    return fromJsonArrayNested(SessionServer.class, new String(responseBytes));
  }

  private static byte[] generateRequestBodyBytes(String apiKey) {
    HashMap<String, Object> sessionServerRequestBody = new HashMap<>();
    sessionServerRequestBody.put(FIELD_SECRET, apiKey);

    return gson.toJson(sessionServerRequestBody).getBytes();
  }

  public Id getId() {
    return id;
  }

  public SessionToken getSessionToken() {
    return sessionToken;
  }

  public UserCompany getUserCompany() {
    return userCompany;
  }

  public UserPerson getUserPerson() {
    return userPerson;
  }

}
