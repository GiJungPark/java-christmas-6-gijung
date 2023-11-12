package christmas.domain;

import java.util.Map;

public class DiscountEvent {

    private final Map<String, Integer> discountEventHistory;

    public DiscountEvent (Map<String, Integer> discountEventHistory) {
        this.discountEventHistory = discountEventHistory;
    }

    public Map<String, Integer> getDiscountEventHistory() {
        return discountEventHistory;
    }

    public int getTotalDiscountPrice() {

        int totalDiscountPrice = 0;

        for ( String title : discountEventHistory.keySet()) {
            totalDiscountPrice += discountEventHistory.get(title);
        }

        return totalDiscountPrice;
    }
}
