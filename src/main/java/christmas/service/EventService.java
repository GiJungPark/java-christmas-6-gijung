package christmas.service;

import christmas.domain.GiveAway;

public class EventService {

    private static final int EVENT_PRICE = 120_000;

    private GiveAway giveAway;

    public void setGiveAway(int totalPriceBeforeDiscount) {
        giveAway = new GiveAway(applyGiveAwayEvent(totalPriceBeforeDiscount));
    }

    private boolean applyGiveAwayEvent(int totalPriceBeforeDiscount) {
        return totalPriceBeforeDiscount >= EVENT_PRICE;
    }
}
