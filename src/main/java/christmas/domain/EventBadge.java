package christmas.domain;

import christmas.configuration.Badge;

public class EventBadge {

    private final String badge;

    public EventBadge(int totalDiscountPrice) {
        badge = Badge.getWhat(totalDiscountPrice);
    }

    @Override
    public String toString() {
        return badge;
    }
}
