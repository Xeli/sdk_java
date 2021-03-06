package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 */
public class MonetaryAccountProfileFill extends BunqModel {

  /**
   * The status of the profile.
   */
  @Expose
  @SerializedName("status")
  private String status;

  /**
   * The goal balance.
   */
  @Expose
  @SerializedName("balance_preferred")
  private Amount balancePreferred;

  /**
   * The low threshold balance.
   */
  @Expose
  @SerializedName("balance_threshold_low")
  private Amount balanceThresholdLow;

  /**
   * The method used to fill the monetary account. Currently only iDEAL is supported, and it is
   * the default one.
   */
  @Expose
  @SerializedName("method_fill")
  private String methodFill;

  /**
   * The bank the fill is supposed to happen from, with BIC and bank name.
   */
  @Expose
  @SerializedName("issuer")
  private Issuer issuer;

  public MonetaryAccountProfileFill(String status, Amount balancePreferred,
      Amount balanceThresholdLow, String methodFill) {
    this.status = status;
    this.balancePreferred = balancePreferred;
    this.balanceThresholdLow = balanceThresholdLow;
    this.methodFill = methodFill;
  }

  /**
   * The status of the profile.
   */
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * The goal balance.
   */
  public Amount getBalancePreferred() {
    return this.balancePreferred;
  }

  public void setBalancePreferred(Amount balancePreferred) {
    this.balancePreferred = balancePreferred;
  }

  /**
   * The low threshold balance.
   */
  public Amount getBalanceThresholdLow() {
    return this.balanceThresholdLow;
  }

  public void setBalanceThresholdLow(Amount balanceThresholdLow) {
    this.balanceThresholdLow = balanceThresholdLow;
  }

  /**
   * The method used to fill the monetary account. Currently only iDEAL is supported, and it is
   * the default one.
   */
  public String getMethodFill() {
    return this.methodFill;
  }

  public void setMethodFill(String methodFill) {
    this.methodFill = methodFill;
  }

  /**
   * The bank the fill is supposed to happen from, with BIC and bank name.
   */
  public Issuer getIssuer() {
    return this.issuer;
  }

  public void setIssuer(Issuer issuer) {
    this.issuer = issuer;
  }

}
