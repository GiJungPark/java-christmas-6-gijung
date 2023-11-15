package christmas.service;

import christmas.configuration.Menu;
import christmas.domain.DiscountEvent;
import christmas.domain.EventBadge;
import christmas.domain.GiveAway;
import christmas.domain.OrderMenus;
import christmas.domain.Price;
import christmas.domain.VisitDate;
import christmas.utils.EventCalculator;

import java.util.HashMap;
import java.util.Map;

public class EventService {

    private GiveAway giveAway;
    private DiscountEvent discountEvent;
    private EventBadge eventBadge;

    public void setGiveAway(Price totalPriceBeforeDiscount) {
        giveAway = new GiveAway(totalPriceBeforeDiscount.isApplyGiveAway());
    }

    public void setDiscountEvent(Price totalPriceBeforeDiscount, VisitDate visitDate, OrderMenus orderMenus) {
        if (!totalPriceBeforeDiscount.isApplyDiscount()) {
            discountEvent = new DiscountEvent(new HashMap<>());
            return;
        }
        discountEvent = new DiscountEvent(calculateEventHistory(visitDate, orderMenus));
    }

    private Map<String, Integer> calculateEventHistory(VisitDate visitDate, OrderMenus orderMenus) {
        Map<String, Integer> eventHistory = new HashMap<>();

        eventHistory.put(EventCalculator.christmasTitle(visitDate), EventCalculator.christmasDiscount(visitDate));
        eventHistory.put(EventCalculator.weekdayTitle(visitDate), EventCalculator.weekdayDiscount(orderMenus));
        eventHistory.put(EventCalculator.weekendTitle(visitDate), EventCalculator.weekendDiscount(orderMenus));
        eventHistory.put(EventCalculator.specialTitle(visitDate), EventCalculator.specialDiscount());
        eventHistory.put(EventCalculator.giveAwayTitle(giveAway.getCount()), Menu.getPrice(giveAway.getTitle()));

        return eventHistory;
    }

    public void setEventBadge(Price getTotalDiscountPrice) {
        this.eventBadge = new EventBadge(getTotalDiscountPrice.getValue());
    }

    public GiveAway getGiveAway() {
        return giveAway;
    }

    public DiscountEvent getDiscountEvent() {
        return discountEvent;
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }
}
