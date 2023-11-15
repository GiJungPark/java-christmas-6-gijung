package christmas.domain;

import christmas.configuration.Event;

import java.util.Map;

public class DiscountEvent {

    private final Map<String, Integer> discountEventHistory;

    public DiscountEvent(Map<String, Integer> discountEventHistory) {
        validateEventHistory(discountEventHistory);
        this.discountEventHistory = discountEventHistory;
    }

    private void validateEventHistory(Map<String, Integer> discountEventHistory) {

        for (String eventTitle : discountEventHistory.keySet()) {

            if (eventTitle.equals(Event.EMPTY_DISCOUNT.getTitle())) {
                discountEventHistory.remove(eventTitle);
                continue;
            }

            if(discountEventHistory.get(eventTitle) == 0) {
                discountEventHistory.remove(eventTitle);
            }
        }

    }

    public Map<String, Integer> getDiscountEventHistory() {
        return discountEventHistory;
    }

}
