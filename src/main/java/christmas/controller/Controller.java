package christmas.controller;

import christmas.service.ChristmasService;
import christmas.service.ConvertorService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ChristmasService christmasService = new ChristmasService();
    private ConvertorService convertorService = new ConvertorService();

    public void printStartMessage() {
        outputView.printStart();
    }

    public void readVisitDate() {
        try {
            christmasService.setVisitDate(inputView.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readVisitDate();
        }
    }

    public void readOrderMenu() {
        try {
            christmasService.setOrderMenu(convertorService.changeForService(inputView.readMenu()));
            christmasService.setTotalPriceBeforeDiscount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readOrderMenu();
        }
    }

    public void printGuideMessage() {
        outputView.printGuide(christmasService.getVisitDate());
        outputView.printChangeLine();
    }

    public void printOrderMenu() {
        outputView.printMenu(convertorService.changeForView(christmasService.getOrderMenus()));
        outputView.printChangeLine();
    }

    public void printTotalPriceBeforeDiscount() {
        outputView.printTotalPriceBeforeDiscount(christmasService.getTotalPriceBeforeDiscount());
        outputView.printChangeLine();
    }

    public void printGiveAway() {
        outputView.printGiveAwayMenu(christmasService.getGiveAwayEvent());
        outputView.printChangeLine();
    }

    public void printDiscountEvent() {
        christmasService.setDiscountEvent();
        outputView.printDiscountHistory(christmasService.getDiscountEvent());
        outputView.printChangeLine();
    }

    public void printTotalDiscountPrice() {
        outputView.printTotalDiscountPrice(christmasService.getTotalDiscountPrice());
        outputView.printChangeLine();
    }

    public void printExpectedPaymentPrice() {
        outputView.printExpectedPaymentPrice(christmasService.getExpectedPaymentPrice());
    }
}
