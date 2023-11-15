package christmas.service;

import christmas.configuration.Event;
import christmas.configuration.Menu;
import christmas.domain.DiscountEvent;
import christmas.domain.OrderMenus;
import christmas.domain.Price;

public class PriceService {

    private Price totalPriceBeforeDiscount;
    private Price totalDiscountPrice;
    private Price discountPrice;
    private Price expectedPaymentPrice;

    public void setTotalPriceBeforeDiscount(OrderMenus orderMenus) {

        int price = 0;
        for (String menuTitle : orderMenus.getValues().keySet()) {
            price += Menu.getPrice(menuTitle) * orderMenus.getValues().get(menuTitle);
        }

        this.totalPriceBeforeDiscount = new Price(price);
    }

    public void setDiscount(DiscountEvent discountEvent) {
        setTotalDiscountPrice(discountEvent);
        setDiscountPrice(discountEvent);
    }
    public void setTotalDiscountPrice(DiscountEvent discountEvent) {

        int price = 0;

        for (String title : discountEvent.getDiscountEventHistory().keySet()) {
            price += discountEvent.getDiscountEventHistory().get(title);
        }

        this.totalDiscountPrice = new Price(price);
    }

    public void setDiscountPrice(DiscountEvent discountEvent) {

        int price = 0;

        for (String title : discountEvent.getDiscountEventHistory().keySet()) {
            if (title.equals(Event.GIVE_AWAY_EVENT.getTitle())) {
                continue;
            }
            price += discountEvent.getDiscountEventHistory().get(title);
        }

        this.discountPrice = new Price(price);
    }

    public void setExpectedPaymentPrice() {
        this.expectedPaymentPrice = new Price(totalPriceBeforeDiscount.getValue() - discountPrice.getValue());
    }

    public Price getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public Price getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public Price getExpectedPaymentPrice() {
        return expectedPaymentPrice;
    }
}
