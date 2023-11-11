package christmas.service;

import christmas.domain.OrderMenus;
import christmas.domain.Price;
import christmas.domain.VisitDate;
import christmas.domain.configuration.Menu;

import java.util.HashMap;

public class ChristmasService {

    private VisitDate visitDate;
    private OrderMenus orderMenu;
    private Price price;

    public void setVisitDate(int number) {
        this.visitDate = new VisitDate(number);
    }

    public void setOrderMenu(HashMap<String, Integer> orderMenu) {
        this.orderMenu = new OrderMenus(orderMenu);
    }

    public int getVisitDate() {
        return visitDate.getNumber();
    }

    public HashMap<String, Integer> getOrderMenus() {
        return orderMenu.get();
    }

    public void setTotalPriceBeforeDiscount() {

        int price = 0;

        for (String menuTitle : orderMenu.get().keySet()) {
            price += Menu.valueOf(menuTitle).getPrice() * orderMenu.get().get(menuTitle) ;
        }

        this.price = new Price(price);
    }

    public int getTotalPriceBeforeDiscount() {
        return price.getPrice();
    }
}
