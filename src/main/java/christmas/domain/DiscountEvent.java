package christmas.domain;

import java.util.Map;

public class DiscountEvent {

    private final Map<String, Integer> DiscountEventHistory;

    public DiscountEvent (Map<String, Integer> discountEventHistory) {
        DiscountEventHistory = discountEventHistory;
    }

    public Map<String, Integer> getDiscountEventHistory() {
        return DiscountEventHistory;
    }
}
