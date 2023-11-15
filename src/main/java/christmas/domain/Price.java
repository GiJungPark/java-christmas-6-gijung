package christmas.domain;

import christmas.configuration.ErrorMessage;

public class Price {

    private static final int GIVE_AWAY_EVENT_PRICE = 120_000;
    private static final int DISCOUNT_EVENT_PRICE = 10_000;

    private int value;

    public Price(int value) {
        validatePrice(value);
        this.value = value;
    }

    private void validatePrice(int value) {
        if (value < 0) {
            throw new ArithmeticException(ErrorMessage.INVALID_PRICE.getMessage());
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isApplyGiveAway() {
        return value >= GIVE_AWAY_EVENT_PRICE;
    }

    public boolean isApplyDiscount() {
        return value >= DISCOUNT_EVENT_PRICE;
    }
}
