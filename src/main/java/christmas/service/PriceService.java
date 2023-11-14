package christmas.service;

import christmas.configuration.Menu;
import christmas.domain.OrderMenus;
import christmas.domain.Price;

public class PriceService {

    private Price totalPriceBeforeDiscount;

    public void setTotalPriceBeforeDiscount(OrderMenus orderMenus) {

        int price = 0;
        for (String menuTitle : orderMenus.getValues().keySet()) {
            price += Menu.getPrice(menuTitle) * orderMenus.getValues().get(menuTitle);
        }

        totalPriceBeforeDiscount = new Price(price);
    }

    public Price getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }
}
