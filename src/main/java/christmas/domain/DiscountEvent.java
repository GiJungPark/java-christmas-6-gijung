package christmas.domain;

import java.util.Map;

public class DiscountEvent {

    private final Map<String, Integer> discountEventHistory;

    public DiscountEvent(Map<String, Integer> discountEventHistory) {
        this.discountEventHistory = discountEventHistory;
    }

    public Map<String, Integer> getDiscountEventHistory() {
        return discountEventHistory;
    }

    public int getTotalDiscountPrice() {

        int totalDiscountPrice = 0;

        for (String title : discountEventHistory.keySet()) {
            totalDiscountPrice += discountEventHistory.get(title);
        }

        return totalDiscountPrice;
    }

    public int getDiscountPrice() {

        int discountPrice = 0;

        for (String title : discountEventHistory.keySet()) {
            if (title.equals("증정 이벤트")) {
                continue;
            }
            discountPrice += discountEventHistory.get(title);
        }

        return discountPrice;
    }
}
