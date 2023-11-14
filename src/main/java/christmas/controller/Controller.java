package christmas.controller;

import christmas.service.ChristmasService;
import christmas.utils.Convertor;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.View;

public class Controller {

    private ChristmasService christmasService = new ChristmasService();

    public void printStartMessage() {
        OutputView.printStart();
    }

    public void initUserData() {
        readVisitDate();
        readOrderMenu();
    }

    private void readVisitDate() {
        try {
            christmasService.setVisitDate(Convertor.toDate(View.readDate()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readVisitDate();
        }
    }

    private void readOrderMenu() {
        try {
            christmasService.setOrderMenu(Convertor.toMenus(View.readOrderMenu()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readOrderMenu();
        }
    }

    public void processLogic() {
        christmasService.setTotalPriceBeforeDiscount();
    }

    public void printResult() {
        printGuideMessage();
        printOrderMenu();
        printTotalPriceBeforeDiscount();
        printGiveAway();
        printDiscountEvent();
        printTotalDiscountPrice();
        printExpectedPaymentPrice();
        printEventBadge();
    }

    private void printGuideMessage() {
        OutputView.printGuide(christmasService.getVisitDate());
        OutputView.printChangeLine();
    }

    private void printOrderMenu() {
        OutputView.printMenu(christmasService.getOrderMenus());
        OutputView.printChangeLine();
    }

    private void printTotalPriceBeforeDiscount() {
        OutputView.printTotalPriceBeforeDiscount(christmasService.getTotalPriceBeforeDiscount());
        OutputView.printChangeLine();
    }

    private void printGiveAway() {
        OutputView.printGiveAwayMenu(christmasService.getGiveAwayEvent());
        OutputView.printChangeLine();
    }

    private void printDiscountEvent() {
        christmasService.setDiscountEvent();
        OutputView.printDiscountHistory(christmasService.getDiscountEvent());
        OutputView.printChangeLine();
    }

    private void printTotalDiscountPrice() {
        OutputView.printTotalDiscountPrice(christmasService.getTotalDiscountPrice());
        OutputView.printChangeLine();
    }

    private void printExpectedPaymentPrice() {
        OutputView.printExpectedPaymentPrice(christmasService.getExpectedPaymentPrice());
        OutputView.printChangeLine();
    }

    private void printEventBadge() {
        christmasService.setEventBadge();
        OutputView.printEventBadge(christmasService.getEventBadge());
    }
}
