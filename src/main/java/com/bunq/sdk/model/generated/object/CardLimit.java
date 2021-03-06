package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 */
public class CardLimit extends BunqModel {

  /**
   * The daily limit amount.
   */
  @Expose
  @SerializedName("daily_limit")
  private String dailyLimit;

  /**
   * Currency for the daily limit.
   */
  @Expose
  @SerializedName("currency")
  private String currency;

  /**
   * The type of transaction for the limit. Can be CARD_LIMIT_ATM, CARD_LIMIT_CONTACTLESS,
   * CARD_LIMIT_DIPPING or CARD_LIMIT_POS_ICC.
   */
  @Expose
  @SerializedName("type")
  private String type;

  public CardLimit(String dailyLimit, String currency, String type) {
    this.dailyLimit = dailyLimit;
    this.currency = currency;
    this.type = type;
  }

  /**
   * The daily limit amount.
   */
  public String getDailyLimit() {
    return this.dailyLimit;
  }

  public void setDailyLimit(String dailyLimit) {
    this.dailyLimit = dailyLimit;
  }

  /**
   * Currency for the daily limit.
   */
  public String getCurrency() {
    return this.currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * The type of transaction for the limit. Can be CARD_LIMIT_ATM, CARD_LIMIT_CONTACTLESS,
   * CARD_LIMIT_DIPPING or CARD_LIMIT_POS_ICC.
   */
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
