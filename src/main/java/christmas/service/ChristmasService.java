package christmas.service;

import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;

import java.util.HashMap;

public class ChristmasService {

    private VisitDate visitDate;
    private OrderMenus orderMenu;

    public void setVisitDate(int number) {
        this.visitDate = new VisitDate(number);
    }

    public void setOrderMenu(HashMap<String, Integer> orderMenu) {
        this.orderMenu = new OrderMenus(orderMenu);
    }

    public int getVisitDate() {
        return visitDate.getNumber();
    }
}
