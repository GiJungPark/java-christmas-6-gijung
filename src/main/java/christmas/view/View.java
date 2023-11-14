package christmas.view;

import java.util.HashMap;

public class View {

    public static int readDate() {
        OutputView.printReadVisitDate();
        return InputView.readDate();
    }

    public static HashMap<String, Integer> readOrderMenu() {
        OutputView.printReadOrderMenu();
        return InputView.readOrderMenu();
    }

}
