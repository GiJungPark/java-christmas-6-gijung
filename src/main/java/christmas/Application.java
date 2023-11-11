package christmas;

import christmas.controller.Controller;

public class Application {

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        controller.printStartMessage();

        controller.readVisitDate();

        controller.readOrderMenu();

    }
}
