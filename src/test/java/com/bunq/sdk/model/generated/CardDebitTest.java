package com.bunq.sdk.model.generated;

import static org.junit.Assert.assertEquals;

import com.bunq.sdk.BunqSdkTestBase;
import com.bunq.sdk.TestConfig;
import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.model.generated.object.Pointer;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests:
 * CardName
 * User
 * CardDebit
 */
public class CardDebitTest extends BunqSdkTestBase {

  /**
   * Config Fields
   */
  private static final String FIELD_USER_ID = "USER_ID";

  /**
   * Config values
   */
  private static final String PIN_CODE = "4045";
  private static final int RADIX_DIGITS_AND_LATIN_LETTERS = 36;
  private static final int NUM_BITS_23_DECIMAL_DIGITS = 76;
  private static final int FIRST_INDEX = 0;
  private static Properties config = TestConfig.prop();
  private static Integer userId = Integer.parseInt(config.getProperty(FIELD_USER_ID));
  private static ApiContext apiContext = getApiContext();

  /**
   * The name that is going to be shown on the card
   */
  private static String nameOnCard;

  /**
   * The alias which this card will be linked to
   */
  private static Pointer alias;

  @BeforeClass
  public static void setUp() {
    List<CardName> cardName = CardName.list(apiContext, userId);
    List cardNameList = cardName.get(FIRST_INDEX).getPossibleCardNameArray();

    User user = User.get(apiContext, userId);

    alias = user.getUserCompany().getAlias().get(FIRST_INDEX);
    nameOnCard = cardNameList.get(new Random().nextInt(cardNameList.size())).toString();
  }

  private static String generateRandomSecondLine() {
    return new BigInteger(NUM_BITS_23_DECIMAL_DIGITS, new SecureRandom())
        .toString(RADIX_DIGITS_AND_LATIN_LETTERS);
  }

  /**
   * Tests ordering a new card and checks if the fields we have entered are indeed correct by
   * retrieving the card from the card endpoint and checks this date against the data we have
   * submitted
   */
  @Test
  public void orderNewMaestroCardTest() throws Exception {
    String secondLine = generateRandomSecondLine();

    HashMap<String, Object> requestMap = new HashMap<>();
    requestMap.put(CardDebit.FIELD_SECOND_LINE, secondLine);
    requestMap.put(CardDebit.FIELD_NAME_ON_CARD, nameOnCard);
    requestMap.put(CardDebit.FIELD_PIN_CODE, PIN_CODE);
    requestMap.put(CardDebit.FIELD_ALIAS, alias);
    CardDebit cardDebit = CardDebit.create(apiContext, requestMap, userId);

    Card cardFromCardEndpoint = getCard(cardDebit.getId());

    assertEquals(nameOnCard, cardFromCardEndpoint.getNameOnCard());
    assertEquals(secondLine, cardFromCardEndpoint.getSecondLine());
    assertEquals(cardDebit.getCreated(), cardFromCardEndpoint.getCreated());
  }

  private Card getCard(Integer cardId) {
    return Card.get(apiContext, userId, cardId);
  }

}
