package christmas.service;

import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;

import java.util.Map;

public class OrderService {

    private VisitDate visitDate;
    private OrderMenus orderMenu;

    public void setVisitDate(int number) {
        this.visitDate = new VisitDate(number);
    }

    public void setOrderMenu(Map<String, Integer> orderMenu) {
        this.orderMenu = new OrderMenus(orderMenu);
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public OrderMenus getOrderMenus() {
        return orderMenu;
    }

}
