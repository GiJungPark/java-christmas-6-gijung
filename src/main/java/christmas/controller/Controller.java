package christmas.controller;

import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ChristmasService christmasService = new ChristmasService();

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
}
