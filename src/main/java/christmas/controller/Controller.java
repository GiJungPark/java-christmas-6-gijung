package christmas.controller;

import christmas.service.OrderService;
import christmas.service.EventService;
import christmas.service.PriceService;
import christmas.utils.Convertor;
import christmas.view.OutputView;
import christmas.view.View;

public class Controller {

    private OrderService orderService = new OrderService();
    private PriceService priceService = new PriceService();
    private EventService eventService = new EventService();

    public void printStartMessage() {
        OutputView.printStart();
    }

    public void initUserData() {
        readVisitDate();
        readOrderMenu();
    }

    private void readVisitDate() {
        try {
            orderService.setVisitDate(Convertor.toDate(View.readDate()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readVisitDate();
        }
    }

    private void readOrderMenu() {
        try {
            orderService.setOrderMenu(Convertor.toMenus(View.readOrderMenu()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readOrderMenu();
        }
    }

    public void printResult() {

        printOrderHistoryMessage();

        printEventHistory();

        printExpectedPaymentPrice();

        printEventBadge();
    }

    private void printOrderHistoryMessage() {
        printVisitMessage();
        printOrderMenu();
        printTotalPriceBeforeDiscount();
    }

    private void printVisitMessage() {
        OutputView.printGuide(orderService.getVisitDate());
        OutputView.printChangeLine();
    }

    private void printOrderMenu() {
        OutputView.printMenu(orderService.getOrderMenus());
        OutputView.printChangeLine();
    }

    private void printTotalPriceBeforeDiscount() {
        priceService.setTotalPriceBeforeDiscount(orderService.getOrderMenus());
        OutputView.printTotalPriceBeforeDiscount(priceService.getTotalPriceBeforeDiscount());
        OutputView.printChangeLine();
    }

    private void printEventHistory() {
        printGiveAway();
        printDiscountEvent();
        printTotalDiscountPrice();
    }

    private void printGiveAway() {
        eventService.setGiveAway(priceService.getTotalPriceBeforeDiscount());
        OutputView.printGiveAwayMenu(eventService.getGiveAway());
        OutputView.printChangeLine();
    }

    private void printDiscountEvent() {
        eventService.setDiscountEvent(priceService.getTotalPriceBeforeDiscount(),
                orderService.getVisitDate(), orderService.getOrderMenus());
        OutputView.printDiscountHistory(eventService.getDiscountEvent());
        OutputView.printChangeLine();
    }

    private void printTotalDiscountPrice() {
        priceService.setDiscount(eventService.getDiscountEvent());
        OutputView.printTotalDiscountPrice(priceService.getTotalDiscountPrice());
        OutputView.printChangeLine();
    }

    private void printExpectedPaymentPrice() {
        priceService.setExpectedPaymentPrice();
        OutputView.printExpectedPaymentPrice(priceService.getExpectedPaymentPrice());
        OutputView.printChangeLine();
    }

    private void printEventBadge() {
        eventService.setEventBadge(priceService.getTotalDiscountPrice());
        OutputView.printEventBadge(eventService.getEventBadge());
    }
}
