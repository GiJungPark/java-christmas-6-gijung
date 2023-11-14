package christmas.controller;

import christmas.service.ChristmasService;
import christmas.service.ConvertorService;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.View;

public class Controller {

    private ChristmasService christmasService = new ChristmasService();
    private ConvertorService convertorService = new ConvertorService();

    public void printStartMessage() {
        OutputView.printStart();
    }

    public void readVisitDate() {
        try {
            christmasService.setVisitDate(View.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readVisitDate();
        }
    }

    public void readOrderMenu() {
        try {
            christmasService.setOrderMenu(convertorService.changeForService(View.readOrderMenu()));
            christmasService.setTotalPriceBeforeDiscount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readOrderMenu();
        }
    }

    public void printGuideMessage() {
        OutputView.printGuide(christmasService.getVisitDate());
        OutputView.printChangeLine();
    }

    public void printOrderMenu() {
        OutputView.printMenu(convertorService.changeForView(christmasService.getOrderMenus()));
        OutputView.printChangeLine();
    }

    public void printTotalPriceBeforeDiscount() {
        OutputView.printTotalPriceBeforeDiscount(christmasService.getTotalPriceBeforeDiscount());
        OutputView.printChangeLine();
    }

    public void printGiveAway() {
        OutputView.printGiveAwayMenu(christmasService.getGiveAwayEvent());
        OutputView.printChangeLine();
    }

    public void printDiscountEvent() {
        christmasService.setDiscountEvent();
        OutputView.printDiscountHistory(christmasService.getDiscountEvent());
        OutputView.printChangeLine();
    }

    public void printTotalDiscountPrice() {
        OutputView.printTotalDiscountPrice(christmasService.getTotalDiscountPrice());
        OutputView.printChangeLine();
    }

    public void printExpectedPaymentPrice() {
        OutputView.printExpectedPaymentPrice(christmasService.getExpectedPaymentPrice());
        OutputView.printChangeLine();
    }

    public void printEventBadge() {
        christmasService.setEventBadge();
        OutputView.printEventBadge(christmasService.getEventBadge());
    }
}
