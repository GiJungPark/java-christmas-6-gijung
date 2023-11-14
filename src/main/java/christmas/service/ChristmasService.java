package christmas.service;

import christmas.domain.DiscountEvent;
import christmas.domain.EventBadge;
import christmas.domain.GiveAway;
import christmas.domain.OrderMenus;
import christmas.domain.Price;
import christmas.domain.VisitDate;
import christmas.configuration.Menu;

import java.util.HashMap;
import java.util.Map;

public class ChristmasService {

    private VisitDate visitDate;
    private OrderMenus orderMenu;
    private Price price;
    private GiveAway giveAway;
    private DiscountEvent discountEvent;
    private EventBadge eventBadge;


    public void setVisitDate(int number) {
        this.visitDate = new VisitDate(number);
    }

    public void setOrderMenu(Map<String, Integer> orderMenu) {
        this.orderMenu = new OrderMenus(orderMenu);
    }

    public int getVisitDate() {
        return visitDate.getNumber();
    }

    public Map<String, Integer> getOrderMenus() {
        return orderMenu.get();
    }

    public void setTotalPriceBeforeDiscount() {

        int price = 0;

        for (String menuTitle : orderMenu.get().keySet()) {
            price += Menu.valueOf(menuTitle).getPrice() * orderMenu.get().get(menuTitle);
        }

        giveAway = new GiveAway(price >= 120000);

        this.price = new Price(price);
    }

    public int getTotalPriceBeforeDiscount() {
        return price.getPrice();
    }

    public GiveAway getGiveAwayEvent() {
        return giveAway;
    }

    public void setDiscountEvent() {

        Map<String, Integer> map = new HashMap<>();

        if (price.getPrice() < 10_000) {
            discountEvent = new DiscountEvent(map);
            return;
        }

        if (daysUntilChristmasDiscount() != 0) {
            map.put("크리스마스 데이 할인", daysUntilChristmasDiscount());
        }
        if (weekdayDiscount() != 0) {
            map.put("평일 할인", weekdayDiscount());
        }
        if (weekendDiscount() != 0) {
            map.put("주말 할인", weekendDiscount());
        }
        if (specialDiscount() != 0) {
            map.put("특별 할인", specialDiscount());
        }
        if (giveAway.getCount() != 0) {
            map.put("증정 이벤트", Menu.CHAMPAGNE.getPrice());
        }

        discountEvent = new DiscountEvent(map);
    }

    private int daysUntilChristmasDiscount() {

        int price = 0;

        if (visitDate.getNumber() <= 25) {
            price = 1000 + (visitDate.getNumber() - 1) * 100;
        }

        return price;
    }

    private int weekdayDiscount() {

        int price = 0;

        if (visitDate.getNumber() % 7 != 1 && visitDate.getNumber() % 7 != 2) {
            for (String title : orderMenu.get().keySet()) {
                if (Menu.isDesert(title)) {
                    price += orderMenu.get().get(title) * 2023;
                }
            }
        }

        return price;
    }

    private int weekendDiscount() {

        int price = 0;

        if (visitDate.getNumber() % 7 == 1 || visitDate.getNumber() % 7 == 2) {
            for (String title : orderMenu.get().keySet()) {
                if (Menu.isMain(title)) {
                    price += orderMenu.get().get(title) * 2023;
                }
            }
        }

        return price;
    }

    private int specialDiscount() {

        int price = 0;

        if (visitDate.getNumber() % 7 == 3 || visitDate.getNumber() == 25) {
            price = 1000;
        }

        return price;
    }

    public DiscountEvent getDiscountEvent() {
        return discountEvent;
    }

    public Price getTotalDiscountPrice() {
        return new Price(discountEvent.getTotalDiscountPrice());
    }

    public Price getExpectedPaymentPrice() {
        return new Price(price.getPrice() - discountEvent.getDiscountPrice());
    }

    public void setEventBadge() {
        eventBadge = new EventBadge(discountEvent.getTotalDiscountPrice());
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }
}
